package me.jpaMain.utils

import org.polyfrost.oneconfig.config.core.PolyColor
import org.polyfrost.oneconfig.api.event.v1.events.EventManager
import org.polyfrost.oneconfig.api.event.v1.events.event.HudRenderEvent
import org.polyfrost.oneconfig.api.event.v1.events.event.WorldLoadEvent
import org.polyfrost.oneconfig.libs.eventbus.Subscribe
import me.jpaMain.jpaMain.mc
import me.jpaMain.utils.renderHelper.drawCenteredText
import me.jpaMain.utils.renderHelper.PolyColorToInt
import net.minecraft.client.gui.ScaledResolution


var title = ""
var size = 0f
var color1 = PolyColorToInt(PolyColor(0, 0, 0, 0))
var time = 0L
var timeStamp = System.currentTimeMillis()
var scaledResolution = ScaledResolution(mc)
var centerX = (scaledResolution.scaledWidth / 2f)
var centerY = (scaledResolution.scaledHeight / 2f)


class titleUtils {
    init {
        EventManager.INSTANCE.register(this)
    }

    @Subscribe
    fun worldLoadEvent(event: WorldLoadEvent) {
        scaledResolution = ScaledResolution(mc)
        centerX = (scaledResolution.scaledWidth / 2f)
        centerY = (scaledResolution.scaledHeight / 2f)
    }

    @Subscribe
    fun titleRenderer(event: HudRenderEvent) {
        if (System.currentTimeMillis() - timeStamp < time) drawCenteredText(title, size, color1, centerX, centerY)
    }


}