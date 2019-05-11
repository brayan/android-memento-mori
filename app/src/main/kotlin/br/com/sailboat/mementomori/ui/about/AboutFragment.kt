package br.com.sailboat.mementomori.ui.about

import android.support.v7.app.AppCompatActivity
import br.com.sailboat.mementomori.App
import br.com.sailboat.mementomori.R
import br.com.sailboat.mementomori.ui.base.mvp.BaseMvpFragment
import kotlinx.android.synthetic.main.appbar.*
import kotlinx.android.synthetic.main.recycler.*

class AboutFragment : BaseMvpFragment<AboutContract.Presenter>(), AboutContract.View {

    override fun inject() {
        (activity?.application as App).appComponent.inject(this)
    }

    override fun getLayoutId() = R.layout.frg_about

    override fun initViews() {
        initToolbar()
        initRecyclerView()
    }

    override fun updateDetails() {
        recycler.adapter?.notifyDataSetChanged()
    }

    private fun initToolbar() {
        toolbar.run {
            (activity as AppCompatActivity).setSupportActionBar(this)
            setTitle(R.string.title_about)
            setNavigationIcon(R.drawable.ic_arrow_back_white_24dp)
            setNavigationOnClickListener { activity?.onBackPressed() }
        }
    }

    private fun initRecyclerView() {
        recycler.run {
            adapter = AboutAdapter(object : AboutAdapter.Callback {
                override fun getAbout() = presenter.getDetails()
            })
        }
    }

}