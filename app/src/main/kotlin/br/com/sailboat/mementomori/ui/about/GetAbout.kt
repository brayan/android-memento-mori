package br.com.sailboat.mementomori.ui.about

import android.content.Context
import br.com.sailboat.mementomori.BuildConfig
import br.com.sailboat.mementomori.R
import br.com.sailboat.mementomori.domain.UseCase
import br.com.sailboat.mementomori.ui.model.LabelAndValueModel
import br.com.sailboat.mementomori.ui.model.RecyclerViewItem
import br.com.sailboat.mementomori.ui.model.TitleModel
import javax.inject.Inject

class GetAbout @Inject constructor(private val appContext: Context) :
    UseCase<List<RecyclerViewItem>>() {

    override fun execute(): List<RecyclerViewItem> {
        var details = mutableListOf<RecyclerViewItem>()

        details.add(TitleModel(title = appContext.getString(R.string.app_name)))

        details.add(
            LabelAndValueModel(
                label = appContext.getString(R.string.label_version),
                value = BuildConfig.VERSION_NAME
            )
        )

        details.add(
            LabelAndValueModel(
                label = appContext.getString(R.string.label_developed_by),
                value = appContext.getString(R.string.value_developed_by)
            )
        )

        return details
    }

}