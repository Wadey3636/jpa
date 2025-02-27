package me.jpaMain.dungeonfeatures


import com.github.Wadey.config.JpaConfig.*
import me.jpaMain.events.SecondEvent
import me.jpaMain.utils.renderHelper.renderTitle
import org.polyfrost.oneconfig.api.event.v1.EventManager
import org.polyfrost.oneconfig.api.event.v1.events.ChatEvent
import org.polyfrost.oneconfig.api.event.v1.invoke.impl.Subscribe


class milestoneReminder {
    private var timeStamp = System.currentTimeMillis()
    private var renderReminder = false

    init {
        EventManager.INSTANCE.register(this)

    }

    @Subscribe
    fun checker(event: ChatEvent.Receive) {
        if (event.fullyUnformattedMessage == "[NPC] Mort: Here, I found this map when I first entered the dungeon.") {
            //UChat.chat("[JPA] reminder enabled.")
            renderReminder = true
            timeStamp = System.currentTimeMillis()

        }
        if (event.fullyUnformattedMessage.contains("Milestone ❸")) {
            renderReminder = false; //UChat.chat("[JPA] Reminder False")
        }

    }

    @Subscribe
    fun secondEvent(event: SecondEvent) {
        if (renderReminder && (mileStone3ReminderTimer * 1000) > System.currentTimeMillis() - timeStamp) {
            renderTitle(mileStone3ReminderText, mileStone3ReminderScale, mileStone3ReminderColor.rgba, 3000L)
            renderReminder = false
        }
    }
}
