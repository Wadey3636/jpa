package me.jpaMain.events

import org.polyfrost.oneconfig.api.event.v1.events.Event

class dungeonStartEvent(Floor: String) : Event.Cancellable() {
    private var floor = Floor

       fun getFloor(): String {
           return floor
       }
}