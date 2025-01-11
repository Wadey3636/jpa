package me.jpaMain.command

import org.polyfrost.oneconfig.libs.universal.UChat
import org.polyfrost.oneconfig.utils.commands.annotations.Command
import org.polyfrost.oneconfig.utils.commands.annotations.Main


@Command(value = "fs", description = "Gets Farming Speeds")

class fsCommand {
    @Main
    private fun resetMidDetector() {
        UChat.chat("Mush: 232")
        UChat.chat("")
    }

}