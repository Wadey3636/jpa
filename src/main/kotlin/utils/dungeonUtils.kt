package me.jpaMain.utils
import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.events.event.LocrawEvent
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe


var scoreboard: Array<String> = arrayOf()
var dungeonFloor = ""
var localInDungeon = false


class dungeonUtils {
    //[www.hypixel.net,            , Auto-closing in: 1:57,          , [M] Wadey36 [Lv37],        ,  Ironman,  The Catacombs (F7),  2:40pm,  Early Winter 13th,   , 10/29/24 m141A]
    //[www.hypixel.net,                , Auto-closing in: 1:52,              , [M] Wadey36 [Lv37], [B] BearSleeping_ [Lv11], [A] Skeldonarmy [Lv25], [H] Garduuk [Lv12], [M] GoldCezar [Lv11],        ,   Ironman,   The Catacombs (F2),  10:20pm,  Early Winter 13th, 10/29/24 m141A]

    init {
        EventManager.INSTANCE.register(this)
    }
    //val testvalue = arrayOf("www.hypixel.ne🎂t","            🎉"," Auto-closing in:🎁 1:57","          👹"," [M] Wadey36 🏀[Lv37]","        ⚽","  ♲ Ironman🍭","  ⏣ The Catac👽ombs (F7),  2:40pm👾","  Early Winter 13🐍th"," 🔮10/29/24 m14👽1A")

    @Subscribe
    fun dungeonInformation(event: LocrawEvent) {
        localInDungeon = false
        dungeonFloor = ""
        scoreboard = getSidebarLines().map { line ->
            line.filter { it in 'a'..'z' || it in 'A'..'Z' || it in '0'..'9' || it == '[' || it == ']'}
        }.toTypedArray()
        if (scoreboard.size < 6) {return}

        scoreboard.forEach({
            when (it) {
                "TheCatacombsF1" -> {
                    dungeonFloor = "F1"
                    localInDungeon = true
                }

                "TheCatacombsF2" -> {
                    dungeonFloor = "F2"
                    localInDungeon = true
                }

                "TheCatacombsF3" -> {
                    dungeonFloor = "F3"
                    localInDungeon = true
                }

                "TheCatacombsF4" -> {
                    dungeonFloor = "F4"
                    localInDungeon = true
                }

                "TheCatacombsF5" -> {
                    dungeonFloor = "F5"
                    localInDungeon = true
                }

                "TheCatacombsF6" -> {
                    dungeonFloor = "F6"
                    localInDungeon = true
                }

                "TheCatacombsF7" -> {
                    dungeonFloor = "F7"
                    localInDungeon = true
                }
                "TheCatacombsM1" -> {
                    dungeonFloor = "M1"
                    localInDungeon = true
                }

                "TheCatacombsM2" -> {
                    dungeonFloor = "M2"
                    localInDungeon = true
                }

                "TheCatacombsM3" -> {
                    dungeonFloor = "M3"
                    localInDungeon = true
                }

                "TheCatacombsM4" -> {
                    dungeonFloor = "M4"
                    localInDungeon = true
                }

                "TheCatacombsM5" -> {
                    dungeonFloor = "M5"
                    localInDungeon = true
                }

                "TheCatacombsM6" -> {
                    dungeonFloor = "M6"
                    localInDungeon = true
                }

                "TheCatacombsM7" -> {
                    dungeonFloor = "M7"
                    localInDungeon = true
                }
            }


        })
        //UChat.chat(scoreboard[scoreboard.size - 5])
        //UChat.chat(dungeonFloor)

    }

}
//7cTheCataccombs7F7
//12