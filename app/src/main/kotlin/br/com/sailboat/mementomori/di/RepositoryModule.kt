package br.com.sailboat.mementomori.di

import android.content.Context
import br.com.sailboat.mementomori.data.DeadlineAlarmRepositoryImpl
import br.com.sailboat.mementomori.settings.SettingsRepositoryImpl
import br.com.sailboat.mementomori.data.YearOfDeathRepositoryImpl
import br.com.sailboat.mementomori.data.DeadlineAlarmRepository
import br.com.sailboat.mementomori.settings.SettingsRepository
import br.com.sailboat.mementomori.domain.repository.YearOfDeathRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesYearRepository(context: Context): YearOfDeathRepository {
        return YearOfDeathRepositoryImpl(context)
    }

    @Provides
    @Singleton
    fun providesSettingsRepository(context: Context): SettingsRepository {
        return SettingsRepositoryImpl(context)
    }

    @Provides
    @Singleton
    fun providesDeadlineAlarmRepository(context: Context): DeadlineAlarmRepository {
        return DeadlineAlarmRepositoryImpl(context)
    }

}