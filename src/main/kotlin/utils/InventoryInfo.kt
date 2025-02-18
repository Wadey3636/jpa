package me.jpaMain.utils

import net.minecraft.inventory.IInventory
import net.minecraft.util.BlockPos

data class InventoryInfo(val location: String, val pos: List<BlockPos>?, val page: IInventory)
