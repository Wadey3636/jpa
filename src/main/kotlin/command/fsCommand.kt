package me.jpaMain.command

import org.polyfrost.oneconfig.api.commands.v1.factories.annotated.Command
import org.polyfrost.universal.UChat


@Command(value = ["fs"], description = "Gets Farming Speeds")

class fsCommand {
    @Command
    private fun resetMidDetector() {

        UChat.chat("Mush: 232")
        UChat.chat("")
    }

}