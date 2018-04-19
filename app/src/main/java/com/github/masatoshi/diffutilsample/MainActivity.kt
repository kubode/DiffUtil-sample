package com.github.masatoshi.diffutilsample

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.masatoshi.diffutilsample.ext.get
import com.github.masatoshi.diffutilsample.ext.observeNonNull
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProviders.of(this).get<MainViewModel>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ItemAdapter(onItemClick = { viewModel.toggleFavorite(it.id) })
        recyclerView.adapter = adapter
        fab.setOnClickListener { viewModel.append() }

        viewModel.items.observeNonNull(this) { adapter.submitList(it) }
    }
}
