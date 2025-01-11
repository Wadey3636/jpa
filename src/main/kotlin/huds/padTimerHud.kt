package me.jpaMain.huds

import org.polyfrost.oneconfig.hud.Hud
import org.polyfrost.oneconfig.libs.universal.UMatrixStack
import org.polyfrost.oneconfig.platform.Platform
import org.polyfrost.oneconfig.renderer.TextRenderer
import me.jpaMain.dungeonfeatures.padcolor
import me.jpaMain.dungeonfeatures.padticks
import me.jpaMain.dungeonfeatures.stormActivated
import kotlin.math.max


class padTimerHud : Hud(stormActivated) {


    override fun draw(matrices: UMatrixStack?, x: Float, y: Float, scale: Float, example: Boolean) {
        if (!stormActivated) return
        if (padticks % 2 != 1f) {
            TextRenderer.drawScaledString(
                (padticks / 20).toString() + "0",
                x,
                y,
                padcolor.getRGB(),
                TextRenderer.TextType.toType(0),
                scale
            )
        } else {
            TextRenderer.drawScaledString(
                (padticks / 20).toString(),
                x,
                y,
                padcolor.getRGB(),
                TextRenderer.TextType.toType(0),
                scale
            )
        }

    }

    override fun getWidth(scale: Float, example: Boolean): Float {
        var width = 0f
        width = max(width.toDouble(), getLineWidth(padticks.toString(), scale).toDouble()).toFloat()
        return width
    }

    override fun getHeight(scale: Float, example: Boolean): Float {
        return 8 * scale
    }


    fun getLineWidth(line: String?, scale: Float): Float {
        return Platform.getGLPlatform().getStringWidth(line) * scale
    }
}