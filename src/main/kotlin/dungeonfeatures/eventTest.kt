package me.jpaMain.dungeonfeatures

import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import cc.polyfrost.oneconfig.libs.universal.UChat
import me.jpaMain.events.EnterRoomEvent
import me.jpaMain.events.ServerTickEvent

class eventTest{
    //init {EventManager.INSTANCE.register(this)}

    @Subscribe
    fun test(event: ServerTickEvent){
        UChat.chat("tick!")
    }
    @Subscribe
    fun test1(event: EnterRoomEvent) {
        UChat.chat("Entered:${event.room.name}")
    }


}