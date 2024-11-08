package me.jpaMain.dungeonfeatures.iceFillSolver

import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import me.jpaMain.events.EnterRoomEvent
import me.jpaMain.utils.isBlock
import net.minecraft.block.Block
import net.minecraft.util.BlockPos
import com.github.Wadey.config.jpaConfig.icefillSolver
import me.jpaMain.utils.convertToRealCoords
import me.jpaMain.utils.plotWarpPoints
import me.jpaMain.utils.roomInfo
import net.minecraft.init.Blocks
import net.minecraft.client.renderer.GlStateManager
import net.minecraft.client.renderer.Tessellator



class iceFillSolver{

    private var inIcefill = false
    private var layer0Variant = plotWarpPoints(listOf(BlockPos(0,0,0)), listOf(BlockPos(0,0,0)))
    private var layer1Variant = plotWarpPoints(listOf(BlockPos(0,0,0)), listOf(BlockPos(0,0,0)))
    private var layer2Variant = plotWarpPoints(listOf(BlockPos(0,0,0)), listOf(BlockPos(0,0,0)))


    val layer0 = listOf(epicCoords, crazyCoords, spongecokeCoords, bfvarroeCoords)
    val layer1 = listOf(desticlesCoords, krzIsStupidCoords, fanficCoords, jpCoords, hiitsmeCoords)
    val layer2 = listOf(americaCoords, pistolCoords, crossCoords, neutralCoords, turtleCoords)
    init {
        EventManager.INSTANCE.register(this)
    }

    fun testForVariant(coordsList: HashSet<BlockPos>, block: Block, room: roomInfo): Boolean{
        val iterator = coordsList.iterator()
        while (iterator.hasNext()) {
            if (!isBlock(convertToRealCoords(room ,iterator.next()), block)) {return false}
        }
        return true
    }

    fun drawVariant(){}

    @Subscribe
    fun onRoomEnter(event: EnterRoomEvent) {
        if (event.room.name != "IceFill" || !icefillSolver) {return}
        inIcefill = true


        //Layer 0
        if (testForVariant(layer0[0], Blocks.stone, event.room)) {
            layer0Variant = plotWarpPoints(epicplot, epicWarpPoints)
        } else if (testForVariant(layer0[1], Blocks.stone, event.room)) {
            layer0Variant = plotWarpPoints(crazyplot, crazyWarpPoints)
        } else if (testForVariant(layer0[2], Blocks.stone, event.room)) {
            layer0Variant = plotWarpPoints(spongecokeplot, spongecokeWarpPoints)
        } else if (testForVariant(layer0[3], Blocks.stone, event.room)) {
            layer0Variant = plotWarpPoints(bfvarroeplot, bfvarroeWarpPoints)
        }

        //Layer 1
        if (testForVariant(layer1[0], Blocks.stone, event.room)) {
            layer1Variant = plotWarpPoints(desticlesplot, desticlesWarpPoints)
        } else if (testForVariant(layer0[1], Blocks.stone, event.room)) {
            layer1Variant = plotWarpPoints(krzIsStupidplot, krzIsStupidWarpPoints)
        } else if (testForVariant(layer0[2], Blocks.stone, event.room)) {
            layer1Variant = plotWarpPoints(fanficplot, fanficWarpPoints)
        } else if (testForVariant(layer0[3], Blocks.stone, event.room)) {
            layer1Variant = plotWarpPoints(jpplot, jpWarpPoints)
        } else if (testForVariant(layer0[4], Blocks.stone, event.room)) {
            layer1Variant = plotWarpPoints(hiitsmeplot, hiitsmeWarpPoints)
        }
        //Layer 2









    }







}