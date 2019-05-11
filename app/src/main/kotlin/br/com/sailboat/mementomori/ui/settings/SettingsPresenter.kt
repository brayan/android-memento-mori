package br.com.sailboat.mementomori.ui.settings

import br.com.sailboat.mementomori.settings.SettingsRepository
import br.com.sailboat.mementomori.ui.base.mvp.BasePresenter
import javax.inject.Inject

class SettingsPresenter @Inject constructor(
    private val viewModel: SettingsViewModel,
    private val settingsRepository: SettingsRepository
) : BasePresenter<SettingsContract.View>(),
    SettingsContract.Presenter {

    override fun setUp() {
        loadSettings()
    }

    override fun restart() {
        updateContentViews()
    }

    override fun onClickNotificationSound() {
        view?.navigateToRingtonePicker(viewModel.notificationSound)
    }

    override fun onClickVibrate(checked: Boolean) {
        settingsRepository.setAllowVibration(checked)
        viewModel.allowVibration = checked
    }

    override fun onClickAbout() {
        view?.navigateToAbout()
    }

    override fun onSelectRingtone(ringtone: String?) {
        viewModel.notificationSound = ringtone
        settingsRepository.setNotificationSound(ringtone)
        updateContentViews()
    }

    private fun loadSettings() {
        launchAsync {
            viewModel.notificationSound = settingsRepository.getNotificationSound()
            viewModel.allowVibration = settingsRepository.allowVibration()
            updateContentViews()
        }
    }

    private fun updateContentViews() {
        view?.setNotificationSound(viewModel.notificationSound)
        view?.setAllowVibration(viewModel.allowVibration)
    }

}