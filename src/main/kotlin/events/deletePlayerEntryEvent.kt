package me.jpaMain.events

import org.polyfrost.oneconfig.api.event.v1.events.Event

class deletePlayerEntryEvent(id: Int) : Event.Cancellable() {

    var deleteID = id

    fun getID(): Int {
        return deleteID
    }

}