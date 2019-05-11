package br.com.sailboat.mementomori.domain.usecase

import br.com.sailboat.mementomori.domain.UseCase
import br.com.sailboat.mementomori.domain.repository.YearOfDeathRepository
import javax.inject.Inject

class ContainsDateOfDeath @Inject constructor(private val yearOfDeathRepository: YearOfDeathRepository) : UseCase<Boolean>() {

    override fun execute() = yearOfDeathRepository.contains()

}