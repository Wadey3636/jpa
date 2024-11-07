package me.jpaMain.command

import cc.polyfrost.oneconfig.libs.universal.UChat
import cc.polyfrost.oneconfig.utils.commands.annotations.Command
import cc.polyfrost.oneconfig.utils.commands.annotations.Main
import me.jpaMain.utils.undeterminedDeadEnds
import me.jpaMain.utils.roomList


@Command(value = "testRooms", description = "tester")

class testCommand {
        @Main
        private fun scoreboardthingy() {
           UChat.chat("undetermined:$undeterminedDeadEnds")
           UChat.chat("roomlist:$roomList")
        }
}