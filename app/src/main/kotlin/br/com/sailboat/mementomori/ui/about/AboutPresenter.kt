package br.com.sailboat.mementomori.ui.about

import br.com.sailboat.mementomori.ui.base.mvp.BasePresenter
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
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
        launchAsync {
            try {
                view?.showProgress()
                val details = async(CommonPool) { getAbout() }.await()

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