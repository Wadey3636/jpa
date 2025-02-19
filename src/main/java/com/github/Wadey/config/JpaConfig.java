package com.github.Wadey.config;

import me.jpaMain.dungeonfeatures.TerminalWaypointsKt;
import me.jpaMain.utils.InventoryInfo;
import org.polyfrost.oneconfig.api.config.v1.Config;
import org.polyfrost.oneconfig.api.config.v1.annotations.*;
import com.github.Wadey.jaquaviouspringletonaddons;
import me.jpaMain.dungeonfeatures.GfsKeybindsKt;
import me.jpaMain.gardenFeatures.PestFarmingKeybindKt;
import org.polyfrost.oneconfig.api.config.v1.annotations.Number;
import org.polyfrost.polyui.color.ColorUtils;
import org.polyfrost.polyui.color.PolyColor;
import org.polyfrost.polyui.input.KeyBinder;
import org.polyfrost.polyui.input.KeybindHelper;
import org.polyfrost.universal.UKeyboard;


import java.util.ArrayList;
import java.util.List;

import static org.polyfrost.oneconfig.api.ui.v1.keybind.KeybindManager.registerKeybind;

@SuppressWarnings("unused")
public class JpaConfig extends Config {

    //@Include
    //public static List<playerEntry> playerEntries = new ArrayList<>();
    @Include
     public static List<InventoryInfo> chestEntries = new ArrayList<>();


    @Switch(
            title = "Icefill Solver",
            category = "Dungeons",
            subcategory = "Solvers",
            description = "Shows FlameOfWar's Icefill routes"
    )
    public static boolean icefillSolver = false;
    @Color(
            title = "Line Color",
            category = "Dungeons",
            subcategory = "Solvers",
            description = "The color of the path"
    )
    public static PolyColor icefillPathColor = ColorUtils.rgba(0, 255, 0);
    @Color(
            title = "Etherwarp Point Color",
            category = "Dungeons",
            subcategory = "Solvers",
            description = "Use a skill called Critical Thinking for one second"
    )
    public static PolyColor icefillEtherwarpPointColor = ColorUtils.rgba(0, 0, 255);
    @Color(
            title = "Teleport Point Color",
            category = "Dungeons",
            subcategory = "Solvers",
            description = "Use a skill called Critical Thinking for one second"
    )
    public static PolyColor icefillTeleportPointColor = ColorUtils.rgba(255, 0, 0);

    @Switch(
            title = "Phase",
            category = "Dungeons",
            subcategory = "Solvers",
            description = "Disabled ATM"
    )
    public static boolean icefillSolverPhase = false;

    //Positional Messages

    @Switch(
            title = "F7/M7 Position messages",
            category = "F7/M7",
            subcategory = "Positional messages"

    )
    public static boolean posMsgs = false;

    @Checkbox(
            title = "Berserker Leap Position Message",
            category = "F7/M7",
            subcategory = "Positional messages"
    )
    public static boolean berzmsg = false;

    @Checkbox(
            title = "Early Entry Position Messages",
            category = "F7/M7",
            subcategory = "Positional messages"
    )
    public static boolean earlyentrypositions = false;

    @Checkbox(
            title = "Healer Leap Position Message (Simon says)",
            category = "F7/M7",
            subcategory = "Positional messages"
    )
    public static boolean simonsayspos = false;

    @Checkbox(
            title = "Inner Chamber position message",
            category = "F7/M7",
            subcategory = "Positional messages"
    )
    public static boolean goldorpos = false;

    @Checkbox(
            title = "Part 5 Position Message",
            category = "F7/M7",
            subcategory = "Positional messages"
    )
    public static boolean dragonpos = false;

    @Checkbox(
            title = "Part 2 Position Message",
            category = "F7/M7",
            subcategory = "Positional messages"
    )
    public static boolean stormposmsg = false;

    @Checkbox(
            title = "Mid Position Message",
            category = "F7/M7",
            subcategory = "Positional messages"
    )
    public static boolean midposmsg = false;


