package me.jpaMain.utils

import org.polyfrost.oneconfig.api.event.v1.events.EventManager
import org.polyfrost.oneconfig.api.event.v1.events.event.ChatReceiveEvent
import org.polyfrost.oneconfig.api.event.v1.events.event.TickEvent
import org.polyfrost.oneconfig.libs.eventbus.Subscribe
import me.jpaMain.events.dungeonStartEvent
import me.jpaMain.utils.guiUtils.deformat
import me.jpaMain.utils.worldUtils.getSidebarLines

var scoreboard: Array<String> = arrayOf()
var dungeonFloor = ""
var localInDungeon = false
val players: HashSet<dungeonPlayerInfo> = hashSetOf()


class dungeonUtils {
    //[www.hypixel.net,                , Auto-closing in: 1:52,              , [M] Wadey36 [Lv37], [B] BearSleeping_ [Lv11], [A] Skeldonarmy [Lv25], [H] Garduuk [Lv12], [M] GoldCezar [Lv11],        ,   Ironman,   The Catacombs (F2),  10:20pm,  Early Winter 13th, 10/29/24 m141A]


    init {
        EventManager.INSTANCE.register(this)
    }
    //val testvalue = arrayOf("www.hypixel.ne🎂t","            🎉"," Auto-closing in:🎁 1:57","          👹"," ","        ⚽","  ♲ Ironman🍭","  ⏣ The Catac👽ombs (F7),  2:40pm👾","  Early Winter 13🐍th"," 🔮10/29/24 m14👽1A")

    @Subscribe
    fun dungeonInformation(event: ChatReceiveEvent) {
        if (event.fullyUnformattedMessage == "[NPC] Mort: Here, I found this map when I first entered the dungeon.") {
            players.clear()
            val sidebar = getSidebarLines()
            sidebar.forEach { scoreboardLine ->
                Regex("\\[([A-Z])]([0-9a-zA-Z-_]+)").find(scoreboardLine)?.value?.let {
                    players.add(dungeonPlayerInfo(it.removeRange(IntRange(0, 2)), it[1].toString()))
                    return@forEach
                }

                Regex("\\((?<Type>[FM])(?<Floor>\\d)\\)").find(scoreboardLine)?.groupValues?.let {
                    EventManager.INSTANCE.post(dungeonStartEvent("${it[1]}${it[2]}"))
                    return@forEach
                }
            }
        }
    }

    @Subscribe
    fun tickEvent(event: TickEvent) {
    }


}
//7cTheCataccombs7F7
//12