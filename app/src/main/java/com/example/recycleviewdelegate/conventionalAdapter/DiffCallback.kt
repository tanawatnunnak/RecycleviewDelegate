package com.example.recycleviewdelegate.conventionalAdapter

import androidx.recyclerview.widget.DiffUtil

class DiffCallback : DiffUtil.ItemCallback<BaseItem>() {
    override fun areItemsTheSame(oldItem: BaseItem, newItem: BaseItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BaseItem, newItem: BaseItem): Boolean {
        return if (oldItem is BaseItem.TitleItem && newItem is BaseItem.TitleItem) {
            oldItem.title == newItem.title
        } else if (oldItem is BaseItem.DetailItem && newItem is BaseItem.DetailItem) {
            oldItem.detail == newItem.detail
        } else if (oldItem is BaseItem.SummaryItem && newItem is BaseItem.SummaryItem) {
            return oldItem.count == newItem.count
        } else {
            false
        }
    }
}