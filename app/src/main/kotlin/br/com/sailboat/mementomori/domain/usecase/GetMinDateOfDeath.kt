package br.com.sailboat.mementomori.domain.usecase

import br.com.sailboat.mementomori.domain.Logger
import br.com.sailboat.mementomori.domain.UseCase
import br.com.sailboat.mementomori.domain.helper.resetTimeFields
import java.util.*
import javax.inject.Inject

class GetMinDateOfDeath @Inject constructor(val logger: Logger) : UseCase<Calendar>() {

    override fun execute(): Calendar {
        logger.d("GetMinDateOfDeath.execute()")
        return Calendar.getInstance().resetTimeFields().apply {
            add(Calendar.YEAR, 1)
            set(Calendar.MONTH, 0)
            set(Calendar.DAY_OF_YEAR, 1)
        }
    }

}