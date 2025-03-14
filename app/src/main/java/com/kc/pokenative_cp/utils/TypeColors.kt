package com.kc.pokenative_cp.utils

object TypeColors {
    val colors = mapOf(
        "dark" to "#75574C",
        "dragon" to "#7037FF"
    )

    fun getColor(type: String): String {
        return colors[type.lowercase()] ?: "#333333"
    }
}