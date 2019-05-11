package br.com.sailboat.mementomori.data

import br.com.sailboat.mementomori.domain.UseCase
import br.com.sailboat.mementomori.domain.usecase.GetDateOfDeath
import javax.inject.Inject

class SetDeadlineAlarm @Inject constructor(
    private val getDateOfDeath: GetDateOfDeath,
    private val deadlineAlarmRepository: DeadlineAlarmRepository
) : UseCase<Unit>() {

    override fun execute() = deadlineAlarmRepository.add(getDateOfDeath())

}