
package me.jpaMain.dungeonfeatures

import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.events.event.ChatReceiveEvent
import cc.polyfrost.oneconfig.events.event.ReceivePacketEvent
import cc.polyfrost.oneconfig.events.event.WorldLoadEvent
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import cc.polyfrost.oneconfig.libs.universal.UChat
import net.minecraft.network.play.server.S32PacketConfirmTransaction
var p3StartTimerticks = 0f
class p3StartTimer {
    init {
        EventManager.INSTANCE.register(this)
    }
//[BOSS] Storm: Pathetic Maxor, just like expected.
    //
    @Subscribe
    fun p3StartTimer(event: ChatReceiveEvent){

        if(event.message.formattedText.toString() == "[351] [MVP+] Wadey36 ♲: aasd") {
            UChat.chat("balls")
        }

        if (event.message.formattedText.toString() == "[BOSS] Storm: I should have known that I stood no chance.") {
            p3StartTimerticks = 104f
        }
    }


    @Subscribe
    fun countDown(event: ReceivePacketEvent){
        if (event.packet is S32PacketConfirmTransaction && p3StartTimerticks > 0f) {
            --p3StartTimerticks
        }
    }

    @Subscribe
    fun reset(event: WorldLoadEvent) {
        p3StartTimerticks = 0f
    }


}

