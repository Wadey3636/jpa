package me.jpaMain.utils
import cc.polyfrost.oneconfig.config.core.OneColor
import net.minecraft.client.renderer.GlStateManager
import net.minecraft.client.renderer.Tessellator
import net.minecraft.client.renderer.vertex.DefaultVertexFormats
import org.lwjgl.opengl.GL11
import me.jpaMain.jpaMain.mc
import net.minecraft.block.Block
import net.minecraft.client.gui.Gui
import net.minecraft.client.renderer.RenderGlobal
import net.minecraft.client.renderer.RenderHelper
import net.minecraft.entity.Entity
import net.minecraft.inventory.Slot
import net.minecraft.item.ItemStack
import net.minecraft.util.*
import java.awt.Color
import java.util.concurrent.locks.ReentrantLock
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin
import kotlin.math.sqrt

object renderHelper {
    private val beaconBeam = ResourceLocation("textures/entity/beacon_beam.png")

    fun drawLine3d(
        x: Double,
        y: Double,
        z: Double,
        x1: Double,
        y1: Double,
        z1: Double,
        color: OneColor,
        thickness: Float,
        phase: Boolean
    ) {

        GL11.glBlendFunc(770, 771)
        GL11.glEnable(GL11.GL_BLEND)
        GL11.glLineWidth(thickness)
        GL11.glDisable(GL11.GL_TEXTURE_2D)
        if (phase) GlStateManager.enableDepth() // enableDepth
        GL11.glDepthMask(false)
        GlStateManager.pushMatrix() // pushMatrix()

        Tessellator.getInstance().worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR)
        Tessellator.getInstance().worldRenderer.pos(x, y, z).color(color.red, color.green, color.blue, color.alpha)
        Tessellator.getInstance().worldRenderer.pos(x1, y1, z1).color(color.red, color.green, color.blue, color.alpha)

        Tessellator.getInstance().draw()

