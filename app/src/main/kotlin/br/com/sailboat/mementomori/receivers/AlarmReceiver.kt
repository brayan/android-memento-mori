package br.com.sailboat.mementomori.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import br.com.sailboat.mementomori.App
import br.com.sailboat.mementomori.ui.notifications.DeadlineNotification
import javax.inject.Inject

class AlarmReceiver : BroadcastReceiver() {

    @Inject
    lateinit var deadlineNotification: DeadlineNotification

    override fun onReceive(context: Context?, intent: Intent?) {
        (context?.applicationContext as App).appComponent.inject(this)
        deadlineNotification.throwNotification()

        // TODO: SET ALARM FOR NEXT YEAR.
    }

}