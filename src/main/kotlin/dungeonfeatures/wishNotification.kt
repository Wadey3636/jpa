package me.jpaMain.dungeonfeatures


import com.github.Wadey.config.JpaConfig.*
import me.jpaMain.utils.renderHelper
import org.polyfrost.oneconfig.api.event.v1.EventManager
import org.polyfrost.oneconfig.api.event.v1.events.ChatReceiveEvent
import org.polyfrost.oneconfig.api.event.v1.invoke.impl.Subscribe


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
            when (event.fullyUnformattedMessage) {
                "⚠ Maxor is enraged! ⚠" -> {
                    renderHelper.renderTitle(
                        "Wish",
                        wishNotificationSize,
                        healerWishNotificationColor.argb,
                        3000
                    )
                }

                "[BOSS] Goldor: But you have nowhere to hide anymore!" -> {
                    renderHelper.renderTitle(
                        "Wish",
                        wishNotificationSize,
                        healerWishNotificationColor.argb,
                        3000
                    )
                }
            }
        }
    }


}