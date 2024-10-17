package me.jpaMain.command

import cc.polyfrost.oneconfig.libs.universal.UChat
import cc.polyfrost.oneconfig.utils.commands.annotations.Command
import cc.polyfrost.oneconfig.utils.commands.annotations.Main
import me.jpaMain.dungeonfeatures.midTriggered
import me.jpaMain.dungeonfeatures.renderTime


@Command(value = "resetMidDetector", description = "Fetches the World Type")

class resetMidDetector {
    @Main
    private fun resetMidDetector() {
        midTriggered = false
        UChat.chat("reset Mid Detector")
        renderTime = 0
    }

}