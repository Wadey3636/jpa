package me.jpaMain.utils

import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.events.event.WorldLoadEvent
import me.jpaMain.jpaMain.mc


var screenCenterX =mc.displayWidth.toFloat() / 2
var screenCenterY = mc.displayHeight.toFloat() / 2
class clientInfo {

    init {
        EventManager.INSTANCE.register(this)
    }

    fun onWorldLoad(event: WorldLoadEvent) {
        screenCenterX =mc.displayWidth.toFloat() / 2
        screenCenterY = mc.displayHeight.toFloat() / 2


    }
}