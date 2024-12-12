package me.jpaMain.dungeonfeatures
import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.events.event.ChatReceiveEvent
import cc.polyfrost.oneconfig.events.event.HudRenderEvent
import cc.polyfrost.oneconfig.events.event.TickEvent
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import me.jpaMain.utils.renderHelper
import com.github.Wadey.config.jpaConfig.*


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
                    color = renderHelper.oneColorToInt(healerWishNotificationColor)
                    renderHelper.renderTitle("Wish", wishNotificationSize, color, 3000)
                }

                "[BOSS] Goldor: But you have nowhere to hide anymore!" -> {
                    color = renderHelper.oneColorToInt(healerWishNotificationColor)
                    renderHelper.renderTitle("Wish", wishNotificationSize, color, 3000)
                }
            }
        }
    }


}