package com.example.recycleviewdelegate.compositeAdapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

class AdapterDiffCallback : DiffUtil.ItemCallback<IItemAdapter>() {
    override fun areItemsTheSame(oldItem: IItemAdapter, newItem: IItemAdapter): Boolean =
        oldItem::class == newItem::class && oldItem.id() == newItem.id()

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: IItemAdapter, newItem: IItemAdapter): Boolean =
        oldItem.content() == newItem.content()

    override fun getChangePayload(oldItem: IItemAdapter, newItem: IItemAdapter): Any =
        oldItem.payload(newItem)
}