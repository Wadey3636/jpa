package com.github.Wadey.config;

import cc.polyfrost.oneconfig.config.annotations.*;
import cc.polyfrost.oneconfig.config.data.OptionSize;
import cc.polyfrost.oneconfig.events.EventManager;
import me.jpaMain.events.deletePlayerEntryEvent;

import java.util.ArrayList;
import java.util.List;

public class playerEntry {

    private int id;
    public playerEntry(int id) {
        this.id = id;
    }

    @Header(
            text = "     ",
            category = "Player Size Customizer",
            size = OptionSize.DUAL,
            subcategory = "Players"
    )
    public static boolean ignored;
    @Switch(
            category = "Player Size Customizer",
            name = "Toggle",
            subcategory = "Players"
    )
    public boolean entryToggle = true;

    @Text(
            category = "Player Size Customizer",
            name = "Player Name",
            subcategory = "Players"
    )
    public String name = "Name";

    @Slider(
            category = "Player Size Customizer",
            name = "X",
            min = 0.5f,
            max = 3.0f,
            subcategory = "Players"
    )
    public float entryX = 1f;

    @Slider(
            category = "Player Size Customizer",
            name = "Y",
            min = 0.5f,
            max = 4.0f,
            subcategory = "Players"
    )
    public float entryY = 2f;

    @Slider(
            category = "Player Size Customizer",
            name = "Z",
            min = 0.5f,
            max = 3.0f,
            subcategory = "Players"
    )
    public float entryZ = 1f;

    @Button(
            category = "Player Size Customizer",
            name = "Remove Entry",
            text = "Remove",
            subcategory = "Players"
    )
    private void deleteEntry(){
    deletePlayerEntryEvent event = new deletePlayerEntryEvent(this.id);
    EventManager.INSTANCE.post(event);
};

    public List getPlayerParamenters(){
        List<Object> list = new ArrayList<>();
        list.add(entryToggle);
        list.add(name);
        list.add(entryX);
        list.add(entryY);
        list.add(entryZ);
        return list;
    }

    public int getId() {
        return id;
    }

    public void setID(int id){
        this.id = id;
    }
}