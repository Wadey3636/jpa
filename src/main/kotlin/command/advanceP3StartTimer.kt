package me.jpaMain.command

import cc.polyfrost.oneconfig.libs.universal.UChat
import cc.polyfrost.oneconfig.utils.commands.annotations.Command
import cc.polyfrost.oneconfig.utils.commands.annotations.Main
import me.jpaMain.dungeonfeatures.p3StartTimerticks


@Command(value = "advP3StartTimer", description = "gay")

class advanceP3StartTimer {
    @Main
    private fun bwah() {
        if (p3StartTimerticks > 0) {
            --p3StartTimerticks
        }
        UChat.chat(p3StartTimerticks)

    }

}