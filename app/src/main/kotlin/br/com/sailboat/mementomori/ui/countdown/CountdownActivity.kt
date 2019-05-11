package br.com.sailboat.mementomori.ui.countdown

import android.content.Context
import android.content.Intent
import br.com.sailboat.mementomori.ui.base.BaseActivity

class CountdownActivity  : BaseActivity() {

    companion object {
        fun startFrom(context: Context) {
            val intent = Intent(context, CountdownActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun newFragmentInstance() = CountdownFragment()

}
