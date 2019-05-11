package br.com.sailboat.mementomori.ui.countdown

import br.com.sailboat.mementomori.ui.model.RecyclerViewItem
import java.util.*
import javax.inject.Inject

class CountdownViewModel @Inject constructor() {

    lateinit var calendarNow: Calendar
    lateinit var calendarDeath: Calendar
    val entityDetails = mutableListOf<RecyclerViewItem>()

}