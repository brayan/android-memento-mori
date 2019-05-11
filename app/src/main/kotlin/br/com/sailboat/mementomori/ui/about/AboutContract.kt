package br.com.sailboat.mementomori.ui.about

import br.com.sailboat.mementomori.ui.base.mvp.BaseMvpContract
import br.com.sailboat.mementomori.ui.model.RecyclerViewItem

interface AboutContract {

    interface View : BaseMvpContract.View {
        fun updateDetails()
    }

    interface Presenter : BaseMvpContract.Presenter {
        fun getDetails(): List<RecyclerViewItem>
    }

}