    @Switch(
            title = "Pest Key Toggle",
            category = "Garden",
            subcategory = "Pest Farming",
            description = "Toggles the Pest Farming Key Bind"
    )
    public static boolean pestKeyToggle;

    @Keybind(
            title = "Garden Pest Farming Key",
            description = "A keybind for warping/setting spawn, it sets your spawn if you are inside a sugar cane block and warps otherwise",
            category = "Garden",
            subcategory = "Pest Farming"
    )
    public static KeyBinder.Bind pestKey = KeybindHelper.builder().keys(UKeyboard.KEY_NONE).does(it -> {
        PestFarmingKeybindKt.pestFarmingKeybind();
        return null;
    }).build();

    @Switch(
            title = "Pearl GFS Toggle",
            category = "Dungeons",
            subcategory = "Keybinds",
            description = "Toggles the Pearl GFS keybind"
    )
    public static boolean pearlKeyToggle;

    @Keybind(
            title = "Pearl GFS",
            description = "/gfs ender_pearl 16",
            category = "Dungeons",
            subcategory = "Keybinds"
    )
    public static KeyBinder.Bind pearlKey = KeybindHelper.builder().keys(UKeyboard.KEY_NONE).does(it -> {
        GfsKeybindsKt.gfsPearl();
        return null;
    }).build();


    @Switch(
            title = "Superboom GFS Toggle",
            category = "Dungeons",
            subcategory = "Keybinds",
            description = "Toggles the Superboom GFS keybind"
    )
    public static boolean superboomKeyToggle;

    @Keybind(
            title = "Pearl GFS",
            description = "/gfs SUPERBOOM_TNT 64",
            category = "Dungeons",
            subcategory = "Keybinds"
    )
    public static KeyBinder.Bind superboomKey = KeybindHelper.builder().keys(UKeyboard.KEY_NONE).does(it -> {
        GfsKeybindsKt.gfsSuperboom();
        return null;
    }).build();

    @Switch(
            title = "Spirit Leap GFS Toggle",
            category = "Dungeons",
            subcategory = "Keybinds",
            description = "Toggles the Spirit Leap GFS keybind"
    )
    public static boolean spiritleapKeyToggle;

    @Keybind(
            title = "Spirit Leap GFS",
            description = "/gfs SPIRIT_LEAP 16",
            category = "Dungeons",
            subcategory = "Keybinds"
    )
    public static KeyBinder.Bind spiritleapKey = KeybindHelper.builder().keys(UKeyboard.KEY_NONE).does(it -> {
        GfsKeybindsKt.gfsSpiritleap();
        return null;
    }).build();

    @Checkbox(
            title = "Mid Detector",
            category = "F7/M7",
            subcategory = "Detectors",
            description = "Detects when a player is at mid"

    )
    public static boolean midDetector = false;
    @Checkbox(
            title = "EE2 Detector",
            category = "F7/M7",
            subcategory = "Detectors",
            description = "Detects when a player is at ee2"

    )
    public static boolean ee2Detector = false;
    @Checkbox(
            title = "EE3 Detector",
            category = "F7/M7",
            subcategory = "Detectors",
            description = "Detects when a player is at ee3"

    )
    public static boolean ee3Detector = false;
    @Checkbox(
            title = "EE4 Detector",
            category = "F7/M7",
            subcategory = "Detectors",
            description = "Detects when a player is at ee4"

    )
    public static boolean ee4Detector = false;
    @Switch(
            title = "Include Safespots",
            category = "F7/M7",
            subcategory = "Detectors",
            description = "Toggles the early entry detectors checking safespots"

    )
    public static boolean safespots = false;
    @Switch(
            title = "Include Position in Alert",
            category = "F7/M7",
            subcategory = "Detectors",
            description = "Toggles the early entry detectors checking safespots"

    )
    public static boolean includePosition = false;

    @Text(
            title = "EE2 Text",
            category = "F7/M7",
            subcategory = "Detectors",
            placeholder = "is at ee2"
    )
    public static String ee2Text = "is at ee2!";

