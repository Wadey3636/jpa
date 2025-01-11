package me.jpaMain.command.floorCommands

import org.polyfrost.oneconfig.libs.universal.UChat
import org.polyfrost.oneconfig.utils.commands.annotations.Command
import org.polyfrost.oneconfig.utils.commands.annotations.Main
import me.jpaMain.jpaMain.mc


@Command(value = "m1", description = "joins M1", aliases = ["M1"])

class masterFloorOne {
    @Main
    private fun resetMidDetector() {
        mc.thePlayer?.sendChatMessage("/joininstance MASTER_CATACOMBS_FLOOR_ONE")
    }

}