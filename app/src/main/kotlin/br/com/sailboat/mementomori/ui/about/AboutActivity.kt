package br.com.sailboat.mementomori.ui.about

import android.content.Context
import android.content.Intent
import br.com.sailboat.mementomori.ui.base.BaseActivity

class AboutActivity  : BaseActivity() {

    companion object {
        fun startFrom(context: Context) {
            val intent = Intent(context, AboutActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun newFragmentInstance() = AboutFragment()

}
