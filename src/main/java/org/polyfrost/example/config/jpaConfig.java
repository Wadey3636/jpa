package org.polyfrost.example.config;

import cc.polyfrost.oneconfig.config.annotations.*;
import org.polyfrost.example.jaquaviouspringletonaddons;
import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import cc.polyfrost.oneconfig.config.data.OptionSize;

/**
 * The main Config entrypoint that extends the Config type and inits the config options.
 * See <a href="https://docs.polyfrost.cc/oneconfig/config/adding-options">this link</a> for more config Options
 */
public class jpaConfig extends Config {

    @Switch(
            name = "Icefill Solver",
            size = OptionSize.SINGLE,
            category = "General Dungeons",
            subcategory = "Solvers",
            description = "Disabled ATM"
    )
    public static boolean icefillSolver = false; // The default value for the boolean Switch.
    @Switch(
            name = "F7/M7 Position messages",
            size = OptionSize.DUAL,
            category = "F7/M7",
            subcategory = "Positional messages"

    )
    public static boolean posMsgs = false;

    @Checkbox(
            name = "Berserker Leap Position Message",
            size = OptionSize.SINGLE,
            category = "F7/M7",
            subcategory = "Positional messages"
    )
    public static boolean berzmsg = false;

    @Checkbox(
            name = "Early Entry Position Messages",
            size = OptionSize.SINGLE,
            category = "F7/M7",
            subcategory = "Positional messages"
    )
    public static boolean earlyentrypositions = false;

    @Checkbox(
            name = "Healer Leap Position Message (Simon says)",
            size = OptionSize.SINGLE,
            category = "F7/M7",
            subcategory = "Positional messages"
    )
    public static boolean simonsayspos = false;

    @Checkbox(
            name = "Inner Chamber position message",
            size = OptionSize.SINGLE,
            category = "F7/M7",
            subcategory = "Positional messages"
    )
    public static boolean goldorpos = false;

    @Checkbox(
            name = "Part 5 Position Message",
            size = OptionSize.SINGLE,
            category = "F7/M7",
            subcategory = "Positional messages"
    )
    public static boolean dragonpos = false;

    @Checkbox(
            name = "Middle Position Message",
            size = OptionSize.SINGLE,
            category = "F7/M7",
            subcategory = "Positional messages"
    )
    public static boolean midposmsg = false;

    public jpaConfig() {

        super(new Mod(jaquaviouspringletonaddons.NAME, ModType.UTIL_QOL), jaquaviouspringletonaddons.MODID + ".json");
        initialize();
    }
}

