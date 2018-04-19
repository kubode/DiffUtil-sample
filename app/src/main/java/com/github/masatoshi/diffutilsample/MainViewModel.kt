package com.github.masatoshi.diffutilsample

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import java.util.concurrent.atomic.AtomicInteger

class MainViewModel : ViewModel() {

    private val counter = AtomicInteger()
    private val _items = MutableLiveData<List<Item>>()

    val items: LiveData<List<Item>> = _items

    fun append() {
        val newItem = Item(counter.incrementAndGet(), false)
        _items.value = _items.value.orEmpty() + newItem
    }

    fun toggleFavorite(id: Int) {
        _items.value = _items.value
                ?.map { item ->
                    item.takeIf { it.id == id }
                            ?.copy(isFavorited = !item.isFavorited)
                            ?: item
                }
    }
}
