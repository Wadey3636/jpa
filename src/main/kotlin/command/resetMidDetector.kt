package me.jpaMain.command

import cc.polyfrost.oneconfig.libs.universal.UChat
import cc.polyfrost.oneconfig.utils.commands.annotations.Command
import cc.polyfrost.oneconfig.utils.commands.annotations.Main
import me.jpaMain.dungeonfeatures.*


@Command(value = "resetMidDetector", description = "Fetches the World Type")

class resetMidDetector {
    @Main
    private fun resetMidDetector() {
        midTriggered.set(false)
        ee2Triggered.set(false)
        ee3Triggered.set(false)
        ee4Triggered.set(false)
        UChat.chat("reset Mid Detector")
        renderTime = 0
    }

}