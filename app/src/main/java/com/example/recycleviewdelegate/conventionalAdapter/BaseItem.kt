package com.example.recycleviewdelegate.conventionalAdapter

sealed class BaseItem(open val id: Int, val type: Int) {
    data class TitleItem(override val id: Int, val title: String) : BaseItem(id, ConventionalType.TITLE)
    data class DetailItem(override val id: Int, val detail: String) : BaseItem(id, ConventionalType.DETAIL)
    data class SummaryItem(override val id: Int, val count: Int) : BaseItem(id, ConventionalType.SUMMARY)
}