package com.example.recycleviewdelegate.compositeAdapter

interface IItemAdapter {
    /**
     * id for identifying each item
     * */
    fun id(): Any

    /**
     * contents for two items are different
     */
    fun content(): Any

    /**
     * payload for updating some views
    * */
    fun payload(other: Any): Payload = Payload.None

    /**
     * Simple marker interface for payloads
     */
    interface Payload {
        object None : Payload
    }
}