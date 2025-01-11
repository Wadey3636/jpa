package me.jpaMain.events

import org.polyfrost.oneconfig.api.event.v1.events.event.CancellableEvent

class deletePlayerEntryEvent(id: Int) : CancellableEvent() {

    var deleteID = id

    fun getID(): Int {
        return deleteID
    }

}