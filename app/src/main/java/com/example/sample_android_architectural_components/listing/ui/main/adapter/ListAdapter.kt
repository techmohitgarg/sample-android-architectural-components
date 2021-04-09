package com.example.sample_android_architectural_components.listing.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.sample_android_architectural_components.R
import com.example.sample_android_architectural_components.databinding.ItemArticleDataBinding
import com.example.sample_android_architectural_components.listing.data.model.Articles
import com.example.sample_android_architectural_components.listing.ui.main.callbacks.ItemClickListener


class ListAdapter(
    private var list: MutableList<Articles> = mutableListOf(),
    private var itemClickListener: ItemClickListener?
) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    // ViewHolder class
    class ViewHolder(val itemArticleDataBinding: ItemArticleDataBinding) :
        RecyclerView.ViewHolder(itemArticleDataBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemArticleDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.view_list_item, parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemArticles = list[position]
        holder.itemArticleDataBinding.itemArticles = itemArticles
        holder.itemArticleDataBinding.callbackOnItemClick = itemClickListener
        holder.itemArticleDataBinding.executePendingBindings()
    }

    fun updateAll(data: List<Articles>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }
}