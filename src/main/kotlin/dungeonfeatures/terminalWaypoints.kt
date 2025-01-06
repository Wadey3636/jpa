package me.jpaMain.dungeonfeatures

import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.events.event.ChatReceiveEvent
import cc.polyfrost.oneconfig.events.event.WorldLoadEvent
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import cc.polyfrost.oneconfig.libs.universal.UChat
import cc.polyfrost.oneconfig.utils.dsl.mc
import me.jpaMain.utils.renderHelper
import net.minecraft.util.BlockPos
import net.minecraftforge.client.event.RenderWorldLastEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import com.github.Wadey.config.jpaConfig.*
import me.jpaMain.events.QuarterSecondEvent
import me.jpaMain.events.changeGuiEvent
import me.jpaMain.utils.guiUtils.containsOneOf
import me.jpaMain.utils.guiUtils.deformat
import me.jpaMain.utils.renderHelper.getViewerPos
import net.minecraft.entity.item.EntityArmorStand
import net.minecraft.util.AxisAlignedBB
import net.minecraftforge.fml.common.eventhandler.Event

class terminalWaypoints {
    init {
        EventManager.INSTANCE.register(this)
    }

    private var activeWaypoints: MutableList<BlockPos> = mutableListOf()
    private var terminalSection: Int = 0
    private var earlyRender: Boolean = false


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
    fun unload(event: WorldLoadEvent){
        EventManager.INSTANCE.unregister(this)
    }

    @Subscribe
    fun onQuarterSec(event: QuarterSecondEvent) {
        if (!earlyRender) {
            activeWaypoints.removeIf { waypoint ->
                val armorStands = mc.theWorld.getEntitiesWithinAABB(
                    EntityArmorStand::class.java,
                    AxisAlignedBB(
                        waypoint.x - 3.0, waypoint.y - 3.0, waypoint.z - 3.0,
                        waypoint.x + 3.0, waypoint.y + 3.0, waypoint.z + 3.0
                    )
                )
                armorStands.isNotEmpty() && armorStands.none {
                    it.name.deformat.containsOneOf(
                        "Inactive",
                        "Not Activated",
                        "CLICK HERE",
                        ignoreCase = true
                    )
                }
            }
        }
    }

    @Subscribe
    fun chatReceived(event: ChatReceiveEvent) {
        if (!terminalWaypoints) return
        when (event.message.unformattedText) {
            "[BOSS] Storm: I should have known that I stood no chance." ->
                {
                    terminalSection = 0
                    earlyRender = true
                    addS1()
                }
            "[BOSS] Goldor: Little ants, plotting and scheming, thinking they are invincible…" ->
                {
                    earlyRender = false
                }
        }

        if (event.message.unformattedText.containsOneOf("! (7/7)", "! (8/8)")) {
            terminalSection += 1
            when (terminalSection) {
                1 -> addS2()
                2 -> addS3()
                3 -> addS4()
            }
        }

    }


    @SubscribeEvent
    fun onRenderLast(event: RenderWorldLastEvent) {
        val viewerPos = getViewerPos(event.partialTicks)
        activeWaypoints.forEach {
            renderHelper.drawBox(it, terminalWaypointsColor, 3f, terminalWaypointsPhase, viewerPos)
        }
        if (terminalWaypointsTracer && activeWaypoints.isNotEmpty()) renderHelper.trace(activeWaypoints[0], viewerPos, terminalWaypointsTracerColor, 3f, true)
    }


    //@Subscribe
    fun balls(event: changeGuiEvent) {
        addS1()
        addS2()
        addS3()
        addS4()
    }
}

