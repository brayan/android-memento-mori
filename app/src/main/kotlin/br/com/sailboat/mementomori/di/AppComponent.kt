package br.com.sailboat.mementomori.di

import br.com.sailboat.mementomori.receivers.AlarmReceiver
import br.com.sailboat.mementomori.receivers.BootReceiver
import br.com.sailboat.mementomori.ui.LauncherActivity
import br.com.sailboat.mementomori.ui.about.AboutFragment
import br.com.sailboat.mementomori.ui.countdown.CountdownFragment
import br.com.sailboat.mementomori.ui.insert.InsertYearFragment
import br.com.sailboat.mementomori.ui.settings.SettingsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, UIModule::class, RepositoryModule::class])
interface AppComponent {

    fun inject(activity: LauncherActivity)
    fun inject(fragment: InsertYearFragment)
    fun inject(fragment: CountdownFragment)
    fun inject(fragment: SettingsFragment)
    fun inject(fragment: AboutFragment)
    fun inject(receiver: BootReceiver)
    fun inject(receiver: AlarmReceiver)

}