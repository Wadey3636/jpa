package me.jpaMain.utils

import cc.polyfrost.oneconfig.libs.universal.UChat
import me.jpaMain.events.openGuiEvent
import me.jpaMain.jpaMain.mc
import net.minecraft.inventory.IInventory

object guiUtils {

    fun getGUI(inventory: IInventory): HashSet<item> {
        val items = HashSet<item>()
        for (i in 0 until inventory.sizeInventory) {

            val itemStack = inventory.getStackInSlot(i)?.displayName?.let { stack ->

                if (!stack.contains("Glass")) {
                    items.add(item(stack, inventory.getStackInSlot(i).getTooltip(mc.thePlayer, false).mapNotNull { it.split('"').getOrNull(3)}, i))
                }

            }
        }
        return items
    }


    fun guiChecker(event: openGuiEvent) {
        if (event.name != "Croesus") return

    }

}

data class item(val name: String, val lore: List<String>, val position: Int)