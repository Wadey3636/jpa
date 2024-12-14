package me.jpaMain.dungeonfeatures.profitTracker

import cc.polyfrost.oneconfig.config.core.OneColor
import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import cc.polyfrost.oneconfig.libs.universal.UChat
import me.jpaMain.events.closeGuiEvent
import me.jpaMain.events.openGuiEvent
import me.jpaMain.jpaMain.mc
import me.jpaMain.utils.guiUtils
import me.jpaMain.utils.renderHelper
import net.minecraftforge.client.event.GuiScreenEvent
import me.jpaMain.utils.universalUtils.abbreviateNumber
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import cc.polyfrost.oneconfig.libs.universal.UResolution
import me.jpaMain.utils.renderHelper.oneColorToInt

class ProfitTracker {
    private val possibleLoot: MutableMap<String, Float> = mutableMapOf()
    private val chests: MutableList<chestLine> = mutableListOf()


    init {
        EventManager.INSTANCE.register(this)
        possibleLoot.clear()
        chests.clear()
    }


    private val red = OneColor(255, 0, 0 , 255)
    private val green = OneColor(0, 255, 0, 255)


    private var scale = 1f
    private var toggleProfitHud = false
    private var posX = (UResolution.scaledWidth / 1.3f)
    private var posY = (UResolution.scaledHeight / 3f)

    @Subscribe
    fun guiChecker(event: openGuiEvent) {
        if (event.name == "Croesus") {
            chests.clear()
            /*
            The Text Renderer scales off of the GUI Scale,
            so to counteract this, the scale of the GUI
            is increased depending on the GUI Scale
             */
            scale = if (mc.gameSettings.guiScale == 0) 1f else (3 / mc.gameSettings.guiScale.toFloat())
            posX = (UResolution.scaledWidth / 1.3f)
            posY = (UResolution.scaledHeight / 3f)
            getValues()


            guiUtils.getGUI(event.inventory).forEach { item ->

                val Chest: String
                var profit: Float = 0f
                UChat.chat(item.name)
                item.lore.forEach{string ->
                    possibleLoot[string]?.let { profit += it }
                    UChat.chat(string)
                    UChat.chat("Necromancer's brooch")
                    UChat.chat(possibleLoot[string].toString())
                }
                UChat.chat(profit)
                when {
                    item.name.contains("Wood") -> Chest = "Wood"
                    item.name.contains("Gold") -> Chest = "Gold"
                    item.name.contains("Diamond") -> Chest = "Diamond"
                    item.name.contains("Emerald") -> Chest = "Emerald"
                    item.name.contains("Obsidian") -> Chest = "Wood"
                    item.name.contains("Bedrock") -> Chest = "Wood"
                    else -> {
                        UChat.chat("[JPA] Unknown Chest Type")
                        Chest = "Unknown"
                    }
                }
                chests.add(chestLine(Chest, profit, determineColor(profit).oneColorToInt))
            }
            toggleProfitHud = true
        }
    }


    @Subscribe
    fun guiClosed(event: closeGuiEvent) {
        toggleProfitHud = false
    }

    private val font = mc.fontRendererObj
    @SubscribeEvent
    fun drawProfit(event: GuiScreenEvent.BackgroundDrawnEvent) {
        if (toggleProfitHud) {
            renderHelper.drawLeftAlignedText("Profit:", scale, renderHelper.argbToInt(255, 255, 255, 255), posX, posY)
            drawLines(chests)
        }
    }


    private fun drawLine(chest: String, profit: Float, color: Int, line: Int) {
        renderHelper.drawLeftAlignedText("$chest: ${abbreviateNumber(profit)}", scale, color, posX, (posY + (1.5f * font.FONT_HEIGHT * line * scale)))
    }
    private fun drawLines(lines: List<chestLine>){
        lines.forEachIndexed{ index, line ->
            drawLine(line.chest, line.profit, line.color, index + 1)
        }
    }



    private fun determineColor(chestProfit: Float): OneColor{
        return if (chestProfit >= 0f) green else red
    }


    //I hate this
    private fun getValues(){
        possibleLoot["Necromancer's brooch"] = 50000f
        possibleLoot["Enchanted Book (rejuvenate)"] = 10f
        possibleLoot["Enchanted Book (Infinite Quiver VI)"] = 0f
    }



}
data class chestLine(val chest: String, val profit: Float, val color: Int)