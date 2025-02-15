/*
import me.jpaMain.dungeonfeatures.padcolor
import org.polyfrost.oneconfig.api.config.v1.annotations.Color
import org.polyfrost.oneconfig.api.hud.v1.TextHud
import org.polyfrost.polyui.color.PolyColor
import me.jpaMain.dungeonfeatures.padticks
import me.jpaMain.dungeonfeatures.stormActivated
import me.jpaMain.utils.renderHelper
import org.polyfrost.oneconfig.api.hud.v1.LegacyHud
import org.polyfrost.universal.UMatrixStack


class padTimerHud(override var width: Float, override var height: Float) : LegacyHud() {


    override fun category(): Category {
        return Category.INFO
    }

    override fun render(stack: UMatrixStack, x: Float, y: Float, scaleX: Float, scaleY: Float) {
        if (!stormActivated) return
        if (padticks % 2 != 1f) {
            renderHelper.drawCenteredText(
                (padticks / 20).toString() + "0",
                scaleX,
                padcolor,
                x,
                y
            )
        } else {
            renderHelper.drawCenteredText(
                (padticks / 20).toString(),
                scaleX,
                padcolor,
                x,
                y
            )
        }

    }

    override fun title(): String {
        return "Pad Timer"
    }

    override fun update(): Boolean {
        return true
    }
}

 */