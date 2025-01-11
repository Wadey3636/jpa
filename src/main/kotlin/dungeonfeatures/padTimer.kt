package me.jpaMain.dungeonfeatures

import org.polyfrost.oneconfig.api.config.v1.core.PolyColor
import org.polyfrost.oneconfig.api.event.v1.events.EventManager
import org.polyfrost.oneconfig.api.event.v1.events.event.ChatReceiveEvent
import org.polyfrost.oneconfig.api.event.v1.events.event.WorldLoadEvent
import org.polyfrost.oneconfig.libs.eventbus.Subscribe
import me.jpaMain.events.ServerTickEvent

var purpleTicks = 0
var stormActivated = false
var padticks = 20f
var padcolor = PolyColor((255 - padticks * 12.75).toInt(), (0 + padticks * 12.75).toInt(), 0, 255)

class padTimer {
    init {
        EventManager.INSTANCE.register(this)
    }


    @Subscribe
    fun reset(event: WorldLoadEvent) {
        stormActivated = false
    }

    @Subscribe
    fun stormPhaseStart(event: ChatReceiveEvent) {
        if (event.message.unformattedText.toString() == "[BOSS] Storm: Pathetic Maxor, just like expected.") {
            padticks = 20f
            purpleTicks = 650
            stormActivated = true
        } else if (event.message.unformattedText.toString() == "[BOSS] Storm: I should have known that I stood no chance.") {
            stormActivated = false
        }
    }

    @Subscribe
    fun tickTimer(event: ServerTickEvent) {
        if (stormActivated) {
            if (padticks > 1) {
                --padticks
            } else {
                padticks = 20f
            }

            if (purpleTicks > 0) --purpleTicks

            padcolor = PolyColor((255 - padticks * 12.75).toInt(), (0 + padticks * 12.75).toInt(), 0, 255)
        }
    }


}