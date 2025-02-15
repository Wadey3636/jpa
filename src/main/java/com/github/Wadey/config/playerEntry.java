package com.github.Wadey.config;

import org.polyfrost.oneconfig.api.config.v1.annotations.*;
import me.jpaMain.events.deletePlayerEntryEvent;
import org.polyfrost.oneconfig.api.event.v1.EventManager;

import java.util.ArrayList;
import java.util.List;

public class playerEntry {

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
            max = 10.0f,
            subcategory = "Players"
    )
    public float entryX = 1f;
    @Slider(
            category = "Player Size Customizer",
            name = "Y",
            min = 0.5f,
            max = 10.0f,
            subcategory = "Players"
    )
    public float entryY = 1f;
    @Slider(
            category = "Player Size Customizer",
            name = "Z",
            min = 0.5f,
            max = 10.0f,
            subcategory = "Players"
    )
    public float entryZ = 1f;
    private int id;

    public playerEntry(int id) {
        this.id = id;
    }

    @Button(
            category = "Player Size Customizer",
            name = "Remove Entry",
            text = "Remove",
            subcategory = "Players"
    )
    private void deleteEntry() {
        deletePlayerEntryEvent event = new deletePlayerEntryEvent(this.id);
        EventManager.INSTANCE.post(event);
    }

    public List getPlayerParamenters() {
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

    public void setID(int id) {
        this.id = id;
    }
}