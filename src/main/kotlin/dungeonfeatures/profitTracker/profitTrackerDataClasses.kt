package me.jpaMain.dungeonfeatures.profitTracker

data class itemValue(val name: String, var price: Float)


data class runLoot(
    val date: String,
    val woodChest: HashSet<itemValue>,
    val goldChest: HashSet<itemValue>,
    val diamondChest: HashSet<itemValue>,
    val emeraldChest: HashSet<itemValue>,
    val obsidianChest: HashSet<itemValue>,
    val bedrockChest: HashSet<itemValue>
)
