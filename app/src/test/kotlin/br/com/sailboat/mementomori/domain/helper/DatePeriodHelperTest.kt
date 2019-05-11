package br.com.sailboat.mementomori.domain.helper

import org.junit.Assert
import org.junit.Test
import java.util.*

class DatePeriodHelperTest {

    @Test
    fun testDatePeriod() {
        val now = Calendar.getInstance()
        val fiftyYearsFromNow = Calendar.getInstance()

        fiftyYearsFromNow.add(Calendar.YEAR, 50);

        val period = DatePeriodHelper.getPeriod(now, fiftyYearsFromNow)

        Assert.assertEquals(50, period.years)
    }
}