package me.jpaMain.events

import org.polyfrost.oneconfig.api.event.v1.events.event.CancellableEvent
import net.minecraft.inventory.ContainerChest
import net.minecraft.inventory.IInventory

class openGuiEvent(val name: String, val gui: ContainerChest, val inventory: IInventory) : CancellableEvent()