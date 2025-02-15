package me.jpaMain.command.floorCommands

import me.jpaMain.jpaMain.mc
import org.polyfrost.oneconfig.api.commands.v1.factories.annotated.Command


@Command(value = ["f3", "F3"], description = "joins F3")

class floorThree {
    @Command
    private fun resetMidDetector() {
        mc.thePlayer?.sendChatMessage("/joininstance CATACOMBS_FLOOR_THREE")
    }

}