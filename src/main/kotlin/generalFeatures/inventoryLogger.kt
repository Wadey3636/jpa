package me.jpaMain.generalFeatures

import com.github.Wadey.config.JpaConfig
import net.minecraftforge.client.event.GuiOpenEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import org.polyfrost.oneconfig.api.event.v1.EventManager
import net.minecraftforge.event.entity.player.PlayerInteractEvent
import me.jpaMain.utils.worldUtils
import net.minecraft.client.gui.inventory.GuiChest
import net.minecraft.util.BlockPos
import com.github.Wadey.config.JpaConfig.chestEntries
import me.jpaMain.utils.InventoryInfo
import org.polyfrost.oneconfig.api.hypixel.v1.HypixelUtils
import org.polyfrost.universal.UChat


class inventoryLogger {

    var lastClickedChest: List<BlockPos> = listOf()
    init {
        EventManager.INSTANCE.register(this)
    }
    private fun entryExists(location: String, pos: List<BlockPos>): Int? {
        var i = 0
        while (i < chestEntries.size) {
            val entry = chestEntries[i]
            if (entry.location == location && entry.pos == pos) return i
            i++
        }
        return null
    }

    @SubscribeEvent
    fun openGui(event: GuiOpenEvent){
        val location = HypixelUtils.getLocation()?.mapName?.get() ?: return
        if (lastClickedChest.isNotEmpty() && event.gui is GuiChest) {
            val index = entryExists(location, lastClickedChest)
            val container = (event.gui as GuiChest).inventorySlots
            if (index != null) {
                chestEntries[index] = InventoryInfo(location, lastClickedChest, container)
            }
            else chestEntries.add(InventoryInfo(location, lastClickedChest, container))
        }
        UChat.chat(chestEntries.size)
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