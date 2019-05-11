package br.com.sailboat.mementomori.domain.usecase

import br.com.sailboat.mementomori.domain.UseCaseWithParams
import br.com.sailboat.mementomori.domain.repository.YearOfDeathRepository
import javax.inject.Inject

class AddYearOfDeath @Inject constructor(private val yearOfDeathRepository: YearOfDeathRepository) : UseCaseWithParams<Int, Unit>() {

    override fun execute(year: Int) = yearOfDeathRepository.add(year)

}