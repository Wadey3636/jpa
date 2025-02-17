package me.jpaMain.gardenFeatures

import com.github.Wadey.config.JpaConfig.pestKeyToggle
import me.jpaMain.jpaMain.mc
import me.jpaMain.utils.inGarden
import me.jpaMain.utils.worldUtils.isBlock
import net.minecraft.init.Blocks
import net.minecraft.util.BlockPos


fun pestFarmingKeybind() {
    if (!inGarden || !pestKeyToggle) return

    if (
        isBlock(BlockPos(mc.thePlayer.position.x, mc.thePlayer.position.y, mc.thePlayer.position.z), Blocks.reeds) ||
        isBlock(
            BlockPos(mc.thePlayer.position.x - 1, mc.thePlayer.position.y, mc.thePlayer.position.z),
            Blocks.reeds
        ) ||
        isBlock(
            BlockPos(mc.thePlayer.position.x, mc.thePlayer.position.y, mc.thePlayer.position.z - 1),
            Blocks.reeds
        ) ||
        isBlock(
            BlockPos(mc.thePlayer.position.x - 1, mc.thePlayer.position.y, mc.thePlayer.position.z - 1),
            Blocks.reeds
        )
    ) {
        mc.thePlayer?.sendChatMessage("/setspawn")
    } else {
        mc.thePlayer?.sendChatMessage("/warp garden")
    }


}



