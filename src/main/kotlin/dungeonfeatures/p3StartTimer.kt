package me.jpaMain.dungeonfeatures

import org.polyfrost.oneconfig.api.event.v1.events.EventManager
import org.polyfrost.oneconfig.api.event.v1.events.event.ChatReceiveEvent
import org.polyfrost.oneconfig.api.event.v1.events.event.ReceivePacketEvent
import org.polyfrost.oneconfig.api.event.v1.events.event.WorldLoadEvent
import org.polyfrost.oneconfig.libs.eventbus.Subscribe
import net.minecraft.network.play.server.S32PacketConfirmTransaction

var p3StartTimerticks = 0f

class p3StartTimer {
    init {
        EventManager.INSTANCE.register(this)
    }

    //
    @Subscribe
    fun p3StartTimer(event: ChatReceiveEvent) {
        if (event.message.unformattedText.toString() == "[BOSS] Storm: I should have known that I stood no chance.") {
            p3StartTimerticks = 104f
        }
    }


    @Subscribe
    fun countDown(event: ReceivePacketEvent) {
        if (event.packet is S32PacketConfirmTransaction && p3StartTimerticks > 0f) {
            --p3StartTimerticks
        }
    }

    @Subscribe
    fun reset(event: WorldLoadEvent) {
        p3StartTimerticks = 0f
    }


}

