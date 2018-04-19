package com.github.masatoshi.diffutilsample

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.view.ViewGroup

class ItemAdapter(
        private val onItemClick: (Item) -> Unit
) : ListAdapter<Item, ItemViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Item, newItem: Item) = oldItem == newItem
            override fun getChangePayload(oldItem: Item, newItem: Item) = newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(parent, onItemClick)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.item = getItem(position)
    }
}
