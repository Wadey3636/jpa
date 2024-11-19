package me.jpaMain.dungeonfeatures.iceFillSolver


import me.jpaMain.utils.variantInfo
import net.minecraft.util.BlockPos


val roomCoords = hashSetOf(
    BlockPos(4, 73, -5),
    BlockPos(-3, 75, -9)
)
// Detection Coordinates
// Layer 3


val americaCoords = hashSetOf(
    BlockPos(3, 72, 4),
    BlockPos(0, 72, 8),
    BlockPos(-1, 72, 8),
    BlockPos(1, 72, 10)
)

val pistolCoords = hashSetOf(
    BlockPos(1, 72, 10),
    BlockPos(0, 72, 8),
    BlockPos(-3, 72, 10),
    BlockPos(-1, 72, 6),
    BlockPos(-2, 72, 6),
    BlockPos(0, 72, 5)
)

val crossCoords = hashSetOf(
    BlockPos(0, 72, 5),
    BlockPos(-2, 72, 5),
    BlockPos(0, 72, 6),
    BlockPos(-1, 72, 7),
    BlockPos(-1, 72, 7),
    BlockPos(2, 72, 7)

)

val neutralCoords = hashSetOf(
    BlockPos(1, 72, 10),
    BlockPos(1, 72, 9),
    BlockPos(1, 72, 6),
    BlockPos(0, 72, 6),
    BlockPos(-1, 72, 6),
    BlockPos(-1, 72, 10)
)

val turtleCoords = hashSetOf(
    BlockPos(-1, 72, 5),
    BlockPos(-1, 72, 4),
    BlockPos(1, 72, 6),
    BlockPos(1, 72, 7),
    BlockPos(2, 72, 7)
)

// Layer 2
val desticlesCoords = hashSetOf(
    BlockPos(0, 71, -2),
    BlockPos(-1, 71, 0)
)

val krzCoords = hashSetOf(
    BlockPos(0, 71, -1),
    BlockPos(1, 71, -1)
)

val fanficCoords = hashSetOf(
    BlockPos(0, 71, -1),
    BlockPos(-1, 71, -1)
)

val jpCoords = hashSetOf(
    BlockPos(0, 71, -2),
    BlockPos(1, 71, -2),
    BlockPos(0, 71, 0),
    BlockPos(-1, 71, 0)
)

val hiitsmeCoords = hashSetOf(
    BlockPos(2, 71, 1),
    BlockPos(1, 71, 1),
    BlockPos(-1, 71, -1),
    BlockPos(1, 71, -2)
)

val akuCoords = hashSetOf(
    BlockPos(2, 71, -3),
    BlockPos(0, 71, -2),
    BlockPos(2, 71, 0),
    BlockPos(2, 71, 1),
    BlockPos(1, 71, 1),
    BlockPos(-1, 71, 0),
    BlockPos(0, 71, -2)
)

// Layer 1
val epicCoords = hashSetOf(
    BlockPos(1, 70, -8),
    BlockPos(-1, 70, -6)
)

val crazyCoords = hashSetOf(
    BlockPos(1, 70, -8),
    BlockPos(-1, 70, -6)
)

val spongecokeCoords = hashSetOf(
    BlockPos(1, 70, -8),
    BlockPos(-1, 70, -8),
    BlockPos(-1, 70, -7),
    BlockPos(-1, 70, -6)
)

val bfvarroeCoords = hashSetOf(
    BlockPos(-1, 70, -8),
    BlockPos(1, 70, -6)
)

