package br.com.sailboat.mementomori.ui.insert

import android.content.Context
import android.content.Intent
import br.com.sailboat.mementomori.ui.base.BaseActivity

class InsertYearActivity : BaseActivity() {

    companion object {
        fun startFrom(context: Context) {
            val intent = Intent(context, InsertYearActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun newFragmentInstance() = InsertYearFragment()

}