package br.com.sailboat.mementomori.domain.usecase

import br.com.sailboat.mementomori.domain.UseCase
import br.com.sailboat.mementomori.domain.repository.YearOfDeathRepository
import javax.inject.Inject

class RemoveDateOfDeath @Inject constructor(private val yearOfDeathRepository: YearOfDeathRepository) : UseCase<Unit>() {

    override fun execute() {
        yearOfDeathRepository.remove()
    }

}