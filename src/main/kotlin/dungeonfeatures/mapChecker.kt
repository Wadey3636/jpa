package me.jpaMain.dungeonfeatures;
import cc.polyfrost.oneconfig.events.EventManager
import cc.polyfrost.oneconfig.events.event.Stage
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import cc.polyfrost.oneconfig.events.event.TickEvent
import cc.polyfrost.oneconfig.events.event.WorldLoadEvent
import cc.polyfrost.oneconfig.libs.universal.UChat
import cc.polyfrost.oneconfig.utils.dsl.mc
import me.jpaMain.utils.isBlock
import net.minecraft.init.Blocks
import net.minecraft.util.BlockPos
import net.minecraft.util.Vec3
import roomInfo


//Each 1x1 unit is 30 by 30

class mapChecker() {

    init {
        EventManager.INSTANCE.register(this)
    }
    var uncheckedRooms: ArrayList<BlockPos> = arrayListOf()
    var Roomlist = ArrayList<roomInfo>()
    @Subscribe
    fun onWorldLoad(event: WorldLoadEvent) {
        var i = 0
        var z = 0
        while (i <= 6) {
            uncheckedRooms.add(BlockPos((-25 - (32 * i)), 99, (-25 - (32 * z))))
            i++
            if (i <= 6 && !(z <= 6)) {
                i = 0
                z++
            }
        }
    }

//-25
//99
//-25
    var coolDown = Long

    @Subscribe
    fun mapChecker(event: TickEvent) {
        if(event.stage == Stage.START) {


            if (coolDown ==) {}
                val bounds = arrayListOf(arrayOf(mc.thePlayer.posX.toInt() - 128, mc.thePlayer.posZ.toInt() - 128),
                    arrayOf(mc.thePlayer.posX.toInt() + 128, mc.thePlayer.posZ.toInt() + 128))



                uncheckedRooms.forEach({

                    if (it.x in bounds[0][0]..bounds[1][0]
                        && mc.theWorld.getChunkFromBlockCoords(it).isLoaded) {
                        if (checkIf1x1(it)) {

                            val doors = findWitherDoors(it)
                            if (doors.size == 1) {
                                Roomlist.add(
                                    roomInfo(
                                        "bob", arrayListOf(
                                            intArrayOf(it.x - 15, 0, it.z - 15),
                                            intArrayOf(it.x + 15, 0, it.z + 15)
                                        ), doors[0]
                                    )
                                )
                                uncheckedRooms.remove(it)
                            } else {uncheckedRooms.remove(it)}
                        } else {uncheckedRooms.remove(it)}




                    }

                })


            UChat.chat(Roomlist)






        }
    }
    fun checkIf1x1(pos: BlockPos): Boolean {
        return !(isBlock(BlockPos(pos.x, 99, pos.y), Blocks.redstone_block) ||
                isBlock(BlockPos(pos.x, 100, pos.y), Blocks.redstone_block) ||
                isBlock(BlockPos(pos.x, 101, pos.y), Blocks.redstone_block)
                )
    }
    fun findWitherDoors(pos: BlockPos): ArrayList<String> {
        var witherDoors = ArrayList<String>()
        if (!isBlock(BlockPos(pos.x, 73, pos.z - 16), Blocks.air)) {witherDoors.add("South")}
        if (!isBlock(BlockPos(pos.x, 73, pos.z + 16), Blocks.air)) {witherDoors.add("North")}
        if (!isBlock(BlockPos(pos.x + 16, 73, pos.z), Blocks.air)) {witherDoors.add("West")}
        if (!isBlock(BlockPos(pos.x - 16, 73, pos.z), Blocks.air)) {witherDoors.add("East")}
        return witherDoors
    }

}