// Route Coordinates
//Layer 1
val neutralplot = listOf(
    BlockPos(0, 71, 4),
    BlockPos(3, 71, 4),
    BlockPos(3, 71, 10),
    BlockPos(2, 71, 10),
    BlockPos(2, 71, 5),
    BlockPos(-1, 71, 5),
    BlockPos(-1, 71, 4),
    BlockPos(-3, 71, 4),
    BlockPos(-3, 71, 5),
    BlockPos(-2, 71, 5),
    BlockPos(-2, 71, 6),
    BlockPos(-3, 71, 6),
    BlockPos(-3, 71, 10),
    BlockPos(-2, 71, 10),
    BlockPos(-2, 71, 7),
    BlockPos(1, 71, 7),
    BlockPos(1, 71, 8),
    BlockPos(-1, 71, 8),
    BlockPos(-1, 71, 9),
    BlockPos(0, 71, 9),
    BlockPos(0, 71, 11)
)
val crossplot = listOf(
    BlockPos(0, 71, 4),
    BlockPos(3, 71, 4),
    BlockPos(3, 71, 5),
    BlockPos(1, 71, 5),
    BlockPos(1, 71, 6),
    BlockPos(3, 71, 6),
    BlockPos(3, 71, 10),
    BlockPos(2, 71, 10),
    BlockPos(2, 71, 8),
    BlockPos(1, 71, 8),
    BlockPos(1, 71, 9),
    BlockPos(-1, 71, 9),
    BlockPos(-1, 71, 8),
    BlockPos(-2, 71, 8),
    BlockPos(-2, 71, 6),
    BlockPos(-1, 71, 6),
    BlockPos(-1, 71, 4),
    BlockPos(-3, 71, 4),
    BlockPos(-3, 71, 9),
    BlockPos(-2, 71, 9),
    BlockPos(-2, 71, 10),
    BlockPos(0, 71, 10),
    BlockPos(0, 71, 11)
)
val americaplot = listOf(
    BlockPos(2, 71, 4),
    BlockPos(-3, 71, 4),
    BlockPos(-3, 71, 5),
    BlockPos(3, 71, 5),
    BlockPos(3, 71, 6),
    BlockPos(-3, 71, 6),
    BlockPos(-3, 71, 10),
    BlockPos(-2, 71, 10),
    BlockPos(-2, 71, 7),
    BlockPos(3, 71, 7),
    BlockPos(3, 71, 10),
    BlockPos(2, 71, 10),
    BlockPos(2, 71, 8),
    BlockPos(1, 71, 8),
    BlockPos(1, 71, 9),
    BlockPos(-1, 71, 9),
    BlockPos(-1, 71, 10),
    BlockPos(0, 71, 10),
    BlockPos(0, 71, 11)
)
val pistolplot = listOf(
    BlockPos(2, 71, 10),
    BlockPos(3, 71, 10),
    BlockPos(3, 71, 4),
    BlockPos(2, 71, 4),
    BlockPos(2, 71, 9),
    BlockPos(1, 71, 9),
    BlockPos(1, 71, 7),
    BlockPos(0, 71, 7),
    BlockPos(0, 71, 6),
    BlockPos(1, 71, 6),
    BlockPos(1, 71, 4),
    BlockPos(-1, 71, 4),
    BlockPos(-1, 71, 5),
    BlockPos(-2, 71, 5),
    BlockPos(-2, 71, 4),
    BlockPos(-3, 71, 4),
    BlockPos(-3, 71, 7),
    BlockPos(-1, 71, 7),
    BlockPos(-1, 71, 8),
    BlockPos(-3, 71, 8),
    BlockPos(-3, 71, 9),
    BlockPos(-2, 71, 9),
    BlockPos(-2, 71, 10),
    BlockPos(-1, 71, 10),
    BlockPos(-1, 71, 9),
    BlockPos(0, 71, 9),
    BlockPos(0, 71, 11)

)
val turtleplot = listOf(
    BlockPos(0, 71, 4),
    BlockPos(0, 71, 5),
    BlockPos(1, 71, 5),
    BlockPos(1, 71, 4),
    BlockPos(3, 71, 4),
    BlockPos(3, 71, 5),
    BlockPos(2, 71, 5),
    BlockPos(2, 71, 6),
    BlockPos(3, 71, 6),
    BlockPos(3, 71, 10),
    BlockPos(2, 71, 10),
    BlockPos(2, 71, 8),
    BlockPos(1, 71, 8),
    BlockPos(1, 71, 9),
    BlockPos(0, 71, 9),
    BlockPos(0, 71, 6),
    BlockPos(-1, 71, 6),
    BlockPos(-1, 71, 8),
    BlockPos(-2, 71, 8),
    BlockPos(-2, 71, 4),
    BlockPos(-3, 71, 4),
    BlockPos(-3, 71, 10),
    BlockPos(0, 71, 10),
    BlockPos(0, 71, 11)
)