    @Text(
            title = "EE2 Safespot Text",
            category = "F7/M7",
            subcategory = "Detectors",
            placeholder = "is at ee2 Safespot"
    )
    public static String ee2TextSS = "is at ee2 Safespot!";
            
    @Text(
            title = "EE3 Text",
            category = "F7/M7",
            subcategory = "Detectors",
            placeholder = "is at ee3"
    )
    public static String ee3Text = "is at ee3!";
    
    @Text(
    title = "EE3 Safespot Text",
    category = "F7/M7",
    subcategory = "Detectors",
            placeholder = "is at ee3 Safespot"
            )
    public static String ee3TextSS = "is at ee3 Safespot!";

    @Text(
            title = "EE4 Text",
            category = "F7/M7",
            subcategory = "Detectors",
            placeholder = "is at ee4"
    )
    public static String ee4Text = "is at ee4!";

    @Text(
            title = "Mid Text",
            category = "F7/M7",
            subcategory = "Detectors",
            placeholder = "is at Mid"
    )
    public static String midText = "is at Mid!";

    @Slider(
            title = "Detector Text Size",
            category = "F7/M7",
            subcategory = "Detectors",
            min = 1.0F, max = 8f)
    public static float detectorTextSize = 3f;
    @Color(
            title = "Color",
            category = "F7/M7",
            subcategory = "Detectors"
    )
    public static PolyColor detectorColor = ColorUtils.rgba(135, 0, 200);
    @Switch(
            title = "Smart Healer Wish Notification",
            category = "F7/M7",
            subcategory = "Wish",
            description = "A healer wish notification that only activates while you are healer"
    )
    public static boolean healerWishNotification = false;




    @Color(
            title = "Color",
            category = "F7/M7",
            subcategory = "Wish"
    )
    public static PolyColor healerWishNotificationColor = ColorUtils.rgba(0, 255, 130);
    @Slider(
            title = "Size",
            category = "F7/M7",
            subcategory = "Wish",
            min = 1.0F, max = 8f)
    public static float wishNotificationSize = 3f;
    @Switch(
            title = "Milestone 3 reminder",
            category = "Dungeons",
            subcategory = "Skill Issue"
    )
    public static boolean mileStone3Reminder = false;
    @Text(
            category = "Dungeons",
            title = "Milestone 3 Reminder Text",
            subcategory = "Skill Issue",
            placeholder = "Get Milestone 3"
    )
    public static String mileStone3ReminderText = "Get Milestone 3";
    @Number(
            title = "Reminder Timer (In Seconds)",
            category = "Dungeons",
            subcategory = "Skill Issue",
            min = 1f, max = 500f
    )
    public static float mileStone3ReminderTimer = 30f;
    @Slider(
            title = "Reminder Scale",
            category = "Dungeons",
            subcategory = "Skill Issue",
            min = 1f, max = 10f
    )
    public static float mileStone3ReminderScale = 10f;
    @Color(
            title = "Reminder Color",
            category = "Dungeons",
            subcategory = "Skill Issue"
    )
    public static PolyColor mileStone3ReminderColor = ColorUtils.rgba(0, 255, 0);

    @Info(
            title = "Case Sensitive",
            category = "Player Size Customizer",
            subcategory = "Players",
            description = ""
    )
    public static boolean ignored;

    @Switch(
            title = "Toggle",
            category = "F7/M7",
            subcategory = "Terminal Waypoints"
    )
    public static boolean terminalWaypoints = false;
    @Button(
            title = "Clear Waypoints",
            category = "F7/M7",
            subcategory = "Terminal Waypoints",
            description = "Useful if the waypoints bug out"
    )
    public void clearWaypoints() {
        TerminalWaypointsKt.activeWaypoints.clear();
    }
    @Color(
            title = "Waypoint Color",
            category = "F7/M7",
            subcategory = "Terminal Waypoints"
    )
    public static PolyColor terminalWaypointsColor = ColorUtils.rgba(0, 0, 255);

