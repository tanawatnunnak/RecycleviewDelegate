package com.example.recycleviewdelegate.compositeAdapter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewdelegate.databinding.ItemTitleBinding
import com.example.recycleviewdelegate.compositeAdapter.AbstractAdapter
import com.example.recycleviewdelegate.compositeAdapter.IItemAdapter
import com.example.recycleviewdelegate.compositeAdapter.adapter.item.TitleItem

class TitleAdapter : AbstractAdapter<TitleItem, TitleAdapter.TitleViewHolder>(TitleItem::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding = ItemTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TitleViewHolder(binding)
    }

    override fun bindViewHolder(model: TitleItem, viewHolder: TitleViewHolder, payloads: List<IItemAdapter.Payload>) {
        viewHolder.bind(model)
    }

    class TitleViewHolder(private val binding: ItemTitleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(titleItem: TitleItem) {
            binding.titleTv.text = titleItem.title
        }
    }
}