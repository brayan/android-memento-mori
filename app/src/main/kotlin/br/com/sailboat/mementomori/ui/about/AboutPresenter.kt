package br.com.sailboat.mementomori.ui.about

import br.com.sailboat.mementomori.ui.base.mvp.BasePresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class AboutPresenter @Inject constructor(
    private val viewModel: AboutViewModel,
    private val getAbout: GetAbout
) : BasePresenter<AboutContract.View>(), AboutContract.Presenter {

    override fun setUp() {
        loadDetails()
    }

    override fun restart() {
        view?.updateDetails()
    }

    override fun getDetails() = viewModel.details

    private fun loadDetails() {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                view?.showProgress()
                val details = getAbout()

                viewModel.details.clear()
                viewModel.details.addAll(details)

                view?.updateDetails()
            } catch (e: Exception) {
                view?.logError(e)
            } finally {
                view?.hideProgress()
            }
        }
    }

}