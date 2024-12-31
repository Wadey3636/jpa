package me.jpaMain.command.floorCommands

import cc.polyfrost.oneconfig.libs.universal.UChat
import cc.polyfrost.oneconfig.utils.commands.annotations.Command
import cc.polyfrost.oneconfig.utils.commands.annotations.Main
import me.jpaMain.jpaMain.mc


@Command(value = "m4", description = "joins M4", aliases = ["M4"])

class masterFloorFour {
    @Main
    private fun resetMidDetector() {
        mc.thePlayer?.sendChatMessage("/joininstance MASTER_CATACOMBS_FLOOR_FOUR")
    }

}