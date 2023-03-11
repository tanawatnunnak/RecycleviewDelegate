package com.example.recycleviewdelegate.compositeAdapter.adapter.item

import com.example.recycleviewdelegate.compositeAdapter.IItemAdapter

class DetailItem(
    val id: Int,
    val title: String,
    val item: Int
) : IItemAdapter {

    override fun id(): Int = id

    override fun content(): Any = DetailContent(title, item)

    override fun payload(other: Any): IItemAdapter.Payload {
        return if (other is DetailItem) {
            when {
                item != other.item -> DetailPayload.ItemChanged(other.item)
                title != other.title -> DetailPayload.TitleChanged(other.title)
                else -> IItemAdapter.Payload.None
            }
        } else {
            IItemAdapter.Payload.None
        }
    }

    inner class DetailContent(
        val title: String,
        val item: Int
    ) {
        override fun equals(other: Any?): Boolean {
            return if (other is DetailContent) {
                title == other.title && other.item == item
            } else {
                false
            }
        }

        override fun hashCode(): Int {
            var result = title.hashCode()
            result = 31 * result + item.hashCode()
            return result
        }
    }

    sealed class DetailPayload : IItemAdapter.Payload {
        data class TitleChanged(val title: String) : DetailPayload()
        data class ItemChanged(val item: Int) : DetailPayload()
    }
}