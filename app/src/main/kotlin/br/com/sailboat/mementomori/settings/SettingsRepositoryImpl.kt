package br.com.sailboat.mementomori.settings

import android.content.Context
import br.com.sailboat.mementomori.helper.PreferencesHelper

class SettingsRepositoryImpl(val context: Context) : SettingsRepository {

    companion object {
        private const val SETTING_NOTIFICATION_SOUND = "SETTING_NOTIFICATION_SOUND"
        private const val SETTING_FIRST_TIME_RUNNING = "SETTING_FIRST_TIME_RUNNING"
        private const val SETTING_ALLOW_VIBRATION = "SETTING_ALLOW_VIBRATION"
    }

    private val preferences = PreferencesHelper.getSharedPreferences(context)

    override fun isFirstTimeRunningApp(): Boolean {
        return preferences.getBoolean(SETTING_FIRST_TIME_RUNNING, true)
    }

    override fun setFirstTimeRunningApp(firstTime: Boolean) {
        preferences.edit().putBoolean(SETTING_FIRST_TIME_RUNNING, firstTime).apply()
    }

    override fun getNotificationSound(): String? {
        return preferences.getString(SETTING_NOTIFICATION_SOUND, null)
    }

    override fun setNotificationSound(sound: String?) {
        val edit = preferences.edit()

        if (sound == null) {
            edit.remove(SETTING_NOTIFICATION_SOUND)
        } else {
            edit.putString(SETTING_NOTIFICATION_SOUND, sound)
        }

        edit.apply()
    }

    override fun allowVibration(): Boolean {
        return preferences.getBoolean(SETTING_ALLOW_VIBRATION, true)
    }

    override fun setAllowVibration(vibration: Boolean) {
        preferences.edit().putBoolean(SETTING_ALLOW_VIBRATION, vibration).apply()
    }

}