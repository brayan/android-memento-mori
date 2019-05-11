package br.com.sailboat.mementomori.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import br.com.sailboat.mementomori.App
import br.com.sailboat.mementomori.data.SetDeadlineAlarm
import javax.inject.Inject

class BootReceiver : BroadcastReceiver() {

    @Inject
    lateinit var setDeadlineAlarm: SetDeadlineAlarm

    override fun onReceive(context: Context?, intent: Intent?) {
        (context?.applicationContext as App).appComponent.inject(this)

        if (isBootCompleted(intent)) {
            setDeadlineAlarm()
        }
    }

    private fun isBootCompleted(intent: Intent?): Boolean {
        return intent?.action == "android.intent.action.BOOT_COMPLETED"
    }

}