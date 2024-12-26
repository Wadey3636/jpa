package me.jpaMain.dungeonfeatures.profitTracker

import cc.polyfrost.oneconfig.config.core.OneColor
import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import cc.polyfrost.oneconfig.libs.universal.UChat
import cc.polyfrost.oneconfig.libs.universal.UResolution
import com.github.Wadey.config.jpaConfig.*
import me.jpaMain.events.changeGuiEvent
import me.jpaMain.events.openGuiEvent
import me.jpaMain.jpaMain.mc
import me.jpaMain.utils.guiUtils
import me.jpaMain.utils.guiUtils.deformat
import me.jpaMain.utils.renderHelper
import me.jpaMain.utils.renderHelper.oneColorToInt
import me.jpaMain.utils.universalUtils.abbreviateNumber
import net.minecraftforge.client.event.GuiScreenEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent


@JvmField
var toggleProfitHud = false

@JvmField
var highlightSlots: MutableList<Int> = mutableListOf()

class ProfitTracker {
    private val possibleLoot: MutableMap<String, Float> = mutableMapOf()
    private val chests: MutableList<chestLine> = mutableListOf()


    init {
        EventManager.INSTANCE.register(this)
        possibleLoot.clear()
        chests.clear()
    }


    private val red = OneColor(255, 0, 0, 255)
    private val green = OneColor(0, 255, 0, 255)


    private var scale = 1f

    private var posX = (UResolution.scaledWidth / 1.3f)
    private var posY = (UResolution.scaledHeight / 3f)

