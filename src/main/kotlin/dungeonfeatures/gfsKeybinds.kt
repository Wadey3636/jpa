package me.jpaMain.dungeonfeatures

import cc.polyfrost.oneconfig.libs.universal.UChat
import com.github.Wadey.config.jpaConfig.*
import me.jpaMain.jpaMain.mc
import me.jpaMain.utils.guiUtils.getInventory
import me.jpaMain.utils.worldUtils
import me.jpaMain.utils.guiUtils.getItemCount
fun gfsPearl() {
    if (!pearlKeyToggle) {
        return
    }
    val count = (getItemCount("ENDER_PEARL", getInventory())) ?: return
    UChat.chat(16 - count)
    mc.thePlayer?.sendChatMessage("/gfs ender_pearl ${16 - count}")
}

fun gfsSuperboom() {
    if (!superboomKeyToggle) {
        return
    }
    val count = (getItemCount("SUPERBOOM_TNT", getInventory())) ?: return
    UChat.chat(16 - count)
    mc.thePlayer?.sendChatMessage("/gfs SUPERBOOM_TNT ${64 - count}")
}

fun gfsSpiritleap() {
    if (!spiritleapKeyToggle) {
        return
    }
    val count = (getItemCount("SPIRIT_LEAP", getInventory())) ?: return
    UChat.chat(16 - count)
    mc.thePlayer?.sendChatMessage("/gfs SPIRIT_LEAP ${16 - count}")
}

