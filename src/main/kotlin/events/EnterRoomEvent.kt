package me.jpaMain.events

import cc.polyfrost.oneconfig.events.event.CancellableEvent
import me.jpaMain.utils.roomInfo

class EnterRoomEvent(val room: roomInfo): CancellableEvent() {}