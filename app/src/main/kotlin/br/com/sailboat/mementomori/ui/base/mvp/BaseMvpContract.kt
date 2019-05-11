package br.com.sailboat.mementomori.ui.base.mvp

interface BaseMvpContract {

    interface View {
        fun showProgress()
        fun hideProgress()
        fun closeKeyboard()
        fun closeWithSuccess()
        fun closeWithFailure()
        fun closeWithFailureDefaultMessage()
        fun disableKeyboardOnStart()
        fun logError(e: Exception)
        fun showErrorOnPerformOperation()
    }

    interface Presenter {
        fun attachView(view: View?)
        fun detachView()
        fun postResult()
        fun onDestroy()
    }

}