    @Subscribe
    fun guiChecker(event: openGuiEvent) {
        if (toggleCalculator && event.name.contains("The Catacombs")) {
            highlightSlots.clear()
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
                item.lore.forEach { string ->
                    val dictionaryValue = possibleLoot[string.deformat]

                    if (dictionaryValue == null) {
                        when {
                            string.deformat.contains("Wither Essence", ignoreCase = true) -> {

                                Regex("\\d+").find(string.deformat)?.value?.let { profit += it.toFloat() * WitherEssence }
                            }

                            string.deformat.contains("Undead Essence", ignoreCase = true) -> {

                                Regex("\\d+").find(string.deformat)?.value?.let { profit += it.toFloat() * UndeadEssence }
                            }

                            string.deformat.contains("Coins") -> {
                                Regex("\\d+").find(
                                    string.deformat.replace(
                                        ",",
                                        ""
                                    )
                                )?.value?.let { profit -= it.toFloat() }
                            }
                        }


                    } else {
                        profit += dictionaryValue
                    }
                }

                when (item.name.deformat) {
                    "Wood Chest" -> Chest = "Wood"
                    "Gold Chest" -> Chest = "Gold"
                    "Diamond Chest" -> Chest = "Diamond"
                    "Emerald Chest" -> Chest = "Emerald"
                    "Obsidian Chest" -> Chest = "Obsidian Chest"
                    "Bedrock Chest" -> Chest = "Bedrock Chest"
                    else -> {
                        UChat.chat("[JPA] Unknown Chest Type")
                        Chest = "Unknown"
                    }
                }
                chests.add(chestLine(Chest, profit, determineColor(profit, item.position).oneColorToInt))
            }
            if (calculatorSort) bubbleSort(chests)

            toggleProfitHud = true
        }
    }




    @Subscribe
    fun guiClosed(event: changeGuiEvent) {
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
        renderHelper.drawLeftAlignedText(
            "$chest: ${abbreviateNumber(profit)}",
            scale,
            color,
            posX,
            (posY + (1.5f * font.FONT_HEIGHT * line * scale))
        )
    }

    private fun drawLines(lines: List<chestLine>) {
        lines.forEachIndexed { index, line ->
            drawLine(line.chest, line.profit, line.color, index + 1)
        }
    }


    private fun determineColor(chestProfit: Float, index: Int): OneColor {
        if (chestProfit >= 0f) {
            highlightSlots.add(index)
            return green
        } else return red
    }

    //Add Balloon Snake

    //I hate this
    private fun getValues() {
        possibleLoot.clear()
        possibleLoot["Necromancer's brooch"] = NecromancersBrooch
        possibleLoot["Hot Potato Book"] = HotPotato
        possibleLoot["Fuming Potato Book"] = FumingPotato
        possibleLoot["Recombobulator 3000"] = Recomb
        possibleLoot["Dungeon Disc"] = DungeonDisc
        possibleLoot["Clown Disc"] = ClownDisc
        possibleLoot["Necron Disc"] = NecronDisc
        possibleLoot["Watcher Disc"] = WatcherDisc
        possibleLoot["Old Disc"] = OldDisc

        possibleLoot["Master Skull - Tier 1"] = MasterSkullT1
        possibleLoot["Master Skull - Tier 2"] = MasterSkullT2
        possibleLoot["Master Skull - Tier 3"] = MasterSkullT3
        possibleLoot["Master Skull - Tier 4"] = MasterSkullT4
        possibleLoot["Master Skull - Tier 5"] = MasterSkullT5
        possibleLoot["First Master Star"] = FirstMasterStar
        possibleLoot["Second Master Star"] = SecondMasterStar
        possibleLoot["Third Master Star"] = ThirdMasterStar
        possibleLoot["Fourth Master Star"] = FourthMasterStar
        possibleLoot["Fifth Master Star"] = FifthMasterStar

        possibleLoot["Bonzo's Staff"] = BonzoStaff
        possibleLoot["Bonzo's Mask"] = BonzoMask
        possibleLoot["Red Nose"] = RedNose

        possibleLoot["Scarf's Studies"] = ScarfStudies
        possibleLoot["Adaptive Belt"] = AdaptiveBelt
        possibleLoot["Red Scarf"] = RedScarf
        possibleLoot["Adaptive Blade"] = AdaptiveBlade


        possibleLoot["Adaptive Helmet"] = AdaptiveHelmet
        possibleLoot["Adaptive Leggings"] = AdaptiveLeggings
        possibleLoot["Adaptive Chestplate"] = AdaptiveChestplate
        possibleLoot["Adaptive Boots"] = AdaptiveBoots
        possibleLoot["Suspicious Vial"] = SussyBaka

        possibleLoot["[Lvl 1] Spirit"] = SpiritPet
        possibleLoot["Spirit Bone"] = SpiritBone
        possibleLoot["Spirit Wing"] = SpiritWing
        possibleLoot["Spirit Sword"] = SpiritSword
        possibleLoot["Spirit Bow"] = SpiritBow
        possibleLoot["Spirit Boots"] = SpiritBoots
        possibleLoot["Spirit Stone"] = SpiritStone

        possibleLoot["Last Breath"] = LastBreath
        possibleLoot["Livid Dagger"] = LividDagger
        possibleLoot["Shadow Assassin Helmet"] = SaHelmet
        possibleLoot["Shadow Assassin Boots"] = SaBoots
        possibleLoot["Shadow Assassin Chestplate"] = SaChestplate
        possibleLoot["Shadow Assassin Leggings"] = SaLeggings
        possibleLoot["Shadow Assassin Cloak"] = SaCloak
        possibleLoot["Shadow Fury"] = ShadowFury
        possibleLoot["Warped Stone"] = WarpedStone
        possibleLoot["Dark Orb"] = DarkOrb


        possibleLoot["Ancient Rose"] = ancientRose
        possibleLoot["Giant Tooth"] = GiantTooth
        possibleLoot["Giant's Sword"] = GiantsSword
        possibleLoot["Necromancer Lord Boots"] = NecromancerLordBoots
        possibleLoot["Necromancer Lord Chestplate"] = NecromancerLordChestplate
        possibleLoot["Necromancer Lord Leggings"] = NecromancerLordLeggings
        possibleLoot["Necromancer Lord Helmet"] = NecromancerLordHelmet
        possibleLoot["Necromancer Sword"] = NecromancerSword
        possibleLoot["Summoning Ring"] = SummoningRing
        possibleLoot["Sadan's Brooch"] = SadanBrooch
        possibleLoot["Precursor Eye"] = PrecursorEye
        possibleLoot["Fel Skull"] = FelSkull
        possibleLoot["Soulweaver Gloves"] = SoulweaverGloves

        possibleLoot["Auto Recombobulator"] = AutoRecom
        possibleLoot["Dark Claymore"] = DarkClaymore
        possibleLoot["Necron Dye"] = NecronDye
        possibleLoot["Thunderlord VII"] = ThunderLordVII
        possibleLoot["Necron's Handle"] = NecronsThickJuicyStick
        possibleLoot["Implosion"] = Implosion
        possibleLoot["Shadow Warp"] = ShadowWarp
        possibleLoot["Wither Shield"] = WitherShield
        possibleLoot["Wither Blood"] = WitherBlood
        possibleLoot["Wither Catalyst"] = WitherCatalyst
        possibleLoot["Wither Helmet"] = WitherHelmet
        possibleLoot["Wither Chestplate"] = WitherChestplate
        possibleLoot["Wither Leggings"] = WitherLeggings
        possibleLoot["Wither Boots"] = WitherBoots
        possibleLoot["Wither Cloak"] = WitherCloak
        possibleLoot["Precursor Gear"] = PrecursorGear
        possibleLoot["Storm the Fish"] = StormFish
        possibleLoot["Goldor the Fish"] = GoldorFish
        possibleLoot["Maxor the Fish"] = MaxorFish


        //ENCHANTED BOOKS
        possibleLoot["Enchanted Book (Soul Eater I)"] = SoulEater
        possibleLoot["Enchanted Book (Soul Eater II)"] = SoulEater * 2

        possibleLoot["Enchanted Book (Bank I)"] = Bank
        possibleLoot["Enchanted Book (Bank II)"] = Bank * 2
        possibleLoot["Enchanted Book (Bank III)"] = Bank * 4

        possibleLoot["Enchanted Book (Rend I)"] = Rend
        possibleLoot["Enchanted Book (Rend II)"] = Rend * 2

        possibleLoot["Enchanted Book (Rejuvenate I)"] = Rejuvenate
        possibleLoot["Enchanted Book (Rejuvenate II)"] = Rejuvenate * 2
        possibleLoot["Enchanted Book (Rejuvenate III)"] = Rejuvenate * 4

        possibleLoot["Enchanted Book (Combo I)"] = Combo
        possibleLoot["Enchanted Book (Combo II)"] = Combo * 2
        possibleLoot["Enchanted Book (Combo III)"] = Combo * 4

        possibleLoot["Enchanted Book (No Pain No Gain I)"] = NoPainNoGain
        possibleLoot["Enchanted Book (No Pain No Gain II)"] = NoPainNoGain * 2
        possibleLoot["Enchanted Book (No Pain No Gain III)"] = NoPainNoGain * 4

        possibleLoot["Enchanted Book (Last Stand I)"] = LastStand
        possibleLoot["Enchanted Book (Last Stand II)"] = LastStand * 2
        possibleLoot["Enchanted Book (Last Stand III)"] = LastStand * 4

        possibleLoot["Enchanted Book (Ultimate Jerry I)"] = UltJerry
        possibleLoot["Enchanted Book (Ultimate Jerry II)"] = UltJerry * 2
        possibleLoot["Enchanted Book (Ultimate Jerry III)"] = UltJerry * 4

        possibleLoot["Enchanted Book (Ultimate Wise I)"] = UltWise
        possibleLoot["Enchanted Book (Ultimate Wise II)"] = UltWise * 2
        possibleLoot["Enchanted Book (Ultimate Wise III)"] = UltWise * 4

        possibleLoot["Enchanted Book (Infinite Quiver VI)"] = InfQuiver
        possibleLoot["Enchanted Book (Infinite Quiver VII)"] = InfQuiver * 2
        possibleLoot["Enchanted Book (Infinite Quiver VIII)"] = InfQuiver * 4

        possibleLoot["Enchanted Book (Feather Falling VI)"] = FeatherFalling
        possibleLoot["Enchanted Book (Feather Falling VII)"] = FeatherFalling * 2
        possibleLoot["Enchanted Book (Feather Falling VIII)"] = FeatherFalling * 4

        possibleLoot["Enchanted Book (Wisdom I)"] = Wisdom
        possibleLoot["Enchanted Book (Wisdom II)"] = Wisdom * 2
        possibleLoot["Enchanted Book (Wisdom III)"] = Wisdom * 4

        possibleLoot["Enchanted Book (One For All I)"] = OneForAll
        possibleLoot["Lethality VI"] = LethalityVI
        possibleLoot["Overload I"] = Overload
        possibleLoot["Legion I"] = Legion
    }
    private fun bubbleSort(arr: MutableList<chestLine>) {
        val n = arr.size
        for (i in 0 until n - 1) {
            for (j in 0 until n - i - 1) {
                if (arr[j].profit < arr[j + 1].profit) {
                    // Swap the elements
                    val temp = arr[j]
                    arr[j] = arr[j + 1]
                    arr[j + 1] = temp
                }
            }
        }
    }

}
data class chestLine(val chest: String, var profit: Float, val color: Int)



/*


 */



