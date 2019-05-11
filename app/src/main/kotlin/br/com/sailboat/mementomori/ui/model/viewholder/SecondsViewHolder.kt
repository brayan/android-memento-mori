package br.com.sailboat.mementomori.ui.model.viewholder

import android.view.ViewGroup
import br.com.sailboat.mementomori.R
import br.com.sailboat.mementomori.ui.base.BaseViewHolder
import br.com.sailboat.mementomori.ui.model.SecondsModel
import kotlinx.android.synthetic.main.vh_seconds.view.*

class SecondsViewHolder(parent: ViewGroup) :
    BaseViewHolder<SecondsModel>(inflate(parent, R.layout.vh_seconds)) {

    override fun bindItem(item: SecondsModel) {
        itemView.txtSeconds.text = item.seconds.toString()
    }

}