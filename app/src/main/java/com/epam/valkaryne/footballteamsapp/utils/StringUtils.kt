package com.epam.valkaryne.footballteamsapp.utils

import com.ibm.icu.text.RuleBasedNumberFormat
import java.util.*

/**
 * Class with string utilities
 */
object StringUtils {

    fun convertNumberToOrdinal(number: Int): String {
        val formatter = RuleBasedNumberFormat(Locale.getDefault(), RuleBasedNumberFormat.ORDINAL)
        return formatter.format(number)
    }
}