//Layer 2
val desticlesplot = listOf(
    BlockPos(0, 70, -3),
    BlockPos(2, 70, -3),
    BlockPos(2, 70, -2),
    BlockPos(1, 70, -2),
    BlockPos(1, 70, -1),
    BlockPos(2, 70, -1),
    BlockPos(2, 70, 1),
    BlockPos(2, 70, 1),
    BlockPos(1, 70, 1),
    BlockPos(1, 70, 0),
    BlockPos(0, 70, 0),
    BlockPos(0, 70, -1),
    BlockPos(-1, 70, -1),
    BlockPos(-1, 70, -3),
    BlockPos(-2, 70, -3),
    BlockPos(-2, 70, 1),
    BlockPos(0, 70, 1),
    BlockPos(0, 70, 2)
)
val krzplot = listOf(
    BlockPos(-2, 70, -3),
    BlockPos(-2, 70, 1),
    BlockPos(-1, 70, 1),
    BlockPos(-1, 70, -3),
    BlockPos(0, 70, -3),
    BlockPos(0, 70, -2),
    BlockPos(1, 70, -2),
    BlockPos(1, 70, -3),
    BlockPos(2, 70, -3),
    BlockPos(2, 70, 1),
    BlockPos(1, 70, 1),
    BlockPos(1, 70, 0),
    BlockPos(0, 70, 0),
    BlockPos(0, 70, 2)
)
val fanficplot = listOf(
    BlockPos(2, 70, -3),
    BlockPos(2, 70, 1),
    BlockPos(1, 70, 1),
    BlockPos(1, 70, -3),
    BlockPos(0, 70, -3),
    BlockPos(0, 70, -2),
    BlockPos(-1, 70, -2),
    BlockPos(-1, 70, -3),
    BlockPos(-2, 70, -3),
    BlockPos(-2, 70, 1),
    BlockPos(-1, 70, 1),
    BlockPos(-1, 70, 0),
    BlockPos(0, 70, 0),
    BlockPos(0, 70, 2)
)
val jpplot = listOf(
    BlockPos(0, 70, -3),
    BlockPos(2, 70, -3),
    BlockPos(2, 70, 1),
    BlockPos(1, 70, 1),
    BlockPos(1, 70, -1),
    BlockPos(-1, 70, -1),
    BlockPos(-1, 70, -3),
    BlockPos(-2, 70, -3),
    BlockPos(-2, 70, 1),
    BlockPos(0, 70, 1),
    BlockPos(0, 70, 2)
)
val akuplot = listOf(
    BlockPos(0, 70, -3),
    BlockPos(1, 70, -3),
    BlockPos(1, 70, -2),
    BlockPos(2, 70, -2),
    BlockPos(2, 70, -1),
    BlockPos(1, 70, -1),
    BlockPos(1, 70, 0),
    BlockPos(0, 70, 0),
    BlockPos(0, 70, -1),
    BlockPos(-1, 70, -1),
    BlockPos(-1, 70, -3),
    BlockPos(-2, 70, -3),
    BlockPos(-2, 70, 1),
    BlockPos(0, 70, 1),
    BlockPos(0, 70, 2)
)

//Layer 3
val epicplot = listOf(
    BlockPos(0, 69, -8),
    BlockPos(-1, 69, -8),
    BlockPos(-1, 69, -7),
    BlockPos(1, 69, -7),
    BlockPos(1, 69, -6),
    BlockPos(0, 69, -6),
    BlockPos(0, 69, -5)
)
val ballsplot = listOf(
    BlockPos(0, 69, -8),
    BlockPos(1, 69, -8),
    BlockPos(1, 69, -7),
    BlockPos(-1, 69, -7),
    BlockPos(-1, 69, -6),
    BlockPos(0, 69, -6),
    BlockPos(0, 69, -5)
)
val crazyplot = listOf(
    BlockPos(0, 69, -8),
    BlockPos(-1, 69, -8),
    BlockPos(-1, 69, -7),
    BlockPos(1, 69, -7),
    BlockPos(1, 69, -6),
    BlockPos(0, 69, -6),
    BlockPos(0, 69, -5)
)
val spongecokeplot = listOf(
    BlockPos(0, 69, -8),
    BlockPos(0, 69, -7),
    BlockPos(1, 69, -7),
    BlockPos(1, 69, -6),
    BlockPos(0, 69, -6),
    BlockPos(0, 69, -5)
)
val bfvarroeplot = listOf(
    BlockPos(0, 69, -8),
    BlockPos(1, 69, -8),
    BlockPos(1, 69, -7),
    BlockPos(-1, 69, -7),
    BlockPos(-1, 69, -6),
    BlockPos(0, 69, -6),
    BlockPos(0, 69, -5)
)
val hiitsmeplot = listOf(
    BlockPos(0, 70, -3),
    BlockPos(2, 70, -3),
    BlockPos(2, 70, 0),
    BlockPos(1, 70, 0),
    BlockPos(1, 70, -1),
    BlockPos(0, 70, -1),
    BlockPos(0, 70, -2),
    BlockPos(-1, 70, -2),
    BlockPos(-1, 70, -3),
    BlockPos(-2, 70, -3),
    BlockPos(-2, 70, 1),
    BlockPos(-1, 70, 1),
    BlockPos(-1, 70, 0),
    BlockPos(0, 70, 0),
    BlockPos(0, 70, 2)
)


