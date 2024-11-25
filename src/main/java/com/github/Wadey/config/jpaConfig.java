package com.github.Wadey.config;

import cc.polyfrost.oneconfig.config.annotations.*;
import cc.polyfrost.oneconfig.config.core.OneColor;
import cc.polyfrost.oneconfig.config.core.OneKeyBind;
import cc.polyfrost.oneconfig.config.data.InfoType;
import cc.polyfrost.oneconfig.events.EventManager;
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe;
import cc.polyfrost.oneconfig.libs.universal.UChat;
import cc.polyfrost.oneconfig.libs.universal.UKeyboard;
import com.github.Wadey.jaquaviouspringletonaddons;
import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import cc.polyfrost.oneconfig.config.data.OptionSize;
import com.google.gson.annotations.Expose;
import me.jpaMain.dungeonfeatures.*;
import me.jpaMain.events.deletePlayerEntryEvent;
import me.jpaMain.gardenFeatures.PestFarmingKeybindKt;
import me.jpaMain.huds.padTimerHud;
import me.jpaMain.huds.p3StartTimerHud;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * The main Config entrypoint that extends the Config type and inits the config options.
 * See <a href="https://docs.polyfrost.cc/oneconfig/config/adding-options">this link</a> for more config Options
 */

public class jpaConfig extends Config {
    @Expose
    public static List<playerEntry> playerEntries = new ArrayList<>();



    @Switch(
            name = "Icefill Solver",
            size = OptionSize.SINGLE,
            category = "Dungeon",
            subcategory = "Solvers",
            description = "Disabled ATM"
    )
    public static boolean icefillSolver = false;
    @Color(
            name = "Line Color",
            category = "Dungeon",
            subcategory = "Solvers",
            description = "The color of the path"
    )
    public static OneColor icefillPathColor = new OneColor(0, 255, 0, 255);
    @Color(
            name = "Etherwarp Point Color",
            category = "Dungeon",
            subcategory = "Solvers",
            description = "Use a skill called Critical Thinking for one second"
    )
    public static OneColor icefillEtherwarpPointColor = new OneColor(0, 0, 255, 255);
    @Color(
            name = "Teleport Point Color",
            category = "Dungeon",
            subcategory = "Solvers",
            description = "Use a skill called Critical Thinking for one second"
    )
    public static OneColor icefillTeleportPointColor = new OneColor(255, 0, 0, 255);
    @Switch(
            name = "F7/M7 Position messages",
            size = OptionSize.DUAL,
            category = "F7/M7",
            subcategory = "Positional messages"

    )
    public static boolean posMsgs = false;

    @Checkbox(
            name = "Berserker Leap Position Message",
            category = "F7/M7",
            subcategory = "Positional messages"
    )
    public static boolean berzmsg = false;

    @Checkbox(
            name = "Early Entry Position Messages",
            category = "F7/M7",
            subcategory = "Positional messages"
    )
    public static boolean earlyentrypositions = false;

    @Checkbox(
            name = "Healer Leap Position Message (Simon says)",
            category = "F7/M7",
            subcategory = "Positional messages"
    )
    public static boolean simonsayspos = false;

    @Checkbox(
            name = "Inner Chamber position message",
            category = "F7/M7",
            subcategory = "Positional messages"
    )
    public static boolean goldorpos = false;

    @Checkbox(
            name = "Part 5 Position Message",
            category = "F7/M7",
            subcategory = "Positional messages"
    )
    public static boolean dragonpos = false;

    @Checkbox(
            name = "Part 2 Position Message",
            category = "F7/M7",
            subcategory = "Positional messages"
    )
    public static boolean stormposmsg = false;

    @Checkbox(
            name = "Mid Position Message",
            category = "F7/M7",
            subcategory = "Positional messages"
    )
    public static boolean midposmsg = false;

    @Switch(
            name = "Pest Key Toggle",
            category = "Garden",
            subcategory = "Pest Farming",
            description = "Toggles the Pest Farming Key Bind"
    )
    public static boolean pestKeyToggle;

    @KeyBind(
            name = "Garden Pest Farming Key",
            description = "A keybind for warping/setting spawn, it sets your spawn if you are inside a sugar cane block and warps otherwise",
            category = "Garden",
            subcategory = "Pest Farming"
    )
    public static OneKeyBind pestKey = new OneKeyBind(UKeyboard.KEY_Q);
    @Switch(
            name = "Pearl GFS Toggle",
            category = "Dungeon",
            subcategory = "Keybinds",
            description = "Toggles the Pearl GFS keybind"
    )
    public static boolean pearlKeyToggle;

    @KeyBind(
            name = "Pearl GFS",
            description = "/gfs ender_pearl 16",
            category = "Dungeon",
            subcategory = "Keybinds"
    )
    public static OneKeyBind pearlKey = new OneKeyBind(UKeyboard.KEY_1);

    @Switch(
            name = "Superboom GFS Toggle",
            category = "Dungeon",
            subcategory = "Keybinds",
            description = "Toggles the Superboom GFS keybind"
    )
    public static boolean superboomKeyToggle;

    @KeyBind(
            name = "Pearl GFS",
            description = "/gfs SUPERBOOM_TNT 64",
            category = "Dungeon",
            subcategory = "Keybinds"
    )
    public static OneKeyBind superboomKey = new OneKeyBind(UKeyboard.KEY_2);

    @Switch(
            name = "Spirit Leap GFS Toggle",
            category = "Dungeon",
            subcategory = "Keybinds",
            description = "Toggles the Spirit Leap GFS keybind"
    )
    public static boolean spiritleapKeyToggle;

