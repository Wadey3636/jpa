package me.jpaMain.command.floorCommands

import org.polyfrost.oneconfig.api.commands.v1.factories.annotated.Command
import org.polyfrost.universal.UChat
import me.jpaMain.jpaMain.mc


@Command(value = ["f5", "F5"], description = "joins F5")

class floorFive {
    @Command
    private fun resetMidDetector() {
        mc.thePlayer?.sendChatMessage("/joininstance CATACOMBS_FLOOR_FIVE")
    }

}