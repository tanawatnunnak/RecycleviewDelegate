package com.example.recycleviewdelegate.compositeAdapter.adapter.item

import com.example.recycleviewdelegate.compositeAdapter.IItemAdapter

class TitleItem(
    val title: String
) : IItemAdapter {
    override fun id(): Any = TitleItem::class.java.toString()

    override fun content(): Any = title
}