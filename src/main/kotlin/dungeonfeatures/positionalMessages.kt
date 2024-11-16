package me.jpaMain.dungeonfeatures

import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import com.github.Wadey.config.jpaConfig.*
import me.jpaMain.events.QuarterSecondEvent
import me.jpaMain.jpaMain.mc
import me.jpaMain.utils.inDungeon
import me.jpaMain.utils.worldUtils.isBlock
import net.minecraft.block.Block
import net.minecraft.init.Blocks
import net.minecraft.util.BlockPos
import java.util.concurrent.atomic.AtomicBoolean


class positionalMessages {
    private var berzposactive = AtomicBoolean(false)
    private var simonsaysposactive = AtomicBoolean(false)
    private var ee2active = AtomicBoolean(false)
    private var ee3active = AtomicBoolean(false)
    private var ee4active = AtomicBoolean(false)
    private var goldorposactive = AtomicBoolean(false)
    private var dragonposactive = AtomicBoolean(false)
    private var midposactive = AtomicBoolean(false)
    private var ee2safespotactive = AtomicBoolean(false)
    private var ee3safespotactive = AtomicBoolean(false)
    private var stormposmsgactive = AtomicBoolean(false)

    init {
        EventManager.INSTANCE.register(this)

    }



    private fun sendPosMessage(coords: BlockPos, smallerpos: IntArray, largerpos: IntArray, checkBlockCoords: BlockPos, blocks: Block, msg: String, msgVariable: AtomicBoolean) {
        if (
            (isBlock(checkBlockCoords, blocks)) &&
            (coords.x in smallerpos[0]..largerpos[0]) &&
            (coords.y in smallerpos[1]..largerpos[1]) &&
            (coords.z in smallerpos[2]..largerpos[2])
            )
            {
                if (!msgVariable.get()) {
                    msgVariable.set(true)

                    mc.thePlayer?.sendChatMessage(msg)
                }
            }
        else {

            msgVariable.set(false)
        }


    }

    @Subscribe
    fun positionalMessages(event: QuarterSecondEvent) {
        if(inDungeon) {
            if (!posMsgs) {return}
            val coords = mc.thePlayer.position;
            if (berzmsg) sendPosMessage(coords, intArrayOf(92, 129, 43), intArrayOf(93, 134, 46), BlockPos(100, 167, 40), Blocks.barrier, "/pc Ready for Healer Leap!", berzposactive)
            if (simonsayspos) sendPosMessage(coords, intArrayOf(106, 119, 89), intArrayOf(111, 125, 97), BlockPos(100, 167, 40), Blocks.barrier, "/pc At Simon Says!", simonsaysposactive)
            if (earlyentrypositions) {
                sendPosMessage(coords, intArrayOf(44, 105, 127), intArrayOf(61, 111, 135), BlockPos(101, 118, 123), Blocks.cobblestone_wall, "/pc At Early Entry 2!", ee2active)
                sendPosMessage(coords, intArrayOf(68,108,120), intArrayOf(70,111,122), BlockPos(101, 118, 123), Blocks.cobblestone_wall, "/pc At Early Entry 2 Safe Spot!", ee2safespotactive)
                sendPosMessage(coords, intArrayOf(-1, 108, 97), intArrayOf(3, 110, 108), BlockPos(17, 118, 132), Blocks.cobblestone_wall, "/pc At Early Entry 3!", ee3active)
                sendPosMessage(coords, intArrayOf(17,121,91), intArrayOf(20,126,100), BlockPos(17, 118, 132), Blocks.cobblestone_wall, "/pc At Early Entry 3 Safe Spot!", ee3safespotactive)
                sendPosMessage(coords, intArrayOf(50,114,50), intArrayOf(58,119,54), BlockPos(17, 118, 132), Blocks.cobblestone_wall, "/pc At Early Entry 4!", ee4active)
            }
            if (goldorpos) sendPosMessage(coords, intArrayOf(49, 113, 55), intArrayOf(58, 120, 116), BlockPos(54, 118, 54), Blocks.gold_block, "/pc In Inner Chamber!", goldorposactive)
            if (dragonpos) sendPosMessage(coords, intArrayOf(51, 40, 64), intArrayOf(60, 55, 79), BlockPos(56,63,77), Blocks.sea_lantern, "/pc In Part 5!", dragonposactive)
            if (midposmsg) sendPosMessage(coords, intArrayOf(46, 64, 62), intArrayOf(68, 72, 84), BlockPos(56,63,77), Blocks.sea_lantern, "/pc At Middle!", midposactive)
            if (stormposmsg) sendPosMessage(coords, intArrayOf(66,206,32), intArrayOf(80,210,49), BlockPos(70, 220,33), Blocks.stone_brick_stairs, "/pc In Part 2!", stormposmsgactive)

        }
    }
}
//Storm phase msg

//     -
//Block{type=minecraft:stone_brick_stairs, x=70, y=220, z=33} (2)




