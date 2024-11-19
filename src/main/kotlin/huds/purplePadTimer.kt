/*
package me.jpaMain.huds

import cc.polyfrost.oneconfig.config.annotations.Color
import cc.polyfrost.oneconfig.config.core.OneColor
import cc.polyfrost.oneconfig.hud.Hud
import cc.polyfrost.oneconfig.libs.universal.UMatrixStack
import cc.polyfrost.oneconfig.platform.Platform
import cc.polyfrost.oneconfig.renderer.TextRenderer
import me.jpaMain.dungeonfeatures.p3StartTimerticks
import kotlin.math.max


class purplePadTimer : Hud(true) {
    @Color(
        name = "Timer Color"
    )
    protected var timerColor = OneColor(0, 255, 0, 255)
    override fun draw(matrices: UMatrixStack?, x: Float, y: Float, scale: Float, example: Boolean) {
        if (p3StartTimerticks <= 0f) return

        if (p3StartTimerticks % 2 == 0f) {
            TextRenderer.drawScaledString(
                (p3StartTimerticks / 20).toString() + "0",
                x,
                y,
                timerColor.getRGB(),
                TextRenderer.TextType.toType(0),
                scale
            )
        } else {
            TextRenderer.drawScaledString(
                (p3StartTimerticks / 20).toString(),
                x,
                y,
                timerColor.getRGB(),
                TextRenderer.TextType.toType(0),
                scale
            )
        }


    }

    override fun getWidth(scale: Float, example: Boolean): Float {
        var width = 0f
        width = max(width.toDouble(), getLineWidth((p3StartTimerticks * 5).toString(), scale).toDouble()).toFloat()
        return width
    }

    override fun getHeight(scale: Float, example: Boolean): Float {
        return 8 * scale
    }


    fun getLineWidth(line: String?, scale: Float): Float {
        return Platform.getGLPlatform().getStringWidth(line) * scale
    }


}

*/