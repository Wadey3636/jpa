package me.jpaMain.command

import org.polyfrost.oneconfig.libs.universal.UChat
import org.polyfrost.oneconfig.utils.commands.annotations.Command
import org.polyfrost.oneconfig.utils.commands.annotations.Main
import me.jpaMain.dungeonfeatures.DungeonScanner.iceFillPosition


@Command(value = "testRooms", description = "tester")

class testCommand {
    @Main
    private fun scoreboardthingy() {
        UChat.chat("roomlist:$iceFillPosition")
    }
}