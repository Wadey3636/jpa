package me.jpaMain.utils

import kotlin.math.floor
import kotlin.math.pow


object universalUtils {
    fun abbreviateNumber(value: Int): String {
        if (value >= 1000) {
            val suffixes = listOf("", "k", "m", "b", "t")
            val suffixNum = floor((value.toString().length / 3).toDouble()).toInt()
            var shortValue: Double
            var result = ""

            for (precision in 2 downTo 1) {
                shortValue = if (suffixNum != 0) {
                    value / 1000.0.pow(suffixNum)
                } else {
                    value.toDouble()
                }

                val dotLessShortValue = shortValue.toString().replace(Regex("[^a-zA-Z0-9]+"), "")
                if (dotLessShortValue.length <= 2) {
                    result = shortValue.toString()
                    break
                }
            }

            if (result.contains(".")) {
                result = String.format("%.1f", result.toDouble())
            }
            return "$result${suffixes[suffixNum]}"
        }
        return value.toString()
    }

}