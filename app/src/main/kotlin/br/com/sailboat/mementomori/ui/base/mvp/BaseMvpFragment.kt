package br.com.sailboat.mementomori.ui.base.mvp

import android.content.Intent
import android.os.Bundle
import android.view.View
import br.com.sailboat.mementomori.ui.base.BaseFragment
import javax.inject.Inject

abstract class BaseMvpFragment<P : BaseMvpContract.Presenter> : BaseFragment(), BaseMvpContract.View {

    @Inject
    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        retainInstance = true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun postResult(requestCode: Int, data: Intent?) {
        super.postResult(requestCode, data)
        presenter.postResult()
    }

}