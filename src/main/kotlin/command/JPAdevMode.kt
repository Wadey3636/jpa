package me.jpaMain.command


import me.jpaMain.utils.inDungeon
import org.polyfrost.oneconfig.api.commands.v1.factories.annotated.Command
import org.polyfrost.universal.UChat

var devMode = false

@Command(value = ["jpaDevMode"], description = "")
class JPAdevMode {
    @Command
    private fun devMode() {
        inDungeon = true
        devMode = true
        UChat.chat("Jpa: Dev Mode Activated")

        //mc.thePlayer.posX
    }

}