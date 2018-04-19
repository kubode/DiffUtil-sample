package com.github.masatoshi.diffutilsample

data class Item(
        val id: Int,
        val isFavorited: Boolean
) {
    override fun toString() = "$id${if (isFavorited) " ⭐" else ""}"
}
