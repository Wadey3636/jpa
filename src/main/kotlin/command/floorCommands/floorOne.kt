package me.jpaMain.command.floorCommands

import cc.polyfrost.oneconfig.libs.universal.UChat
import cc.polyfrost.oneconfig.utils.commands.annotations.Command
import cc.polyfrost.oneconfig.utils.commands.annotations.Main
import me.jpaMain.jpaMain.mc


@Command(value = "f1", description = "joins F1", aliases = ["F1"])

class floorOne {
    @Main
    private fun resetMidDetector() {
        mc.thePlayer?.sendChatMessage("/joininstance CATACOMBS_FLOOR_ONE")
    }

}