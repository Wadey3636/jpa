package me.jpaMain.command.floorCommands

import org.polyfrost.oneconfig.libs.universal.UChat
import org.polyfrost.oneconfig.utils.commands.annotations.Command
import org.polyfrost.oneconfig.utils.commands.annotations.Main
import me.jpaMain.jpaMain.mc


@Command(value = "m7", description = "joins M7", aliases = ["M7"])

class masterFloorSeven {
    @Main
    private fun resetMidDetector() {
        mc.thePlayer?.sendChatMessage("/joininstance MASTER_CATACOMBS_FLOOR_SEVEN")
    }

}