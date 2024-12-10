package me.jpaMain.dungeonfeatures.profitTracker
import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import cc.polyfrost.oneconfig.libs.universal.UChat
import me.jpaMain.events.openGuiEvent
import me.jpaMain.jpaMain.mc

class profitTracker {
    init {
        EventManager.INSTANCE.register(this)
    }

    //it will register the run based on the date

/*
    @Subscribe
    fun guiChecker(event: openGuiEvent) {
        if (event.name != "Croesus") return

    }
*/
    //give @p minecraft:skull 1 0 {Base:{Type:"",Rarity:"UNCOMMON",RarityColor:'{"text":"","color":"green"}'},HideFlags:63,Unbreakable:1b,Description:['[{"text":"gas","color":"gray","italic":false}]','[{"text":""}]'],display:{Name:"The Catacombs",Lore:['gas','','UNCOMMON']}}

}