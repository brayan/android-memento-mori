package br.com.sailboat.mementomori.ui.insert

import android.support.v7.app.AppCompatActivity
import br.com.sailboat.mementomori.App
import br.com.sailboat.mementomori.R
import br.com.sailboat.mementomori.ui.base.mvp.BaseMvpFragment
import br.com.sailboat.mementomori.ui.countdown.CountdownActivity
import br.com.sailboat.mementomori.ui.settings.SettingsActivity
import kotlinx.android.synthetic.main.appbar.*
import kotlinx.android.synthetic.main.frg_insert_date.*

class InsertYearFragment : BaseMvpFragment<InsertYearContract.Presenter>(), InsertYearContract.View {

    override fun inject() {
        (activity?.application as App).appComponent.inject(this)
    }

    override fun getLayoutId() = R.layout.frg_insert_date

    override fun initViews() {
        initToolbar()
        initNumberPicker()
        initSkullButton()
    }

    override fun setMinYear(year: Int) {
        numberPicker.minValue = year
    }

    override fun setMaxYear(year: Int) {
        numberPicker.maxValue = year
    }

    override fun setCurrentYear(year: Int) {
        numberPicker.value = year
    }

    override fun navigateToCountdown() {
        activity?.run { CountdownActivity.startFrom(this) }
    }

    override fun navigateToSettings() {
        activity?.run { SettingsActivity.startFrom(this) }
    }

    override fun showErrorOnSaveYear() {
        showErrorMessage(R.string.error_on_save_year)
    }

    private fun initToolbar() {
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
    }

    private fun initNumberPicker() {
        numberPicker.setOnValueChangedListener { _, _, newVal ->
            presenter.onSelectYear(newVal)
        }
    }

    private fun initSkullButton() {
        btnSkull.setOnClickListener { presenter.onClickSkull() }
    }

}