package me.jpaMain.utils

import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.events.event.LocrawEvent
import cc.polyfrost.oneconfig.events.event.WorldLoadEvent
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe


var inSkyBlock = false
var inDungeon = false
var inGarden = false

class locationUtils {



    init {
        EventManager.INSTANCE.register(this)

    }

    @Subscribe
    fun locationChecker(event: LocrawEvent) {
        inDungeon = event.info.mapName == "Dungeon"
        inGarden = event.info.mapName == "Garden"
        inSkyBlock = event.info.gameMode == "SKYBLOCK"
        //UChat.chat(event.info.gameMode)
        //UChat.chat(event.info.gameType)
        //UChat.chat(event.info.serverId)
        //UChat.chat(event.info.rawGameType)

    }

    @Subscribe
    fun worldLoad(event: WorldLoadEvent) {
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