    @KeyBind(
            name = "Spirit Leap GFS",
            description = "/gfs SPIRIT_LEAP 16",
            category = "Dungeon",
            subcategory = "Keybinds"
    )
    public static OneKeyBind spiritleapKey = new OneKeyBind(UKeyboard.KEY_3);

    @Checkbox(
            name = "Mid Detector",
            category = "F7/M7",
            subcategory = "Detectors",
            description = "Detects when a player is at mid"

    )
    public static boolean midDetector = false;
    @Checkbox(
            name = "EE2 Detector",
            category = "F7/M7",
            subcategory = "Detectors",
            description = "Detects when a player is at ee2"

    )
    public static boolean ee2Detector = false;
    @Checkbox(
            name = "EE3 Detector",
            category = "F7/M7",
            subcategory = "Detectors",
            description = "Detects when a player is at ee3"

    )
    public static boolean ee3Detector = false;
    @Checkbox(
            name = "EE4 Detector",
            category = "F7/M7",
            subcategory = "Detectors",
            description = "Detects when a player is at ee4"

    )
    public static boolean ee4Detector = false;
    @Switch(
            name = "Include Safespots",
            size = OptionSize.DUAL,
            category = "F7/M7",
            subcategory = "Detectors",
            description = "Toggles the early entry detectors checking safespots"

    )
    public static boolean safespots = false;


    @Slider(
            name = "Detector Text Size",
            category = "F7/M7",
            subcategory = "Detectors",
            min = 1.0F, max = 8f)
    public static float detectorTextSize = 3f;
    @Color(
            name = "Color",
            category = "F7/M7",
            subcategory = "Detectors"
    )
    public static OneColor detectorColor = new OneColor(160, 0, 255, 255);
    @HUD(
            name = "Pad Timer",
            category = "F7/M7",
            subcategory = "Timers"
    )
    public padTimerHud hud = new padTimerHud();

    @HUD(
            name = "P3 Start Timer",
            category = "F7/M7",
            subcategory = "Timers"
    )
    public p3StartTimerHud starthud = new p3StartTimerHud();

    @Switch(
            name = "Smart Healer Wish Notification",
            category = "F7/M7",
            subcategory = "Wish",
            description = "A healer wish notification that only activates while you are healer"
    )
    public static boolean healerWishNotification = false;
    @Color(
            name = "Color",
            category = "F7/M7",
            subcategory = "Wish"
    )
    public static OneColor healerWishNotificationColor = new OneColor(0, 255, 0, 255);
    @Slider(
            name = "Size",
            category = "F7/M7",
            subcategory = "Wish",
            min = 1.0F, max = 8f)
    public static float wishNotificationSize = 3f;
                                                                                                                                                                                 


    //PLAYER SIZE CUSTOMIZER
    @Button(
            name = "Add Players",
            text = "Add",
            size = OptionSize.DUAL,
            category = "Player Size Customizer",
            subcategory = "Add Players"
    )
    Runnable runnable = () -> {

        playerEntries.add(new playerEntry(playerEntries.size() + 1));
        save();
        generateOptionList(playerEntries.get(playerEntries.size() - 1), mod.defaultPage, mod, false);
    };

    @Header(
            text = "",
            category = "Player Size Customizer",
            subcategory = "Players",
            size = OptionSize.DUAL
    )
    public static boolean ignored;

    @Subscribe
    public void deleteEntry(deletePlayerEntryEvent event) {
        playerEntries.remove(event.getID() - 1);
        save();

        int i = 0;
        while (i < 7) {
            mod.defaultPage.categories.get("Player Size Customizer").subcategories.get(1).options.
                    remove(((event.getID() - 1) * 7 + 1));
            i++;
        }


        reorderIds(playerEntries);
    }
    private void reorderIds(@NotNull List<playerEntry> players){
        int i = 0;
        while (i < players.size()){
            players.get(i).setID(i + 1);
            i++;
        }
    }



    @Override
    public void reInitialize() {
        super.reInitialize();
    }

    @Override
    public void initialize() {
        super.initialize();
        int i = 0;
        while (playerEntries.size() > i) {
            generateOptionList(playerEntries.get(i), mod.defaultPage, mod, false);
            i++;
        }
    }

    public jpaConfig() {
        super(new Mod(jaquaviouspringletonaddons.NAME, ModType.SKYBLOCK), jaquaviouspringletonaddons.MODID + ".json");
        initialize();
        registerKeyBind(pestKey, PestFarmingKeybindKt::pestFarmingKeybind);
        registerKeyBind(pearlKey, GfsKeybindsKt::gfsPearl);
        registerKeyBind(superboomKey, GfsKeybindsKt::gfsSuperboom);
        registerKeyBind(spiritleapKey, GfsKeybindsKt::gfsSpiritleap);
        addDependency("Berserker Leap Position Message", "F7/M7 Position messages", () -> posMsgs);
        addDependency("Early Entry Position Messages", "F7/M7 Position messages", () -> posMsgs);
        addDependency("Healer Leap Position Message (Simon says)", "F7/M7 Position messages", () -> posMsgs);
        addDependency("Inner Chamber position message", "F7/M7 Position messages", () -> posMsgs);
        addDependency("Part 5 Position Message", "F7/M7 Position messages", () -> posMsgs);
        addDependency("Middle Position Message", "F7/M7 Position messages", () -> posMsgs);
        EventManager.INSTANCE.register(this);
    }
}

