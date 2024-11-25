package me.jpaMain.playerRenderer

import net.minecraft.client.entity.AbstractClientPlayer
import com.github.Wadey.config.jpaConfig.playerEntries
import net.minecraft.client.renderer.GlStateManager.scale
import net.minecraft.client.renderer.GlStateManager.translate
object playerRenderer {
    fun preRenderCallbackScaleHook(entityLivingBaseIn: AbstractClientPlayer) {
        val entry = playerEntries.firstOrNull{it.name == entityLivingBaseIn.name} ?: return
        scale(entry.entryX, entry.entryY, entry.entryZ)
        if (entry.entryY < 0) translate(0f, entry.entryY * -2, 0f)
    }
}