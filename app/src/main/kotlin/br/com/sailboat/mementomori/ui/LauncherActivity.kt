package br.com.sailboat.mementomori.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.sailboat.mementomori.App
import br.com.sailboat.mementomori.domain.usecase.ContainsDateOfDeath
import br.com.sailboat.mementomori.settings.SetUpInitialSettings
import br.com.sailboat.mementomori.ui.countdown.CountdownActivity
import br.com.sailboat.mementomori.ui.insert.InsertYearActivity
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class LauncherActivity : AppCompatActivity() {

    @Inject
    lateinit var setUpInitialSettings: SetUpInitialSettings

    @Inject
    lateinit var containsDateOfDeath: ContainsDateOfDeath

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as App).appComponent.inject(this)

        launch(UI) {
            async { setUpInitialSettings() }.await()

            if (async { containsDateOfDeath() }.await()) {
                CountdownActivity.startFrom(this@LauncherActivity)
            } else {
                InsertYearActivity.startFrom(this@LauncherActivity)
            }

            finish()
        }
    }

}