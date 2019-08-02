package br.com.sailboat.mementomori.ui.insert

import br.com.sailboat.mementomori.data.SetDeadlineAlarm
import br.com.sailboat.mementomori.domain.Logger
import br.com.sailboat.mementomori.domain.usecase.AddYearOfDeath
import br.com.sailboat.mementomori.domain.usecase.GetMaxDateOfDeath
import br.com.sailboat.mementomori.domain.usecase.GetMinDateOfDeath
import br.com.sailboat.mementomori.ui.base.mvp.BasePresenter
import java.util.*
import javax.inject.Inject

class InsertYearPresenter @Inject constructor(
    private val viewModel: InsertYearViewModel,
    private val getMinDateOfDeath: GetMinDateOfDeath,
    private val getMaxDateOfDeath: GetMaxDateOfDeath,
    private val addYearOfDeath: AddYearOfDeath,
    private val setDeadlineAlarm: SetDeadlineAlarm,
    private val logger: Logger
) : BasePresenter<InsertYearContract.View>(), InsertYearContract.Presenter {

    override fun setUp() {
        launchAsync {
            loadYearInfo()
            updateContentViews()
        }
    }

    override fun restart() {
        updateContentViews()
    }

    override fun onSelectYear(year: Int) {
        viewModel.currentYear = year
    }

    override fun onClickSettings() {
        view?.navigateToSettings()
    }

    override fun onClickSkull() {
        launchAsync {
            try {
                logger.d("InsertYearPresenter.onClickSkull()")
                addYearOfDeath(viewModel.currentYear)
                setDeadlineAlarm()
                view?.navigateToCountdown()
                view?.closeWithSuccess()
            } catch (e: Exception) {
                logger.e("Error InsertYearPresenter.onClickSkull", e)
                view?.showErrorOnSaveYear()
            }
        }

    }

    private fun loadYearInfo() {
        viewModel.minYear = getMinDateOfDeath().get(Calendar.YEAR)
        viewModel.maxYear = getMaxDateOfDeath().get(Calendar.YEAR)
        viewModel.currentYear = viewModel.minYear
    }

    private fun updateContentViews() {
        logger.d("InsertYearPresenter.updateContentViews()")

        view?.setCurrentYear(viewModel.currentYear)

       /* var years = mutableListOf<String>()
        for (i in viewModel.minYear..viewModel.maxYear) {
            years.add(i.toString())
        }

        view?.setYears(years.toTypedArray())*/

        view?.setMinYear(viewModel.minYear)
        view?.setMaxYear(viewModel.maxYear)

    }

}