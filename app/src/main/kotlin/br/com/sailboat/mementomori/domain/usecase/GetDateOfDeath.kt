package br.com.sailboat.mementomori.domain.usecase

import br.com.sailboat.mementomori.domain.UseCase
import br.com.sailboat.mementomori.domain.helper.resetTimeFields
import br.com.sailboat.mementomori.domain.repository.YearOfDeathRepository
import java.util.*
import javax.inject.Inject

class GetDateOfDeath @Inject constructor(private val yearOfDeathRepository: YearOfDeathRepository, private val getMinDateOfDeath: GetMinDateOfDeath) : UseCase<Calendar>() {

    override fun execute(): Calendar {
        var year = if (yearOfDeathRepository.contains()) {
            yearOfDeathRepository.get()
        } else {
            getMinDateOfDeath().get(Calendar.YEAR)
        }

        return Calendar.getInstance().resetTimeFields().apply {
            set(Calendar.YEAR, year)
            set(Calendar.MONTH, 0)
            set(Calendar.DAY_OF_YEAR, 1)
        }
    }

}