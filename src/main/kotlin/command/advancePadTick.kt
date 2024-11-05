package me.jpaMain.command

import cc.polyfrost.oneconfig.config.core.OneColor
import cc.polyfrost.oneconfig.libs.universal.UChat
import cc.polyfrost.oneconfig.utils.commands.annotations.Command
import cc.polyfrost.oneconfig.utils.commands.annotations.Main
import me.jpaMain.dungeonfeatures.padcolor
import me.jpaMain.dungeonfeatures.padticks


@Command(value = "advPadTick", description = "gay")

class advancePadTick {
    @Main
    private fun bwah() {
        --padticks
        UChat.chat(padticks)
        padcolor = OneColor((255 - padticks* 12.75).toInt() , (0 + padticks * 12.75).toInt(), 0, 255)
    }

}