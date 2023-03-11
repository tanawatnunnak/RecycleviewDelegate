package com.example.recycleviewdelegate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recycleviewdelegate.compositeAdapter.IItemAdapter
import com.example.recycleviewdelegate.compositeAdapter.adapter.item.DetailItem
import com.example.recycleviewdelegate.compositeAdapter.adapter.item.SummaryItem
import com.example.recycleviewdelegate.compositeAdapter.adapter.item.TitleItem
import com.example.recycleviewdelegate.conventionalAdapter.BaseItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _itemsLiveData: MutableLiveData<List<IItemAdapter>> = MutableLiveData()
    val itemsLiveData: LiveData<List<IItemAdapter>> = _itemsLiveData

    fun fetchSomeThing() {
        this._itemsLiveData.value = mockCompositeItems()
    }

    fun loadMore() {
        viewModelScope.launch {
            delay(2000L)
            val newItems = itemsLiveData.value?.toMutableList()?.apply {
                for (count in 0..20) {
                    val id = size + count
                    add(DetailItem(id = id, title = "Detail count", item = id))
                }
            }
            this@MainViewModel._itemsLiveData.value = newItems
        }
    }

    private fun mockCompositeItems(): List<IItemAdapter> {
        return mutableListOf<IItemAdapter>().apply {
            add(TitleItem("Title"))
            for (count in size..20) {
                add(DetailItem(id = count, title = "Detail count", item = count))
            }
           // add(SummaryItem(this.size))
        }
    }

    private fun mockConventionalItems(): List<BaseItem> {
        return mutableListOf<BaseItem>().apply {
            add(BaseItem.TitleItem(this.size, "Title"))
            for (count in size..4) {
                add(BaseItem.DetailItem(this.size, "Detail $count", count))
            }
            //add(BaseItem.SummaryItem(this.size, this.size - 1))
        }
    }
}