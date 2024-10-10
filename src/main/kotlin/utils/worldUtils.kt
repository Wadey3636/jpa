package me.jpaMain.utils
import net.minecraft.init.Blocks
import net.minecraft.util.BlockPos
import me.jpaMain.jpaMain.mc
import net.minecraft.block.Block

/**
 * Retrieves the block object at the specified positon
 *
 * @param pos The position to query.
 * @return The block as a `Block`.
 */

fun getBlockAt(pos: IntArray): Block {
    val x = pos[0]
    val y = pos[1]
    val z = pos[2]
    val newPos = BlockPos(x, y, z)
    return mc.theWorld?.getBlockState(newPos)?.block ?: Blocks.air
}
fun getBlockAt(pos: BlockPos): Block {
    return mc.theWorld?.getBlockState(pos)?.block ?: Blocks.air
}

/**
 * Checks if a block at a specified position is a specified Block.
 * Returns as a Boolean
 *
 * @param pos: BlockPos
 * @param blocks: Block
 */

fun isBlock(pos: BlockPos, blocks: Block): Boolean {
    return if(blocks == (mc.theWorld?.getBlockState(pos)?.block ?: Blocks.air)) {
        true
    }
    else {
        false
    }


}