    @Switch(
            title = "Phase",
            category = "F7/M7",
            subcategory = "Terminal Waypoints",
            description = "Visible through Walls"
    )
    public static boolean terminalWaypointsPhase = true;

    @Info(
            title = "Tracer requires [View Bobbing] and [Parallax Fix] - (From Patcher) to be off.",
            category = "F7/M7",
            subcategory = "Terminal Waypoints",
            description = ""
            
    )
    static boolean ignored15 = false;
    //bookmark
    @Switch(
            title = "Toggle Tracer",
            category = "F7/M7",
            subcategory = "Terminal Waypoints"
    )
    public static boolean terminalWaypointsTracer = false;

    @Color(
            title = "Tracer Color",
            category = "F7/M7",
            subcategory = "Terminal Waypoints"
    )
    public static PolyColor terminalWaypointsTracerColor = ColorUtils.rgba(0, 255, 0);

    @Dropdown(
            title = "Presets",
            category = "F7/M7",
            subcategory = "Terminal Waypoints",
            
            options = {"Mage", "Tank", "Archer", "Berserker", "Custom"}
    )
    public static int terminalPreset = 0;

    @Switch(
            title = "EE2?",
            category = "F7/M7",
            subcategory = "Terminal Waypoints"
    )
    public static boolean ee2 = false;

    @Switch(
            title = "I4?",
            category = "F7/M7",
            subcategory = "Terminal Waypoints"
    )
    public static boolean I4 = false;

    @Switch(
            title = "Mage Coring?",
            category = "F7/M7",
            subcategory = "Terminal Waypoints"
    )
    public static boolean mageCoring = false;

    @Info(
            title = "Use slashes (/) to separate values in the list.",
            description = "",
            category = "F7/M7",
            subcategory = "Terminal Waypoints"
            
    )
    static boolean ignored11 = false;

    @Info(
            title = "RL stands for Right Lever, LL Stands for Left Lever.",
            description = "",
            category = "F7/M7",
            subcategory = "Terminal Waypoints"
            
    )
    static boolean ignored12 = false;

    @Info(
            title = "List the terminals in the order you plan to complete them for the tracer to work.",
            description = "",
            category = "F7/M7",
            subcategory = "Terminal Waypoints"
            
    )
    static boolean ignored13 = false;

    @Info(
            title = "Example: 4/3/RL",
            category = "F7/M7",
            subcategory = "Terminal Waypoints",
            description = ""
            
    )
    static boolean ignored14 = false;


    @Text(
            title = "Section 1",
            category = "F7/M7",
            subcategory = "Terminal Waypoints",
            description = ""
            
    )
    public static String terminalWaypointsTextS1 = "";

    @Text(
            title = "Section 2",
            category = "F7/M7",
            subcategory = "Terminal Waypoints",
            description = ""
            
    )
    public static String terminalWaypointsTextS2 = "";

    @Text(
            title = "Section 3",
            category = "F7/M7",
            subcategory = "Terminal Waypoints",
            description = ""
            
    )
    public static String terminalWaypointsTextS3 = "";

    @Text(
            title = "Section 4",
            category = "F7/M7",
            subcategory = "Terminal Waypoints",
            description = ""
            
    )
    public static String terminalWaypointsTextS4 = "";


























    //DUNGEON LOOT
    @Switch(
            title = "Toggle Profit Calculator",
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"

    )
    public static boolean toggleCalculator = false;
    @Switch(
            title = "Sort Values",
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"

    )
    public static boolean calculatorSort = false;
    @Switch(
            title = "Highlight Chests",
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"

    )
    public static boolean calculatorHighlight = false;





