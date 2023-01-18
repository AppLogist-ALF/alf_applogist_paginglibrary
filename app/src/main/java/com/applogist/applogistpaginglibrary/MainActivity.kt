package com.applogist.applogistpaginglibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.applogist.applogistpaginglibrary.adapter.PopularMoviePagingAdapter
import com.applogist.applogistpaginglibrary.base.BaseActivity
import com.applogist.applogistpaginglibrary.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel: MainScreenViewModel by viewModels()
    lateinit var adapter: PopularMoviePagingAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
    }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun prepareView(savedInstanceState: Bundle?) {
        adapter = PopularMoviePagingAdapter {

        }
        initAdapter()
        pagingObserve()
        swipeRefresh()
    }

    private fun pagingObserve() {
        lifecycleScope.launch {
            viewModel.fetchList().collectLatest { response ->
                adapter.submitData(response)
            }
        }
    }

    private fun swipeRefresh() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            pagingObserve()
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }

    private fun initAdapter() {
        binding.popularMoviesRecyclerView.adapter = adapter
    }

    private fun initPagingAdapterLoadStateListener() {
        adapter.addLoadStateListener { combinedLoadStates ->
            if (combinedLoadStates.refresh is LoadState.Loading) {
//                LogUtils.d("samsamsam", "loading")
//                showProgressDialog()
            } else {
//                LogUtils.d("samsamsam", "notLoading")
//                hideProgressDialog()
            }
        }
    }
}