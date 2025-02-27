package me.jpaMain.command

import org.polyfrost.oneconfig.api.commands.v1.factories.annotated.Command
import org.polyfrost.universal.UChat
import me.jpaMain.dungeonfeatures.dungeonScanner.iceFillPosition


@Command(value = ["testRooms"], description = "tester")

class testCommand {
    @Command
    private fun main() {
        UChat.chat("roomlist:$iceFillPosition")
    }
}