package me.jpaMain.command.floorCommands

import org.polyfrost.oneconfig.libs.universal.UChat
import org.polyfrost.oneconfig.utils.commands.annotations.Command
import org.polyfrost.oneconfig.utils.commands.annotations.Main
import me.jpaMain.jpaMain.mc


@Command(value = "f6", description = "joins F6", aliases = ["F6"])

class floorSix {
    @Main
    private fun resetMidDetector() {
        mc.thePlayer?.sendChatMessage("/joininstance CATACOMBS_FLOOR_SIX")
    }

}