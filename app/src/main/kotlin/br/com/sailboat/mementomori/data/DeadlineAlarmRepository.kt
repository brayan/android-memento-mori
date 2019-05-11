package br.com.sailboat.mementomori.data

import java.util.*

interface DeadlineAlarmRepository {
    fun add(deadline: Calendar)
    fun remove()
}