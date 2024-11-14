package me.jpaMain.command

import cc.polyfrost.oneconfig.libs.universal.UChat
import cc.polyfrost.oneconfig.utils.commands.annotations.Command
import cc.polyfrost.oneconfig.utils.commands.annotations.Main
import me.jpaMain.dungeonfeatures.*
import me.jpaMain.dungeonfeatures.DungeonScanner.iceFillPosition
import me.jpaMain.dungeonfeatures.DungeonScanner.scanFinished
import me.jpaMain.dungeonfeatures.DungeonScanner.uncheckedRooms
import net.minecraft.util.BlockPos


@Command(value = "resetDungeonScanner", description = "Fetches the World Type")

class resetMidDetector {
    @Main
    private fun resetMidDetector() {
        uncheckedRooms.clear()
        iceFillPosition = null
        scanFinished = false

        for (i in 0..6) {
            for (z in 0..6) {
                uncheckedRooms.add(BlockPos((-25 - (32 * i)), 90, (-25 - (32 * z))))
            }
        }
    }

}