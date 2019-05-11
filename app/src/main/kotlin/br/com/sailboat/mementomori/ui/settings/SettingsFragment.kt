package br.com.sailboat.mementomori.ui.settings

import android.content.Intent
import android.media.RingtoneManager
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import br.com.sailboat.mementomori.App
import br.com.sailboat.mementomori.R
import br.com.sailboat.mementomori.ui.about.AboutActivity
import br.com.sailboat.mementomori.ui.base.mvp.BaseMvpFragment
import br.com.sailboat.mementomori.ui.helper.RequestCode
import kotlinx.android.synthetic.main.appbar.*
import kotlinx.android.synthetic.main.frg_settings.*

class SettingsFragment : BaseMvpFragment<SettingsContract.Presenter>(), SettingsContract.View {

    override fun inject() {
        (activity?.application as App).appComponent.inject(this)
    }

    override fun getLayoutId() = R.layout.frg_settings

    override fun initViews() {
        initToolbar()
        lnlNotifications.setOnClickListener { presenter.onClickNotificationSound() }
        frlVibrate.setOnClickListener { cbxVibrate.performClick() }
        cbxVibrate.setOnCheckedChangeListener { _, isChecked -> presenter.onClickVibrate(isChecked) }
        lnlAbout.setOnClickListener { presenter.onClickAbout() }
    }

    override fun setNotificationSound(notificationSound: String?) {
        if (notificationSound != null) {
            val uri = Uri.parse(notificationSound)
            val ringtone = RingtoneManager.getRingtone(context, uri)
            txtNotificationSound.text = ringtone.getTitle(context)
        } else {
            txtNotificationSound.text = getString(R.string.settings_notification_tone_none)
        }
    }

    override fun setAllowVibration(allowVibration: Boolean) {
        cbxVibrate.isChecked = allowVibration
    }

    override fun navigateToRingtonePicker(notificationSound: String?) {
        val intent = Intent(RingtoneManager.ACTION_RINGTONE_PICKER)
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE, RingtoneManager.TYPE_NOTIFICATION)
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TITLE, getString(R.string.settings_notification_tone))
        notificationSound?.run { intent.putExtra(RingtoneManager.EXTRA_RINGTONE_EXISTING_URI, Uri.parse(notificationSound)) }

        startActivityForResult(intent, RequestCode.NOTIFICATION_SOUND_SETTINGS.ordinal)
    }

    override fun navigateToAbout() {
        activity?.run { AboutActivity.startFrom(this) }
    }

    override fun onResultOk(requestCode: Int, data: Intent?) {
        super.onResultOk(requestCode, data)

        when (requestCode) {
            RequestCode.NOTIFICATION_SOUND_SETTINGS.ordinal -> {
                var uri = data?.getParcelableExtra<Uri>(RingtoneManager.EXTRA_RINGTONE_PICKED_URI)
                presenter.onSelectRingtone(uri?.toString())
            }

        }

    }

    private fun initToolbar() {
        toolbar.run {
            (activity as AppCompatActivity).setSupportActionBar(this)
            setTitle(R.string.title_settings)
            setNavigationIcon(R.drawable.ic_arrow_back_white_24dp)
            setNavigationOnClickListener { activity?.onBackPressed() }
        }
    }

}