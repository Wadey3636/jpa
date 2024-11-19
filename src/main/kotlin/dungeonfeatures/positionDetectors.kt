package me.jpaMain.dungeonfeatures

import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.events.event.HudRenderEvent
import cc.polyfrost.oneconfig.events.event.WorldLoadEvent
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import cc.polyfrost.oneconfig.libs.universal.UChat
import cc.polyfrost.oneconfig.platform.Platform
import me.jpaMain.utils.renderHelper.oneColorToInt

import com.github.Wadey.config.jpaConfig.*
import me.jpaMain.command.devMode
import me.jpaMain.events.QuarterSecondEvent
import me.jpaMain.jpaMain.mc
import me.jpaMain.utils.*
import me.jpaMain.utils.worldUtils.isBlock
import net.minecraft.block.Block
import net.minecraft.init.Blocks
import net.minecraft.util.BlockPos
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.math.max

var ee2Triggered = AtomicBoolean(false)
var ee3Triggered = AtomicBoolean(false)
var ee4Triggered = AtomicBoolean(false)
var midTriggered = AtomicBoolean(false)
var berzLeapSpot = AtomicBoolean(false)

var renderTime: Int = 0

class positionDetectors {
    private var textColor = 0xFF0000
    private var xPos = 0f
    private var yPos = 0f
    private fun getWidth(line: String?, scale: Float): Float {
        return max(0f, (Platform.getGLPlatform().getStringWidth((player)).toFloat() * scale))
    }

    init {
        EventManager.INSTANCE.register(this)
    }

    private var player: String = ""

    @Subscribe
    fun midReset(event: WorldLoadEvent) {

        midTriggered.set(false)
        ee2Triggered.set(false)
        ee3Triggered.set(false)
        ee4Triggered.set(false)
        berzLeapSpot.set(false)

    }

    /**
     * @param detectconfig: Boolean
     * @param players: ArrayListOf<PlayerInfo>()
     * @param lowCoords: intArrayOf() Use the lowest coordinate numbers
     * @param highCoords: intArrayOf() Use the highest coordinate numbers
     * @param blockPos: BlockPos() Condition Block coordinates
     * @param block: Condition Block type
     * @param detectorActive: AtomicBoolean()
     */

    fun detectPlayers(
        detectconfig: Boolean,
        players: ArrayList<PlayerPosInfo>,
        lowCoords: IntArray,
        highCoords: IntArray,
        blockPos: BlockPos,
        block: Block,
        detectorActive: AtomicBoolean
    ) {
        if (!detectconfig || renderTime > 0 || !isBlock(BlockPos(blockPos), block)) return
        val detected = players.firstOrNull {
            it.position.xCoord.toInt() in lowCoords[0]..highCoords[0] &&
                    it.position.yCoord.toInt() in lowCoords[1]..highCoords[1] &&
                    it.position.zCoord.toInt() in lowCoords[2]..highCoords[2]
        }
        if (detected == null) {
            detectorActive.set(false); return
        }
        if (detectorActive.get()) return

        renderTime = 12
        detected.let { player = it.name }
        textColor = oneColorToInt(detectorColor)
        xPos = screenCenterX - (getWidth(player, detectorTextSize) / 4)
        yPos = screenCenterY - (detectorTextSize * 4)
        mc.theWorld.playSound(
            mc.thePlayer.posX,
            mc.thePlayer.posY,
            mc.thePlayer.posZ,
            "minecraft:random.orb",
            1.0f,
            1.0f,
            false
        )
        detectorActive.set(true)

    }


    @Subscribe
    fun midDetector(event: QuarterSecondEvent) {
        if (renderTime > 0) {
            renderTime += -1
        }



        if (inDungeon) {
            val players = arrayListOf<PlayerPosInfo>()
            if (devMode) {
                mc.theWorld?.playerEntities?.forEach {
                    players.add(PlayerPosInfo(it.displayNameString, it.positionVector))
                }
            } else {
                mc.theWorld?.playerEntities?.forEach {
                    if (it != mc.thePlayer) players.add(PlayerPosInfo(it.displayNameString, it.positionVector))
                }
            }


            detectPlayers(
                midDetector,
                players,
                intArrayOf(46, 64, 62),
                intArrayOf(68, 72, 84),
                BlockPos(53, 63, 110),
                Blocks.air,
                midTriggered
            )

            detectPlayers(
                ee2Detector,
                players,
                intArrayOf(44, 105, 127),
                intArrayOf(61, 111, 135),
                BlockPos(101, 118, 123),
                Blocks.cobblestone_wall,
                ee2Triggered
            )

            detectPlayers(
                ee3Detector,
                players,
                intArrayOf(-1, 108, 97),
                intArrayOf(3, 110, 108),
                BlockPos(17, 118, 132),
                Blocks.cobblestone_wall,
                ee3Triggered
            )
            detectPlayers(
                ee4Detector,
                players,
                intArrayOf(50, 114, 50),
                intArrayOf(58, 119, 54),
                BlockPos(17, 118, 132),
                Blocks.cobblestone_wall,
                ee4Triggered
            )



            if (safespots) {
                detectPlayers(
                    true,
                    players,
                    intArrayOf(68, 108, 120),
                    intArrayOf(70, 111, 122),
                    BlockPos(101, 118, 123),
                    Blocks.cobblestone_wall,
                    ee2Triggered
                )
                detectPlayers(
                    true,
                    players,
                    intArrayOf(17, 121, 91),
                    intArrayOf(20, 126, 100),
                    BlockPos(17, 118, 132),
                    Blocks.cobblestone_wall,
                    ee3Triggered
                )
            }
        }

    }


    @Subscribe
    fun onHudRender(event: HudRenderEvent) {
        if (renderTime <= 0) return
        renderHelper.renderTitleText(player, detectorTextSize, textColor)

//-16776961
    }

}





