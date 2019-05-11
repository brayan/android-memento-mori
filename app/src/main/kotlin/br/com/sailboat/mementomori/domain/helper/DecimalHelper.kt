package br.com.sailboat.mementomori.domain.helper

import java.math.BigDecimal
import java.math.RoundingMode
import java.text.NumberFormat

object DecimalHelper {

    fun round(value: Double, scale: Int): BigDecimal {
        return BigDecimal.valueOf(value).setScale(scale, BigDecimal.ROUND_HALF_UP)
    }

    fun toPresentation(value: Double): String {
        return if (value % 1 == 0.0) {
            value.toLong().toString()
        } else {
            value.toString()
        }
    }

    fun toCurrency(value: Double): String {
        val newValue = BigDecimal.valueOf(value)

        val format = NumberFormat.getCurrencyInstance()
        format.roundingMode = RoundingMode.HALF_UP

        return format.format(newValue)
    }
}