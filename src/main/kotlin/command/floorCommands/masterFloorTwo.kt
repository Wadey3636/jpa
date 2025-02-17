package me.jpaMain.command.floorCommands


import me.jpaMain.jpaMain.mc
import org.polyfrost.oneconfig.api.commands.v1.factories.annotated.Command


@Command(value = ["m2", "M2"], description = "joins M2")

class masterFloorTwo {
    @Command
    private fun resetMidDetector() {
        mc.thePlayer?.sendChatMessage("/joininstance MASTER_CATACOMBS_FLOOR_TWO")
    }

}