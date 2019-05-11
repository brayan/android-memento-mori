package br.com.sailboat.mementomori.ui.settings

import javax.inject.Inject

class SettingsViewModel @Inject constructor() {

    var notificationSound: String?  = null
    var allowVibration: Boolean = true

}