//etherwarp points

//Layer 3
val pistolWarpPoints = listOf(
    BlockPos(2, 71, 10),
    BlockPos(2, 71, 4),
    BlockPos(1, 71, 9),
    BlockPos(0, 71, 7),
    BlockPos(0, 71, 6),
    BlockPos(1, 71, 6),
    BlockPos(1, 71, 5),
    BlockPos(1, 71, 4),
    BlockPos(0, 71, 4),
    BlockPos(-1, 71, 4),
    BlockPos(-2, 71, 5),
    BlockPos(-3, 71, 4),
    BlockPos(-2, 71, 7),
    BlockPos(-1, 71, 7),
    BlockPos(-1, 71, 8),
    BlockPos(-2, 71, 8),
    BlockPos(-3, 71, 8),
    BlockPos(-3, 71, 9),
    BlockPos(-2, 71, 9),
    BlockPos(-2, 71, 10),
    BlockPos(-1, 71, 10),
    BlockPos(-1, 71, 9),
    BlockPos(0, 71, 9),
    BlockPos(0, 71, 10),
    BlockPos(0, 71, 11)
)
val pistolTp = listOf(2, 71, 10)

val turtleWarpPoints = listOf(
    BlockPos(0, 71, 4),
    BlockPos(0, 71, 5),
    BlockPos(1, 71, 5),
    BlockPos(1, 71, 4),
    BlockPos(2, 71, 4),
    BlockPos(3, 71, 4),
    BlockPos(3, 71, 5),
    BlockPos(2, 71, 6),
    BlockPos(2, 71, 10),
    BlockPos(1, 71, 8),
    BlockPos(0, 71, 9),
    BlockPos(-1, 71, 6),
    BlockPos(-2, 71, 8)
)
val americaWarpPoints = listOf(
    BlockPos(2, 71, 4),
    BlockPos(-3, 71, 5),
    BlockPos(3, 71, 6),
    BlockPos(-2, 71, 10),
    BlockPos(-1, 71, 7),
    BlockPos(0, 71, 7),
    BlockPos(1, 71, 7),
    BlockPos(2, 71, 7),
    BlockPos(3, 71, 7),
    BlockPos(2, 71, 10),
    BlockPos(1, 71, 8),
    BlockPos(1, 71, 9),
    BlockPos(0, 71, 9),
    BlockPos(-1, 71, 9),
    BlockPos(-1, 71, 10),
    BlockPos(0, 71, 10),
    BlockPos(0, 71, 11)
)
val neutralWarpPoints = listOf(
    BlockPos(0, 71, 4),
    BlockPos(2, 71, 10),
    BlockPos(1, 71, 5),
    BlockPos(0, 71, 5),
    BlockPos(-1, 71, 5),
    BlockPos(-2, 71, 4),
    BlockPos(-3, 71, 4),
    BlockPos(-3, 71, 5),
    BlockPos(-2, 71, 5),
    BlockPos(-2, 71, 6),
    BlockPos(-3, 71, 6),
    BlockPos(-2, 71, 10),
    BlockPos(-1, 71, 7),
    BlockPos(1, 71, 8),
    BlockPos(-1, 71, 9),
    BlockPos(0, 71, 10),
    BlockPos(0, 71, 11)
)
val crossWarpPoints = listOf(
    BlockPos(0, 71, 4),
    BlockPos(3, 71, 5),
    BlockPos(1, 71, 6),
    BlockPos(2, 71, 10),
    BlockPos(1, 71, 8),
    BlockPos(0, 71, 9),
    BlockPos(-1, 71, 9),
    BlockPos(-2, 71, 8),
    BlockPos(-2, 71, 4),
    BlockPos(-3, 71, 4),
    BlockPos(-2, 71, 9),
    BlockPos(-1, 71, 10),
    BlockPos(0, 71, 10)
)

