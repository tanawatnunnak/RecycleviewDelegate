package com.example.recycleviewdelegate.compositeAdapter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewdelegate.databinding.ItemSummaryBinding
import com.example.recycleviewdelegate.compositeAdapter.AbstractAdapter
import com.example.recycleviewdelegate.compositeAdapter.IItemAdapter
import com.example.recycleviewdelegate.compositeAdapter.adapter.item.SummaryItem

class SummaryAdapter : AbstractAdapter<SummaryItem, SummaryAdapter.SummaryViewHolder>(SummaryItem::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding = ItemSummaryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SummaryViewHolder(binding)
    }

    override fun bindViewHolder(model: SummaryItem, viewHolder: SummaryViewHolder, payloads: List<IItemAdapter.Payload>) {
        viewHolder.bind(model)
    }

    class SummaryViewHolder(private val binding: ItemSummaryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SummaryItem) {
            binding.summaryTv.text = item.count.toString()
        }
    }
}