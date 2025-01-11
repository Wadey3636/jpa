package me.jpaMain.command

import org.polyfrost.oneconfig.libs.universal.UChat
import org.polyfrost.oneconfig.utils.commands.annotations.Command
import org.polyfrost.oneconfig.utils.commands.annotations.Main
import me.jpaMain.utils.inDungeon

var devMode = false

@Command(value = "jpaDevMode", description = "")
class JPAdevMode {
    @Main
    private fun devMode() {
        inDungeon = true
        devMode = true
        UChat.chat("Jpa: Dev Mode Activated")

        //mc.thePlayer.posX
    }

}