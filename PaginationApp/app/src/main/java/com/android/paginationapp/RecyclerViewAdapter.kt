package com.android.paginationapp

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.paginationapp.network.CharacterData
import com.bumptech.glide.Glide

class RecyclerViewAdapter : PagedListAdapter<CharacterData, RecyclerViewAdapter.MyViewHolder>(DiffUtilCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row, parent, false)

        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val tvTitle:TextView = view.findViewById(R.id.tvTitle)
        val tvDesc: TextView = view.findViewById(R.id.tvDesc)
        val imageThumb: ImageView = view.findViewById(R.id.imageThumb)

        fun bind(data: CharacterData) {
            tvTitle.text = data.name
            if(!TextUtils.isEmpty(data.species)) {
                tvDesc.text = data.species
            } else {
                tvDesc.text = "No species available."
            }

            val url = data.image
            Glide.with(imageThumb)
                .load(url)
                .circleCrop()
                .into(imageThumb)
        }

    }

}