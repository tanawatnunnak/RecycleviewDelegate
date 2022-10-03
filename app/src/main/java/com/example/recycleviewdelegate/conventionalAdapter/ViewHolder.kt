package com.example.recycleviewdelegate.conventionalAdapter

import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewdelegate.databinding.ItemDetailBinding
import com.example.recycleviewdelegate.databinding.ItemSummaryBinding
import com.example.recycleviewdelegate.databinding.ItemTitleBinding

class TitleViewHolder(private val binding: ItemTitleBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: BaseItem.TitleItem) {
        binding.titleTv.text = data.title
    }
}

class DetailViewHolder(private val binding: ItemDetailBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: BaseItem.DetailItem) {
        binding.detailTv.text = data.detail
    }
}

class SummaryViewHolder(private val binding: ItemSummaryBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: BaseItem.SummaryItem) {
        binding.summaryTv.text = data.count.toString()
    }
}