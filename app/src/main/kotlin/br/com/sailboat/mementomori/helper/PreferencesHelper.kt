package br.com.sailboat.mementomori.helper

import android.content.Context
import android.content.SharedPreferences

object PreferencesHelper {

    private const val KEY = "br.com.sailboat.mementomori.PREFERENCE_KEY"

    fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(KEY, Context.MODE_PRIVATE)
    }

}