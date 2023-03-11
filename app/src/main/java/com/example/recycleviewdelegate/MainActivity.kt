package com.example.recycleviewdelegate

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import com.example.recycleviewdelegate.compositeAdapter.CompositeAdapter
import com.example.recycleviewdelegate.compositeAdapter.adapter.DetailAdapter
import com.example.recycleviewdelegate.compositeAdapter.adapter.LoadingAdapter
import com.example.recycleviewdelegate.compositeAdapter.adapter.SummaryAdapter
import com.example.recycleviewdelegate.compositeAdapter.adapter.TitleAdapter
import com.example.recycleviewdelegate.conventionalAdapter.ConventionalAdapter
import com.example.recycleviewdelegate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val conventionalAdapter: ConventionalAdapter = ConventionalAdapter()
    private val viewModel: MainViewModel by viewModels()
    private var isLoading = false

    private val compositeAdapter by lazy {
        CompositeAdapter.Builder()
            .add(TitleAdapter())
            .add(DetailAdapter())
            .add(SummaryAdapter())
            .add(LoadingAdapter())
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        iniObservable()
        viewModel.fetchSomeThing()
    }

    private fun iniObservable() {
        viewModel.itemsLiveData.observe(this) {
            if (isLoading) {
                compositeAdapter.removeLoading()
            }
            compositeAdapter.submitList(it)
        }
    }

    private fun initRecyclerView() {
        binding.itemsRcv.apply {
            adapter = compositeAdapter
            layoutManager = LinearLayoutManager(context)
            addOnScrollListener(object : OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager?

                    val total = recyclerView.layoutManager?.itemCount ?: 0
                    val isLastItem = (linearLayoutManager?.findLastVisibleItemPosition() ?: 0) <= total
                    if (!isLoading) {
                        if (linearLayoutManager != null && isLastItem) {
                            //bottom of list!
                            isLoading = true
                            compositeAdapter.addLoading()
                            viewModel.loadMore()
                        }
                    }
                }
            })
        }
    }
}