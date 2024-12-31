package me.jpaMain.command.floorCommands

import cc.polyfrost.oneconfig.libs.universal.UChat
import cc.polyfrost.oneconfig.utils.commands.annotations.Command
import cc.polyfrost.oneconfig.utils.commands.annotations.Main
import me.jpaMain.jpaMain.mc


@Command(value = "m3", description = "joins M3", aliases = ["M3"])

class masterFloorThree {
    @Main
    private fun resetMidDetector() {
        mc.thePlayer?.sendChatMessage("/joininstance MASTER_CATACOMBS_FLOOR_THREE")
    }

}