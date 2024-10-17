package me.jpaMain.command

import cc.polyfrost.oneconfig.libs.universal.UChat
import cc.polyfrost.oneconfig.utils.commands.annotations.Command
import cc.polyfrost.oneconfig.utils.commands.annotations.Main
import me.jpaMain.utils.inDungeon
import me.jpaMain.utils.inGarden


@Command(value = "getWorldType", description = "Fetches the World Type")

class getWorldType {
        @Main
        private fun getScoreboard() {
           UChat.chat("In Dungeon:" + inDungeon)
            UChat.chat("In Garden:" + inGarden)
        }

}