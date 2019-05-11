package br.com.sailboat.mementomori.domain.helper

import org.joda.time.LocalDateTime
import org.joda.time.Period
import java.util.*


object DatePeriodHelper {

    fun getPeriod(start: Calendar, ent: Calendar): Period {
        return Period(LocalDateTime(start), LocalDateTime(ent))
    }

}