
import org.polyfrost.oneconfig.api.config.v1.annotations.Color
import org.polyfrost.oneconfig.api.hud.v1.TextHud
import org.polyfrost.polyui.color.PolyColor
import me.jpaMain.dungeonfeatures.padticks
import me.jpaMain.dungeonfeatures.stormActivated
import org.polyfrost.oneconfig.api.hud.v1.LegacyHud


class padTimerHud : LegacyHud() {

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