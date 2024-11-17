package me.jpaMain.dungeonfeatures

import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.events.event.HudRenderEvent
import cc.polyfrost.oneconfig.events.event.WorldLoadEvent
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import cc.polyfrost.oneconfig.renderer.NanoVGHelper
import cc.polyfrost.oneconfig.renderer.font.Fonts
import com.github.Wadey.config.jpaConfig.*
import me.jpaMain.events.QuarterSecondEvent
import me.jpaMain.jpaMain.mc
import me.jpaMain.utils.PlayerPosInfo
import me.jpaMain.utils.inDungeon
import me.jpaMain.utils.screenCenterX
import me.jpaMain.utils.screenCenterY
import me.jpaMain.utils.worldUtils.isBlock
import net.minecraft.block.Block
import net.minecraft.init.Blocks
import net.minecraft.util.BlockPos
import java.util.concurrent.atomic.AtomicBoolean

public var ee2Triggered = AtomicBoolean(false)
public var ee3Triggered = AtomicBoolean(false)
public var ee4Triggered = AtomicBoolean(false)
public var midTriggered = AtomicBoolean(false)
public var berzLeapSpot = AtomicBoolean(false)

public var renderTime: Int = 0

class positionDetectors {

    init {
        EventManager.INSTANCE.register(this)
    }

    var player: String = ""

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
        val detected = players.firstOrNull{
                it.position.xCoord.toInt() in lowCoords[0]..highCoords[0] &&
                it.position.yCoord.toInt() in lowCoords[1]..highCoords[1] &&
                it.position.zCoord.toInt() in lowCoords[2]..highCoords[2]
        }
        if (detected == null) {detectorActive.set(false); return}
        if (detectorActive.get()) return

        renderTime = 60
        detected.let { player = it.name }
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

    fun detectPlayersInverseBlock(
            detectconfig: Boolean,
            players: ArrayList<PlayerPosInfo>,
            lowCoords: IntArray,
            highCoords: IntArray,
            blockPos: BlockPos,
            block: Block,
            detectorActive: AtomicBoolean
    ) {
        if (!detectconfig || renderTime > 0 || isBlock(BlockPos(blockPos), block)) return
        val detected = players.firstOrNull{ it ->

            it.position.xCoord.toInt() in lowCoords[0]..highCoords[0] &&
                    it.position.yCoord.toInt() in lowCoords[1]..highCoords[1] &&
                    it.position.zCoord.toInt() in lowCoords[2]..highCoords[2]


        }
        if (detected == null) {detectorActive.set(false); return}
        if (detectorActive.get()) return

        renderTime = 12
        detected.let { player = it.name }
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



            if (
                inDungeon) {
                val players = arrayListOf<PlayerPosInfo>()
                mc.theWorld?.playerEntities?.forEach {
                    if (it != mc.thePlayer) players.add(PlayerPosInfo(it.displayNameString, it.positionVector))
                    //players.add(PlayerInfo(it.displayNameString, it.positionVector))
                }

                detectPlayersInverseBlock(
                    midDetector,
                    players,
                    intArrayOf(46, 64, 62),
                    intArrayOf(68, 72, 84),
                    BlockPos(53, 63, 110),
                    Blocks.stone,
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

            NanoVGHelper.INSTANCE.setupAndDraw { vg: Long ->

                NanoVGHelper.INSTANCE.drawCenteredText(
                    vg,
                    player,
                    screenCenterX,
                    screenCenterY,
                    -16776961,
                    midDetectorTextSize * 5,
                    Fonts.MINECRAFT_REGULAR
                )

            }


        }

    }





