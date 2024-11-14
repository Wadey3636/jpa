package me.jpaMain.events

import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.events.event.ReceivePacketEvent
import cc.polyfrost.oneconfig.events.event.Stage
import cc.polyfrost.oneconfig.events.event.TickEvent
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import net.minecraft.network.play.server.S32PacketConfirmTransaction
import me.jpaMain.utils.isPlayerInRoom
import me.jpaMain.utils.roomInfo

class fireEvents {
    init {
        EventManager.INSTANCE.register(this)
    }

    private var lastTimeQuarter = System.currentTimeMillis()
    private var lastTimeSecond = System.currentTimeMillis()
    private val serverTicked by lazy {ServerTickEvent()}

    @Subscribe
    fun onServerTick(event: ReceivePacketEvent) {
        if (event.packet is S32PacketConfirmTransaction) {EventManager.INSTANCE.post(serverTicked)}
    }

    @Subscribe
    fun onTick(event: TickEvent) {
        if (event.stage != Stage.START) return
        if ( System.currentTimeMillis() - lastTimeQuarter > 250) {
            lastTimeQuarter = System.currentTimeMillis()
            EventManager.INSTANCE.post(QuarterSecondEvent())
        }
        if ( System.currentTimeMillis() - lastTimeSecond > 1000) {
            lastTimeSecond = System.currentTimeMillis()
            EventManager.INSTANCE.post(SecondEvent())
        }




    }


}