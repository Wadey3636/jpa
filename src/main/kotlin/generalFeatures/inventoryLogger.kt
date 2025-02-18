package me.jpaMain.generalFeatures

import me.jpaMain.events.PacketEvent
import net.minecraft.init.Blocks
import net.minecraft.network.play.server.S2DPacketOpenWindow
import net.minecraftforge.client.event.GuiOpenEvent
import net.minecraftforge.event.world.BlockEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.polyfrost.oneconfig.api.event.v1.EventManager
import net.minecraftforge.event.entity.player.PlayerInteractEvent
import org.polyfrost.oneconfig.api.event.v1.invoke.impl.Subscribe
import me.jpaMain.utils.worldUtils
import net.minecraft.client.gui.inventory.GuiChest
import net.minecraft.util.BlockPos
import com.github.Wadey.config.JpaConfig.chestEntries
import org.polyfrost.oneconfig.api.hypixel.v1.HypixelUtils


class inventoryLogger {
    var lastClickedChest: List<BlockPos> = listOf()
    init {
        EventManager.INSTANCE.register(this)
    }
    private fun entryExists(location: String, pos: List<BlockPos>): Int? {
        for (index in chestEntries.size) {
            val entry = chestEntries.get(index)
            if (entry.location == location && entry.pos == pos) return index

        }
        return null
    }

    @SubscribeEvent
    fun openGui(event: GuiOpenEvent){
        val location = HypixelUtils.getLocation().mapName.get()
        if (event.gui is GuiChest) {
            entryExists(location, lastClickedChest)
        }

    }
    @SubscribeEvent
    fun findChest(event: PlayerInteractEvent) {
        if (
            event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK
            && worldUtils.isChest(event.pos)
            ) {
            lastClickedChest = worldUtils.findDoubleChest(event.pos)
        }
    }
}