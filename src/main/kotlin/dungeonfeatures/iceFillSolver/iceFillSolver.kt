package me.jpaMain.dungeonfeatures.iceFillSolver

import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import me.jpaMain.events.EnterRoomEvent
import me.jpaMain.utils.isBlock
import net.minecraft.block.Block
import net.minecraft.util.BlockPos
import com.github.Wadey.config.jpaConfig.icefillSolver
import me.jpaMain.utils.convertToRealCoords
import me.jpaMain.utils.roomInfo

class iceFillSolver{
    init {
        EventManager.INSTANCE.register(this)
    }

    fun testForVarient(coordsList: HashSet<BlockPos>, Block: Block, room: roomInfo): Boolean{
        val iterator = coordsList.iterator()
        while (iterator.hasNext()) {
            if (!isBlock(convertToRealCoords(room ,iterator.next()), Block)) {return false}
        }
        return true
    }

    @Subscribe
    fun onRoomEnter(event: EnterRoomEvent) {
        if (event.room.name != "IceFill" || !icefillSolver) {return}



    }







}