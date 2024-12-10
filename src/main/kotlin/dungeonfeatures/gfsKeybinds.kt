package me.jpaMain.dungeonfeatures

import cc.polyfrost.oneconfig.libs.universal.UChat
import com.github.Wadey.config.jpaConfig.*
import me.jpaMain.jpaMain.mc
import me.jpaMain.utils.worldUtils

fun gfsPearl() {
    if (!pearlKeyToggle) {
        return
    }
    UChat.chat()
    mc.thePlayer?.sendChatMessage("/gfs ender_pearl 16")
}

fun gfsSuperboom() {
    if (!superboomKeyToggle) {
        return
    }
    mc.thePlayer?.sendChatMessage("/gfs SUPERBOOM_TNT 64")
}

fun gfsSpiritleap() {
    if (!spiritleapKeyToggle) {
        return
    }
    mc.thePlayer?.sendChatMessage("/gfs SPIRIT_LEAP 16")
}

