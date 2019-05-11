package br.com.sailboat.mementomori.ui.settings

import br.com.sailboat.mementomori.ui.base.mvp.BaseMvpContract

interface SettingsContract {

    interface View : BaseMvpContract.View {
        fun setNotificationSound(notificationSound: String?)
        fun navigateToRingtonePicker(notificationSound: String?)
        fun setAllowVibration(allowVibration: Boolean)
        fun navigateToAbout()
    }

    interface Presenter : BaseMvpContract.Presenter {
        fun onClickNotificationSound()
        fun onSelectRingtone(ringtone: String?)
        fun onClickVibrate(checked: Boolean)
        fun onClickAbout()
    }

}