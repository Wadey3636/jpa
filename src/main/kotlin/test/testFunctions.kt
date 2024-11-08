package me.jpaMain.test

import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.events.event.HudRenderEvent
import cc.polyfrost.oneconfig.events.event.RenderEvent
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import cc.polyfrost.oneconfig.libs.universal.UChat
import me.jpaMain.dungeonfeatures.iceFillSolver.epicplot
import me.jpaMain.utils.renderHelper.drawLineThroughPointsAboveBlock
import com.github.Wadey.config.jpaConfig.icefillPathColor
import me.jpaMain.utils.renderHelper.renderBeaconBeam
import me.jpaMain.utils.renderHelper.drawLine3d


class testFunctions {
    init {
        EventManager.INSTANCE.register(this)
    }

    @Subscribe
    fun onRender(event: RenderEvent){
        renderBeaconBeam(0.0, 0.0, 0.0, -1, 5f, 40f)

        drawLineThroughPointsAboveBlock(epicplot, icefillPathColor, true, 3f, false)

        drawLine3d(1.0, 4.0, 0.0, 0.0, 4.0, 0.0, icefillPathColor, 3f, true)
    }

}