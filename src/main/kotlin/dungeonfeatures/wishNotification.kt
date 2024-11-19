package me.jpaMain.dungeonfeatures
import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.events.event.ChatReceiveEvent
import cc.polyfrost.oneconfig.events.event.HudRenderEvent
import cc.polyfrost.oneconfig.events.event.TickEvent
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import me.jpaMain.utils.renderHelper
import com.github.Wadey.config.jpaConfig.*

var wishNotificationRenderTime: Int = 0

class wishNotification {
    private var color = 0
    //⚠ Maxor is enraged! ⚠
    //You have done it, you destroyed the factory…
    init {
        EventManager.INSTANCE.register(this)
    }

    @Subscribe
    fun onChat(event: ChatReceiveEvent) {
        if (healerWishNotification) {
            when (event.message.unformattedText) {
                "⚠ Maxor is enraged! ⚠" -> {
                    wishNotificationRenderTime = 60
                    color = renderHelper.oneColorToInt(healerWishNotificationColor)
                }

                "[BOSS] Goldor: But you have nowhere to hide anymore!" -> {
                    wishNotificationRenderTime = 60
                    color = renderHelper.oneColorToInt(healerWishNotificationColor)
                }
            }
        }
    }


    @Subscribe
    fun onTick(event: TickEvent) {
        if (wishNotificationRenderTime > 0) --wishNotificationRenderTime
    }

    @Subscribe
    fun onHud(event: HudRenderEvent) {
        if (wishNotificationRenderTime > 0) renderHelper.renderTitleText("Wish", wishNotificationSize, color)

    }


}