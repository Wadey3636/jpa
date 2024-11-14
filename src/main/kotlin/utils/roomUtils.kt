package me.jpaMain.utils

/*
    The idea for this system of room rotation and converting to and from
room coords was pretty much just yoinked out of Bloom. I originally made
the icefill solver in a chat triggers module that ran off of blooms room
system. So to make the process of porting the solver over easier, I pretty
much stole it.

Credit to Unclaimedbloom6
Their GitHub can be found here: https://github.com/UnclaimedBloom6

*/

import cc.polyfrost.oneconfig.libs.universal.UChat
import me.jpaMain.dungeonfeatures.DungeonScanner.iceFillPosition
import net.minecraft.util.BlockPos
import me.jpaMain.jpaMain.mc

fun playerInRoomBounds(room: roomInfo, pos: BlockPos): Boolean {
    return (pos.x in (room.getX() -15)..(room.getX() + 15) &&
            pos.z in (room.getZ() - 15)..(room.getZ() + 15)
            )
}

    fun convertToRoomCoords(room: roomInfo, coords: BlockPos): BlockPos {
        return rotateCoords(BlockPos(coords.x - room.getX(), coords.y, coords.z - room.getZ()), room.rotation)
    }


    //-27 -> - 23
    fun convertToRealCoords(room: roomInfo, coord: BlockPos): BlockPos {
        if (invertRotation(room.rotation) == null) return BlockPos(0, 0, 0)
        val coords = rotateCoords(coord, invertRotation(room.rotation)!!)
        //UChat.chat(invertRotation(room.rotation)!!)
        //UChat.chat(coord)
        //UChat.chat(coords)
        //UChat.chat("${coords.x + room.getX()}, ${coords.y}, ${coords.z + room.getZ()}")
        return BlockPos(coords.x + room.getX(), coords.y, coords.z + room.getZ())

    }
//-121, -185
//[15:57:38] [main/INFO] (Minecraft) [CHAT] BlockPos{x=1, y=70, z=-8}
//[15:57:38] [main/INFO] (Minecraft) [CHAT] -129, 70, -193
// (-8,70, -1)
//-113 70 - 186
//-121 + 8 , 70 , 185 - 1
    fun invertRotation(rotation: String): String? {
        when (rotation) {
            "South" -> return "South"
            "North" -> return "North"
            "West" -> return "East"
            "East" -> return "West"
        }
        return null
    }
    //0, -16


fun isPlayerInRoom(): Boolean {
    if (iceFillPosition == null) return false
    val playerPos = BlockPos(mc.thePlayer.position)


        val roomBounds = getRoomBounds(iceFillPosition!!)
        if (isWithinBounds(playerPos, roomBounds.first, roomBounds.second)) {
            return true // Player is in this room
        }

    return false // Player is not in any room
}

/**
 * Helper method to get the bounds of a room based on its center position and fixed room size.
 */
fun getRoomBounds(room: roomInfo): Pair<BlockPos, BlockPos> {
    val roomSize = 15 // Half of 30x30 room (1x1 unit), adjust if necessary
    val centerX = room.getX()
    val centerZ = room.getZ()

    val min = BlockPos(centerX - roomSize, 0, centerZ - roomSize)
    val max = BlockPos(centerX + roomSize, 255, centerZ + roomSize)
    return Pair(min, max)
}

/**
 * Checks if a given position is within the bounds defined by min and max BlockPos.
 */
fun isWithinBounds(pos: BlockPos, min: BlockPos, max: BlockPos): Boolean {
    return pos.x in min.x..max.x && pos.y in min.y..max.y && pos.z in min.z..max.z
}



    //south = 0
    //West = 90
    //North = 180
    //East = 270

fun rotateCoords(coord:BlockPos, rotation: String): BlockPos {
    when (rotation)
        {"South" -> {return coord}
        "East" -> {return BlockPos(coord.z, coord.y, -coord.x)}
        "North" -> {return BlockPos(-coord.x, coord.y, -coord.z)}
        "West" -> {return BlockPos(-coord.z, coord.y, coord.x)}}
        return BlockPos(0, 0,0)
    }

// (8,70, -1)
//

//[15:57:38] [main/INFO] (Minecraft) [CHAT] BlockPos{x=1, y=70, z=-8}
//[15:57:38] [main/INFO] (Minecraft) [CHAT] -129, 70, -193



// [BlockPos{x=-118, y=70, z=-188},
// BlockPos{x=-122, y=70, z=-184},
// BlockPos{x=-122, y=70, z=-184},
// BlockPos{x=-118, y=70, z=-188},
// BlockPos{x=-118, y=70, z=-188},
// BlockPos{x=-119, y=70, z=-187},
// BlockPos{x=-119, y=70, z=-187},
// BlockPos{x=-118, y=70, z=-188},
// BlockPos{x=-118, y=70, z=-188},
// BlockPos{x=-122, y=70, z=-184},
// BlockPos{x=-122, y=70, z=-184},
// BlockPos{x=-121, y=70, z=-185},
// BlockPos{x=-121, y=70, z=-185},
// BlockPos{x=-123, y=70, z=-183}]