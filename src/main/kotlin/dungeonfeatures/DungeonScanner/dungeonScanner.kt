package me.jpaMain.dungeonfeatures.DungeonScanner

import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.events.event.Stage
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import cc.polyfrost.oneconfig.events.event.TickEvent
import cc.polyfrost.oneconfig.events.event.WorldLoadEvent
import cc.polyfrost.oneconfig.libs.universal.UChat
import me.jpaMain.jpaMain.mc
import com.github.Wadey.config.jpaConfig.icefillSolver
import me.jpaMain.events.SecondEvent
import me.jpaMain.utils.getBlockAt
import me.jpaMain.utils.inDungeon
import me.jpaMain.utils.isBlock
import me.jpaMain.utils.roomInfo
import net.minecraft.init.Blocks
import net.minecraft.util.BlockPos
import java.lang.System.console
import java.lang.System.currentTimeMillis
import kotlin.collections.HashSet

// Each 1x1 unit is 30 by 30
var iceFillPosition: roomInfo? = null
var scanFinished = false
val uncheckedRooms = HashSet<BlockPos>()
var possiblePositions = HashSet<BlockPos>()

class dungeonScanner {

    private var lastScan = currentTimeMillis()

    init {
        EventManager.INSTANCE.register(this)
    }

    @Subscribe
    fun onWorldLoad(event: WorldLoadEvent) {
        uncheckedRooms.clear()
        iceFillPosition = null
        scanFinished = false

        for (i in 0..6) {
            for (z in 0..6) {
                uncheckedRooms.add(BlockPos((-25 - (32 * i)), 90, (-25 - (32 * z))))
            }
        }
        possiblePositions = uncheckedRooms
    }
    //-186,90,-24 Block{type=minecraft:stone, x=-186, y=90, z=-24} (2)

    @Subscribe
    fun dungeonScanner(event: SecondEvent) {
        if (scanFinished || !icefillSolver/* || !inDungeon*/) return
        if (currentTimeMillis() - lastScan < 5000) return
        lastScan = currentTimeMillis()


        val iterator = uncheckedRooms.iterator()
        while (iterator.hasNext()) {
            val pos = iterator.next()
            if (mc.theWorld.getChunkFromBlockCoords(pos).isLoaded) {
                //UChat.chat(pos)
                if (isIceFill(pos)) {
                    //UChat.chat("Is icefill")
                    val doors = findWitherDoors(pos)
                    if (doors.size == 1) {
                        iceFillPosition = roomInfo("IceFill", intArrayOf(pos.x, pos.z), doors[0])
                    }
                    iterator.remove()
                } else {
                    iterator.remove()
                }
            }
        }


        if (uncheckedRooms.isEmpty()) scanFinished = true


    }
//roomlist:roomInfo(name=IceFill, center=[-185, -121], rotation=West)


    private fun isIceFill(pos: BlockPos): Boolean {
        //UChat.chat("$pos, ${isBlock(BlockPos(pos), Blocks.stone)}:${getBlockAt(pos)}")
        //UChat.chat("$pos, ${isBlock(BlockPos(BlockPos(pos.x - 1, pos.y, pos.z)), Blocks.redstone_block)}:${getBlockAt(BlockPos(pos.x - 1, pos.y, pos.z))}")
        //UChat.chat(getBlockAt(pos).toString())
        //UChat.chat("")
        return isBlock(BlockPos(pos), Blocks.stone) && isBlock(BlockPos(pos.x - 1, pos.y, pos.z), Blocks.redstone_block)

    }





    private fun findWitherDoors(pos: BlockPos): List<String> {
        return listOfNotNull(
            "South".takeIf { !isBlock(BlockPos(pos.x, 73, pos.z - 16), Blocks.air) },
            "North".takeIf { !isBlock(BlockPos(pos.x, 73, pos.z + 16), Blocks.air) },
            "East".takeIf { !isBlock(BlockPos(pos.x + 16, 73, pos.z), Blocks.air) },
            "West".takeIf { !isBlock(BlockPos(pos.x - 16, 73, pos.z), Blocks.air) }
        )
    }

}