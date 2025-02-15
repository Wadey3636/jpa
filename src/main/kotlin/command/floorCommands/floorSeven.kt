package me.jpaMain.command.floorCommands

import me.jpaMain.jpaMain.mc
import org.polyfrost.oneconfig.api.commands.v1.factories.annotated.Command


@Command(value = ["f7", "F7"], description = "joins F7")

class floorSeven {
    @Command
    private fun resetMidDetector() {
        mc.thePlayer?.sendChatMessage("/joininstance CATACOMBS_FLOOR_SEVEN")
    }

}