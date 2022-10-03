package com.example.recycleviewdelegate.conventionalAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewdelegate.databinding.ItemDetailBinding
import com.example.recycleviewdelegate.databinding.ItemSummaryBinding
import com.example.recycleviewdelegate.databinding.ItemTitleBinding

class ConventionalAdapter : ListAdapter<BaseItem, RecyclerView.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ConventionalType.TITLE -> {
                val view = ItemTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                TitleViewHolder(view)
            }
            ConventionalType.DETAIL -> {
                val view = ItemDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                DetailViewHolder(view)
            }
            ConventionalType.SUMMARY -> {
                val view = ItemSummaryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                SummaryViewHolder(view)
            }
            else -> throw Exception("type error")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TitleViewHolder -> {
                val data = getItem(position) as BaseItem.TitleItem
                holder.bind(data)
            }
            is DetailViewHolder -> {
                val data = getItem(position) as BaseItem.DetailItem
                holder.bind(data)
            }
            is SummaryViewHolder -> {
                val data = getItem(position) as BaseItem.SummaryItem
                holder.bind(data)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).type
    }
}