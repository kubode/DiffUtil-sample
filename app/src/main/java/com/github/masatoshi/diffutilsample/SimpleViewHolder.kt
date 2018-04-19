package com.github.masatoshi.diffutilsample

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class SimpleViewHolder(
        parent: ViewGroup,
        @LayoutRes layout: Int
) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(layout, parent, false)
)
