package me.jpaMain.command.floorCommands


import me.jpaMain.jpaMain.mc
import org.polyfrost.oneconfig.api.commands.v1.factories.annotated.Command


@Command(value = ["f4", "F4"], description = "joins F4")

class floorFour {
    @Command
    private fun resetMidDetector() {
        mc.thePlayer?.sendChatMessage("/joininstance CATACOMBS_FLOOR_FOUR")
    }

}