        GlStateManager.popMatrix() // popMatrix()
        if (phase) GlStateManager.disableDepth() // disableDepth
        GL11.glEnable(GL11.GL_TEXTURE_2D)
        GL11.glDepthMask(true)
        GL11.glDisable(GL11.GL_BLEND)
    }


    /**
     * Taken from NotEnoughUpdates under Creative Commons Attribution-NonCommercial 3.0
     * https://github.com/Moulberry/NotEnoughUpdates/blob/master/LICENSE
     * @author Moulberry
     * @author Mojang
     */

    fun renderBeaconBeam(x: Double, y: Double, z: Double, rgb: Int, alphaMultiplier: Float, partialTicks: Float) {
        val height = 300
        val bottomOffset = 0
        val topOffset = bottomOffset + height
        val tessellator = Tessellator.getInstance()
        val worldrenderer = tessellator.worldRenderer
        mc.textureManager.bindTexture(beaconBeam)
        GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, 10497.0f)
        GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, 10497.0f)
        GlStateManager.disableLighting()
        GlStateManager.enableCull()
        GlStateManager.enableTexture2D()
        GlStateManager.tryBlendFuncSeparate(770, 1, 1, 0)
        GlStateManager.enableBlend()
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0)
        val time = mc.theWorld.totalWorldTime + partialTicks.toDouble()
        val d1 = MathHelper.func_181162_h(
            -time * 0.2 - MathHelper.floor_double(-time * 0.1)
                .toDouble()
        )
        val r = (rgb shr 16 and 0xFF) / 255f
        val g = (rgb shr 8 and 0xFF) / 255f
        val b = (rgb and 0xFF) / 255f
        val d2 = time * 0.025 * -1.5
        val d4 = 0.5 + cos(d2 + 2.356194490192345) * 0.2
        val d5 = 0.5 + sin(d2 + 2.356194490192345) * 0.2
        val d6 = 0.5 + cos(d2 + Math.PI / 4.0) * 0.2
        val d7 = 0.5 + sin(d2 + Math.PI / 4.0) * 0.2
        val d8 = 0.5 + cos(d2 + 3.9269908169872414) * 0.2
        val d9 = 0.5 + sin(d2 + 3.9269908169872414) * 0.2
        val d10 = 0.5 + cos(d2 + 5.497787143782138) * 0.2
        val d11 = 0.5 + sin(d2 + 5.497787143782138) * 0.2
        val d14 = -1.0 + d1
        val d15 = height.toDouble() * 2.5 + d14
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR)
        worldrenderer.pos(x + d4, y + topOffset, z + d5).tex(1.0, d15).color(r, g, b, 1.0f * alphaMultiplier)
            .endVertex()
        worldrenderer.pos(x + d4, y + bottomOffset, z + d5).tex(1.0, d14).color(r, g, b, 1.0f).endVertex()
        worldrenderer.pos(x + d6, y + bottomOffset, z + d7).tex(0.0, d14).color(r, g, b, 1.0f).endVertex()
        worldrenderer.pos(x + d6, y + topOffset, z + d7).tex(0.0, d15).color(r, g, b, 1.0f * alphaMultiplier)
            .endVertex()
        worldrenderer.pos(x + d10, y + topOffset, z + d11).tex(1.0, d15).color(r, g, b, 1.0f * alphaMultiplier)
            .endVertex()
        worldrenderer.pos(x + d10, y + bottomOffset, z + d11).tex(1.0, d14).color(r, g, b, 1.0f).endVertex()
        worldrenderer.pos(x + d8, y + bottomOffset, z + d9).tex(0.0, d14).color(r, g, b, 1.0f).endVertex()
        worldrenderer.pos(x + d8, y + topOffset, z + d9).tex(0.0, d15).color(r, g, b, 1.0f * alphaMultiplier)
            .endVertex()
        worldrenderer.pos(x + d6, y + topOffset, z + d7).tex(1.0, d15).color(r, g, b, 1.0f * alphaMultiplier)
            .endVertex()
        worldrenderer.pos(x + d6, y + bottomOffset, z + d7).tex(1.0, d14).color(r, g, b, 1.0f).endVertex()
        worldrenderer.pos(x + d10, y + bottomOffset, z + d11).tex(0.0, d14).color(r, g, b, 1.0f).endVertex()
        worldrenderer.pos(x + d10, y + topOffset, z + d11).tex(0.0, d15).color(r, g, b, 1.0f * alphaMultiplier)
            .endVertex()
        worldrenderer.pos(x + d8, y + topOffset, z + d9).tex(1.0, d15).color(r, g, b, 1.0f * alphaMultiplier)
            .endVertex()
        worldrenderer.pos(x + d8, y + bottomOffset, z + d9).tex(1.0, d14).color(r, g, b, 1.0f).endVertex()
        worldrenderer.pos(x + d4, y + bottomOffset, z + d5).tex(0.0, d14).color(r, g, b, 1.0f).endVertex()
        worldrenderer.pos(x + d4, y + topOffset, z + d5).tex(0.0, d15).color(r, g, b, 1.0f * alphaMultiplier)
            .endVertex()
        tessellator.draw()
        GlStateManager.disableCull()
        val d12 = -1.0 + d1
        val d13 = height + d12
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR)
        worldrenderer.pos(x + 0.2, y + topOffset, z + 0.2).tex(1.0, d13).color(r, g, b, 0.25f * alphaMultiplier)
            .endVertex()
        worldrenderer.pos(x + 0.2, y + bottomOffset, z + 0.2).tex(1.0, d12).color(r, g, b, 0.25f).endVertex()
        worldrenderer.pos(x + 0.8, y + bottomOffset, z + 0.2).tex(0.0, d12).color(r, g, b, 0.25f).endVertex()
        worldrenderer.pos(x + 0.8, y + topOffset, z + 0.2).tex(0.0, d13).color(r, g, b, 0.25f * alphaMultiplier)
            .endVertex()
        worldrenderer.pos(x + 0.8, y + topOffset, z + 0.8).tex(1.0, d13).color(r, g, b, 0.25f * alphaMultiplier)
            .endVertex()
        worldrenderer.pos(x + 0.8, y + bottomOffset, z + 0.8).tex(1.0, d12).color(r, g, b, 0.25f).endVertex()
        worldrenderer.pos(x + 0.2, y + bottomOffset, z + 0.8).tex(0.0, d12).color(r, g, b, 0.25f).endVertex()
        worldrenderer.pos(x + 0.2, y + topOffset, z + 0.8).tex(0.0, d13).color(r, g, b, 0.25f * alphaMultiplier)
            .endVertex()
        worldrenderer.pos(x + 0.8, y + topOffset, z + 0.2).tex(1.0, d13).color(r, g, b, 0.25f * alphaMultiplier)
            .endVertex()
        worldrenderer.pos(x + 0.8, y + bottomOffset, z + 0.2).tex(1.0, d12).color(r, g, b, 0.25f).endVertex()
        worldrenderer.pos(x + 0.8, y + bottomOffset, z + 0.8).tex(0.0, d12).color(r, g, b, 0.25f).endVertex()
        worldrenderer.pos(x + 0.8, y + topOffset, z + 0.8).tex(0.0, d13).color(r, g, b, 0.25f * alphaMultiplier)
            .endVertex()
        worldrenderer.pos(x + 0.2, y + topOffset, z + 0.8).tex(1.0, d13).color(r, g, b, 0.25f * alphaMultiplier)
            .endVertex()
        worldrenderer.pos(x + 0.2, y + bottomOffset, z + 0.8).tex(1.0, d12).color(r, g, b, 0.25f).endVertex()
        worldrenderer.pos(x + 0.2, y + bottomOffset, z + 0.2).tex(0.0, d12).color(r, g, b, 0.25f).endVertex()
        worldrenderer.pos(x + 0.2, y + topOffset, z + 0.2).tex(0.0, d13).color(r, g, b, 0.25f * alphaMultiplier)
            .endVertex()
        tessellator.draw()
    }

    /**
     * @author Mojang
     */
    @JvmStatic
    fun drawOutlinedBoundingBox(aabb: AxisAlignedBB?, color: Color, width: Float, partialTicks: Float) {
        val render = mc.renderViewEntity
        val realX = interpolate(render.posX, render.lastTickPosX, partialTicks)
        val realY = interpolate(render.posY, render.lastTickPosY, partialTicks)
        val realZ = interpolate(render.posZ, render.lastTickPosZ, partialTicks)
        GlStateManager.pushMatrix()
        GlStateManager.translate(-realX, -realY, -realZ)
        GlStateManager.disableTexture2D()
        GlStateManager.enableBlend()
        GlStateManager.disableLighting()
        GlStateManager.disableAlpha()
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0)
        GL11.glLineWidth(width)
        RenderGlobal.drawOutlinedBoundingBox(aabb, color.red, color.green, color.blue, color.alpha)
        GlStateManager.translate(realX, realY, realZ)
        GlStateManager.disableBlend()
        GlStateManager.enableAlpha()
        GlStateManager.enableTexture2D()
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f)
        GlStateManager.popMatrix()
    }


    fun interpolate(currentValue: Double, lastValue: Double, multiplier: Float): Double {
        return lastValue + (currentValue - lastValue) * multiplier
    }

    /**
     *
     * @param {Number[][]} points - List of vertices as [[x, y, z], [x, y, z], ...]
     * @param {Number} r
     * @param {Number} g
     * @param {Number} b
     * @param {Number} a
     * @param {Boolean} phase - Show the line through walls
     * @param {Number} lineWidth - The width of the line
     */
    fun drawLineThroughPoints(
        points: List<List<Double>>,
        color: OneColor,
        phase: Boolean,
        lineWidth: Float,
        loop: Boolean
    ) {

        GlStateManager.pushMatrix()

        GL11.glLineWidth(lineWidth)
        GlStateManager.disableCull() // disableCullFace
        GlStateManager.depthMask(false)
        GlStateManager.disableTexture2D()
        GlStateManager.enableBlend()

        if (phase) GlStateManager.disableDepth()

        if (loop) Tessellator.getInstance().worldRenderer.begin(GL11.GL_LINE_LOOP, DefaultVertexFormats.POSITION_COLOR)
        else Tessellator.getInstance().worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR)

        Tessellator.getInstance().worldRenderer.color(color.red, color.green, color.blue, color.alpha)
        var i = 0
        while (i < points.size) {
            Tessellator.getInstance().worldRenderer.pos(points[i][0], points[i][1], points[i][2])
            i++
        }

        Tessellator.getInstance().draw()

        if (phase) GlStateManager.enableDepth()

        GlStateManager.enableCull() // enableCull
        GlStateManager.enableTexture2D()
        GlStateManager.disableBlend()
        GlStateManager.depthMask(true)
        GlStateManager.popMatrix()

    }

    fun drawLineThroughPointsAboveBlock(
        points: List<BlockPos>,
        color: OneColor,
        phase: Boolean,
        lineWidth: Float,
        loop: Boolean
    ) {

        GlStateManager.pushMatrix()

        GL11.glLineWidth(lineWidth)
        GlStateManager.disableCull() // disableCullFace
        GlStateManager.depthMask(false)
        GlStateManager.disableTexture2D()
        GlStateManager.enableBlend()

        if (phase) GlStateManager.disableDepth()

        if (loop) Tessellator.getInstance().worldRenderer.begin(GL11.GL_LINE_LOOP, DefaultVertexFormats.POSITION_COLOR)
        else Tessellator.getInstance().worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR)

        Tessellator.getInstance().worldRenderer.color(color.red, color.green, color.blue, color.alpha)
        var i = 0
        while (i < points.size) {
            Tessellator.getInstance().worldRenderer.pos(points[i].x.toDouble() + 0.5, points[i].y.toDouble() +1.01, points[i].z.toDouble() + 0.5)
            i++
        }

        Tessellator.getInstance().draw()

        if (phase) GlStateManager.enableDepth()

        GlStateManager.enableCull() // enableCull
        GlStateManager.enableTexture2D()
        GlStateManager.disableBlend()
        GlStateManager.depthMask(true)
        GlStateManager.popMatrix()

    }

    fun renderBoxOutlineFromCorners(
        x0: Double,
        y0: Double,
        z0: Double,
        x1: Double,
        y1: Double,
        z1: Double,
        color: OneColor,
        lineWidth: Float,
        phase: Boolean
    ) {
        GlStateManager.pushMatrix()

        GL11.glLineWidth(lineWidth)
        Tessellator.getInstance().worldRenderer.begin(3, DefaultVertexFormats.POSITION_TEX_COLOR)
        GlStateManager.depthMask(false)
        GlStateManager.disableTexture2D()
        GlStateManager.enableBlend()

        if (phase) GlStateManager.disableDepth()
        Tessellator.getInstance().worldRenderer.color(color.red, color.green, color.blue, color.alpha)

        Tessellator.getInstance().worldRenderer.pos(x0, y0, z0).tex(0.0, 0.0)
        Tessellator.getInstance().worldRenderer.pos(x0, y0, z1).tex(0.0, 0.0)
        Tessellator.getInstance().worldRenderer.pos(x0, y1, z1).tex(0.0, 0.0)
        Tessellator.getInstance().worldRenderer.pos(x1, y1, z1).tex(0.0, 0.0)
        Tessellator.getInstance().worldRenderer.pos(x1, y1, z0).tex(0.0, 0.0)
        Tessellator.getInstance().worldRenderer.pos(x0, y1, z0).tex(0.0, 0.0)
        Tessellator.getInstance().worldRenderer.pos(x0, y0, z0).tex(0.0, 0.0)
        Tessellator.getInstance().worldRenderer.pos(x1, y0, z0).tex(0.0, 0.0)
        Tessellator.getInstance().worldRenderer.pos(x1, y0, z1).tex(0.0, 0.0)
        Tessellator.getInstance().worldRenderer.pos(x0, y0, z1).tex(0.0, 0.0)
        Tessellator.getInstance().worldRenderer.pos(x0, y1, z1).tex(0.0, 0.0)
        Tessellator.getInstance().worldRenderer.pos(x0, y1, z0).tex(0.0, 0.0)
        Tessellator.getInstance().worldRenderer.pos(x1, y1, z0).tex(0.0, 0.0)
        Tessellator.getInstance().worldRenderer.pos(x1, y0, z0).tex(0.0, 0.0)
        Tessellator.getInstance().worldRenderer.pos(x1, y0, z1).tex(0.0, 0.0)
        Tessellator.getInstance().worldRenderer.pos(x1, y1, z1).tex(0.0, 0.0)

        Tessellator.getInstance().draw()

        if (phase) GlStateManager.enableDepth()

        GlStateManager.enableTexture2D()
        GlStateManager.disableBlend()
        GlStateManager.depthMask(true)
        GlStateManager.popMatrix()
    }

    fun renderBoxOutline(
        x: Double,
        y: Double,
        z: Double,
        w: Double,
        h: Double,
        color: OneColor,
        lineWidth: Float,
        phase: Boolean
    ) {
        renderBoxOutlineFromCorners(x - w / 2, y, z - w / 2, x + w / 2, y + h, z + w / 2, color, lineWidth, phase)
    }
}