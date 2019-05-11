package br.com.sailboat.mementomori.domain.helper

import java.util.*

fun Calendar.resetTimeFields(): Calendar {
    set(Calendar.HOUR_OF_DAY, 0)
    set(Calendar.SECOND, 0)
    set(Calendar.MINUTE, 0)
    set(Calendar.MILLISECOND, 0)
    return this
}