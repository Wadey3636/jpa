package me.jpaMain.dungeonfeatures
import com.github.Wadey.config.jpaConfig.spiritleapKeyToggle
import com.github.Wadey.config.jpaConfig.superboomKeyToggle
import com.github.Wadey.config.jpaConfig.pearlKeyToggle
import me.jpaMain.jpaMain.mc


fun gfsPearl(){
    if (!pearlKeyToggle) {return}
    mc.thePlayer?.sendChatMessage("/gfs ender_pearl 16")
}
fun gfsSuperboom(){
    if (!superboomKeyToggle) {return}
    mc.thePlayer?.sendChatMessage("/gfs SUPERBOOM_TNT 64")
}
fun gfsSpiritleap(){
    if (!spiritleapKeyToggle) {return}
    mc.thePlayer?.sendChatMessage("/gfs SPIRIT_LEAP 16")
}

