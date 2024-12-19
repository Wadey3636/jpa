package me.jpaMain.dungeonfeatures.iceFillSolver

import cc.polyfrost.oneconfig.events.EventManager
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
import me.jpaMain.utils.worldUtils.isBlock
import net.minecraft.init.Blocks
import net.minecraft.util.BlockPos
import net.minecraftforge.client.event.RenderWorldLastEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent


class iceFillSolver {

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

    private var inIcefill = false
    private var determinedVariants = false

    private fun determineVariant(variants: List<variantInfo>, room: roomInfo): determinedVariant {
        for (points in variants) {
            if (points.detectionPoints.count {
                    isBlock(
                        convertToRealCoords(room, it),
                        Blocks.stone
                    )
                } == points.detectionPoints.size) {
                return determinedVariant(points.name, points.plotPoints, points.warpPoints, points.tpPoint)
            }
        }

        UChat.chat("§c[Jpa] Error: Variant Undetermined")
        return determinedVariant("none", emptyList(), emptyList(), null)
    }


    private fun drawVariant(plot: List<BlockPos>?, warp: List<BlockPos>?, tpPoint: BlockPos?, partialTicks: Float) {
        if (plot == null || warp == null) return
        val viewerPos = getViewerPos(partialTicks)
        drawLines3dAboveBlocks(plot, icefillPathColor, 3f, false, viewerPos)
        warp.forEachIndexed { i, point ->
            if ((i <= 2 || isBlock(warp[i - 3], Blocks.packed_ice)) && !isBlock(point, Blocks.packed_ice)) {
                drawBox(point, icefillEtherwarpPointColor, 3f, false, viewerPos)
            }
        }

        tpPoint?.let {
            drawBox(it, icefillTeleportPointColor, 3f, false, viewerPos)
        }
    }


    private fun bulkConvertToRealCoords(list: List<BlockPos>, room: roomInfo): List<BlockPos> {
        return list.map { convertToRealCoords(room, it) }
    }


    @Subscribe
    fun reset(event: WorldLoadEvent) {
        determinedVariants = false
        inIcefill = false

    }

    @Subscribe
    fun OnQuarterSecond(event: QuarterSecondEvent) {
        if (!icefillSolver) return


        iceFillPosition?.let { position ->
            if (!playerInRoomBounds(position, mc.thePlayer.position)) {
                inIcefill = false
                return
            }

            inIcefill = true
            if (determinedVariants) return


            // Check for variants!11!!!!1!!!111 WOOWOOWOWO
            layer0 = determineVariant(listOf(spongecokeVariant, epicVariant, crazyVariant, bfvarroeVariant), position)
            layer1 = determineVariant(
                listOf(
                    akuVariant,
                    jpVariant,
                    desticlesVariant,
                    krzVariant,
                    fanficVariant,
                    hiitsmeVariant
                ), position
            )
            layer2 = determineVariant(
                listOf(crossVariant, turtleVariant, americaVariant, pistolVariant, neutralVariant),
                position
            )


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
    }


    @SubscribeEvent
    fun onRender(event: RenderWorldLastEvent) {
        if (inIcefill && determinedVariants) {
            drawVariant(layer0plot, layer0warp, null, event.partialTicks)
            drawVariant(layer1plot, layer1warp, layer1tp, event.partialTicks)
            drawVariant(layer2plot, layer2warp, layer2tp, event.partialTicks)
        }
    }
}
