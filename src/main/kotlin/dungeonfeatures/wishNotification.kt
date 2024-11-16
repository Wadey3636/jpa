package me.jpaMain.dungeonfeatures

import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.events.event.ChatReceiveEvent
import cc.polyfrost.oneconfig.events.event.TickEvent
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe

var wishNotificationRenderTime: Int = 0
class wishNotification {

    //⚠ Maxor is enraged! ⚠
    //You have done it, you destroyed the factory…
    init {
        EventManager.INSTANCE.register(this)
    }

    @Subscribe
    fun onChat(event: ChatReceiveEvent){
        when(event.message.unformattedText) {
            "⚠ Maxor is enraged! ⚠" -> {
                wishNotificationRenderTime = 60

            }
        }

    }


    @Subscribe
    fun onTick(event: TickEvent) {
        if (wishNotificationRenderTime > 0) --wishNotificationRenderTime

    }


}