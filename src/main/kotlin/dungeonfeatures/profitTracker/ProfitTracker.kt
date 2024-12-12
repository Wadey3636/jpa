package me.jpaMain.dungeonfeatures.profitTracker
import cc.polyfrost.oneconfig.config.core.OneColor
import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.events.event.HudRenderEvent
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import cc.polyfrost.oneconfig.libs.universal.UChat
import me.jpaMain.events.closeGuiEvent
import me.jpaMain.events.openGuiEvent
import me.jpaMain.jpaMain.mc
import me.jpaMain.utils.renderHelper
import net.minecraft.client.gui.GuiButton
import net.minecraft.client.gui.GuiControls
import net.minecraft.client.gui.ScaledResolution
import net.minecraftforge.client.event.GuiOpenEvent
import net.minecraftforge.client.event.GuiScreenEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import me.jpaMain.utils.universalUtils.abbreviateNumber

class ProfitTracker {
    init {
        EventManager.INSTANCE.register(this)
    }


    private val red = OneColor(255, 0, 0 , 255)
    private val green = OneColor(0, 255, 0, 255)
    private var woodProfit = 1000
    private var woodColor = OneColor(0,0,0,0)
    private var goldProfit = 10000000
    private var goldColor = OneColor(0,0,0,0)
    private var diamondProfit = 0
    private var diamondColor = OneColor(0,0,0,0)
    private var emeraldProfit = 0
    private var emeraldColor = OneColor(0,0,0,0)
    private var obsidianProfit = 0
    private var obsidianColor = OneColor(0,0,0,0)
    private var bedrockProfit = 0
    private var bedrockColor = OneColor(0,0,0,0)

    private var toggleProfitHud = false
    private var scaledResolution = ScaledResolution(mc)
    private var posX = (scaledResolution.scaledWidth / 1.3f)
    private var posY = (scaledResolution.scaledHeight / 3f)

    @Subscribe
    fun guiChecker(event: openGuiEvent) {
        if (event.name == "Croesus") {
            UChat.chat("Hud Enabled")
            toggleProfitHud = true
            scaledResolution = ScaledResolution(mc)
            posX = (scaledResolution.scaledWidth / 1.3f)
            posY = (scaledResolution.scaledHeight / 3f)
            determineColors()
            abbreviateNumber(goldProfit)

        }
    }
    @Subscribe
    fun guiClosed(event: closeGuiEvent) {
        toggleProfitHud = false
    }

    private val font = mc.fontRendererObj

    //@SubscribeEvent
    fun drawProfit(event: GuiScreenEvent.BackgroundDrawnEvent) {
        if (toggleProfitHud) {

            renderHelper.drawLeftAlignedText("Profit:", 1f, renderHelper.argbToInt(255, 255, 255, 255), posX, posY)
            drawLine("Wood", woodProfit, renderHelper.oneColorToInt(woodColor), 1)
            drawLine("Gold", goldProfit, renderHelper.oneColorToInt(goldColor), 2)
        }
    }

    //give @p minecraft:skull 1 0 {Base:{Type:"",Rarity:"UNCOMMON",RarityColor:'{"text":"","color":"green"}'},HideFlags:63,Unbreakable:1b,Description:['[{"text":"gas","color":"gray","italic":false}]','[{"text":""}]'],display:{Name:"The Catacombs",Lore:['gas','','UNCOMMON']}}

    private fun drawLine(chest: String, profit: Int, color: Int, Line: Int) {
        renderHelper.drawLeftAlignedText("$chest: ${abbreviateNumber(profit)}", 1f, color, posX, (posY + (1.5f * font.FONT_HEIGHT * Line)))
    }
    private fun determineColors(){
        woodColor = if (woodProfit >= 0) green else red
        goldColor = if (goldProfit >= 0) green else red
        diamondColor = if (diamondProfit >= 0) green else red
        emeraldColor = if (emeraldProfit >= 0) green else red
        obsidianColor = if (obsidianProfit >= 0) green else red
        bedrockColor = if (bedrockProfit >= 0) green else red
    }

}