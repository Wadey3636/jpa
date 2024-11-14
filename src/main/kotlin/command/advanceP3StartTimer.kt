package me.jpaMain.command

import cc.polyfrost.oneconfig.libs.universal.UChat
import cc.polyfrost.oneconfig.utils.commands.annotations.Command
import cc.polyfrost.oneconfig.utils.commands.annotations.Main
import cc.polyfrost.oneconfig.utils.dsl.mc
import me.jpaMain.dungeonfeatures.DungeonScanner.possiblePositions
import me.jpaMain.dungeonfeatures.p3StartTimerticks
import me.jpaMain.utils.playerInRoomBounds


@Command(value = "nearestRoomIcefill", description = "gay")

class advanceP3StartTimer {
    @Main
    private fun bwah() {
        val position = mc.thePlayer.position
        //possiblePositions.forEach{ playerInRoomBounds(it, position)}

    }

}