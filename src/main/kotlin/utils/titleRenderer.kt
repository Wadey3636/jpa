package me.jpaMain.utils



import me.jpaMain.jpaMain.mc
import me.jpaMain.utils.renderHelper.drawCenteredText
import net.minecraft.client.gui.ScaledResolution
import org.polyfrost.oneconfig.api.event.v1.EventManager
import org.polyfrost.oneconfig.api.event.v1.events.HudRenderEvent
import org.polyfrost.oneconfig.api.event.v1.events.WorldEvent
import org.polyfrost.oneconfig.api.event.v1.invoke.impl.Subscribe
import org.polyfrost.polyui.color.PolyColor


var title = ""
var size = 0f
var color1 = PolyColor.Mutable(0f, 0f, 0f, 0f).argb
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
    fun worldLoadEvent(event: WorldEvent.Load) {

        scaledResolution = ScaledResolution(mc)
        centerX = (scaledResolution.scaledWidth / 2f)
        centerY = (scaledResolution.scaledHeight / 2f)
    }

    @Subscribe
    fun titleRenderer(event: HudRenderEvent) {
        if (System.currentTimeMillis() - timeStamp < time) drawCenteredText(title, size, color1, centerX, centerY)
    }


}