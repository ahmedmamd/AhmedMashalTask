package com.example.task.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.task.R
import com.example.task.databinding.ItemPopularStarBinding
import com.example.task.pojo.popularStare.Items

class PopularStareAdapter ( var items: ArrayList<Items>,
    val context: Context , var limit :Int
    ): RecyclerView.Adapter<PopularStareAdapter.PopularStarViewHolder>() {

    class PopularStarViewHolder (val binding: ItemPopularStarBinding): RecyclerView.ViewHolder(binding.root){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularStarViewHolder {
        val binding : ItemPopularStarBinding
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_popular_star,parent,false)
        return PopularStarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularStarViewHolder, position: Int) {
        holder.binding.popularStar = items.get(position)
    }

    override fun getItemCount(): Int {
        if (items.size > limit){
            return limit
        }else{
            return  items.size
        }
    }
}
