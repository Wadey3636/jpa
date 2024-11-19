package me.jpaMain.utils

data class roomInfo(val name: String, val center: IntArray, val rotation: String) {
    fun getX(): Int {
        return center[0]
    }

    fun getZ(): Int {
        return center[1]
    }
}


