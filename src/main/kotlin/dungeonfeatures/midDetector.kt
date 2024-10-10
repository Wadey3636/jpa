package me.jpaMain.dungeonfeatures

import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.events.event.Stage
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import cc.polyfrost.oneconfig.events.event.TickEvent
import me.jpaMain.jpaMain.mc
import net.minecraft.init.Blocks
import net.minecraft.util.BlockPos
import me.jpaMain.utils.isBlock
import net.minecraft.block.Block
import net.minecraft.client.Minecraft
import org.polyfrost.example.config.jpaConfig.*
import java.util.concurrent.atomic.AtomicBoolean


class midDetector {
    init {
        EventManager.INSTANCE.register(this)
    }
    @Subscribe
    fun midDetector(event: TickEvent) {
        if(event.stage == Stage.START) {



            mc.theWorld.playerEntities.forEach({

            })



        }
    }




}
