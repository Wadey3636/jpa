package me.jpaMain.pages

import cc.polyfrost.oneconfig.config.annotations.Button
import cc.polyfrost.oneconfig.config.annotations.Text
import cc.polyfrost.oneconfig.config.annotations.Number
import cc.polyfrost.oneconfig.config.data.OptionSize
import cc.polyfrost.oneconfig.gui.pages.Page
import cc.polyfrost.oneconfig.utils.InputHandler
import scala.collection.mutable.MutableList

class customPlayersPage(title: String?) : Page(title) {
    val playerEntries = MutableList<playerEntry>()
    override fun draw(vg: Long, x: Int, y: Int, inputHandler: InputHandler?) {

    }
    data class playerEntry(
        @Text(
            name = "Name:",
            multiline = false
        )
        var name: String = "",
        @Number(
            name = "X:",
            size = OptionSize.DUAL,
            min = 0.3f,
            max = 3f
        )
        var x: Float = 1f,

        @Number(
            name = "Y:",
            size = OptionSize.DUAL,
            min = 0.3f,
            max = 4f
        )
        var y: Float = 2f,
        @Number(
            name = "Z:",
            size = OptionSize.DUAL,
            min = 0.3f,
            max = 3f
        )
        var z: Float = 1f
    )

    @Button(
        name = "",
        text = "Add Player",
        size = OptionSize.DUAL
    )



    val addPlayer: Runnable = Runnable {

    }

    // SCROLLING
    // if you want it to be scrollable, you can use the following methods:
    fun drawStatic(vg: Long, x: Int, y: Int): Int {
        // draw elements that are not going to be scrollable
        return 12 // return the height of the elements that are drawn in this method
    }

    override fun getMaxScrollHeight(): Int {
        return 1240 // return the total length of the page (how far can be scrolled)
    }

}