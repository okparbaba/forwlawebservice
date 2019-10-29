package com.poppingpinpaw.webservicelesson

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var posts:ArrayList<Post>
    private lateinit var ada:PostAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        posts = ArrayList()
        ada = PostAdapter(posts)
        progressBar.visibility = VISIBLE
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ada
        RetrofitBuilder
            .getRetrofit()
            .create(WService::class.java)
            .getPost()
            .enqueue(object :Callback<List<Post>>{
                override fun onFailure(call: Call<List<Post>>, t: Throwable) {
//                    progressBar.visibility = GONE
                }

                override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                    progressBar.visibility = GONE
                    if (response.isSuccessful){
                        val postList = response.body()
                        posts.addAll(postList as ArrayList)
                        ada.notifyDataSetChanged()
                    }
                }

            })
    }
}