    public static boolean ignored10;
    @Info(
            title = "Universal",
            description = "",
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static boolean ignored0;
    @Number(
            title = "Wither Essence",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float WitherEssence = 2500f;
    @Number(
            title = "Undead Essence",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float UndeadEssence = 1000f;
    @Number(
            title = "Feather Falling",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float FeatherFalling = 0f;
    @Number(
            title = "Infinite Quiver",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float InfQuiver = 0f;
    @Number(
            title = "Rejuvenate",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float Rejuvenate = 20000f;
    @Number(
            title = "Bank",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float Bank = 0f;
    @Number(
            title = "Combo",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float Combo = 0f;
    @Number(
            title = "No Pain No Gain",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float NoPainNoGain = 0f;
    @Number(
            title = "Last Stand",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float LastStand = 100000f;
    @Number(
            title = "Ultimate Jerry",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float UltJerry = 0f;
    @Number(
            title = "Ultimate Wise",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float UltWise = 120000f;
    @Number(
            title = "Wisdom",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float Wisdom = 120000f;
    @Number(
            title = "Necromancers Brooch",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float NecromancersBrooch = 40000f;
    @Number(
            title = "Hot Potato Book",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float HotPotato = 80000f;
    @Number(
            title = "Fuming Potato Book",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float FumingPotato = 1000000f;
    @Number(
            title = "Recombobulator",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float Recomb = 6000000f;
    @Number(
            title = "Dungeon Disc",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float DungeonDisc = 0f;
    @Number(
            title = "Clown Disc",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float ClownDisc = 0f;
    @Number(
            title = "Necron Disc",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float NecronDisc = 0f;
    @Number(
            title = "Watcher Disc",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float WatcherDisc = 0f;
    @Number(
            title = "Old Disc",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float OldDisc = 0f;
    @Info(
            title = "Master Skulls",
            description = "",
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static boolean ignored8;
    @Number(
            title = "Master Skull - Tier 1",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float MasterSkullT1 = 500000f;
    @Number(
            title = "Master Skull - Tier 2",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float MasterSkullT2 = 500000f;
    @Number(
            title = "Master Skull - Tier 3",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float MasterSkullT3 = 500000f;
    @Number(
            title = "Master Skull - Tier 4",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float MasterSkullT4 = 500000f;
    @Number(
            title = "Master Skull - Tier 5",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float MasterSkullT5 = 500000f;
    @Number(
            title = "Bonzo's Staff",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float BonzoStaff = 7000000f;
    @Number(
            title = "Bonzo's Mask",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float BonzoMask = 400000f;
    @Number(
            title = "Red Nose",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float RedNose = 0f;
    @Info(
            title = "Floor 2",
            description = "",
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static boolean ignored2;
    @Number(
            title = "Scarf's Studies",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float ScarfStudies = 300000f;
    @Number(
            title = "Adaptive Belt",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float AdaptiveBelt = 500000f;
    @Number(
            title = "Adaptive Blade",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float AdaptiveBlade = 0f;
    @Number(
            title = "Red Scarf",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float RedScarf = 2500000f;
    @Info(
            title = "Floor 3",
            description = "",
            
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static boolean ignored3;
    @Number(
            title = "Adaptive Helmet",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float AdaptiveHelmet = 0f;
    @Number(
            title = "Adaptive Chestplate",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float AdaptiveChestplate = 0f;
    @Number(
            title = "Adaptive Leggings",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float AdaptiveLeggings = 0f;
    @Number(
            title = "Adaptive Boots",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float AdaptiveBoots = 0f;
    @Number(
            title = "Suspicious Vial",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SussyBaka = 0f;
    @Number(
            title = "First Master Star",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float FirstMasterStar = 0f;
    @Info(
            title = "Floor 4",
            description = "",
            
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static boolean ignored4;
    @Number(
            title = "Spirit Pet",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SpiritPet = 5000000f;
    @Number(
            title = "Spirit Bone",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SpiritBone = 2000000f;
    @Number(
            title = "Spirit Wing",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SpiritWing = 2000000f;
    @Number(
            title = "Spirit Sword",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SpiritSword = 0f;
    @Number(
            title = "Spirit Bow",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SpiritBow = 0f;
    @Number(
            title = "Spirit Boots",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SpiritBoots = 0f;
    @Number(
            title = "Spirit Stone",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SpiritStone = 0f;
    @Number(
            title = "Rend",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float Rend = 0f;
    @Number(
            title = "Second Master Star",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SecondMasterStar = 12000000f;
    @Info(
            title = "Floor 5",
            description = "",
            
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static boolean ignored5;
    @Number(
            title = "Last Breath",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float LastBreath = 0f;
    @Number(
            title = "Livid Dagger",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float LividDagger = 0f;
    @Number(
            title = "Shadow Assassin Helmet",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SaHelmet = 0f;
    @Number(
            title = "Shadow Assassin Chestplate",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SaChestplate = 0f;
    @Number(
            title = "Shadow Assassin Leggings",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SaLeggings = 0f;
    @Number(
            title = "Shadow Assassin Boots",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SaBoots = 0f;
    @Number(
            title = "Shadow Assassin Cloak",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SaCloak = 5000000f;
    @Number(
            title = "Shadow Fury",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float ShadowFury = 0f;
    @Number(
            title = "Warped Stone",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float WarpedStone = 0f;
    @Number(
            title = "Dark Orb",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float DarkOrb = 500000f;
    @Number(
            title = "Third Master Star",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float ThirdMasterStar = 0f;
    @Number(
            title = "Lethality VI",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float LethalityVI = 0f;
    @Number(
            title = "Overload",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float Overload = 0f;
    @Number(
            title = "Legion",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float Legion = 2000000f;
    @Number(
            title = "Ancient Rose",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float ancientRose = 50000f;
    @Number(
            title = "Giant Tooth",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float GiantTooth = 250000f;
    @Number(
            title = "Giant's Sword",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float GiantsSword = 150000000f;
    @Number(
            title = "Necromancer Lord Helmet",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float NecromancerLordHelmet = 0f;
    @Number(
            title = "Necromancer Lord Chestplate",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float NecromancerLordChestplate = 0f;
    @Number(
            title = "Necromancer Lord Leggings",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float NecromancerLordLeggings = 0f;
    @Number(
            title = "Necromancer Lord Boots",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float NecromancerLordBoots = 0f;
    @Number(
            title = "Necromancer Sword",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float NecromancerSword = 5000000f;
    @Number(
            title = "Summoning Ring",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SummoningRing = 10000000f;
    @Number(
            title = "Sadan's Brooch",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SadanBrooch = 0f;
    @Number(
            title = "Precursor Eye",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float PrecursorEye = 40000000f;
    @Number(
            title = "Fel Skull",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float FelSkull = 5000000f;
    @Number(
            title = "Soulweaver Gloves",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SoulweaverGloves = 6000000f;
    @Number(
            title = "Fourth Master Star",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float FourthMasterStar = 60000000f;
    @Info(
            title = "Floor 7",
            description = "",
            
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static boolean ignored7;
    @Number(
            title = "Auto Recombobulator",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float AutoRecom = 10000000f;
    @Number(
            title = "Dark Claymore",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float DarkClaymore = 150000000f;
    @Number(
            title = "Fifth Master Star",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float FifthMasterStar = 100000000f;
    @Number(
            title = "Necron Dye",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float NecronDye = 50000000f;
    @Number(
            title = "Thunderlord VII",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float ThunderLordVII = 10000000f;
    @Number(
            title = "Necron's Handle",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float NecronsThickJuicyStick = 0f;
    @Number(
            title = "Implosion",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float Implosion = 200000000f;
    @Number(
            title = "Shadow Warp",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float ShadowWarp = 200000000f;
    @Number(
            title = "Wither Shield",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float WitherShield = 200000000f;
    @Number(
            title = "Wither Blood",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float WitherBlood = 0f;
    @Number(
            title = "Wither Catalyst",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float WitherCatalyst = 0f;
    @Number(
            title = "Wither Helmet",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float WitherHelmet = 0f;
    @Number(
            title = "Wither Chestplate",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float WitherChestplate = 12000000f;
    @Number(
            title = "Wither Leggings",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float WitherLeggings = 0f;
    @Number(
            title = "Wither Boots",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float WitherBoots = 0f;
    @Number(
            title = "Wither Cloak Sword",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float WitherCloak = 0f;
    @Number(
            title = "Precursor Gear",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float PrecursorGear = 600000f;
    @Number(
            title = "Soul Eater",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float SoulEater = 1000000f;
    @Number(
            title = "One For All",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float OneForAll = 0f;
    @Number(
            title = "Goldor the Fish",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float GoldorFish = 0f;
    @Number(
            title = "Storm the Fish",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float StormFish = 0f;
    @Number(
            title = "Maxor The Fish",
            min = 0f, max = 1000000000,
            category = "Dungeons",
            subcategory = "Ironman Profit Calculator"
    )
    public static float MaxorFish = 0f;




    public static final JpaConfig INSTANCE = new JpaConfig();

    public JpaConfig() {
        super(jaquaviouspringletonaddons.MODID + ".json", jaquaviouspringletonaddons.NAME, Category.QOL);
        registerKeybind(pestKey);
        registerKeybind(pearlKey);
        registerKeybind(superboomKey);
        registerKeybind(spiritleapKey);
        hideIf("ee2Text", () ->   !includePosition);
        hideIf("ee3Text", () ->   !includePosition);
        hideIf("ee4Text", () ->   !includePosition);
        hideIf("ee2TextSS",  () ->  !includePosition || !safespots);
        hideIf("ee3TextSS",  () ->  !includePosition || !safespots);
        hideIf("midText", () ->   !includePosition);
        
        hideIf("terminalWaypointsTextS1", () -> terminalPreset != 4);
        hideIf("terminalWaypointsTextS2", () -> terminalPreset != 4);
        hideIf("terminalWaypointsTextS3", () -> terminalPreset != 4);
        hideIf("terminalWaypointsTextS4", () -> terminalPreset != 4);
        hideIf("ignored11",  () ->  terminalPreset != 4);
        hideIf("ignored12", () -> terminalPreset != 4);
        hideIf("ignored13", () -> terminalPreset != 4);
        hideIf("ignored14", () -> terminalPreset != 4);
        hideIf("mageCoring",  () ->  !(terminalPreset == 0 || terminalPreset == 2) );
        hideIf("ee2", () ->   !(terminalPreset == 0 || terminalPreset == 2));
        hideIf("I4", () -> terminalPreset == 4);
        
        addDependency("terminalWaypointsTextS1", "terminalWaypoints");
        addDependency("terminalWaypointsTextS2", "terminalWaypoints");
        addDependency("terminalWaypointsTextS3", "terminalWaypoints");
        addDependency("terminalWaypointsTextS4", "terminalWaypoints");
        addDependency("mageCoring", "terminalWaypoints");
        addDependency("ee2", "terminalWaypoints");
        addDependency("I4", "terminalWaypoints");
        addDependency("terminalPreset", "terminalWaypoints");
        addDependency("terminalWaypointsTracer", "terminalWaypoints");
        addDependency("terminalWaypointsTracerColor", "terminalWaypoints");
        addDependency("terminalWaypointsPhase", "terminalWaypoints");
        addDependency("terminalWaypointsColor", "terminalWaypoints");
        addDependency("icefillPathColor", "icefillSolver");
        addDependency("icefillEtherwarpPointColor", "icefillSolver");
        addDependency("icefillTeleportPointColor", "icefillSolver");
        addDependency("icefillSolverPhase", "icefillSolver");
        addDependency("healerWishNotificationColor", "healerWishNotification");
        addDependency("wishNotificationSize", "healerWishNotification");

        addDependency("berzmsg", "posMsgs");
        addDependency("earlyentrypositions", "posMsgs");
        addDependency("simonsayspos", "posMsgs");
        addDependency("goldorpos", "posMsgs");
        addDependency("dragonpos", "posMsgs");
        addDependency("midposmsg", "posMsgs");
        addDependency("stormposmsg", "posMsgs");
    }
}