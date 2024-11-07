package me.jpaMain.dungeonfeatures

import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.events.event.HudRenderEvent
import cc.polyfrost.oneconfig.events.event.Stage
import cc.polyfrost.oneconfig.events.event.TickEvent
import cc.polyfrost.oneconfig.events.event.WorldLoadEvent
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import cc.polyfrost.oneconfig.renderer.NanoVGHelper
import cc.polyfrost.oneconfig.renderer.font.Fonts
import com.github.Wadey.config.jpaConfig.*
import me.jpaMain.jpaMain.mc
import me.jpaMain.utils.PlayerPosInfo
import me.jpaMain.utils.inDungeon
import me.jpaMain.utils.isBlock
import net.minecraft.block.Block
import net.minecraft.init.Blocks
import net.minecraft.util.BlockPos
import java.util.concurrent.atomic.AtomicBoolean

public var ee2Triggered = AtomicBoolean(false)
public var ee3Triggered = AtomicBoolean(false)
public var ee4Triggered = AtomicBoolean(false)
public var midTriggered = AtomicBoolean(false)

public var renderTime: Int = 0

class positionDetectors {

    init {
        EventManager.INSTANCE.register(this)
    }

    var player: String = ""
    var xpos: Float = 0f
    var ypos: Float = 0f

    @Subscribe
    fun midReset(event: WorldLoadEvent) {
        midTriggered.set(false)
        ee2Triggered.set(false)
        ee3Triggered.set(false)
        ee4Triggered.set(false)
        xpos = mc.displayWidth.toFloat() / 2
        ypos = mc.displayHeight.toFloat() / 2
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
        if (detectorActive.get() || !detectconfig) return
        players.forEach {
            if (
                it.position.xCoord.toInt() in lowCoords[0]..highCoords[0] &&
                it.position.yCoord.toInt() in lowCoords[1]..highCoords[1] &&
                it.position.zCoord.toInt() in lowCoords[2]..highCoords[2] &&
                isBlock(BlockPos(blockPos), block)
            ) {

                player = it.name
                renderTime = 60
                detectorActive.set(true)
                mc.theWorld.playSound(
                    mc.thePlayer.posX,
                    mc.thePlayer.posY,
                    mc.thePlayer.posZ,
                    "minecraft:random.orb",
                    1.0f,
                    1.0f,
                    false
                )
                return
            }

        }
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
            if (detectorActive.get() || !detectconfig) return
            players.forEach {
                if (
                    it.position.xCoord.toInt() in lowCoords[0]..highCoords[0] &&
                    it.position.yCoord.toInt() in lowCoords[1]..highCoords[1] &&
                    it.position.zCoord.toInt() in lowCoords[2]..highCoords[2] &&
                    !isBlock(BlockPos(blockPos), block)
                ) {

                    player = it.name
                    renderTime = 60
                    detectorActive.set(true)
                    mc.theWorld.playSound(
                        mc.thePlayer.posX,
                        mc.thePlayer.posY,
                        mc.thePlayer.posZ,
                        "minecraft:random.orb",
                        1.0f,
                        1.0f,
                        false
                    )
                    return
                }

            }


        }

        @Subscribe
        fun midDetector(event: TickEvent) {
            if (renderTime > 0) {
                renderTime += -1
            }



            if ((event.stage == Stage.START) && inDungeon) {
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
                    "$player",
                    xpos,
                    ypos,
                    -16776961,
                    midDetectorTextSize * 5,
                    Fonts.MINECRAFT_REGULAR
                )

            }


        }

    }





