package me.jpaMain.dungeonfeatures


import org.polyfrost.oneconfig.utils.v1.dsl.mc
import me.jpaMain.utils.renderHelper
import net.minecraft.util.BlockPos
import net.minecraftforge.client.event.RenderWorldLastEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import com.github.Wadey.config.JpaConfig.*
import me.jpaMain.events.QuarterSecondEvent
import me.jpaMain.utils.guiUtils.containsOneOf
import me.jpaMain.utils.guiUtils.deformat
import me.jpaMain.utils.renderHelper.getViewerPos
import me.jpaMain.utils.worldUtils
import net.minecraft.entity.item.EntityArmorStand
import net.minecraft.util.AxisAlignedBB
import org.polyfrost.oneconfig.api.event.v1.EventManager
import org.polyfrost.oneconfig.api.event.v1.events.ChatEvent
import org.polyfrost.oneconfig.api.event.v1.events.WorldEvent
import org.polyfrost.oneconfig.api.event.v1.invoke.impl.Subscribe
import org.polyfrost.polyui.color.*

@JvmField
public var activeWaypoints: MutableList<BlockPos> = mutableListOf()
class terminalWaypoints {
    init {
        EventManager.INSTANCE.register(this)
    }

    private var terminalSection: Int = 0

    private fun addS1(){
        when (terminalPreset) {
            0 -> if (I4 && ee2) "4/3" else if (I4) "3" else "2"
            1 -> if (I4) "2/1" else "1"
            2 -> if (ee2) "LL/RL" else "4/RL/LL"
            3 -> if (I4) "" else "3"
            4 -> terminalWaypointsTextS1
            else -> ""
        }.split("/").forEach {
            when (it) {
                "1" -> activeWaypoints.add(BlockPos(111, 113, 73))
                "2" -> activeWaypoints.add(BlockPos(111, 119, 79))
                "3" -> activeWaypoints.add(BlockPos(89, 112, 92))
                "4" -> activeWaypoints.add(BlockPos(89, 122, 101))
                "LL" -> activeWaypoints.add(BlockPos(106, 124, 113))
                "RL" -> activeWaypoints.add(BlockPos(94, 124, 113))
                else -> return@forEach
            }
        }
    }
    
    private fun addS2(){
        when (terminalPreset) {
            0 -> if (mageCoring) "2" else "2/3"
            1 -> "1/3"
            2 -> "4/RL"
            3 -> "5/3"
            4 -> terminalWaypointsTextS2
            else -> ""
        }.split("/").forEach {
            when (it) {
                "1" -> activeWaypoints.add(BlockPos(68, 109, 121))
                "2" -> activeWaypoints.add(BlockPos(59, 120, 122))
                "3" -> activeWaypoints.add(BlockPos(39, 108, 143))
                "4" -> activeWaypoints.add(BlockPos(40, 124, 125))
                "5" -> activeWaypoints.add(BlockPos(23, 132, 138))
                "LL" -> activeWaypoints.add(BlockPos(23, 132, 138))
                "RL" -> activeWaypoints.add(BlockPos(27, 124, 127))
                else -> return@forEach
            }
        }
        
    }

    private fun addS3(){

        when (terminalPreset) {
            0 -> if (mageCoring) "" else "2"
            1 -> "1"
            2 -> "4/LL/RL"
            3 -> "3"
            4 -> terminalWaypointsTextS3
            else -> ""
        }.split("/").forEach {
            when (it) {
                "1" -> activeWaypoints.add(BlockPos(-3, 109, 112))
                "2" -> activeWaypoints.add(BlockPos(-3, 119, 93))
                "3" -> activeWaypoints.add(BlockPos(19, 123, 93))
                "4" -> activeWaypoints.add(BlockPos(-3, 109, 77))
                "LL" -> activeWaypoints.add(BlockPos(2, 122, 55))
                "RL" -> activeWaypoints.add(BlockPos(14, 122, 55))
                else -> return@forEach
            }
        }

    }

    private fun addS4(){
        when (terminalPreset) {
            0 -> if (mageCoring) "" else "2"
            1 -> "1"
            2 -> if (mageCoring) "2" else "4"
            3 -> "3"
            4 -> terminalWaypointsTextS4
            else -> ""
        }.split("/").forEach {
            when (it) {
                "1" -> activeWaypoints.add(BlockPos(41, 109, 29))
                "2" -> activeWaypoints.add(BlockPos(44, 121, 29))
                "3" -> activeWaypoints.add(BlockPos(67, 109, 29))
                "4" -> activeWaypoints.add(BlockPos(72, 115, 48))
                "LL" -> activeWaypoints.add(BlockPos(84, 121, 34))
                "RL" -> activeWaypoints.add(BlockPos(86, 128, 46))
                else -> return@forEach
            }
        }

    }

    @Subscribe
    fun onQuarterSec(event: QuarterSecondEvent) {
        activeWaypoints.removeIf { waypoint ->
            val armorStands = mc.theWorld.getEntitiesWithinAABB(
                EntityArmorStand::class.java,
                AxisAlignedBB(
                    waypoint.x - 3.0, waypoint.y - 3.0, waypoint.z - 3.0,
                    waypoint.x + 3.0, waypoint.y + 3.0, waypoint.z + 3.0
                )
            )
            armorStands.isNotEmpty() && armorStands.any {
                it.name.deformat.containsOneOf("active", "terminal active", "activated", "device active", ignoreCase = true)
            }
        }
    }

    @Subscribe
    fun worldLoad(event: WorldEvent.Load) {
        activeWaypoints.clear()
    }

    @Subscribe
    fun chatReceived(event: ChatEvent.Receive) {
        if (!terminalWaypoints) return
        when (event.fullyUnformattedMessage) {
            "[BOSS] Storm: I should have known that I stood no chance." ->
                {
                    terminalSection = 0
                    addS1()
                }
        }
        if (event.fullyUnformattedMessage.containsOneOf("! (7/7)", "! (8/8)")) {
            terminalSection += 1
            when (terminalSection) {
                1 -> addS2()
                2 -> addS3()
                3 -> addS4()
            }
        }

    }

    private fun isDev(pos: BlockPos): Boolean{
        return true

    }

    @SubscribeEvent
    fun onRenderLast(event: RenderWorldLastEvent) {
        if (!terminalWaypoints || activeWaypoints.isEmpty()) return
        val viewerPos = getViewerPos(event.partialTicks)
        val firstWaypoint = activeWaypoints.firstOrNull()
        var devColor = terminalWaypointsColor
        var renderWaypoints = activeWaypoints
        if (firstWaypoint != null && isDev(firstWaypoint)) {
            val distance = worldUtils.findDistance3D(
                viewerPos.first, viewerPos.second, viewerPos.third,
                firstWaypoint.x.toDouble(), firstWaypoint.y.toDouble(), firstWaypoint.z.toDouble()
            )
            val clampedAlpha = (distance.coerceIn(2.0, 10.0) / 10).let { if (it == 0.2) 0.0 else it }
            devColor = rgba(terminalWaypointsColor.r, terminalWaypointsColor.g, terminalWaypointsColor.b, clampedAlpha.toFloat())
            renderWaypoints = activeWaypoints.drop(1).toMutableList()
        }
        renderWaypoints.forEach {
            renderHelper.drawBox(it, terminalWaypointsColor, 3f, terminalWaypointsPhase, viewerPos)
        }
        firstWaypoint?.let {
            if (terminalWaypointsTracer) {
                renderHelper.trace(it, viewerPos, devColor, 3f, true)
            }
        }
    }

}

