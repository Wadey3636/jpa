package me.jpaMain.command

import cc.polyfrost.oneconfig.utils.commands.annotations.Command
import cc.polyfrost.oneconfig.utils.commands.annotations.Main
import cc.polyfrost.oneconfig.utils.dsl.mc

@Command(value = "getRoomCoord", description = "")
class getRoomCoord {
    @Main
    private fun getPos(){
        val position = mc.thePlayer.position
        //mc.thePlayer.posX
    }

}