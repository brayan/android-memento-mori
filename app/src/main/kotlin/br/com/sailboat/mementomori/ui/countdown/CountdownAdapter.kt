package br.com.sailboat.mementomori.ui.countdown

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import br.com.sailboat.mementomori.ui.model.CountdownModel
import br.com.sailboat.mementomori.ui.model.RecyclerViewItem
import br.com.sailboat.mementomori.ui.model.SecondsModel
import br.com.sailboat.mementomori.ui.model.ViewType
import br.com.sailboat.mementomori.ui.model.viewholder.CountdownViewHolder
import br.com.sailboat.mementomori.ui.model.viewholder.SecondsViewHolder

class CountdownAdapter(var callback: Callback) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        when (viewType) {
            ViewType.COUNTDOWN.ordinal -> return CountdownViewHolder(parent)
            ViewType.SECONDS.ordinal -> return SecondsViewHolder(parent)
            else -> throw RuntimeException("ViewHolder not found")
        }

    }

    override fun getItemCount() = callback.getDetails().size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = callback.getDetails()[position]

        when (holder) {
            is CountdownViewHolder -> holder.bindItem(item as CountdownModel)
            is SecondsViewHolder -> holder.bindItem(item as SecondsModel)
            else -> throw RuntimeException("ViewHolder not found")
        }
    }

    override fun getItemViewType(position: Int) = callback.getDetails()[position].viewType


    interface Callback {
        fun getDetails(): List<RecyclerViewItem>
    }

}