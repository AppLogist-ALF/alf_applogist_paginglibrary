package com.applogist.applogistpaginglibrary.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.applogist.applogistpaginglibrary.R
import com.applogist.applogistpaginglibrary.utils.ProgressDialog

abstract class BaseFragment<VDB : ViewDataBinding> : Fragment() {

    lateinit var binding: VDB

    private var dialog: ProgressDialog? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog = context?.let { ProgressDialog(it, R.style.LoadingDialogStyle) }!!
        binding = DataBindingUtil.inflate(layoutInflater, getLayoutId(), container, false)
        return binding.root
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareView(savedInstanceState)
    }

    abstract fun prepareView(savedInstanceState: Bundle?)

    fun showProgressDialog() {
        try {
            if (!dialog!!.isShowing) {
                dialog!!.show()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * Hide Progress Dialog
     */
    fun hideProgressDialog() {
        try {
            if (dialog!!.isShowing)
                dialog!!.dismiss()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}