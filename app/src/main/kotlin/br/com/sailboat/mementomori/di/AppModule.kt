package br.com.sailboat.mementomori.di

import android.app.Application
import android.content.Context
import br.com.sailboat.mementomori.data.LogcatLogger
import br.com.sailboat.mementomori.domain.Logger
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Provides
    @Singleton
    fun providesApplicationContext(): Context = application

    @Singleton
    @Provides
    fun providesLogger(logger: LogcatLogger): Logger {
        return logger
    }

}