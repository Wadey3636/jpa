package me.jpaMain.command

import cc.polyfrost.oneconfig.libs.universal.UChat
import cc.polyfrost.oneconfig.utils.commands.annotations.Command
import cc.polyfrost.oneconfig.utils.commands.annotations.Main
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