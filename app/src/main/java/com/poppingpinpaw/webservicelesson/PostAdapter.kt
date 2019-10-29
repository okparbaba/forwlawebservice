package com.poppingpinpaw.webservicelesson

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list.view.*

class PostAdapter(val l:List<Post>) : RecyclerView.Adapter<PostAdapter.PostHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        return PostHolder(LayoutInflater.from(parent.context).inflate(R.layout.list,parent,false))
    }

    override fun getItemCount() = l.size

    override fun onBindViewHolder(h: PostHolder, p: Int) {
        val post = l[p]
        h.tvTitle.text = post.title
        h.tvBody.text = post.body
        h.tvStart.text = post.title[0].toUpperCase().toString()
    }

    class PostHolder(v: View) : RecyclerView.ViewHolder(v) {
        val tvTitle = v.tvTitle
        val tvBody = v.tvBody
        val tvStart = v.tvStart
    }
}
