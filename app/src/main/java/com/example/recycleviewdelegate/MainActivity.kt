package com.example.recycleviewdelegate

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleviewdelegate.conventionalAdapter.ConventionalAdapter
import com.example.recycleviewdelegate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val conventionalAdapter: ConventionalAdapter = ConventionalAdapter()
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        iniObservable()
        viewModel.fetchSomeThing()
    }

    private fun iniObservable() {
        viewModel.itemsLiveData.observe(this, conventionalAdapter::submitList)
    }

    private fun initRecyclerView() {
        binding.itemsRcv.apply {
            adapter = conventionalAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }
}