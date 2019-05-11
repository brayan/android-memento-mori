package br.com.sailboat.mementomori.ui.model

data class CountdownModel(
    override val viewType: Int = ViewType.COUNTDOWN.ordinal,
    val countdown: Int,
    val unit: String
) : RecyclerViewItem