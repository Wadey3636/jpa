package me.jpaMain.utils

import net.minecraft.inventory.Container
import net.minecraft.util.BlockPos

data class InventoryInfo(val location: String, val pos: List<BlockPos>?, val page: Container)
