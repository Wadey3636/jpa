package me.jpaMain.dungeonfeatures

import org.polyfrost.oneconfig.api.event.v1.events.EventManager
import org.polyfrost.oneconfig.api.event.v1.events.event.ChatReceiveEvent
import org.polyfrost.oneconfig.libs.eventbus.Subscribe
import com.github.Wadey.config.jpaConfig.*
import me.jpaMain.utils.renderHelper
import me.jpaMain.utils.renderHelper.PolyColorToInt


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
                    renderHelper.renderTitle(
                        "Wish",
                        wishNotificationSize,
                        healerWishNotificationColor.PolyColorToInt,
                        3000
                    )
                }

                "[BOSS] Goldor: But you have nowhere to hide anymore!" -> {
                    renderHelper.renderTitle(
                        "Wish",
                        wishNotificationSize,
                        healerWishNotificationColor.PolyColorToInt,
                        3000
                    )
                }
            }
        }
    }


}