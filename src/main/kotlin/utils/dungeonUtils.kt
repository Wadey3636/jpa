package me.jpaMain.utils
import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.events.event.WorldLoadEvent
import cc.polyfrost.oneconfig.libs.eventbus.EventBus
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import cc.polyfrost.oneconfig.libs.universal.UChat
import me.jpaMain.utils.getSidebarLines


class dungeonUtils {
    //[www.hypixel.ne🎂t,            🎉, Auto-closing in:🎁 1:57,          👹, [M] Wadey36 🏀[Lv37],        ⚽,  ♲ Ironman🍭,  ⏣ The Catac👽ombs (F7),  2:40pm👾,  Early Winter 13🐍th,   🔮, 10/29/24 m14👽1A]
    //[www.hypixel.ne🎂t,                🎉, Auto-closing in:🎁 1:52,              👹, [M] Wadey36 🏀[Lv37], [B] BearSlee⚽ping_ [Lv11], [A] Skeldona🍭rmy [Lv25], [H] Garduuk 🌠[Lv12], [M] GoldCeza👾r [Lv11],        🐍,  ♲ Ironman🔮,  ⏣ The Catac👽ombs (F2),  10:20pm💣,  Early Winter 13🍫th,   🔫]


    init {
        EventManager.INSTANCE.register(this)
    }

    @Subscribe
    fun dungeonInformation(event: WorldLoadEvent) {
        val scoreboard = getSidebarLines().map { line ->
            line.filter { it in 'a'..'z' || it in 'A'..'Z' || it in '0'..'9' || it == '[' || it == ']'}
        }

    }

}

