package me.jpaMain.dungeonfeatures


import me.jpaMain.events.ServerTickEvent
import me.jpaMain.utils.renderHelper
import org.polyfrost.oneconfig.api.event.v1.EventManager
import org.polyfrost.oneconfig.api.event.v1.events.ChatEvent
import org.polyfrost.oneconfig.api.event.v1.events.WorldEvent
import org.polyfrost.oneconfig.api.event.v1.invoke.impl.Subscribe


var purpleTicks = 0
var stormActivated = false
var padticks = 20f
var padcolor = renderHelper.argbToInt(255, (255 - padticks * 12.75).toInt(), (0 + padticks * 12.75).toInt(), 0)
    //PolyColor(

class padTimer {
    init {
        EventManager.INSTANCE.register(this)

    }


    @Subscribe
    fun reset(event: WorldEvent.Load) {
        stormActivated = false
    }

    @Subscribe
    fun stormPhaseStart(event: ChatEvent.Receive) {
        if (event.fullyUnformattedMessage.toString() == "[BOSS] Storm: Pathetic Maxor, just like expected.") {
            padticks = 20f
            purpleTicks = 650
            stormActivated = true
        } else if (event.fullyUnformattedMessage.toString() == "[BOSS] Storm: I should have known that I stood no chance.") {
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

            padcolor = renderHelper.argbToInt(255, (255 - padticks * 12.75).toInt(), (0 + padticks * 12.75).toInt(), 0)
        }
    }


}