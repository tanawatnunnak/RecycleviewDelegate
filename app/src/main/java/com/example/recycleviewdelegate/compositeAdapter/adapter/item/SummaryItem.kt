package com.example.recycleviewdelegate.compositeAdapter.adapter.item

import com.example.recycleviewdelegate.compositeAdapter.IItemAdapter

class SummaryItem(
    val count: Int
) : IItemAdapter {

    override fun id(): Any = SummaryItem::class.java.toString()

    override fun content(): Any = count
}