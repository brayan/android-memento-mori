package br.com.sailboat.mementomori.data

import android.content.Context
import br.com.sailboat.mementomori.domain.repository.YearOfDeathRepository
import br.com.sailboat.mementomori.helper.PreferencesHelper

class YearOfDeathRepositoryImpl(context: Context) : YearOfDeathRepository {

    companion object {
        const val YEAR_KEY = "YEAR_KEY"
        const val INVALID_YEAR = -1
    }

    private val preferences = PreferencesHelper.getSharedPreferences(context)

    override fun get(): Int {
        return preferences.getInt(YEAR_KEY, INVALID_YEAR)
    }

    override fun add(year: Int) {
        preferences.edit().putInt(YEAR_KEY, year).apply()
    }

    override fun remove() {
        preferences.edit().remove(YEAR_KEY).apply()
    }

    override fun contains() = (get() != INVALID_YEAR)
}