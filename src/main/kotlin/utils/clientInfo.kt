package me.jpaMain.utils

import org.polyfrost.oneconfig.api.event.v1.events.EventManager
import org.polyfrost.oneconfig.api.event.v1.events.event.WorldLoadEvent
import org.polyfrost.oneconfig.libs.universal.UResolution


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