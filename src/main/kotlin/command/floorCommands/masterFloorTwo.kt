package me.jpaMain.command.floorCommands

import cc.polyfrost.oneconfig.libs.universal.UChat
import cc.polyfrost.oneconfig.utils.commands.annotations.Command
import cc.polyfrost.oneconfig.utils.commands.annotations.Main
import me.jpaMain.jpaMain.mc


@Command(value = "m2", description = "joins M2", aliases = ["M2"])

class masterFloorTwo {
    @Main
    private fun resetMidDetector() {
        mc.thePlayer?.sendChatMessage("/joininstance MASTER_CATACOMBS_FLOOR_TWO")
    }

}