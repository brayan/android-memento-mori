package br.com.sailboat.mementomori.ui.model.viewholder

import android.view.ViewGroup
import br.com.sailboat.mementomori.R
import br.com.sailboat.mementomori.ui.base.BaseViewHolder
import br.com.sailboat.mementomori.ui.model.TitleModel
import kotlinx.android.synthetic.main.vh_title.view.*

class TitleViewHolder(parent: ViewGroup) :
    BaseViewHolder<TitleModel>(inflate(parent, R.layout.vh_title)) {

    override fun bindItem(item: TitleModel) {
        itemView.tvTitle.text = item.title
    }

}