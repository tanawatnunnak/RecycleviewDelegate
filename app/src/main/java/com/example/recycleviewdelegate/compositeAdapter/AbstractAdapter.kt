package com.example.recycleviewdelegate.compositeAdapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class AbstractAdapter<Model, in VH : RecyclerView.ViewHolder>(val modelClass: Class<out Model>) {

    abstract fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
    abstract fun bindViewHolder(model: Model, viewHolder: VH, payloads: List<IItemAdapter.Payload>)

    open fun onViewRecycled(viewHolder: VH) = Unit
    open fun onViewDetachedFromWindow(viewHolder: VH) = Unit
    open fun onViewAttachedToWindow(viewHolder: VH) = Unit
}