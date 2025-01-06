package me.jpaMain.events

import cc.polyfrost.oneconfig.events.event.CancellableEvent

class dungeonStartEvent(Floor: String) : CancellableEvent() {
    private var floor = Floor

       fun getFloor(): String {
           return floor
       }
}