//Layer 2
val desticlesWarpPoints = listOf(
    BlockPos(0, 70, -3),
    BlockPos(2, 70, -2),
    BlockPos(1, 70, -1),
    BlockPos(1, 70, 1),
    BlockPos(0, 70, 0),
    BlockPos(-1, 70, -1),
    BlockPos(-2, 70, -3),
    BlockPos(-1, 70, 1),
    BlockPos(0, 70, 1),
    BlockPos(0, 70, 2)
)
val krzWarpPoints = listOf(
    BlockPos(-2, 70, -3),
    BlockPos(-1, 70, 1),
    BlockPos(0, 70, -3),
    BlockPos(1, 70, -2),
    BlockPos(2, 70, -3),
    BlockPos(1, 70, 1),
    BlockPos(0, 70, 0)
)
val jpWarpPoints = listOf(
    BlockPos(0, 70, -3),
    BlockPos(1, 70, 1),
    BlockPos(0, 70, -1),
    BlockPos(-1, 70, -1),
    BlockPos(-2, 70, -3),
    BlockPos(-1, 70, 1),
    BlockPos(0, 70, 1)
)
val hiitsmeWarpPoints = listOf(
    BlockPos(0, 70, -3),
    BlockPos(1, 70, 0),
    BlockPos(0, 70, -1),
    BlockPos(-1, 70, -2),
    BlockPos(-2, 70, -3),
    BlockPos(-1, 70, 1),
    BlockPos(0, 70, 0)
)
val fanficWarpPoints = listOf(
    BlockPos(2, 70, -3),
    BlockPos(1, 70, 1),
    BlockPos(0, 70, -3),
    BlockPos(-1, 70, -2),
    BlockPos(-2, 70, -3),
    BlockPos(-1, 70, 1),
    BlockPos(0, 70, 0)
)
val akuWarpPoints = listOf(
    BlockPos(0, 70, -3),
    BlockPos(1, 70, -2),
    BlockPos(1, 70, -1),
    BlockPos(0, 70, 0),
    BlockPos(-1, 70, -1)
)

//Layer 1
val ballsWarpPoints = listOf(
    BlockPos(0, 69, -8),
    BlockPos(1, 69, -7),
    BlockPos(-1, 69, -6),
    BlockPos(0, 69, -5)
)
val crazyWarpPoints = listOf(
    BlockPos(0, 69, -8),
    BlockPos(-1, 69, -7),
    BlockPos(1, 69, -6),
    BlockPos(0, 69, -5)
)
val spongecokeWarpPoints = listOf(
    BlockPos(0, 69, -8),
    BlockPos(0, 69, -7),
    BlockPos(1, 69, -6),
    BlockPos(0, 69, -5)
)
val epicWarpPoints = listOf(
    BlockPos(0, 69, -8),
    BlockPos(-1, 69, -7),
    BlockPos(1, 69, -6),
    BlockPos(0, 69, -5)
)
val bfvarroeWarpPoints = listOf(
    BlockPos(0, 69, -8),
    BlockPos(1, 69, -7),
    BlockPos(-1, 69, -6),
    BlockPos(0, 69, -5)
)


val epicVariant = variantInfo(epicCoords, "epic", epicplot, epicWarpPoints, null)
val crazyVariant = variantInfo(crazyCoords, "crazy", crazyplot, crazyWarpPoints, null)
val spongecokeVariant = variantInfo(spongecokeCoords, "spongecoke", spongecokeplot, spongecokeWarpPoints, null)
val bfvarroeVariant = variantInfo(bfvarroeCoords, "bfvarroe", bfvarroeplot, bfvarroeWarpPoints, null)

val desticlesVariant = variantInfo(desticlesCoords, "desticles", desticlesplot, desticlesWarpPoints, null)
val krzVariant = variantInfo(krzCoords, "krz", krzplot, krzWarpPoints, BlockPos(-3, 71, -3))
val fanficVariant = variantInfo(fanficCoords, "fanfic", fanficplot, fanficWarpPoints, BlockPos(3, 71, -3))
val jpVariant = variantInfo(jpCoords, "jp", jpplot, jpWarpPoints, null)
val akuVariant = variantInfo(akuCoords, "aku", akuplot, akuWarpPoints, null)
val hiitsmeVariant = variantInfo(hiitsmeCoords, "hiitsme", hiitsmeplot, hiitsmeWarpPoints, null)
val americaVariant = variantInfo(americaCoords, "america", americaplot, americaWarpPoints, BlockPos(3, 72, 4))
val pistolVariant = variantInfo(pistolCoords, "pistol", pistolplot, pistolWarpPoints, BlockPos(2, 72, 11))
val crossVariant = variantInfo(crossCoords, "cross", crossplot, crossWarpPoints, null)
val neutralVariant = variantInfo(neutralCoords, "neutral", neutralplot, neutralWarpPoints, null)
val turtleVariant = variantInfo(turtleCoords, "turtle", turtleplot, turtleWarpPoints, null)

