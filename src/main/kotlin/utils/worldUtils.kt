package me.jpaMain.utils

import com.google.common.collect.Iterables
import com.google.common.collect.Lists
import me.jpaMain.jpaMain.mc
import me.jpaMain.utils.guiUtils.deformat
import net.minecraft.block.Block
import net.minecraft.init.Blocks
import net.minecraft.scoreboard.Score
import net.minecraft.scoreboard.ScorePlayerTeam
import net.minecraft.util.BlockPos
import java.util.stream.Collectors

/**
 * Retrieves the block object at the specified positon
 *
 * @param pos The position to query.
 * @return The block as a `Block`.
 */
object worldUtils {
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
        return blocks.toString() == (mc.theWorld?.getBlockState(pos)?.block ?: Blocks.air).toString()
    }


    /**
     * Checks if a given position is within the bounds defined by min and max BlockPos.
     */
    fun isWithinBounds(pos: BlockPos, min: BlockPos, max: BlockPos): Boolean {
        return pos.x in min.x..max.x && pos.y in min.y..max.y && pos.z in min.z..max.z
    }

//Thank you to Wyan because I just yoinked this code from him when he sent me how he got the scoreboard

    fun getSidebarLines(): List<String> {
        val lines: MutableList<String> = ArrayList()
        if (mc.theWorld == null) return lines
        val scoreboard = mc.theWorld.scoreboard ?: return lines

        val objective = scoreboard.getObjectiveInDisplaySlot(1) ?: return lines

        var scores = scoreboard.getSortedScores(objective)
        val list = scores.stream()
            .filter { input: Score? -> input != null && input.playerName != null && !input.playerName.startsWith("#") }
            .collect(
                Collectors.toList()
            )

        scores = if (list.size > 15) {
            Lists.newArrayList(Iterables.skip(list, scores.size - 15))
        } else {
            list
        }
        for (score in scores) {
            val team = scoreboard.getPlayersTeam(score.playerName)
            lines.add(ScorePlayerTeam.formatPlayerName(team, score.playerName).deformat)
        }

        return lines
    }
}