package me.jpaMain.dungeonfeatures.iceFillSolver

import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.events.event.Stage
import cc.polyfrost.oneconfig.events.event.TickEvent
import cc.polyfrost.oneconfig.events.event.WorldLoadEvent
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import cc.polyfrost.oneconfig.libs.universal.UChat
import cc.polyfrost.oneconfig.utils.dsl.mc
import com.github.Wadey.config.jpaConfig.*
import me.jpaMain.dungeonfeatures.DungeonScanner.iceFillPosition
import me.jpaMain.events.QuarterSecondEvent
import me.jpaMain.utils.*
import me.jpaMain.utils.renderHelper.drawBox
import me.jpaMain.utils.renderHelper.drawLines3dAboveBlocks
import me.jpaMain.utils.renderHelper.getViewerPos
import net.minecraft.init.Blocks
import net.minecraft.util.BlockPos
import net.minecraftforge.client.event.RenderWorldLastEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import java.lang.System.currentTimeMillis


class iceFillSolver{

    init {
        EventManager.INSTANCE.register(this)
    }
    private lateinit var layer0: determinedVariant
    private lateinit var layer1: determinedVariant
    private lateinit var layer2: determinedVariant
    private var layer0plot: List<BlockPos>? = null
    private var layer1plot: List<BlockPos>? = null
    private var layer2plot: List<BlockPos>? = null
    private var layer0warp: List<BlockPos>? = null
    private var layer1warp: List<BlockPos>? = null
    private var layer2warp: List<BlockPos>? = null
    private var layer1tp: BlockPos? = null
    private var layer2tp: BlockPos? = null
    private var lastScan = currentTimeMillis()

    private var inIcefill = false
    private var determinedVariants = false

    private fun determineVariant(variants: List<variantInfo>, room: roomInfo): determinedVariant{
        val iterator = variants.iterator()
        while (iterator.hasNext()) {
            var correct = 0
            val points = iterator.next()

           // UChat.chat(points.name)

            points.detectionPoints.forEach {
                //UChat.chat("${convertToRealCoords(room, it)}:${!isBlock(convertToRealCoords(room, it), Blocks.stone)}:${getBlockAt(convertToRealCoords(room, it))}")
                if (isBlock(convertToRealCoords(room, it), Blocks.stone)) {
                    correct++
                    //UChat.chat("passed")
                }
                if (correct == points.detectionPoints.size) {
                    return determinedVariant(points.name, points.plotPoints, points.warpPoints, points.tpPoint)
                }
            }


        }
        return determinedVariant("none", listOf(), listOf(), null)
    }

    private fun drawVariant(plot: List<BlockPos>?, warp: List<BlockPos>?, tpPoint: BlockPos?, partialTicks: Float) {
        if (plot == null || warp == null) return
        val viewerPos = getViewerPos(partialTicks)
        drawLines3dAboveBlocks(plot, icefillPathColor, 3f, false, viewerPos)
        var i = 0
        warp.forEach{
            var isBlock3BlocksBehindPackedIce = true
            if (i > 2) {
                isBlock3BlocksBehindPackedIce = isBlock(warp[i - 3], Blocks.packed_ice)
            }

            if (isBlock3BlocksBehindPackedIce && !isBlock(it, Blocks.packed_ice)) {
                drawBox(it, icefillEtherwarpPointColor, 3f, false, viewerPos)
            }
            i++
        }
        if (tpPoint == null) return
        drawBox(tpPoint, icefillTeleportPointColor, 3f, false, viewerPos)

    }

    private fun bulkConvertToRealCoords(list: List<BlockPos>, room: roomInfo): List<BlockPos> {
        //UChat.chat(list)
        return list.map { convertToRealCoords(room, it) }

    }


    @Subscribe
    fun reset(event: WorldLoadEvent) {
        determinedVariants = false
    }

    @Subscribe
    fun onTick(event: QuarterSecondEvent) {
        if (!icefillSolver) return

        val position = iceFillPosition ?: return // Store a local copy and return if null
        lastScan = currentTimeMillis()

        inIcefill = playerInRoomBounds(position, mc.thePlayer.position)
        if (!inIcefill || determinedVariants) return
        //UChat.chat(position.rotation)
        //UChat.chat("x:${position.getX()}, z: ${position.getZ()}")
        //UChat.chat(position.name)


        // Process layers
        layer0 = determineVariant(listOf(spongecokeVariant, epicVariant, crazyVariant, bfvarroeVariant), position)
        layer1 = determineVariant(listOf(akuVariant, jpVariant, desticlesVariant, krzVariant, fanficVariant, hiitsmeVariant), position)
        layer2 = determineVariant(listOf(crossVariant, turtleVariant, americaVariant, pistolVariant, neutralVariant), position)

        // Convert plots and warps
        layer0plot = bulkConvertToRealCoords(layer0.plotPoints, position)
        layer1plot = bulkConvertToRealCoords(layer1.plotPoints, position)
        layer2plot = bulkConvertToRealCoords(layer2.plotPoints, position)
        layer0warp = bulkConvertToRealCoords(layer0.warpPoints, position)
        layer1warp = bulkConvertToRealCoords(layer1.warpPoints, position)
        layer2warp = bulkConvertToRealCoords(layer2.warpPoints, position)


        layer1tp = layer1.tpPoint?.let { convertToRealCoords(position, it) }
        layer2tp = layer2.tpPoint?.let { convertToRealCoords(position, it) }
        determinedVariants = true
    }


    @SubscribeEvent
    fun onRender(event: RenderWorldLastEvent){
        if (!inIcefill || !determinedVariants) return

        drawVariant(layer0plot, layer0warp, null, event.partialTicks)
        drawVariant(layer1plot, layer1warp, layer1tp, event.partialTicks)
        drawVariant(layer2plot, layer2warp, layer2tp, event.partialTicks)


    }
}

// [BlockPos{x=2, y=71, z=4},
//-121, 0, -185
//(-4, 71, 2)
//-125, 71, -181
//-125 71, -183


// BlockPos{x=-3, y=71, z=5},
// -5, 71, -3



// BlockPos{x=3, y=71, z=6},
// BlockPos{x=-2, y=71, z=10},
// BlockPos{x=-1, y=71, z=7},
// BlockPos{x=0, y=71, z=7},
// BlockPos{x=1, y=71, z=7},
// BlockPos{x=2, y=71, z=7},
// BlockPos{x=3, y=71, z=7},
// BlockPos{x=2, y=71, z=10},
// BlockPos{x=1, y=71, z=8},
// BlockPos{x=1, y=71, z=9},
// BlockPos{x=0, y=71, z=9},
// BlockPos{x=-1, y=71, z=9},
// BlockPos{x=-1, y=71, z=10}
// , BlockPos{x=0, y=71, z=10},
// BlockPos{x=0, y=71, z=11}]