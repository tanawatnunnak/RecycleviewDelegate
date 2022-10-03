package com.example.recycleviewdelegate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _itemsLiveData: MutableLiveData<List<BaseItem>> = MutableLiveData()
    val itemsLiveData: LiveData<List<BaseItem>> = _itemsLiveData

    fun fetchSomeThing() {
        this._itemsLiveData.value = mockItems()
    }

    private fun mockItems(): List<BaseItem> {
        return mutableListOf<BaseItem>().apply {
            add(BaseItem.TitleItem(this.size, "Title"))
            add(BaseItem.DetailItem(this.size, "Detail ${this.size}"))
            add(BaseItem.DetailItem(this.size, "Detail ${this.size}"))
            add(BaseItem.DetailItem(this.size, "Detail ${this.size}"))
            add(BaseItem.SummaryItem(this.size, this.size - 1))
        }
    }
}