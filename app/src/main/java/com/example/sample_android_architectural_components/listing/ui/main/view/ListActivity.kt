package com.example.sample_android_architectural_components.listing.ui.main.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.sample_android_architectural_components.R
import com.example.sample_android_architectural_components.databinding.ListActivityDataBinding
import com.example.sample_android_architectural_components.listing.ui.main.viewmodel.ListViewModel
import com.example.sample_android_architectural_components.listing.ui.main.viewmodel.ViewModelFactory
import com.example.sample_android_architectural_components.utils.Result
import javax.inject.Inject
import androidx.activity.viewModels
import com.example.sample_android_architectural_components.app.MyApplication
import com.example.sample_android_architectural_components.listing.data.model.Articles
import com.example.sample_android_architectural_components.listing.ui.main.adapter.ListAdapter
import com.example.sample_android_architectural_components.listing.ui.main.callbacks.ItemClickListener
import com.example.sample_android_architectural_components.utils.Constants


class ListActivity : AppCompatActivity(), ItemClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var listAdapter: ListAdapter? = null

    private val listViewModel by viewModels<ListViewModel>(factoryProducer = { viewModelFactory })

    private lateinit var dataBinding: ListActivityDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as MyApplication).getAppComponent().inject(this)
        super.onCreate(savedInstanceState)
        // Set the tool-bar title
        supportActionBar?.title = "News List"
        setAdapter()
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_list)
        dataBinding.viewModel = listViewModel
        dataBinding.listAdapter = listAdapter
        setupObserver()

        // Calling the fetchNewsData api
        listViewModel.fetchNewsData(Constants.country_code, Constants.api_key)
    }

    override fun onItemClicked(article: Articles) {
        startActivity(Intent(this, ListItemDetailsActivity::class.java).apply {
            putExtras(Bundle().apply {
                putParcelable("key", article)
                putString("data", "Hello")
            })
        })
    }

    private fun setupObserver() {
        listViewModel.resultNewsList.observe(this, Observer {
            when (it) {
                is Result.Loading -> {
                    listViewModel.progressBarState.set(true)
                    listViewModel.recyclerViewState.set(false)
                }
                is Result.Error -> {
                    listViewModel.progressBarState.set(false)
                    listViewModel.recyclerViewState.set(false)
                }
                is Result.Success -> {
                    listViewModel.progressBarState.set(false)
                    listViewModel.recyclerViewState.set(true)
                    setAdapter(it.data)
                }
                else -> {

                }
            }
        })
    }

    private fun setAdapter(data: List<Articles> = emptyList()) {
        if (listAdapter == null)
            listAdapter = ListAdapter(itemClickListener = this)

        listAdapter?.updateAll(data.toMutableList())
    }

}