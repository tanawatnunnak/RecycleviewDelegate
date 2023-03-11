package com.example.recycleviewdelegate.compositeAdapter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewdelegate.databinding.ItemDetailBinding
import com.example.recycleviewdelegate.compositeAdapter.AbstractAdapter
import com.example.recycleviewdelegate.compositeAdapter.IItemAdapter
import com.example.recycleviewdelegate.compositeAdapter.adapter.item.DetailItem

class DetailAdapter : AbstractAdapter<DetailItem, DetailAdapter.DetailViewHolder>(DetailItem::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding = ItemDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailViewHolder(binding)
    }

    override fun bindViewHolder(model: DetailItem, viewHolder: DetailViewHolder, payloads: List<IItemAdapter.Payload>) {
        when (val payload = payloads.firstOrNull() as? DetailItem.DetailPayload) {
            is DetailItem.DetailPayload.TitleChanged -> viewHolder.bindTitle(payload.title)
            is DetailItem.DetailPayload.ItemChanged -> viewHolder.bindItem(payload.item)
            else -> viewHolder.bind(model)
        }
    }

    class DetailViewHolder(private val binding: ItemDetailBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(detailItem: DetailItem) {
            binding.apply {
                detailTv.text = detailItem.title
                itemTv.text = detailItem.item.toString()
            }
        }

        fun bindTitle(title: String) {
            binding.detailTv.text = title
        }

        fun bindItem(item: Int) {
            binding.itemTv.text = item.toString()
        }
    }
}