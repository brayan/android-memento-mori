package br.com.sailboat.mementomori.ui.countdown

import br.com.sailboat.mementomori.data.RemoveDeadlineAlarm
import br.com.sailboat.mementomori.domain.helper.DatePeriodHelper
import br.com.sailboat.mementomori.domain.usecase.GetDateOfDeath
import br.com.sailboat.mementomori.domain.usecase.RemoveDateOfDeath
import br.com.sailboat.mementomori.ui.base.mvp.BasePresenter
import kotlinx.coroutines.delay
import java.util.*
import javax.inject.Inject

class CountdownPresenter @Inject constructor(
    private val viewModel: CountdownViewModel,
    private val getCountdownDetails: GetCountdownDetails,
    private val getDateOfDeath: GetDateOfDeath,
    private val removeDateOfDeath: RemoveDateOfDeath,
    private val removeDeadlineAlarm: RemoveDeadlineAlarm
) : BasePresenter<CountdownContract.View>(), CountdownContract.Presenter {

    override fun setUp() {
        loadDetails()
    }

    override fun getDetails() = viewModel.entityDetails

    override fun onClickDelete() {
        view?.showDeleteOptions()
    }

    override fun onClickYesOnDelete() {
        cancelAllAsync()
        launchAsync {
            removeDateOfDeath()
            removeDeadlineAlarm()
            view?.navigateToInsertYear()
            view?.closeWithSuccess()
        }
    }

    override fun onClickSettings() {
        view?.navigateToSettings()
    }

    private fun loadDetails() {
        launchAsync {
            try {
                viewModel.calendarNow = Calendar.getInstance()
                viewModel.calendarDeath = getDateOfDeath()

                while (true) {
                    viewModel.calendarNow.add(Calendar.SECOND, 1)

                    val period =
                        DatePeriodHelper.getPeriod(viewModel.calendarNow, viewModel.calendarDeath)

                    view?.setSeconds(period.seconds.toString())

                    viewModel.entityDetails.clear()
                    viewModel.entityDetails.addAll(getCountdownDetails(period))

                    view?.updateDetails()

                    delay(1000)
                }
            } catch (e: Exception) {
                view?.logError(e)
            }
        }
    }

}