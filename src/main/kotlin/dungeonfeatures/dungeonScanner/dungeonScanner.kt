package me.jpaMain.dungeonfeatures.dungeonScanner


import com.github.Wadey.config.JpaConfig.icefillSolver
import me.jpaMain.events.SecondEvent
import me.jpaMain.jpaMain.mc
import me.jpaMain.utils.inDungeon
import me.jpaMain.utils.roomInfo
import me.jpaMain.utils.worldUtils.isBlock
import net.minecraft.init.Blocks
import net.minecraft.util.BlockPos
import org.polyfrost.oneconfig.api.event.v1.EventManager
import org.polyfrost.oneconfig.api.event.v1.events.WorldEvent
import org.polyfrost.oneconfig.api.event.v1.invoke.impl.Subscribe
import java.lang.System.currentTimeMillis

// Each 1x1 unit is 30 by 30
var iceFillPosition: roomInfo? = null
var scanFinished = false
val uncheckedRooms = HashSet<BlockPos>()


class dungeonScanner {
    private var lastScan = currentTimeMillis()

    init {
        EventManager.INSTANCE.register(this)
    }

    @Subscribe
    fun onWorldLoad(event: WorldEvent.Load) {
        uncheckedRooms.clear()
        iceFillPosition = null
        scanFinished = false

        for (i in 0..6) {
            for (z in 0..6) {
                uncheckedRooms.add(BlockPos((-25 - (32 * i)), 70, (-25 - (32 * z))))
            }
        }
    }
    //-186,90,-24 Block{type=minecraft:stone, x=-186, y=90, z=-24} (2)
    //67 - icepath
    // 70 icefill


    @Subscribe
    fun dungeonScanner(event: SecondEvent) {
        if (scanFinished || !icefillSolver || !inDungeon) return
        if (currentTimeMillis() - lastScan < 5000) return
        lastScan = currentTimeMillis()
        val iterator = uncheckedRooms.iterator()
        while (iterator.hasNext()) {
            val pos = iterator.next()
            if (mc.theWorld.getChunkFromBlockCoords(pos).isLoaded) {
                if (isIceFill(pos)) {
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


    private fun isIceFill(pos: BlockPos): Boolean {
        return isBlock(BlockPos(pos.x, pos.y, pos.z), Blocks.ice)

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