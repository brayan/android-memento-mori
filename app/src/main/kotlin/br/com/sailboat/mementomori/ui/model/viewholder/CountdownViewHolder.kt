package br.com.sailboat.mementomori.ui.model.viewholder

import android.view.ViewGroup
import br.com.sailboat.mementomori.R
import br.com.sailboat.mementomori.ui.base.BaseViewHolder
import br.com.sailboat.mementomori.ui.model.CountdownModel
import kotlinx.android.synthetic.main.vh_countdown.view.*

class CountdownViewHolder(parent: ViewGroup) :
    BaseViewHolder<CountdownModel>(inflate(parent, R.layout.vh_countdown)) {

    override fun bindItem(item: CountdownModel) {
        itemView.txtCountdown.text = item.countdown.toString()
        itemView.txtUnit.text = item.unit
    }

}