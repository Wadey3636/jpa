
package me.jpaMain.dungeonfeatures
import cc.polyfrost.oneconfig.config.core.OneColor
import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.events.event.ChatReceiveEvent
import cc.polyfrost.oneconfig.events.event.HudRenderEvent
import cc.polyfrost.oneconfig.events.event.ReceivePacketEvent
import cc.polyfrost.oneconfig.events.event.TickEvent
import cc.polyfrost.oneconfig.events.event.WorldLoadEvent
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import cc.polyfrost.oneconfig.libs.universal.UChat
import cc.polyfrost.oneconfig.renderer.NanoVGHelper
import cc.polyfrost.oneconfig.renderer.font.Fonts
import com.github.Wadey.config.jpaConfig.*
import net.minecraft.network.play.server.S32PacketConfirmTransaction

var stormActivated = false
var padticks = 20f
var padcolor = OneColor((255 - padticks* 12.75).toInt() , (0 + padticks * 12.75).toInt(), 0, 255)

class padTimer {
    init {
        EventManager.INSTANCE.register(this)
    }




    @Subscribe
    fun reset(event: WorldLoadEvent) {
        stormActivated = false
    }
    @Subscribe
    fun stormPhaseStart(event: ChatReceiveEvent){
        if (event.message.formattedText == "[BOSS] Storm: Pathetic Maxor, just like expected.") {
            padticks = 20f
            stormActivated = true
        }
        else if (event.message.formattedText == "[BOSS] Storm: I should have known that I stood no chance.") {
            stormActivated = false
        }
    }
    @Subscribe
    fun tickTimer(event:ReceivePacketEvent) {
        if (stormActivated && event.packet is S32PacketConfirmTransaction) {
            if (padticks > 1) {--padticks}
            else {padticks = 20f}
            padcolor = OneColor((255 - padticks* 12.75).toInt() , (0 + padticks * 12.75).toInt(), 0, 255)
        }
    }


}