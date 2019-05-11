package br.com.sailboat.mementomori.settings

import android.media.RingtoneManager
import br.com.sailboat.mementomori.domain.UseCase
import javax.inject.Inject

class SetUpInitialSettings @Inject constructor(private val settingsRepository: SettingsRepository) : UseCase<Unit>() {

    override fun execute() {
        settingsRepository.apply {
            if (isFirstTimeRunningApp()) {
                val uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                setNotificationSound(uri.toString())
                setAllowVibration(true)
                setFirstTimeRunningApp(false)
            }
        }
    }

}