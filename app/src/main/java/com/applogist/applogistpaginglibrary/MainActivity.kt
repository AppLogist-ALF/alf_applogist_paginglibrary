package com.applogist.applogistpaginglibrary

import android.os.Bundle
import androidx.activity.viewModels
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
    lateinit var vAdapter: PopularMoviePagingAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
    }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun prepareView(savedInstanceState: Bundle?) {
        vAdapter = PopularMoviePagingAdapter {
            //detaya atılcak
        }
        initAdapter()
        pagingObserve()
        initPagingAdapterLoadStateListener()

    }

    private fun pagingObserve() {
        lifecycleScope.launch {
            viewModel.fetchList().collectLatest { response ->
                vAdapter.submitData(response)
            }
        }
    }



    private fun initAdapter() {
        binding.customRecyclerView.
    }

    private fun initPagingAdapterLoadStateListener() {
        vAdapter.addLoadStateListener { combinedLoadStates ->
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