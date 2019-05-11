package br.com.sailboat.mementomori.di

import br.com.sailboat.mementomori.ui.about.AboutContract
import br.com.sailboat.mementomori.ui.about.AboutPresenter
import br.com.sailboat.mementomori.ui.countdown.CountdownContract
import br.com.sailboat.mementomori.ui.countdown.CountdownPresenter
import br.com.sailboat.mementomori.ui.insert.InsertYearContract
import br.com.sailboat.mementomori.ui.insert.InsertYearPresenter
import br.com.sailboat.mementomori.ui.settings.SettingsContract
import br.com.sailboat.mementomori.ui.settings.SettingsPresenter
import dagger.Module
import dagger.Provides

@Module
class UIModule {

    @Provides
    fun providesSettingsPresenter(presenter: SettingsPresenter): SettingsContract.Presenter {
        return presenter
    }

    @Provides
    fun providesAboutPresenter(presenter: AboutPresenter): AboutContract.Presenter {
        return presenter
    }

    @Provides
    fun providesInsertDatePresenter(presenter: InsertYearPresenter): InsertYearContract.Presenter {
        return presenter
    }

    @Provides
    fun providesCountdownPresenter(presenter: CountdownPresenter): CountdownContract.Presenter {
        return presenter
    }

}