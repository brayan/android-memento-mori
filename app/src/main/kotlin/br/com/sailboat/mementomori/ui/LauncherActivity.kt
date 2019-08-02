package br.com.sailboat.mementomori.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.sailboat.mementomori.App
import br.com.sailboat.mementomori.domain.usecase.ContainsDateOfDeath
import br.com.sailboat.mementomori.settings.SetUpInitialSettings
import br.com.sailboat.mementomori.ui.countdown.CountdownActivity
import br.com.sailboat.mementomori.ui.insert.InsertYearActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class LauncherActivity : AppCompatActivity() {

    @Inject
    lateinit var setUpInitialSettings: SetUpInitialSettings

    @Inject
    lateinit var containsDateOfDeath: ContainsDateOfDeath

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as App).appComponent.inject(this)

        GlobalScope.launch(Dispatchers.Main) {
            setUpInitialSettings()

            if (containsDateOfDeath()) {
                CountdownActivity.startFrom(this@LauncherActivity)
            } else {
                InsertYearActivity.startFrom(this@LauncherActivity)
            }

            finish()
        }
    }

}