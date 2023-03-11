package com.example.recycleviewdelegate.compositeAdapter.adapter.item

import com.example.recycleviewdelegate.compositeAdapter.IItemAdapter

class LoadingItem : IItemAdapter {

    override fun id(): Any = LoadingItem::class.java.toString()
    override fun content(): Any = LoadingItem::class.java.toString()
}