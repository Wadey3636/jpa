package me.jpaMain.utils

import net.minecraft.util.BlockPos

data class variantInfo(
    val detectionPoints: HashSet<BlockPos>,
    val name: String,
    val plotPoints: List<BlockPos>,
    val warpPoints: List<BlockPos>,
    val tpPoint: BlockPos?
)

data class determinedVariant(
    val name: String,
    val plotPoints: List<BlockPos>,
    val warpPoints: List<BlockPos>,
    val tpPoint: BlockPos?
)

