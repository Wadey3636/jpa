package me.jpaMain.command.floorCommands

import me.jpaMain.jpaMain.mc
import org.polyfrost.oneconfig.api.commands.v1.factories.annotated.Command


@Command(value = ["m5", "M5"], description = "joins M5")

class masterFloorFive {
    @Command
    private fun resetMidDetector() {
        mc.thePlayer?.sendChatMessage("/joininstance MASTER_CATACOMBS_FLOOR_FIVE")
    }

}