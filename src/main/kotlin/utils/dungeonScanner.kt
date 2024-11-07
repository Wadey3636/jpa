package me.jpaMain.utils

import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.events.event.Stage
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import cc.polyfrost.oneconfig.events.event.TickEvent
import cc.polyfrost.oneconfig.events.event.WorldLoadEvent
import cc.polyfrost.oneconfig.utils.dsl.mc
import net.minecraft.init.Blocks
import net.minecraft.util.BlockPos
import java.lang.System.currentTimeMillis
import kotlin.collections.HashSet

// Each 1x1 unit is 30 by 30
var roomList = mutableListOf<roomInfo>()
var undeterminedDeadEnds = HashSet<roomInfo>()

class mapChecker {
    private val uncheckedRooms = HashSet<BlockPos>()
    private var lastScan = currentTimeMillis()

    init {
        EventManager.INSTANCE.register(this)
    }

    @Subscribe
    fun onWorldLoad(event: WorldLoadEvent) {
        uncheckedRooms.clear()
        roomList.clear()
        undeterminedDeadEnds.clear()

        for (i in 0..6) {
            for (z in 0..6) {
                uncheckedRooms.add(BlockPos((-25 - (32 * i)), 99, (-25 - (32 * z))))
            }
        }
    }

    @Subscribe
    fun mapChecker(event: TickEvent) {
        if (event.stage != Stage.START || currentTimeMillis() - lastScan < 5000) return
        lastScan = currentTimeMillis()

        val bounds = arrayOf(
            mc.thePlayer.posX.toInt() - 128 to mc.thePlayer.posZ.toInt() - 128,
            mc.thePlayer.posX.toInt() + 128 to mc.thePlayer.posZ.toInt() + 128
        )

        val iterator = uncheckedRooms.iterator()
        while (iterator.hasNext()) {
            val pos = iterator.next()
            if (mc.theWorld.getChunkFromBlockCoords(pos).isLoaded) {
                if (checkIf1x1(pos)) {
                    val doors = findWitherDoors(pos)
                    if (doors.size == 1) {
                        undeterminedDeadEnds.add(roomInfo("unchecked", intArrayOf(pos.x, pos.z), doors[0]))
                    }
                    iterator.remove()
                } else {
                    iterator.remove()
                }
            }
        }

        val deadEndIterator = undeterminedDeadEnds.iterator()
        while (deadEndIterator.hasNext()) {
            val room = deadEndIterator.next()
            if (isBlock(convertToRealCoords(room, BlockPos(-2, 71, -7)), Blocks.iron_bars) &&
                isBlock(convertToRealCoords(room, BlockPos(3, 71, -4)), Blocks.iron_bars)
            ) {
                roomList.add(roomInfo("ThreeWeirdos", room.center, room.rotation))
            } else {
                roomList.add(roomInfo("Unknown", room.center, room.rotation))
            }
            deadEndIterator.remove()
        }
    }

    private fun checkIf1x1(pos: BlockPos): Boolean {
        val yRange = 99..101
        return yRange.none { isBlock(BlockPos(pos.x, it, pos.z), Blocks.redstone_block) }
    }

    private fun findWitherDoors(pos: BlockPos): List<String> {
        val directions = mutableListOf<String>()
        if (!isBlock(BlockPos(pos.x, 73, pos.z - 16), Blocks.air)) directions.add("South")
        if (!isBlock(BlockPos(pos.x, 73, pos.z + 16), Blocks.air)) directions.add("North")
        if (!isBlock(BlockPos(pos.x + 16, 73, pos.z), Blocks.air)) directions.add("West")
        if (!isBlock(BlockPos(pos.x - 16, 73, pos.z), Blocks.air)) directions.add("East")
        return directions
    }
}