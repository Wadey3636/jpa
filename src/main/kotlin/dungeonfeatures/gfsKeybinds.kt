package me.jpaMain.dungeonfeatures

import com.github.Wadey.config.JpaConfig.*
import me.jpaMain.jpaMain.mc
import me.jpaMain.utils.guiUtils.getInventory
import me.jpaMain.utils.guiUtils.getItemCount

fun gfsPearl() {
    if (!pearlKeyToggle) {
        return
    }
    val count = 16 - (getItemCount("ENDER_PEARL", getInventory()))
    if (count != 0) mc.thePlayer?.sendChatMessage("/gfs ender_pearl $count")
}

fun gfsSuperboom() {
    if (!superboomKeyToggle) {
        return
    }
    val count = 64 - (getItemCount("SUPERBOOM_TNT", getInventory()))
    if (count != 0) mc.thePlayer?.sendChatMessage("/gfs SUPERBOOM_TNT $count")
}

fun gfsSpiritleap() {
    if (!spiritleapKeyToggle) {
        return
    }
    val count = 16 - (getItemCount("SPIRIT_LEAP", getInventory()))
    if (count != 0) mc.thePlayer?.sendChatMessage("/gfs SPIRIT_LEAP $count")
}

