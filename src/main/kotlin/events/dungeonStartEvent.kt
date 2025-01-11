package me.jpaMain.events

import org.polyfrost.oneconfig.api.event.v1.events.event.CancellableEvent

class dungeonStartEvent(Floor: String) : CancellableEvent() {
    private var floor = Floor

       fun getFloor(): String {
           return floor
       }
}