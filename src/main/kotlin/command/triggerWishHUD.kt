package me.jpaMain.command


import cc.polyfrost.oneconfig.utils.commands.annotations.Command
import cc.polyfrost.oneconfig.utils.commands.annotations.Main
import me.jpaMain.dungeonfeatures.wishNotificationRenderTime


@Command(value = "triggerWishHud", description = "gay")

class triggerWishHUD {
    @Main
    private fun bwah() {
        wishNotificationRenderTime = 60
    }

}