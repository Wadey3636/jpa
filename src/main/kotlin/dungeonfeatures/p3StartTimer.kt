package me.jpaMain.dungeonfeatures

import me.jpaMain.events.ServerTickEvent
//import me.jpaMain.huds.p3StartTimerText
import org.polyfrost.oneconfig.api.event.v1.EventManager
import org.polyfrost.oneconfig.api.event.v1.eventHandler
import org.polyfrost.oneconfig.api.event.v1.events.ChatReceiveEvent
import org.polyfrost.oneconfig.api.event.v1.events.TickEvent
import org.polyfrost.oneconfig.api.event.v1.events.WorldLoadEvent
import org.polyfrost.oneconfig.api.event.v1.invoke.impl.Subscribe
import org.polyfrost.universal.UChat

var p3StartTimerticks = 0f

class p3StartTimer {
    init {
        EventManager.INSTANCE.register(this)
    }


    @Subscribe
    fun p3StartTimer(event: ChatReceiveEvent) {
        if (event.fullyUnformattedMessage == "[BOSS] Storm: I should have known that I stood no chance.") {
            p3StartTimerticks = 104f
        }
    }




    @Subscribe
    fun countDown(event: ServerTickEvent) {
        --p3StartTimerticks
        //if (p3StartTimerticks <= 0f) {p3StartTimerText = ""; return}
        //p3StartTimerText = if (p3StartTimerticks % 2 == 0f) {
        //    (p3StartTimerticks / 20).toString() + "0"
        //} else {
       //     (p3StartTimerticks / 20).toString()
        //}
    }

    @Subscribe
    fun reset(event: WorldLoadEvent) {
        p3StartTimerticks = 0f
    }


}

