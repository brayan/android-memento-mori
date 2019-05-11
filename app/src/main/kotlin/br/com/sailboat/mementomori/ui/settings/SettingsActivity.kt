package br.com.sailboat.mementomori.ui.settings

import android.content.Context
import android.content.Intent
import br.com.sailboat.mementomori.ui.base.BaseActivity

class SettingsActivity  : BaseActivity() {

    companion object {
        fun startFrom(context: Context) {
            val intent = Intent(context, SettingsActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun newFragmentInstance() = SettingsFragment()

}
