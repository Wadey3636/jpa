package me.jpaMain.command.floorCommands

import me.jpaMain.jpaMain.mc
import org.polyfrost.oneconfig.api.commands.v1.factories.annotated.Command


@Command(value = ["f6", "F6"], description = "joins F6")

class floorSix {
    @Command
    private fun resetMidDetector() {
        mc.thePlayer?.sendChatMessage("/joininstance CATACOMBS_FLOOR_SIX")
    }

}