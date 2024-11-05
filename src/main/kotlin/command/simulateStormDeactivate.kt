package me.jpaMain.command
import cc.polyfrost.oneconfig.libs.universal.UChat
import cc.polyfrost.oneconfig.utils.commands.annotations.Command
import cc.polyfrost.oneconfig.utils.commands.annotations.Main
import me.jpaMain.dungeonfeatures.p3StartTimerticks
import me.jpaMain.dungeonfeatures.stormActivated

@Command(value = "simulateStormEndingMessage", description = "gay")
class simulateStormDeactivate {
    @Main
    private fun sendStormStartMessage() {
        UChat.chat("[BOSS] Storm: I should have known that I stood no chance.")
        p3StartTimerticks = 104f
        stormActivated = false
    }
}





