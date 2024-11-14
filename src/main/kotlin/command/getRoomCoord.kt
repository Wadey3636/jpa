package me.jpaMain.command

import cc.polyfrost.oneconfig.libs.universal.UChat
import cc.polyfrost.oneconfig.utils.commands.annotations.Command
import cc.polyfrost.oneconfig.utils.commands.annotations.Main
import cc.polyfrost.oneconfig.utils.dsl.mc
import me.jpaMain.dungeonfeatures.DungeonScanner.iceFillPosition
import me.jpaMain.utils.*

@Command(value = "getRoomCoord", description = "")
class getRoomCoord {
    @Main
    private fun getPos(){
        val position = mc.thePlayer.position
        //mc.thePlayer.posX
    }

}