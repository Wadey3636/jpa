package me.jpaMain.command

import cc.polyfrost.oneconfig.libs.universal.UChat
import cc.polyfrost.oneconfig.utils.commands.annotations.Command
import cc.polyfrost.oneconfig.utils.commands.annotations.Main
import me.jpaMain.dungeonfeatures.padticks
import me.jpaMain.dungeonfeatures.stormActivated

@Command(value = "simulateStormStartingMessage", description = "gay")
class simulateStormActivate {
    @Main
    private fun sendStormStartMessage() {
        UChat.chat("[BOSS] Storm: Pathetic Maxor, just like expected.")
        stormActivated = true
        padticks = 20f
    }
}





