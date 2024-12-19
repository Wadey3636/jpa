package me.jpaMain.utils

import cc.polyfrost.oneconfig.config.core.OneColor
import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.events.event.HudRenderEvent
import cc.polyfrost.oneconfig.events.event.WorldLoadEvent
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import me.jpaMain.jpaMain.mc
import me.jpaMain.utils.renderHelper.drawCenteredText
import me.jpaMain.utils.renderHelper.oneColorToInt
import net.minecraft.client.gui.ScaledResolution


var title = ""
var size = 0f
var color1 = oneColorToInt(OneColor(0, 0, 0, 0))
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