package me.jpaMain.dungeonfeatures
import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.events.event.ChatReceiveEvent
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import me.jpaMain.utils.renderHelper.renderTitle
import com.github.Wadey.config.jpaConfig.*
import me.jpaMain.events.SecondEvent
import me.jpaMain.utils.renderHelper.oneColorToInt

class milestoneReminder {
    private var timeStamp = System.currentTimeMillis()
    private var renderReminder = false
    init {
        EventManager.INSTANCE.register(this)
    }
    @Subscribe
    fun checker(event: ChatReceiveEvent) {
        if (event.message.unformattedText == "[NPC] Mort: Here, I found this map when I first entered the dungeon.") {
            renderReminder = true
            timeStamp = System.currentTimeMillis()

        }
        if (event.message.unformattedText.contains("Milestone ❸")) {renderReminder = false}

    }
    @Subscribe
    fun secondEvent(event: SecondEvent) {
        if (renderReminder && (mileStone3ReminderTimer * 100) > System.currentTimeMillis() - timeStamp) {
            renderTitle(mileStone3ReminderText, mileStone3ReminderScale, oneColorToInt(mileStone3ReminderColor), 3000L)
            renderReminder = false
        }
    }
}
