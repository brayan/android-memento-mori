package br.com.sailboat.mementomori.ui.model

data class TitleModel(
override val viewType: Int = ViewType.TITLE.ordinal,
val title: String
) : RecyclerViewItem