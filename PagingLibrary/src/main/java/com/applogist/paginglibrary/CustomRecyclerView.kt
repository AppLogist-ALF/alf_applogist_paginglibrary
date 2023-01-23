package com.applogist.paginglibrary

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class CustomRecyclerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0,

    ) : ConstraintLayout(context, attrs, defStyleAttr) {

    var swipeRefreshLayout: SwipeRefreshLayout? = null
    var recyclerView: RecyclerView? = null

    init {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {

        inflate(context, R.layout.alf_custom_recyclerview, this)

        val customAttributesStyle =
            context.obtainStyledAttributes(attrs, R.styleable.CustomRecyclerView, 0, 0)

        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout)
        recyclerView = findViewById(R.id.recyclerView)

        try {
            swipeRefresh()
        } finally {
            customAttributesStyle.recycle()
        }

    }

    public fun adapter(adapter: PagingDataAdapter<*,*>){
        recyclerView?.adapter = adapter
    }

    private fun swipeRefresh() {
        swipeRefreshLayout?.setOnRefreshListener {
            swipeRefreshLayout?.isRefreshing = false
        }
    }

    fun data(){

    }

}