package me.jpaMain.dungeonfeatures

import cc.polyfrost.oneconfig.config.core.OneColor
import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.events.event.ChatReceiveEvent
import cc.polyfrost.oneconfig.events.event.WorldLoadEvent
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import me.jpaMain.events.ServerTickEvent

var purpleTicks = 0
var stormActivated = false
var padticks = 20f
var padcolor = OneColor((255 - padticks * 12.75).toInt(), (0 + padticks * 12.75).toInt(), 0, 255)

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

            padcolor = OneColor((255 - padticks * 12.75).toInt(), (0 + padticks * 12.75).toInt(), 0, 255)
        }
    }


}