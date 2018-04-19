package com.github.masatoshi.diffutilsample

import android.view.ViewGroup
import android.widget.TextView

class ItemViewHolder(
        parent: ViewGroup,
        private val onItemClick: (Item) -> Unit
) : SimpleViewHolder(
        parent,
        android.R.layout.simple_list_item_1
) {

    private val textView: TextView = itemView.findViewById(android.R.id.text1)

    init {
        textView.setOnClickListener { item?.let { onItemClick(it) } }
    }

    var item: Item? = null
        set(value) {
            field = value
            textView.text = value?.toString()
        }
}
