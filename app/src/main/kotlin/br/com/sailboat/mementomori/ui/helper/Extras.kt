package br.com.sailboat.mementomori.ui.helper

import android.content.Intent
import android.os.Bundle
import br.com.sailboat.mementomori.R
import br.com.sailboat.mementomori.domain.helper.EntityHelper

object Extras {

    private const val BUNDLE = "BUNDLE"
    private const val ENTITY_ID = "ENTITY_ID"
    private const val FEEDBACK_MESSAGE = "FEEDBACK_MESSAGE"
    private const val ERROR_MESSAGE = "ERROR_MESSAGE"

    fun putBundle(intent: Intent?, bundle: Bundle) = intent?.putExtra(BUNDLE, bundle)
    fun getBundle(intent: Intent?) = intent?.getBundleExtra(BUNDLE)

    fun putEntityId(bundle: Bundle?, id: Long) = bundle?.putLong(ENTITY_ID, id)
    fun getEntityId(bundle: Bundle?) = bundle?.getLong(ENTITY_ID, EntityHelper.NO_ID) ?: EntityHelper.NO_ID

    fun putFeedbackMessage(intent: Intent?, msgId: Int) = intent?.putExtra(FEEDBACK_MESSAGE, msgId)
    fun getFeedbackMessage(intent: Intent?) = intent?.getIntExtra(FEEDBACK_MESSAGE, R.string.default_string)
    fun hasFeedbackMessage(intent: Intent?) = intent?.hasExtra(FEEDBACK_MESSAGE) ?: false
    fun putErrorMessage(intent: Intent?, msgId: Int) = intent?.putExtra(ERROR_MESSAGE, msgId)
    fun getErrorMessage(intent: Intent?) = intent?.getIntExtra(ERROR_MESSAGE, R.string.default_string)
    fun hasErrorMessage(intent: Intent?) = intent?.hasExtra(ERROR_MESSAGE) ?: false

}