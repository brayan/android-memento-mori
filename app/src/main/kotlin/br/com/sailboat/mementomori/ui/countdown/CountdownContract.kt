package br.com.sailboat.mementomori.ui.countdown

import br.com.sailboat.mementomori.ui.base.mvp.BaseMvpContract
import br.com.sailboat.mementomori.ui.model.RecyclerViewItem

interface CountdownContract {

    interface View : BaseMvpContract.View {
        fun setSeconds(seconds: String)
        fun updateDetails()
        fun navigateToInsertYear()
        fun navigateToSettings()
        fun showDeleteOptions()
    }

    interface Presenter : BaseMvpContract.Presenter {
        fun getDetails(): List<RecyclerViewItem>
        fun onClickDelete()
        fun onClickSettings()
        fun onClickYesOnDelete()
    }

}