package me.jpaMain.dungeonfeatures;
import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.events.event.Stage
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import cc.polyfrost.oneconfig.libs.universal.UChat
import cc.polyfrost.oneconfig.events.event.TickEvent
import me.jpaMain.utils.getBlockAt



//Each 1x1 unit is 30 by 30

class mapChecker() {
/*
    init {
        EventManager.INSTANCE.register(this)
    }
 */
    @Subscribe
    fun mapChecker(event: TickEvent) {
        if(event.stage == Stage.START) {
            // do something at the start of the tick
            //y = 73
            //val x = -41
            //sets checker starting position

            var z = -57
            var i = 0
            while(i != 5) {
                val block = getBlockAt(intArrayOf(-41, 73, z))
                //UChat.chat(block)
                z += 32
                i++
            }



        }
    }
}
