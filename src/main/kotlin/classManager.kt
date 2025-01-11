package me.jpaMain

import org.polyfrost.oneconfig.api.event.v1.events.EventManager

class classManager {
    init {
        EventManager.INSTANCE.register(this)
    }
}