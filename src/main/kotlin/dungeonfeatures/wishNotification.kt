package me.jpaMain.dungeonfeatures


import com.github.Wadey.config.JpaConfig.*
import me.jpaMain.utils.renderHelper
import org.polyfrost.oneconfig.api.event.v1.EventManager
import org.polyfrost.oneconfig.api.event.v1.events.ChatEvent
import org.polyfrost.oneconfig.api.event.v1.invoke.impl.Subscribe


class wishNotification {
    private var color = 0

    //⚠ Maxor is enraged! ⚠
    //You have done it, you destroyed the factory…
    init {
        EventManager.INSTANCE.register(this)
    }

    @Subscribe
    fun onChat(event: ChatEvent.Receive) {

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

                "[BOSS] Goldor: You have done it, you destroyed the factory…" -> {
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