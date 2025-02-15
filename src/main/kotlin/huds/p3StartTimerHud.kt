package me.jpaMain.huds

import me.jpaMain.dungeonfeatures.p3StartTimerticks
import org.polyfrost.oneconfig.api.config.v1.annotations.Color
import org.polyfrost.oneconfig.api.hud.v1.TextHud
import org.polyfrost.universal.UMatrixStack
import kotlin.math.max
import org.polyfrost.polyui.color.PolyColor
import org.polyfrost.oneconfig.api.event.v1.eventHandler

var p3StartTimerText: String = ""
class p3StartTimerHud : TextHud("", p3StartTimerText) {
    @Color(
        title = "Timer Color"
    )
    protected var timerColor = PolyColor.Mutable(0f ,0f ,0f ,0f)


    override fun id() = "p3_start_timer"

    override fun title() = "P3 Start Timer"

    override fun category() = Category.INFO
    override fun getText(): String? {
        if (p3StartTimerticks <= 0f) return null
        return if (p3StartTimerticks % 2 == 0f) {
            (p3StartTimerticks / 20).toString() + "0"
        } else {
            (p3StartTimerticks / 20).toString()
        }
    }

}



