package me.jpaMain.events

import cc.polyfrost.oneconfig.events.EventManager
import me.jpaMain.events.ServerTickEvent
import cc.polyfrost.oneconfig.events.event.ReceivePacketEvent
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import javafx.event.Event
import net.minecraft.network.play.server.S32PacketConfirmTransaction
import net.minecraftforge.common.MinecraftForge


class fireEvents {
    init {
        EventManager.INSTANCE.register(this)
    }

    val serverticked = ServerTickEvent()
    @Subscribe
    fun onServerTick(event: ReceivePacketEvent) {
        if (event.packet is S32PacketConfirmTransaction) {EventManager.INSTANCE.post(serverticked)}
    }

}