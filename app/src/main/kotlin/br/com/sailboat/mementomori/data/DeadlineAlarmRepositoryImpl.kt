package br.com.sailboat.mementomori.data

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import br.com.sailboat.mementomori.receivers.AlarmReceiver
import java.util.*

class DeadlineAlarmRepositoryImpl(val context: Context) : DeadlineAlarmRepository {

    private val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    private val alarmIntent = Intent(context, AlarmReceiver::class.java).let {
        PendingIntent.getBroadcast(context, 0, it, PendingIntent.FLAG_UPDATE_CURRENT)
    }

    override fun add(deadline: Calendar) {
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, deadline.timeInMillis, alarmIntent)
    }

    override fun remove() {
        alarmManager.cancel(alarmIntent)
    }

}