package br.com.sailboat.mementomori.ui.insert

import br.com.sailboat.mementomori.ui.base.mvp.BaseMvpContract

interface InsertYearContract {

    interface View : BaseMvpContract.View {
        fun setMinYear(year: Int)
        fun setMaxYear(year: Int)
        fun setCurrentYear(year: Int)
        fun navigateToCountdown()
        fun navigateToSettings()
        fun showErrorOnSaveYear()
    }

    interface Presenter : BaseMvpContract.Presenter {
        fun onSelectYear(year: Int)
        fun onClickSettings()
        fun onClickSkull()
    }

}