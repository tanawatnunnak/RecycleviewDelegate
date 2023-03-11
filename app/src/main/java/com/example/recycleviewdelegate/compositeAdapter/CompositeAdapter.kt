package com.example.recycleviewdelegate.compositeAdapter

import android.util.SparseArray
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewdelegate.compositeAdapter.adapter.item.LoadingItem

class CompositeAdapter(
    private val adapters: SparseArray<AbstractAdapter<IItemAdapter, RecyclerView.ViewHolder>>
) : ListAdapter<IItemAdapter, RecyclerView.ViewHolder>(AdapterDiffCallback()) {

    override fun getItemViewType(position: Int): Int {
        for (i in 0 until adapters.size()) {
            if (adapters[i].modelClass == getItem(position).javaClass) {
                return adapters.keyAt(i)
            }
        }
        throw NullPointerException("Can not get viewType for position $position")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        adapters[viewType].createViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        onBindViewHolder(holder, position, mutableListOf())

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, payloads: MutableList<Any>) {
        val delegateAdapter = adapters[getItemViewType(position)]

        if (delegateAdapter != null) {
            val delegatePayloads = payloads.map { it as IItemAdapter.Payload }
            delegateAdapter.bindViewHolder(getItem(position), holder, delegatePayloads)
        } else {
            throw NullPointerException("can not find adapter for position $position")
        }
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        adapters[holder.itemViewType].onViewRecycled(holder)
        super.onViewRecycled(holder)
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        adapters[holder.itemViewType].onViewDetachedFromWindow(holder)
        super.onViewDetachedFromWindow(holder)
    }

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        adapters[holder.itemViewType].onViewAttachedToWindow(holder)
        super.onViewAttachedToWindow(holder)
    }

    fun addLoading() {
        val newItems = currentList.toMutableList()
        newItems.add(LoadingItem())
        submitList(newItems)
    }

    fun removeLoading() {
        val newItems = currentList.toMutableList()
        newItems.removeAt(newItems.size - 1)
        submitList(newItems)
    }

    class Builder {

        private var count: Int = 0
        private val adapters: SparseArray<AbstractAdapter<IItemAdapter, RecyclerView.ViewHolder>> = SparseArray()

        fun add(delegateAdapter: AbstractAdapter<out IItemAdapter, *>): Builder {
            adapters.put(count++, delegateAdapter as AbstractAdapter<IItemAdapter, RecyclerView.ViewHolder>)
            return this
        }

        fun build(): CompositeAdapter {
            require(count != 0) { "Register at least one adapter" }
            return CompositeAdapter(adapters)
        }
    }
}