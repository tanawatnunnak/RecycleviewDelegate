package com.example.recycleviewdelegate.compositAdapter.item

import com.example.recycleviewdelegate.compositAdapter.DelegateAdapterItem

class DetailItem(
    val title: String,
    val item: Int
) : DelegateAdapterItem {
    override fun id(): Any {
        TODO("Not yet implemented")
    }

    override fun content(): Any {
        TODO("Not yet implemented")
    }

    override fun payload(other: Any): DelegateAdapterItem.Payload {
        if(other is DetailItem){
            if(item != other.item){
              return  DetailPayload.ItemChange(other.item)
            }
        }
        return DelegateAdapterItem.Payload.None
    }

    inner class DetailContent(){

    }

    sealed class DetailPayload : DelegateAdapterItem.Payload {
        data class ItemChange(val item: Int) : DetailPayload()
    }
}