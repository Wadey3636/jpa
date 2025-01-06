package me.jpaMain

import cc.polyfrost.oneconfig.events.EventManager

class classManager {
    init {
        EventManager.INSTANCE.register(this)
    }
}