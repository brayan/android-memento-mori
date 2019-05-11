package br.com.sailboat.mementomori.settings

interface SettingsRepository {
    fun isFirstTimeRunningApp(): Boolean
    fun setFirstTimeRunningApp(firstTime: Boolean)
    fun getNotificationSound(): String?
    fun setNotificationSound(sound: String?)
    fun allowVibration(): Boolean
    fun setAllowVibration(vibration: Boolean)
}