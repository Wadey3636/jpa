
package me.jpaMain.huds
import cc.polyfrost.oneconfig.hud.Hud
import cc.polyfrost.oneconfig.libs.universal.UMatrixStack
import cc.polyfrost.oneconfig.platform.Platform
import cc.polyfrost.oneconfig.renderer.TextRenderer
import me.jpaMain.dungeonfeatures.p3StartTimerticks
import kotlin.math.max
import com.github.Wadey.config.jpaConfig.healerWishNotificationColor
import me.jpaMain.dungeonfeatures.wishNotificationRenderTime
import me.jpaMain.utils.screenCenterX
import me.jpaMain.utils.screenCenterY

class WishHud : Hud(true, screenCenterX, screenCenterY, 50f) {
    override fun draw(matrices: UMatrixStack?, x: Float, y: Float, scale: Float, example: Boolean) {

        if (wishNotificationRenderTime > 0) TextRenderer.drawScaledString((p3StartTimerticks / 20).toString() + "0", x, y, healerWishNotificationColor.getRGB(), TextRenderer.TextType.toType(0), scale)
    }

    override fun getWidth(scale: Float, example: Boolean): Float {
        return max(0.0, getLineWidth("Wish", 5f).toDouble()).toFloat()
    }

    override fun getHeight(scale: Float, example: Boolean): Float {
        return 8 * scale
    }


    fun getLineWidth(line: String?, scale: Float): Float {
        return Platform.getGLPlatform().getStringWidth(line) * scale
    }



}

