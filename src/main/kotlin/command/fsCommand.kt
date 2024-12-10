package me.jpaMain.command

import cc.polyfrost.oneconfig.libs.universal.UChat
import cc.polyfrost.oneconfig.utils.commands.annotations.Command
import cc.polyfrost.oneconfig.utils.commands.annotations.Main



@Command(value = "fs", description = "Gets Farming Speeds")

class fsCommand {
    @Main
    private fun resetMidDetector() {
        UChat.chat("Mush: 232")
        UChat.chat("")
    }

}