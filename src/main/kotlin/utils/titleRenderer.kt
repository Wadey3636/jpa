package me.jpaMain.utils

import cc.polyfrost.oneconfig.config.core.OneColor
import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.events.event.HudRenderEvent
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import me.jpaMain.utils.renderHelper.renderTitleText
import me.jpaMain.utils.renderHelper.oneColorToInt

var title = ""
var size = 0f
var color1 = oneColorToInt(OneColor(0, 0, 0, 0))
var time = 0L
var timeStamp = System.currentTimeMillis()
class titleUtils {
    init {
        EventManager.INSTANCE.register(this)
    }

    @Subscribe
    fun titleRenderer(event: HudRenderEvent){
        if (System.currentTimeMillis() - timeStamp < time) renderTitleText(title, size, color1)
    }


}