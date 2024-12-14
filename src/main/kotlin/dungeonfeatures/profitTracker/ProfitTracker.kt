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

//ALSO MASTER STARS
//CLAYMORE
//THUNDERLORD VII

/*
Bank: 1
One For All: 1.8m
Last Stand: 200k
Ultimate Jerry: 45k
Combo: 1
No Pain No Gain: 1
Ultimate Wise: 120k
Rejuvenate: 20k
Infinite Quiver: 5k
Feather Falling: 5k
Wisdom: 120k


Floor One

Necromancers Brooch: 40k
Bonzo's Staff: 2.2m
Recombobulator: 5m
Fuming Potato Book: 1m
Bonzo’s Mask: 400k
Hot Potato Book: 65k
Red Nose: 2.5k

Floor Two

Scarf’s Studies: 300k

Floor Three

Adaptive Helmet: 1.7m
Adaptive Chestplate: 3.8m
Adaptive Leggings: 1m
Adaptive Boots: 180k
Adaptive Blade: 800k

Floor Four

Rend: 350k
Spirit Sword: 2.4m
Spirit Bow: 1.2m
Spirit Stone: 750k
Spirit Bone: 3.8m
Spirit Wing: 2.3m
Spirit Boots: 3.6m
Spirit Pet (Epic): 450k
Spirit Pet (Legendary): 3.6m

Floor Five

Overload: 1m
Legion: 2.5m
Last Breath: 7m
Shadow Assassin Helmet (Epic/Leg) 1.8m:/ 3m
Shadow Assassin Chestplate (Epic/Leg): 24m/27m
Shadow Assassin Leggings (Epic/Leg): 4m/5.1
Shadow Assassin Boots (Epic/Leg): 1m/2.3
Shadow Fury: 14.5m
Livid Dagger: 7m
Warped Stone: 4.5m

Floor Six
Swarm: 600k
Giant Sword: 82m
Necromancer Lord Helmet: 375k
Necromancer Lord Chestplate: 15m
Necromancer Lord Leggings: 3.8m
Necromancer Lord Boots: 1.2m
Giant’s Tooth: 400k
Precursor Eye: 25m
Ancient Rose: 860k
Summoning Ring: 10m

Floor Seven

Soul Eater: 1m
Precursor Gear: 650k
Wither Catalyst: 1.2m
Wither Blood: 2.5m
Necron’s Handle: 350m
Wither Helmet: 2.6m
Wither Chestplate: 28m
Wither Leggings: 5.8m
Wither Boots: 1.6m
Wither Cloak Sword: 4.4m
Implosion: 39m
Wither Shield: 30m
Shadow Warp: 26m
Auto Recombobulator: 10m

 */