package br.com.sailboat.mementomori.ui.base;

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.sailboat.mementomori.R
import br.com.sailboat.mementomori.ui.dialog.MessageDialog
import br.com.sailboat.mementomori.ui.dialog.ProgressDialog
import br.com.sailboat.mementomori.ui.helper.Extras
import br.com.sailboat.mementomori.ui.helper.UIHelper

abstract class BaseFragment: Fragment() {

    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }

    open fun inject() {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initListeners()
    }

    open fun initViews() {}

    open fun initListeners() {}

    fun showProgress() {
        progressDialog = ProgressDialog()
        progressDialog?.show(fragmentManager!!, "PROGRESS")
    }

    fun hideProgress() {
        if (progressDialog != null) {
            progressDialog?.dismiss()
            progressDialog = null
        }
    }

    fun showErrorMessage(msgId: Int) {
        MessageDialog.show(fragmentManager!!, R.string.dlg_title_warning, msgId)
    }

    fun showFeedbackMessage(msgId: Int) {
        if (view is CoordinatorLayout) {
            Snackbar.make(view!!, msgId, 4000).show()
        } else {
            Toast.makeText(activity, msgId, Toast.LENGTH_LONG).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (resultCode) {
            Activity.RESULT_OK -> {
                onResultOk(requestCode, data)
            }
            Activity.RESULT_CANCELED -> {
                onResultCanceled(requestCode, data)
            }
        }

        postResult(requestCode, data)
    }

    open fun onResultOk(requestCode: Int, data: Intent?) {
        if (Extras.hasFeedbackMessage(data)) {
            showFeedbackMessage(Extras.getFeedbackMessage(data)!!)
        }
    }

    open fun onResultCanceled(requestCode: Int, data: Intent?) {
        if (Extras.hasErrorMessage(data)) {
            showErrorMessage(Extras.getErrorMessage(data)!!)
        }
    }

    open fun postResult(requestCode: Int, data: Intent?) {
    }

    fun closeKeyboard() {
        UIHelper.closeKeyboard(activity)
    }

    fun disableKeyboardOnStart() {
        UIHelper.disableKeyboardOnStart(activity)
    }

    fun closeWithSuccess() {
        activity?.setResult(Activity.RESULT_OK)
        activity?.finish()
    }

    fun closeWithSuccess(msgId: Int) {
        val intent = Intent()
        Extras.putFeedbackMessage(intent, msgId)

        activity?.setResult(Activity.RESULT_OK, intent)
        activity?.finish()
    }

    fun closeWithFailure() {
        activity?.setResult(Activity.RESULT_CANCELED)
        activity?.finish()
    }

    fun closeWithFailure(msgId: Int) {
        val intent = Intent()
        Extras.putFeedbackMessage(intent, msgId)

        activity?.setResult(Activity.RESULT_CANCELED)
        activity?.finish()
    }

    fun closeWithFailureDefaultMessage() {
        closeWithFailure(R.string.default_msg_error)
    }

    fun logError(e: Exception) {
        Log.e("APP_ERROR_LOG", e.message ?: getString(R.string.default_msg_error), e)
    }

    fun showErrorOnPerformOperation() {
        showErrorMessage(R.string.msg_data_cant_be_greater)
    }

    protected abstract fun getLayoutId(): Int

}