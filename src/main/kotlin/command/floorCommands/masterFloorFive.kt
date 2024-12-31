package me.jpaMain.command.floorCommands

import cc.polyfrost.oneconfig.libs.universal.UChat
import cc.polyfrost.oneconfig.utils.commands.annotations.Command
import cc.polyfrost.oneconfig.utils.commands.annotations.Main
import me.jpaMain.jpaMain.mc


@Command(value = "m5", description = "joins M5", aliases = ["M5"])

class masterFloorFive {
    @Main
    private fun resetMidDetector() {
        mc.thePlayer?.sendChatMessage("/joininstance MASTER_CATACOMBS_FLOOR_FIVE")
    }

}