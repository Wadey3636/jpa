package me.jpaMain.utils

import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.events.event.WorldLoadEvent
import cc.polyfrost.oneconfig.libs.universal.UResolution


var screenCenterX = UResolution.scaledWidth / 2
var screenCenterY = UResolution.scaledHeight / 2

class clientInfo {

    init {
        EventManager.INSTANCE.register(this)
    }

    fun onWorldLoad(event: WorldLoadEvent) {
        screenCenterX = UResolution.scaledWidth / 2
        screenCenterY = UResolution.scaledHeight / 2


    }
}