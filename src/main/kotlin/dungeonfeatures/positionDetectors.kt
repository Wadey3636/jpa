package me.jpaMain.dungeonfeatures


import com.github.Wadey.config.JpaConfig.*
import me.jpaMain.command.devMode
import me.jpaMain.events.P3StartEvent
import me.jpaMain.events.QuarterSecondEvent
import me.jpaMain.jpaMain.mc
import me.jpaMain.utils.PlayerPosInfo
import me.jpaMain.utils.inDungeon
import me.jpaMain.utils.renderHelper.renderTitle
import me.jpaMain.utils.worldUtils.isBlock
import net.minecraft.block.Block
import net.minecraft.init.Blocks
import net.minecraft.util.BlockPos
import org.polyfrost.oneconfig.api.event.v1.EventManager
import org.polyfrost.oneconfig.api.event.v1.eventHandler
import org.polyfrost.oneconfig.api.event.v1.events.WorldEvent
import org.polyfrost.oneconfig.api.event.v1.invoke.impl.Subscribe
import java.util.concurrent.atomic.AtomicBoolean

var ee2Triggered = AtomicBoolean(false)
var ee3Triggered = AtomicBoolean(false)
var ee4Triggered = AtomicBoolean(false)
var midTriggered = AtomicBoolean(false)

var eess2Triggered = AtomicBoolean(false)
var eess3Triggered = AtomicBoolean(false)

/**
 * I made this before I knew about engineerclient
 */

class positionDetectors {
    private var textColor = 0xFF0000



    init {

        EventManager.INSTANCE.register(this)
    }

    private var player: String = ""

    @Subscribe
    fun midReset(event: WorldEvent.Load) {
        midTriggered.set(false)
        ee2Triggered.set(false)
        ee3Triggered.set(false)
        ee4Triggered.set(false)
        eess2Triggered.set(false)
        eess3Triggered.set(false)
        EventManager.INSTANCE.unregister(Detector)
    }

    @Subscribe
    fun onP3Start(event: P3StartEvent) {
        Detector.register()
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
        detectorActive: AtomicBoolean, text: String
    ) {
        if (!detectconfig || !isBlock(BlockPos(blockPos), block)) return
        val detected = players.firstOrNull {
            it.position.xCoord.toInt() in lowCoords[0]..highCoords[0] &&
                    it.position.yCoord.toInt() in lowCoords[1]..highCoords[1] &&
                    it.position.zCoord.toInt() in lowCoords[2]..highCoords[2]
        }
        if (detected == null) {
            detectorActive.set(false); return
        }

        if (!detectorActive.get()) {
            detected.let { player = it.name }
            textColor = detectorColor.argb
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
            if (includePosition) {renderTitle("$player $text", detectorTextSize, textColor, 3000L)}
            else renderTitle(player, detectorTextSize, textColor, 3000L)
        }

    }



    val Detector = eventHandler { event: QuarterSecondEvent  ->
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
                midTriggered,
                midText
            )

            detectPlayers(
                ee2Detector,
                players,
                intArrayOf(44, 105, 127),
                intArrayOf(61, 111, 135),
                BlockPos(101, 118, 123),
                Blocks.cobblestone_wall,
                ee2Triggered,
                ee2Text
            )

            detectPlayers(
                ee3Detector,
                players,
                intArrayOf(-1, 108, 97),
                intArrayOf(3, 110, 108),
                BlockPos(17, 118, 132),
                Blocks.cobblestone_wall,
                ee3Triggered,
                ee3Text
            )
            detectPlayers(
                ee4Detector,
                players,
                intArrayOf(50, 114, 50),
                intArrayOf(58, 119, 54),
                BlockPos(17, 118, 132),
                Blocks.cobblestone_wall,
                ee4Triggered,
                ee4Text
            )





            if (safespots) {

                detectPlayers(
                    ee2Detector,
                    players,
                    intArrayOf(68, 108, 120),
                    intArrayOf(70, 111, 122),
                    BlockPos(101, 118, 123),
                    Blocks.cobblestone_wall,
                    eess2Triggered,
                    ee2TextSS
                )

                detectPlayers(
                    ee3Detector,
                    players,
                    intArrayOf(17, 121, 91),
                    intArrayOf(20, 126, 100),
                    BlockPos(17, 118, 132),
                    Blocks.cobblestone_wall,
                    eess3Triggered,
                    ee3TextSS
                )


            }
        }

    }

}





