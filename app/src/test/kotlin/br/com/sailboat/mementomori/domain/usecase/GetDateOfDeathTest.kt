package br.com.sailboat.mementomori.domain.usecase

import br.com.sailboat.mementomori.domain.Logger
import br.com.sailboat.mementomori.domain.repository.YearOfDeathRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.*

class GetDateOfDeathTest {

    private val yearOfDeathRepository: YearOfDeathRepository = mock()
    private val logger: Logger = mock()

    private lateinit var getMinDateOfDeath: GetMinDateOfDeath
    private lateinit var getDateOfDeath: GetDateOfDeath

    @Before
    fun setUp() {
        getMinDateOfDeath = GetMinDateOfDeath(logger)
        getDateOfDeath = GetDateOfDeath(yearOfDeathRepository, getMinDateOfDeath)
    }

    @Test
    fun shouldReturnTheDateOfDeathAdded() {
        whenever(yearOfDeathRepository.contains()).thenReturn(true)
        whenever(yearOfDeathRepository.get()).thenReturn(2051)

        val calendar = getCalendarTest().apply {
            set(Calendar.YEAR, 2051)
        }

        assertEquals(calendar, getDateOfDeath())
    }

    @Test
    fun shouldReturnTheMinimumDateOfDeath() {
        whenever(yearOfDeathRepository.contains()).thenReturn(false)

        val calendar = getCalendarTest().apply {
            add(Calendar.YEAR, 1)
        }

        assertEquals(calendar, getDateOfDeath())
    }

    private fun getCalendarTest() = Calendar.getInstance().apply {
        set(Calendar.HOUR_OF_DAY, 0)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 0)
        set(Calendar.MILLISECOND, 0)
        set(Calendar.DAY_OF_YEAR, 1)
        set(Calendar.MONTH, 0)
    }

}