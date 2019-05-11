package br.com.sailboat.mementomori.ui.model

data class SecondsModel(
    override val viewType: Int = ViewType.SECONDS.ordinal,
    val seconds: Int
) : RecyclerViewItem