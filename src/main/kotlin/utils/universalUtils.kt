package me.jpaMain.utils

import cc.polyfrost.oneconfig.libs.universal.UChat
import kotlin.math.floor
import kotlin.math.pow
//10,000,000
//10m
object universalUtils {

    /**
     * Abbreviates a number
     * Ex: 10,000,000 -> 10.0m
     *
     * @param n Double which is abbreviated
     */
    fun abbreviateNumber(n: Double): String {
        return when {
            n < 1_000 -> n.toString()
            n in 1_000.0..999_999.0 -> "${"%.1f".format(n / 1_000)}K"
            n in 1_000_000.0..999_999_999.0 -> "${"%.1f".format(n / 1_000_000)}M"
            n in 1_000_000_000.0..999_999_999_999.0 -> "${"%.1f".format(n / 1_000_000_000)}B"
            n >= 1_000_000_000_000.0 -> "${"%.1f".format(n / 1_000_000_000_000)}T"
            else -> n.toString()
        }
    }
    fun abbreviateNumber(n: Int): String {
        return abbreviateNumber(n.toDouble())
    }
    fun abbreviateNumber(n: Float): String {
        return abbreviateNumber(n.toDouble())
    }

}