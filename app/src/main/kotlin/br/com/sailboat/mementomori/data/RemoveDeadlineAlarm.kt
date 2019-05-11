package br.com.sailboat.mementomori.data

import br.com.sailboat.mementomori.domain.UseCase
import javax.inject.Inject

class RemoveDeadlineAlarm @Inject constructor(
    private val deadlineAlarmRepository: DeadlineAlarmRepository
) : UseCase<Unit>() {

    override fun execute() {
        deadlineAlarmRepository.remove()
    }

}