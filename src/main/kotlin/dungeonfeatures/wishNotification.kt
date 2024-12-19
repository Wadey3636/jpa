package me.jpaMain.dungeonfeatures

import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.events.event.ChatReceiveEvent
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import com.github.Wadey.config.jpaConfig.*
import me.jpaMain.utils.renderHelper
import me.jpaMain.utils.renderHelper.oneColorToInt


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
                        healerWishNotificationColor.oneColorToInt,
                        3000
                    )
                }

                "[BOSS] Goldor: But you have nowhere to hide anymore!" -> {
                    renderHelper.renderTitle(
                        "Wish",
                        wishNotificationSize,
                        healerWishNotificationColor.oneColorToInt,
                        3000
                    )
                }
            }
        }
    }


}