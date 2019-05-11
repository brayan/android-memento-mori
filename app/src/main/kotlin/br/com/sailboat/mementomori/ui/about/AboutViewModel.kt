package br.com.sailboat.mementomori.ui.about

import br.com.sailboat.mementomori.ui.model.RecyclerViewItem
import javax.inject.Inject

class AboutViewModel @Inject constructor() {

    val details = mutableListOf<RecyclerViewItem>()
}