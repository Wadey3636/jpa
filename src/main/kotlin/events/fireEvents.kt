// Function copied from [https://github.com/odtheking/Odin/blob/44062aed8e0307333e45efbde24b9e384e3476ec/src/main/kotlin/me/odinmain/events/EventDispatcher.kt#L21]
// Copyright (c) 2024, odtheking
//
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are met:
//
// 1. Redistributions of source code must retain the above copyright notice, this
//    list of conditions and the following disclaimer.
//
// 2. Redistributions in binary form must reproduce the above copyright notice,
//    this list of conditions and the following disclaimer in the documentation
//    and/or other materials provided with the distribution.
//
// 3. Neither the name of the copyright holder nor the names of its
//    contributors may be used to endorse or promote products derived from
//    this software without specific prior written permission.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
// AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
// IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
// DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
// FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
// DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
// SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
// CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
// OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
// OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.


package me.jpaMain.events

import org.polyfrost.oneconfig.api.event.v1.events.EventManager
import org.polyfrost.oneconfig.api.event.v1.events.event.ReceivePacketEvent
import org.polyfrost.oneconfig.api.event.v1.events.event.Stage
import org.polyfrost.oneconfig.api.event.v1.events.event.TickEvent
import org.polyfrost.oneconfig.libs.eventbus.Subscribe
import org.polyfrost.oneconfig.libs.universal.UChat
import org.polyfrost.oneconfig.utils.dsl.openScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import me.jpaMain.utils.waitUntilLastItem
import net.minecraft.client.gui.GuiScreen
import net.minecraft.client.gui.inventory.GuiChest
import net.minecraft.inventory.ContainerChest
import net.minecraft.network.play.server.S32PacketConfirmTransaction
import net.minecraftforge.client.event.GuiOpenEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import kotlin.coroutines.EmptyCoroutineContext

class fireEvents {
    init {
        EventManager.INSTANCE.register(this)
    }

    /*
    dungeonStartEvent is posted in dungeonUtils

     */


    private var lastConfigOpen: Boolean = false
    private var lastGui: GuiScreen? = null
    private var lastTimeQuarter = System.currentTimeMillis()
    private var lastTimeSecond = System.currentTimeMillis()
    private val serverTicked by lazy { ServerTickEvent() }

    @Subscribe
    fun onServerTick(event: ReceivePacketEvent) {
        if (event.packet is S32PacketConfirmTransaction) {
            EventManager.INSTANCE.post(serverTicked)
        }
    }

    @Subscribe
    fun onTick(event: TickEvent) {
        if (event.stage != Stage.START) return
        if (System.currentTimeMillis() - lastTimeQuarter > 250) {
            lastTimeQuarter = System.currentTimeMillis()
            EventManager.INSTANCE.post(QuarterSecondEvent())
        }
        if (System.currentTimeMillis() - lastTimeSecond > 1000) {
            lastTimeSecond = System.currentTimeMillis()
            EventManager.INSTANCE.post(SecondEvent())
        }


    }

    /**
     * Adapted from odin
     * @author odtheking
     */

    @SubscribeEvent
    fun onGUI(event: GuiOpenEvent) = CoroutineScope(EmptyCoroutineContext).launch {
        if (event.gui !is GuiChest) return@launch
        val container = (event.gui as GuiChest).inventorySlots
        if (container !is ContainerChest) return@launch
        val deferred = waitUntilLastItem(container)
        try {
            deferred.await()
        } catch (_: Exception) {
            return@launch
        } // Wait until the last item in the chest isn't null
        EventManager.INSTANCE.post(
            openGuiEvent(
                container.lowerChestInventory.displayName.unformattedText,
                container,
                container.lowerChestInventory
            )
        )
    }

    @SubscribeEvent
    fun closeGUI(event: GuiOpenEvent) {
        if (event.gui != lastGui) EventManager.INSTANCE.post(changeGuiEvent())
        if (event.gui == null) EventManager.INSTANCE.post(closeGuiEvent())
        if (event.gui == null && lastConfigOpen) EventManager.INSTANCE.post(closeConfigEvent())
        lastGui = event.gui
        lastConfigOpen = org.polyfrost.oneconfig.gui.OneConfigGui.isOpen()
    }


}