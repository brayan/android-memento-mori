package br.com.sailboat.mementomori.data

import android.util.Log
import br.com.sailboat.mementomori.domain.Logger
import javax.inject.Inject

class LogcatLogger @Inject constructor() : Logger {

    companion object {
        const val TAG = "LOGCAT_LOGGER"
    }

    override fun d(msg: String) {
        Log.d(TAG, msg)
    }

    override fun e(tr: Throwable) {
        Log.e(TAG, tr.message ?: "Error", tr)
    }

    override fun e(msg: String, tr: Throwable) {
        Log.e(TAG, msg, tr)
    }

}