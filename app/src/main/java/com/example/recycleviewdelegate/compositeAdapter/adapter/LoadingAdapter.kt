package com.example.recycleviewdelegate.compositeAdapter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewdelegate.compositeAdapter.AbstractAdapter
import com.example.recycleviewdelegate.compositeAdapter.IItemAdapter
import com.example.recycleviewdelegate.compositeAdapter.adapter.item.LoadingItem
import com.example.recycleviewdelegate.databinding.ItemLoadingBinding

class LoadingAdapter : AbstractAdapter<LoadingItem, LoadingAdapter.ViewHolder>(LoadingItem::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val view = ItemLoadingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view.root)
    }

    override fun bindViewHolder(model: LoadingItem, viewHolder: ViewHolder, payloads: List<IItemAdapter.Payload>) {
        //not implement yet
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

}