package me.jpaMain.command

import cc.polyfrost.oneconfig.libs.universal.UChat
import cc.polyfrost.oneconfig.utils.commands.annotations.Command
import cc.polyfrost.oneconfig.utils.commands.annotations.Main
import me.jpaMain.utils.*


@Command(value = "testScoreboard", description = "gay")

class getWorldType {
        @Main
        private fun scoreboardthingy() {
            UChat.chat(dungeonFloor)
        }
}