package br.com.sailboat.mementomori.ui.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v4.app.NotificationCompat
import br.com.sailboat.mementomori.R
import br.com.sailboat.mementomori.settings.SettingsRepository
import br.com.sailboat.mementomori.ui.LauncherActivity
import javax.inject.Inject


class DeadlineNotification @Inject constructor(private val context: Context, private val settingsRepository: SettingsRepository) {

    fun throwNotification() {
        val mNotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val channelId = NotificationChannels.DEADLINE.channelId

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val channelName = context.getString(NotificationChannels.DEADLINE.channelName)
            val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT)
            channel.description = "Basic Notification"
            mNotificationManager.createNotificationChannel(channel)
        }

        val mBuilder = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setCategory(NotificationCompat.CATEGORY_ALARM)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentTitle(context.getString(R.string.notification_title_deadline))
            .setContentText("Remember!")
            .setAutoCancel(true)

        initVibrate(mBuilder)
        initSound(mBuilder)

        val resultIntent = Intent(context, LauncherActivity::class.java)

        val resultPendingIntent = PendingIntent.getActivity(context, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT)
        mBuilder.setContentIntent(resultPendingIntent)

        mNotificationManager.notify(0, mBuilder.build())
    }

    private fun initVibrate(builder: NotificationCompat.Builder) {
        if (settingsRepository.allowVibration()) {
            builder.setDefaults(NotificationCompat.DEFAULT_VIBRATE or NotificationCompat.DEFAULT_LIGHTS)
        } else {
            builder.setDefaults(NotificationCompat.DEFAULT_LIGHTS)
        }
    }

    private fun initSound(builder: NotificationCompat.Builder) {
        settingsRepository.getNotificationSound()?.run { builder.setSound(Uri.parse(this)) }
    }


}