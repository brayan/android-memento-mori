package br.com.sailboat.mementomori.ui.countdown

import android.content.Context
import br.com.sailboat.mementomori.R
import br.com.sailboat.mementomori.domain.UseCaseWithParams
import br.com.sailboat.mementomori.ui.model.CountdownModel
import br.com.sailboat.mementomori.ui.model.RecyclerViewItem
import org.joda.time.Period
import javax.inject.Inject

class GetCountdownDetails @Inject constructor(private val appContext: Context) : UseCaseWithParams<Period, List<RecyclerViewItem>>() {

    override fun execute(period: Period): List<RecyclerViewItem> {
        var details = mutableListOf<RecyclerViewItem>()

        period.years.takeIf { it > 0 }?.run {
            details.add(
                CountdownModel(
                    countdown = this,
                    unit = appContext.getString(R.string.countdown_metric_year)
                )
            )
        }

        period.months.takeIf { it > 0 }?.run {
            details.add(
                CountdownModel(
                    countdown = this,
                    unit = appContext.getString(R.string.countdown_metric_month)
                )
            )
        }

        period.weeks.takeIf { it > 0 }?.run {
            details.add(
                CountdownModel(
                    countdown = this,
                    unit = appContext.getString(R.string.countdown_metric_week)
                )
            )
        }

        period.days.takeIf { it > 0 }?.run {
            details.add(
                CountdownModel(
                    countdown = this,
                    unit = appContext.getString(R.string.countdown_metric_day)
                )
            )
        }

        period.hours.takeIf { it > 0 }?.run {
            details.add(
                CountdownModel(
                    countdown = this,
                    unit = appContext.getString(R.string.countdown_metric_hour)
                )
            )
        }

        period.minutes.takeIf { it > 0 }?.run {
            details.add(
                CountdownModel(
                    countdown = this,
                    unit = appContext.getString(R.string.countdown_metric_minute)
                )
            )
        }

        return details
    }

}