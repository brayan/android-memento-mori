package br.com.sailboat.mementomori.ui.base.mvp

import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.Main

abstract class BasePresenter<V : BaseMvpContract.View> : BaseMvpContract.Presenter {

    private var firstSession = true
    private val asyncJobs: MutableList<Job> = mutableListOf()
    var view: V? = null


    override fun attachView(view: BaseMvpContract.View?) {
        this.view = view as V
        onViewAttached()
    }

    override fun detachView() {
        view = null
    }

    override fun onDestroy() {
        cancelAllAsync()
    }

    fun launchAsync(block: suspend CoroutineScope.() -> Unit) {
        val job: Job = GlobalScope.launch(Dispatchers.Main) {
            try {
                block()
            } catch (e: Exception) {
                view?.logError(e)
                view?.showErrorOnPerformOperation()
            }
        }
        asyncJobs.add(job)
        job.invokeOnCompletion { asyncJobs.remove(job) }
    }

    fun cancelAllAsync() {
        val asyncJobsSize = asyncJobs.size

        if (asyncJobsSize > 0) {
            for (i in asyncJobsSize - 1 downTo 0) {
                asyncJobs[i].cancel()
            }
        }
    }

    private fun onViewAttached() {
        if (firstSession) {
            firstSession = false
            setUp()
        } else {
            restart()
        }
        postAttached()
    }

    open fun setUp() {}
    open fun restart() {}
    open fun postAttached() {}

    override fun postResult() {}
}