package me.jpaMain.events

import cc.polyfrost.oneconfig.events.event.CancellableEvent

class deletePlayerEntryEvent(id: Int) : CancellableEvent() {

    final var deleteID = id;

    fun getID(): Int{
        return deleteID
    }

}