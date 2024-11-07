package me.jpaMain.events

import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.events.event.ReceivePacketEvent
import cc.polyfrost.oneconfig.events.event.Stage
import cc.polyfrost.oneconfig.events.event.TickEvent
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import cc.polyfrost.oneconfig.libs.universal.UChat
import net.minecraft.network.play.server.S32PacketConfirmTransaction
import me.jpaMain.utils.isPlayerInRoom
import me.jpaMain.utils.roomInfo

class fireEvents {
    init {
        EventManager.INSTANCE.register(this)
    }
    private var lastRoom:roomInfo? = null

    private val serverTicked by lazy {ServerTickEvent()}

    @Subscribe
    fun onServerTick(event: ReceivePacketEvent) {
        if (event.packet is S32PacketConfirmTransaction) {EventManager.INSTANCE.post(serverTicked)}
    }

    @Subscribe
    fun triggerRoomEvents(event: TickEvent) {
        if (event.stage != Stage.START) return

        val currentRoom = isPlayerInRoom()
        if (currentRoom == lastRoom) return // Exit early if still in the same room

        // Room exit logic
        if (currentRoom == null && lastRoom != null) {
            EventManager.INSTANCE.post(ExitRoomEvent())
            lastRoom = null
            return
        }

        // Room entry logic
        if (currentRoom != null) {
            EventManager.INSTANCE.post(EnterRoomEvent(currentRoom))
            lastRoom = currentRoom
        }
    }


}