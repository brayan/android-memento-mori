package br.com.sailboat.mementomori.ui.countdown

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import br.com.sailboat.mementomori.App
import br.com.sailboat.mementomori.R
import br.com.sailboat.mementomori.ui.base.mvp.BaseMvpFragment
import br.com.sailboat.mementomori.ui.dialog.OptionDialog
import br.com.sailboat.mementomori.ui.insert.InsertYearActivity
import br.com.sailboat.mementomori.ui.settings.SettingsActivity
import kotlinx.android.synthetic.main.appbar.*
import kotlinx.android.synthetic.main.frg_countdown.*

class CountdownFragment : BaseMvpFragment<CountdownContract.Presenter>(), CountdownContract.View {

    override fun inject() {
        (activity?.application as App).appComponent.inject(this)
    }

    override fun getLayoutId() = R.layout.frg_countdown

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.countdown_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?) = when (item?.itemId) {
        R.id.menu_delete -> {
            presenter.onClickDelete()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    override fun initViews() {
        initToolbar()
        initRecyclerView()
    }

    override fun setSeconds(seconds: String) {
        txtSeconds.text = seconds
    }

    override fun updateDetails() {
        recycler.adapter?.notifyDataSetChanged()
    }

    override fun navigateToInsertYear() {
        activity?.run { InsertYearActivity.startFrom(this) }
    }

    override fun navigateToSettings() {
        activity?.run { SettingsActivity.startFrom(this) }
    }

    override fun showDeleteOptions() {
        val dialog = OptionDialog()
        dialog.message = R.string.msg_delete
        dialog.yesOption = R.string.delete
        dialog.onClickPositive = DialogInterface.OnClickListener { _, _ ->
            presenter.onClickYesOnDelete()
        }
        dialog.show(fragmentManager, "DELETE_DIALOG")
    }

    private fun initRecyclerView() {
        recycler.run {
            adapter = CountdownAdapter(object : CountdownAdapter.Callback {
                override fun getDetails() = presenter.getDetails()
            })
        }
    }

    private fun initToolbar() {
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
    }

}