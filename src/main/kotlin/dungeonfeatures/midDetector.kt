package me.jpaMain.dungeonfeatures

import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.events.event.HudRenderEvent
import cc.polyfrost.oneconfig.events.event.Stage
import cc.polyfrost.oneconfig.events.event.TickEvent
import cc.polyfrost.oneconfig.events.event.WorldLoadEvent
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import cc.polyfrost.oneconfig.libs.universal.UChat
import cc.polyfrost.oneconfig.renderer.NanoVGHelper
import cc.polyfrost.oneconfig.renderer.font.Fonts
import me.jpaMain.jpaMain.mc
import me.jpaMain.utils.PlayerInfo
import me.jpaMain.utils.isBlock
import net.minecraft.init.Blocks
import net.minecraft.util.BlockPos
import org.polyfrost.example.config.jpaConfig.*
import me.jpaMain.utils.inDungeon

public var midTriggered: Boolean = false
public var renderTime: Int = 0

class midDetector {
    init {
        EventManager.INSTANCE.register(this)
    }

    var player: String = ""
    var xpos: Float = 0f

    @Subscribe
    fun midReset(event: WorldLoadEvent) {
        midTriggered = false
        xpos = mc.displayWidth.toFloat() / 2
    }

    @Subscribe
    fun midDetector(event: TickEvent) {
        if (renderTime > 0) {
            renderTime += -1
        }

        if (midTriggered) return

        if ((event.stage == Stage.START) && midDetector && inDungeon) {
            val players = arrayListOf<PlayerInfo>()



            mc.theWorld.playerEntities.forEach {
                players.add(PlayerInfo(it.displayNameString, it.positionVector))
            }

            players.forEach {
                if (
                    it.position.xCoord in 46.0..68.0 &&
                    it.position.yCoord in 64.0..72.0 &&
                    it.position.zCoord in 62.0..84.0 &&
                    !isBlock(BlockPos(53, 63, 110), Blocks.stone) &&
                    !midTriggered
                ) {
                    player = it.name
                    renderTime = 60
                    midTriggered = true
                    return
                }

            }

        }
    }

    @Subscribe
    fun onHudRender(event: HudRenderEvent) {
        if (renderTime <= 0) return

        NanoVGHelper.INSTANCE.setupAndDraw { vg: Long ->

            NanoVGHelper.INSTANCE.drawCenteredText(
                vg,
                "$player",
                xpos,
                100f,
                -1,
                midDetectorTextSize * 5,
                Fonts.MINECRAFT_BOLD
            )

        }


    }

}





