package com.example.sample_android_architectural_components.listing.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.sample_android_architectural_components.app.MyApplication
import com.example.sample_android_architectural_components.databinding.ArticleDetailsDataBinding
import com.example.sample_android_architectural_components.listing.data.model.Articles
import com.example.sample_android_architectural_components.listing.ui.main.viewmodel.ListDetailsModel
import com.example.sample_android_architectural_components.listing.ui.main.viewmodel.ViewModelFactory
import com.example.sample_android_architectural_components.utils.Util
import javax.inject.Inject

class ListItemDetailsActivity : AppCompatActivity() {
    var TAG = ListItemDetailsActivity::class.java.name

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var util: Util

    lateinit var article: Articles

    private lateinit var dataBinding: ArticleDetailsDataBinding

    private val listViewModel by viewModels<ListDetailsModel>(factoryProducer = { viewModelFactory })

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as MyApplication).getAppComponent().inject(this)
        super.onCreate(savedInstanceState)
        getIntentData()
        //updateArticleData()

        //dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_list_item_details)
        //dataBinding.viewModel = listViewModel
        //dataBinding.itemArticles = article

        // Calling the api
        //val articleID = util.getArticleID(article.url)

        //listViewModel.fetchLikesData("${NetWorkConfigurations.likes}${articleID}")
        //listViewModel.fetchCommentData("${NetWorkConfigurations.comments}${articleID}")
    }

    private fun getIntentData() {
        intent?.extras?.let {
            if (it["key"] != null) {
                article = it.getParcelable<Articles>("key") as Articles
                Log.e(TAG, article.toString())
            }
        }

    }

    private fun updateArticleData() {
        article?.let {
            supportActionBar?.title = article.source.name
        }
    }
}