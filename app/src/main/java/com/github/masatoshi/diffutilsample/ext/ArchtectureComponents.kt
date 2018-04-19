package com.github.masatoshi.diffutilsample.ext

import android.arch.lifecycle.*

inline fun <reified T : ViewModel> ViewModelProvider.get(): T {
    return get(T::class.java)
}

inline fun <T> LiveData<T>.observeNonNull(
        owner: LifecycleOwner,
        crossinline observer: (T) -> Unit
) {
    observe(owner, Observer { it?.let { observer(it) } })
}
