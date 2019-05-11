package br.com.sailboat.mementomori.ui.about

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import br.com.sailboat.mementomori.ui.model.LabelAndValueModel
import br.com.sailboat.mementomori.ui.model.RecyclerViewItem
import br.com.sailboat.mementomori.ui.model.TitleModel
import br.com.sailboat.mementomori.ui.model.ViewType
import br.com.sailboat.mementomori.ui.model.viewholder.LabelAndValueViewHolder
import br.com.sailboat.mementomori.ui.model.viewholder.TitleViewHolder

class AboutAdapter(var callback: Callback) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        when (viewType) {
            ViewType.TITLE.ordinal -> return TitleViewHolder(parent)
            ViewType.LABEL_VALUE.ordinal -> return LabelAndValueViewHolder(parent)
            else -> throw RuntimeException("ViewHolder not found")
        }

    }

    override fun getItemCount() = callback.getAbout().size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = callback.getAbout()[position]

        when (holder) {
            is TitleViewHolder -> holder.bindItem(item as TitleModel)
            is LabelAndValueViewHolder -> holder.bindItem(item as LabelAndValueModel)
            else -> throw RuntimeException("ViewHolder not found")
        }
    }

    override fun getItemViewType(position: Int) = callback.getAbout()[position].viewType


    interface Callback {
        fun getAbout(): List<RecyclerViewItem>
    }

}