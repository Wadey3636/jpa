package me.jpaMain.utils

import org.polyfrost.oneconfig.api.event.v1.events.WorldEvent
import org.polyfrost.oneconfig.api.event.v1.events.HypixelLocationEvent
import org.polyfrost.oneconfig.api.event.v1.invoke.impl.Subscribe
import org.polyfrost.oneconfig.api.event.v1.EventManager
import org.polyfrost.universal.UChat

var inSkyBlock = false
var inDungeon = false
var inGarden = false

class locationUtils {



    init {
        EventManager.INSTANCE.register(this)
    }

    @Subscribe
    fun locationChecker(event: HypixelLocationEvent) {
        inDungeon = event.location.mapName.get() == "Dungeon"
        inGarden = event.location.mapName.get() == "Garden"
        inSkyBlock = event.location.mapName.get() == "SKYBLOCK"
        UChat.chat(event.location.mapName.get())
        //UChat.chat(event.info.gameType)
        //UChat.chat(event.info.serverId)
        //UChat.chat(event.info.rawGameType)

    }

    @Subscribe
    fun worldLoad(event: WorldEvent.Unload) {
        inDungeon = false
        inGarden = false
        inSkyBlock = false
    }

}
//Hub
//Dungeon Hub
//Garden
//The Farming Islands
//Dwarven Mines
//Crystal Hollows
//The End
//Spider\u0027s Den