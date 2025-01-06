package com.github.Wadey.config;


import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.Number;
import cc.polyfrost.oneconfig.config.annotations.*;
import cc.polyfrost.oneconfig.config.core.OneColor;
import cc.polyfrost.oneconfig.config.core.OneKeyBind;
import cc.polyfrost.oneconfig.config.data.*;
import cc.polyfrost.oneconfig.events.EventManager;
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe;
import cc.polyfrost.oneconfig.libs.universal.UChat;
import cc.polyfrost.oneconfig.libs.universal.UKeyboard;
import com.github.Wadey.jaquaviouspringletonaddons;
import com.google.gson.annotations.Expose;
import me.jpaMain.dungeonfeatures.GfsKeybindsKt;
import me.jpaMain.events.deletePlayerEntryEvent;
import me.jpaMain.gardenFeatures.PestFarmingKeybindKt;
import me.jpaMain.huds.p3StartTimerHud;
import me.jpaMain.huds.padTimerHud;
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
            category = "Dungeons",
            subcategory = "Solvers",
            description = "Disabled ATM"
    )
    public static boolean icefillSolver = false;
    @Color(
            name = "Line Color",
            category = "Dungeons",
            subcategory = "Solvers",
            description = "The color of the path"
    )
    public static OneColor icefillPathColor = new OneColor(0, 255, 0, 255);
    @Color(
            name = "Etherwarp Point Color",
            category = "Dungeons",
            subcategory = "Solvers",
            description = "Use a skill called Critical Thinking for one second"
    )
    public static OneColor icefillEtherwarpPointColor = new OneColor(0, 0, 255, 255);
    @Color(
            name = "Teleport Point Color",
            category = "Dungeons",
            subcategory = "Solvers",
            description = "Use a skill called Critical Thinking for one second"
    )
    public static OneColor icefillTeleportPointColor = new OneColor(255, 0, 0, 255);

    @Switch(
            name = "Phase",
            category = "Dungeons",
            subcategory = "Solvers",
            description = "Disabled ATM"
    )
    public static boolean icefillSolverPhase = false;

    //Positional Messages

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
            category = "Dungeons",
            subcategory = "Keybinds",
            description = "Toggles the Pearl GFS keybind"
    )
    public static boolean pearlKeyToggle;

    @KeyBind(
            name = "Pearl GFS",
            description = "/gfs ender_pearl 16",
            category = "Dungeons",
            subcategory = "Keybinds"
    )
    public static OneKeyBind pearlKey = new OneKeyBind(UKeyboard.KEY_1);

    @Switch(
            name = "Superboom GFS Toggle",
            category = "Dungeons",
            subcategory = "Keybinds",
            description = "Toggles the Superboom GFS keybind"
    )
    public static boolean superboomKeyToggle;

    @KeyBind(
            name = "Pearl GFS",
            description = "/gfs SUPERBOOM_TNT 64",
            category = "Dungeons",
            subcategory = "Keybinds"
    )
    public static OneKeyBind superboomKey = new OneKeyBind(UKeyboard.KEY_2);

    @Switch(
            name = "Spirit Leap GFS Toggle",
            category = "Dungeons",
            subcategory = "Keybinds",
            description = "Toggles the Spirit Leap GFS keybind"
    )
    public static boolean spiritleapKeyToggle;

    @KeyBind(
            name = "Spirit Leap GFS",
            description = "/gfs SPIRIT_LEAP 16",
            category = "Dungeons",
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
            category = "F7/M7",
            subcategory = "Detectors",
            description = "Toggles the early entry detectors checking safespots"

    )
    public static boolean safespots = false;
    @Switch(
            name = "Include Position in Alert",
            category = "F7/M7",
            subcategory = "Detectors",
            description = "Toggles the early entry detectors checking safespots"

    )
    public static boolean includePosition = false;

    @Text(
            name = "EE2 Text",
            category = "F7/M7",
            subcategory = "Detectors",
            placeholder = "is at ee2"
    )
    public static String ee2Text = "is at ee2!";

    @Text(
            name = "EE2 Safespot Text",
            category = "F7/M7",
            subcategory = "Detectors",
            placeholder = "is at ee2 Safespot"
    )
    public static String ee2TextSS = "is at ee2 Safespot!";
            
    @Text(
            name = "EE3 Text",
            category = "F7/M7",
            subcategory = "Detectors",
            placeholder = "is at ee3"
    )
    public static String ee3Text = "is at ee3!";
    
    @Text(
    name = "EE3 Safespot Text",
    category = "F7/M7",
    subcategory = "Detectors",
            placeholder = "is at ee3 Safespot"
            )
    public static String ee3TextSS = "is at ee3 Safespot!";

    @Text(
            name = "EE4 Text",
            category = "F7/M7",
            subcategory = "Detectors",
            placeholder = "is at ee4"
    )
    public static String ee4Text = "is at ee4!";

    @Text(
            name = "Mid Text",
            category = "F7/M7",
            subcategory = "Detectors",
            placeholder = "is at Mid"
    )
    public static String midText = "is at Mid!";

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
    @Switch(
            name = "Milestone 3 reminder",
            category = "Dungeons",
            subcategory = "Skill Issue"
    )
    public static boolean mileStone3Reminder = false;
    @Text(
            category = "Dungeons",
            name = "Milestone 3 Reminder Text",
            subcategory = "Skill Issue",
            placeholder = "Get Milestone 3"
    )
    public static String mileStone3ReminderText = "Get Milestone 3";
    @Number(
            name = "Reminder Timer (In Seconds)",
            category = "Dungeons",
            subcategory = "Skill Issue",
            min = 1f, max = 500f
    )
    public static float mileStone3ReminderTimer = 30f;
    @Slider(
            name = "Reminder Scale",
            category = "Dungeons",
            subcategory = "Skill Issue",
            min = 1f, max = 10f
    )
    public static float mileStone3ReminderScale = 10f;
    @Color(
            name = "Reminder Color",
            category = "Dungeons",
            subcategory = "Skill Issue"
    )
    public static OneColor mileStone3ReminderColor = new OneColor(50, 255, 30, 255);

    @Button(
            name = "Add Players",
            text = "Add",
            size = OptionSize.DUAL,
            category = "Player Size Customizer",
            subcategory = "Add Players"
    )
    private void addPlayers() {
        playerEntries.add(new playerEntry(playerEntries.size() + 1));
        save();
        generateOptionList(playerEntries.get(playerEntries.size() - 1), mod.defaultPage, mod, false);
    }

    @Info(
            text = "Case Sensitive",
            category = "Player Size Customizer",
            subcategory = "Players",
            size = OptionSize.DUAL,
            type = InfoType.INFO
    )
    public static boolean ignored;

    @Switch(
            name = "Toggle",
            category = "F7/M7",
            subcategory = "Terminal Waypoints"
    )
    public static boolean terminalWaypoints = false;

    @Color(
            name = "Waypoint Color",
            category = "F7/M7",
            subcategory = "Terminal Waypoints"
    )
    public static OneColor terminalWaypointsColor = new OneColor(0, 0 ,255, 255);

    @Switch(
            name = "Phase",
            category = "F7/M7",
            subcategory = "Terminal Waypoints",
            description = "Visible through Walls"
    )
    public static boolean terminalWaypointsPhase = true;

    @Info(
            text = "Tracer requires [View Bobbing] and [Parallax Fix] - (From Patcher) to be off.",
            category = "F7/M7",
            subcategory = "Terminal Waypoints",
            type = InfoType.WARNING,
            size = OptionSize.DUAL
    )
    static boolean ignored15 = false;
    //bookmark
    @Switch(
            name = "Toggle Tracer",
            category = "F7/M7",
            subcategory = "Terminal Waypoints"
    )
    public static boolean terminalWaypointsTracer = false;

    @Color(
            name = "Tracer Color",
            category = "F7/M7",
            subcategory = "Terminal Waypoints"
    )
    public static OneColor terminalWaypointsTracerColor = new OneColor(0, 0 ,255, 255);

    @Dropdown(
            name = "Presets",
            category = "F7/M7",
            subcategory = "Terminal Waypoints",
            size = 2,
            options = {"Mage", "Tank", "Archer", "Berserker", "Custom"}
    )
    public static int terminalPreset = 0;

    @Switch(
            name = "EE2?",
            category = "F7/M7",
            subcategory = "Terminal Waypoints"
    )
    public static boolean ee2 = false;

    @Switch(
            name = "I4?",
            category = "F7/M7",
            subcategory = "Terminal Waypoints"
    )
    public static boolean I4 = false;

    @Switch(
            name = "Mage Coring?",
            category = "F7/M7",
            subcategory = "Terminal Waypoints"
    )
    public static boolean mageCoring = false;

    @Info(
            text = "Use slashes (/) to separate values in the list.",
            type = InfoType.INFO,
            category = "F7/M7",
            subcategory = "Terminal Waypoints",
            size = 2
    )
    static boolean ignored11 = false;

    @Info(
            text = "RL stands for Right Lever, LL Stands for Left Lever.",
            type = InfoType.INFO,
            category = "F7/M7",
            subcategory = "Terminal Waypoints",
            size = 2
    )
    static boolean ignored12 = false;

    @Info(
            text = "List the terminals in the order you plan to complete them for the tracer to work.",
            type = InfoType.INFO,
            category = "F7/M7",
            subcategory = "Terminal Waypoints",
            size = 2
    )
    static boolean ignored13 = false;

    @Info(
            text = "Example: 4/3/RL",
            type = InfoType.SUCCESS,
            category = "F7/M7",
            subcategory = "Terminal Waypoints",
            size = 2
    )
    static boolean ignored14 = false;
    /*
    Use slashes (/) to separate values in the list.
    RL stands for Right Lever, LL Stands for Left Lever
    List the terminals in the order you plan to complete them
    Example: 4/3/RL
    */

    @Text(
            name = "Section 1",
            category = "F7/M7",
            subcategory = "Terminal Waypoints",
            size = OptionSize.DUAL
    )
    public static String terminalWaypointsTextS1 = "";

    @Text(
            name = "Section 2",
            category = "F7/M7",
            subcategory = "Terminal Waypoints",
            size = OptionSize.DUAL
    )
    public static String terminalWaypointsTextS2 = "";

    @Text(
            name = "Section 3",
            category = "F7/M7",
            subcategory = "Terminal Waypoints",
            size = OptionSize.DUAL
    )
    public static String terminalWaypointsTextS3 = "";

    @Text(
            name = "Section 4",
            category = "F7/M7",
            subcategory = "Terminal Waypoints",
            size = OptionSize.DUAL
    )
    public static String terminalWaypointsTextS4 = "";


























    //DUNGEON LOOT
    @Switch(
            name = "Toggle Profit Calculator",
            size = OptionSize.DUAL,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"

    )
    public static boolean toggleCalculator = false;
    @Header(
            text = "",
            size = OptionSize.DUAL,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static boolean ignored9;
    @Switch(
            name = "Sort Values",
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"

    )
    public static boolean calculatorSort = false;
    @Switch(
            name = "Highlight Chests",
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"

    )
    public static boolean calculatorHighlight = false;

//:
    //PLAYER SIZE CUSTOMIZER


    @Header(
            text = "",
            size = OptionSize.DUAL,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static boolean ignored10;
    @Header(
            text = "Universal",
            size = OptionSize.DUAL,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static boolean ignored0;
    @Number(
            name = "Wither Essence",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float WitherEssence = 2500f;
    @Number(
            name = "Undead Essence",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float UndeadEssence = 1000f;
    @Number(
            name = "Feather Falling",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float FeatherFalling = 0f;
    @Number(
            name = "Infinite Quiver",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float InfQuiver = 0f;
    @Number(
            name = "Rejuvenate",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float Rejuvenate = 20000f;
    @Number(
            name = "Bank",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float Bank = 0f;
    @Number(
            name = "Combo",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float Combo = 0f;
    @Number(
            name = "No Pain No Gain",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float NoPainNoGain = 0f;
    @Number(
            name = "Last Stand",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float LastStand = 100000f;
    @Number(
            name = "Ultimate Jerry",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float UltJerry = 0f;
    @Number(
            name = "Ultimate Wise",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float UltWise = 120000f;
    @Number(
            name = "Wisdom",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float Wisdom = 120000f;
    @Number(
            name = "Necromancers Brooch",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float NecromancersBrooch = 40000f;
    @Number(
            name = "Hot Potato Book",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float HotPotato = 80000f;
    @Number(
            name = "Fuming Potato Book",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float FumingPotato = 1000000f;
    @Number(
            name = "Recombobulator",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float Recomb = 6000000f;
    @Number(
            name = "Dungeon Disc",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float DungeonDisc = 0f;
    @Number(
            name = "Clown Disc",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float ClownDisc = 0f;
    @Number(
            name = "Necron Disc",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float NecronDisc = 0f;
    @Number(
            name = "Watcher Disc",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float WatcherDisc = 0f;
    @Number(
            name = "Old Disc",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float OldDisc = 0f;
    @Header(
            text = "Master Skulls",
            size = OptionSize.DUAL,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static boolean ignored8;
    @Number(
            name = "Master Skull - Tier 1",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float MasterSkullT1 = 500000f;
    @Number(
            name = "Master Skull - Tier 2",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float MasterSkullT2 = 500000f;
    @Number(
            name = "Master Skull - Tier 3",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float MasterSkullT3 = 500000f;
    @Number(
            name = "Master Skull - Tier 4",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float MasterSkullT4 = 500000f;
    @Number(
            name = "Master Skull - Tier 5",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float MasterSkullT5 = 500000f;
    @Header(
            text = "Floor 1",
            size = OptionSize.DUAL,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static boolean ignored1;
    @Number(
            name = "Bonzo's Staff",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float BonzoStaff = 7000000f;
    @Number(
            name = "Bonzo's Mask",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float BonzoMask = 400000f;
    @Number(
            name = "Red Nose",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float RedNose = 0f;
    @Header(
            text = "Floor 2",
            size = OptionSize.DUAL,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static boolean ignored2;
    @Number(
            name = "Scarf's Studies",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float ScarfStudies = 300000f;
    @Number(
            name = "Adaptive Belt",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float AdaptiveBelt = 500000f;
    @Number(
            name = "Adaptive Blade",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float AdaptiveBlade = 0f;
    @Number(
            name = "Red Scarf",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float RedScarf = 2500000f;
    @Header(
            text = "Floor 3",
            size = OptionSize.DUAL,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static boolean ignored3;
    @Number(
            name = "Adaptive Helmet",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float AdaptiveHelmet = 0f;
    @Number(
            name = "Adaptive Chestplate",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float AdaptiveChestplate = 0f;
    @Number(
            name = "Adaptive Leggings",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float AdaptiveLeggings = 0f;
    @Number(
            name = "Adaptive Boots",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float AdaptiveBoots = 0f;
    @Number(
            name = "Suspicious Vial",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SussyBaka = 0f;
    @Number(
            name = "First Master Star",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float FirstMasterStar = 0f;
    @Header(
            text = "Floor 4",
            size = OptionSize.DUAL,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static boolean ignored4;
    @Number(
            name = "Spirit Pet",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SpiritPet = 5000000f;
    @Number(
            name = "Spirit Bone",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SpiritBone = 2000000f;
    @Number(
            name = "Spirit Wing",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SpiritWing = 2000000f;
    @Number(
            name = "Spirit Sword",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SpiritSword = 0f;
    @Number(
            name = "Spirit Bow",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SpiritBow = 0f;
    @Number(
            name = "Spirit Boots",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SpiritBoots = 0f;
    @Number(
            name = "Spirit Stone",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SpiritStone = 0f;
    @Number(
            name = "Rend",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float Rend = 0f;
    @Number(
            name = "Second Master Star",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SecondMasterStar = 12000000f;
    @Header(
            text = "Floor 5",
            size = OptionSize.DUAL,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static boolean ignored5;
    @Number(
            name = "Last Breath",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float LastBreath = 0f;
    @Number(
            name = "Livid Dagger",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float LividDagger = 0f;
    @Number(
            name = "Shadow Assassin Helmet",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SaHelmet = 0f;
    @Number(
            name = "Shadow Assassin Chestplate",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SaChestplate = 0f;
    @Number(
            name = "Shadow Assassin Leggings",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SaLeggings = 0f;
    @Number(
            name = "Shadow Assassin Boots",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SaBoots = 0f;
    @Number(
            name = "Shadow Assassin Cloak",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SaCloak = 5000000f;
    @Number(
            name = "Shadow Fury",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float ShadowFury = 0f;
    @Number(
            name = "Warped Stone",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float WarpedStone = 0f;
    @Number(
            name = "Dark Orb",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float DarkOrb = 500000f;
    @Number(
            name = "Third Master Star",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float ThirdMasterStar = 0f;
    @Number(
            name = "Lethality VI",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float LethalityVI = 0f;
    @Number(
            name = "Overload",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float Overload = 0f;
    @Number(
            name = "Legion",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float Legion = 2000000f;
    @Header(
            text = "Floor 6",
            size = OptionSize.DUAL,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static boolean ignored6;
    @Number(
            name = "Ancient Rose",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float ancientRose = 50000f;
    @Number(
            name = "Giant Tooth",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float GiantTooth = 250000f;
    @Number(
            name = "Giant's Sword",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float GiantsSword = 150000000f;
    @Number(
            name = "Necromancer Lord Helmet",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float NecromancerLordHelmet = 0f;
    @Number(
            name = "Necromancer Lord Chestplate",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float NecromancerLordChestplate = 0f;
    @Number(
            name = "Necromancer Lord Leggings",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float NecromancerLordLeggings = 0f;
    @Number(
            name = "Necromancer Lord Boots",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float NecromancerLordBoots = 0f;
    @Number(
            name = "Necromancer Sword",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float NecromancerSword = 5000000f;
    @Number(
            name = "Summoning Ring",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SummoningRing = 10000000f;
    @Number(
            name = "Sadan's Brooch",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SadanBrooch = 0f;
    @Number(
            name = "Precursor Eye",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float PrecursorEye = 40000000f;
    @Number(
            name = "Fel Skull",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float FelSkull = 5000000f;
    @Number(
            name = "Soulweaver Gloves",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SoulweaverGloves = 6000000f;
    @Number(
            name = "Fourth Master Star",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float FourthMasterStar = 60000000f;
    @Header(
            text = "Floor 7",
            size = OptionSize.DUAL,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static boolean ignored7;
    @Number(
            name = "Auto Recombobulator",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float AutoRecom = 10000000f;
    @Number(
            name = "Dark Claymore",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float DarkClaymore = 150000000f;
    @Number(
            name = "Fifth Master Star",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float FifthMasterStar = 100000000f;
    @Number(
            name = "Necron Dye",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float NecronDye = 50000000f;
    @Number(
            name = "Thunderlord VII",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float ThunderLordVII = 10000000f;
    @Number(
            name = "Necron's Handle",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float NecronsThickJuicyStick = 0f;
    @Number(
            name = "Implosion",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float Implosion = 200000000f;
    @Number(
            name = "Shadow Warp",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float ShadowWarp = 200000000f;
    @Number(
            name = "Wither Shield",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float WitherShield = 200000000f;
    @Number(
            name = "Wither Blood",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float WitherBlood = 0f;
    @Number(
            name = "Wither Catalyst",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float WitherCatalyst = 0f;
    @Number(
            name = "Wither Helmet",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float WitherHelmet = 0f;
    @Number(
            name = "Wither Chestplate",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float WitherChestplate = 12000000f;
    @Number(
            name = "Wither Leggings",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float WitherLeggings = 0f;
    @Number(
            name = "Wither Boots",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float WitherBoots = 0f;
    @Number(
            name = "Wither Cloak Sword",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float WitherCloak = 0f;
    @Number(
            name = "Precursor Gear",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float PrecursorGear = 600000f;
    @Number(
            name = "Soul Eater",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SoulEater = 1000000f;
    @Number(
            name = "One For All",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float OneForAll = 0f;
    @Number(
            name = "Goldor the Fish",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float GoldorFish = 0f;
    @Number(
            name = "Storm the Fish",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float StormFish = 0f;
    @Number(
            name = "Maxor The Fish",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float MaxorFish = 0f;
    @Button(
            name = "Edit Locations",
            text = "Edit",
            category = "F7/M7",
            subcategory = "Timers"
    )
    private void editPositions(){

    }

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

    /*
        @Text(
            name = "EE2 Text",
            category = "F7/M7",
            subcategory = "Detectors"
    )
    public static String ee2Text = "is at ee2!";
     */

    public jpaConfig() {
        super(new Mod(jaquaviouspringletonaddons.NAME, ModType.SKYBLOCK), jaquaviouspringletonaddons.MODID + ".json");
        initialize();
        registerKeyBind(pestKey, PestFarmingKeybindKt::pestFarmingKeybind);
        registerKeyBind(pearlKey, GfsKeybindsKt::gfsPearl);
        registerKeyBind(superboomKey, GfsKeybindsKt::gfsSuperboom);
        registerKeyBind(spiritleapKey, GfsKeybindsKt::gfsSpiritleap);
        hideIf("ee2Text", () -> !includePosition);
        hideIf("ee3Text", () -> !includePosition);
        hideIf("ee4Text", () -> !includePosition);
        hideIf("ee2TextSS", () -> !includePosition || !safespots);
        hideIf("ee3TextSS", () -> !includePosition || !safespots);
        hideIf("midText", () -> !includePosition);



        hideIf("terminalWaypointsTextS1", () -> terminalPreset != 4);
        hideIf("terminalWaypointsTextS2", () -> terminalPreset != 4);
        hideIf("terminalWaypointsTextS3", () -> terminalPreset != 4);
        hideIf("terminalWaypointsTextS4", () -> terminalPreset != 4);
        hideIf("ignored11", () -> terminalPreset != 4);
        hideIf("ignored12", () -> terminalPreset != 4);
        hideIf("ignored13", () -> terminalPreset != 4);
        hideIf("ignored14", () -> terminalPreset != 4);
        hideIf("mageCoring", () -> !(terminalPreset == 0 || terminalPreset == 2) );
        hideIf("ee2", () -> !(terminalPreset == 0 || terminalPreset == 2));
        hideIf("I4", () -> terminalPreset == 4);
        addDependency("terminalWaypointsTextS1", "Toggle", () -> terminalWaypoints);
        addDependency("terminalWaypointsTextS2", "Toggle", () -> terminalWaypoints);
        addDependency("terminalWaypointsTextS3", "Toggle", () -> terminalWaypoints);
        addDependency("terminalWaypointsTextS4", "Toggle", () -> terminalWaypoints);
        addDependency("mageCoring", "Toggle", () -> terminalWaypoints);
        addDependency("ee2", "Toggle", () -> terminalWaypoints);
        addDependency("I4", "Toggle", () -> terminalWaypoints);
        addDependency("terminalPreset", "Toggle", () -> terminalWaypoints);
        addDependency("terminalWaypointsTracer", "Toggle", () -> terminalWaypoints);
        addDependency("terminalWaypointsTracerColor", "Toggle", () -> terminalWaypoints);
        addDependency("terminalWaypointsPhase", "Toggle", () -> terminalWaypoints);
        addDependency("terminalWaypointsColor", "Toggle", () -> terminalWaypoints);


        //bookmark




        addDependency("Icefill Solver", "icefillPathColor", () -> icefillSolver);
        addDependency("Icefill Solver", "icefillEtherwarpPointColor", () -> icefillSolver);
        addDependency("Icefill Solver", "icefillTeleportPointColor", () -> icefillSolver);
        addDependency("Icefill Solver", "icefillSolverPhase", () -> icefillSolver);
        addDependency("Smart Healer Wish Notification", "healerWishNotificationColor", () -> healerWishNotification);
        addDependency("", "wishNotificationSize", () -> healerWishNotification);





        addDependency("berzmsg", "F7/M7 Position messages", () -> posMsgs);

        addDependency("earlyentrypositions", "F7/M7 Position messages", () -> posMsgs);
        addDependency("simonsayspos", "F7/M7 Position messages", () -> posMsgs);
        addDependency("goldorpos", "F7/M7 Position messages", () -> posMsgs);
        addDependency("dragonpos", "F7/M7 Position messages", () -> posMsgs);
        addDependency("midposmsg", "F7/M7 Position messages", () -> posMsgs);
        addDependency("stormposmsg", "F7/M7 Position messages", () -> posMsgs);
        EventManager.INSTANCE.register(this);
    }



    @Subscribe
    public void deleteEntry(deletePlayerEntryEvent event) {
        UChat.chat("Receiving Attempt");
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

    private void reorderIds(@NotNull List<playerEntry> players) {
        int i = 0;
        while (i < players.size()) {
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
}

