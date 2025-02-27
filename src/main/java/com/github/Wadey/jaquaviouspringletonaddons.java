package com.github.Wadey;

import com.github.Wadey.config.JpaConfig;
import org.polyfrost.oneconfig.api.commands.v1.CommandManager;
import org.polyfrost.oneconfig.api.event.v1.events.InitializationEvent;
import me.jpaMain.command.floorCommands.*;
import com.github.Wadey.command.jpaCommand;
import me.jpaMain.command.JPAdevMode;
import me.jpaMain.command.fsCommand;
import me.jpaMain.command.testCommand;
import me.jpaMain.dungeonfeatures.dungeonScanner.dungeonScanner;
import me.jpaMain.dungeonfeatures.iceFillSolver.iceFillSolver;
import me.jpaMain.dungeonfeatures.*;
import me.jpaMain.dungeonfeatures.ProfitTracker;
import me.jpaMain.events.fireEvents;
import me.jpaMain.utils.dungeonUtils;
import me.jpaMain.utils.locationUtils;
import me.jpaMain.utils.titleUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/**
 * The entrypoint of the Example Mod that initializes it.
 *
 * @see Mod
 * @see InitializationEvent
 */
@Mod(modid = jaquaviouspringletonaddons.MODID, name = jaquaviouspringletonaddons.NAME, version = jaquaviouspringletonaddons.VERSION)
public class jaquaviouspringletonaddons {

    // Sets the variables from `gradle.properties`. See the `blossom` config in `build.gradle.kts`.
    public static final String MODID = "@MOD_ID@";
    public static final String NAME = "@MOD_NAME@";
    public static final String VERSION = "@MOD_VERSION@";
    @Mod.Instance(MODID)
    public static jaquaviouspringletonaddons INSTANCE; // Adds the instance of the mod, so we can access other variables.



    // Register the config and commands.
    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        JpaConfig.INSTANCE.preload();
        CommandManager.registerCommand(new jpaCommand());
        CommandManager.registerCommand(new fsCommand());
        CommandManager.registerCommand(new testCommand());
        CommandManager.registerCommand(new JPAdevMode());
        CommandManager.registerCommand(new floorSeven());
        CommandManager.registerCommand(new floorSix());
        CommandManager.registerCommand(new floorFive());
        CommandManager.registerCommand(new floorFour());
        CommandManager.registerCommand(new floorThree());
        CommandManager.registerCommand(new floorTwo());
        CommandManager.registerCommand(new floorOne());
        CommandManager.registerCommand(new masterFloorSeven());
        CommandManager.registerCommand(new masterFloorSix());
        CommandManager.registerCommand(new masterFloorFive());
        CommandManager.registerCommand(new masterFloorFour());
        CommandManager.registerCommand(new masterFloorThree());
        CommandManager.registerCommand(new masterFloorTwo());
        CommandManager.registerCommand(new masterFloorOne());
        MinecraftForge.EVENT_BUS.register(new terminalWaypoints());
        MinecraftForge.EVENT_BUS.register(new dungeonScanner());
        MinecraftForge.EVENT_BUS.register(new p3StartTimer());
        MinecraftForge.EVENT_BUS.register(new positionalMessages());
        MinecraftForge.EVENT_BUS.register(new positionDetectors());
        MinecraftForge.EVENT_BUS.register(new locationUtils());
        MinecraftForge.EVENT_BUS.register(new dungeonUtils());
        MinecraftForge.EVENT_BUS.register(new padTimer());
        MinecraftForge.EVENT_BUS.register(new fireEvents());
        MinecraftForge.EVENT_BUS.register(new iceFillSolver());
        MinecraftForge.EVENT_BUS.register(new wishNotification());
        MinecraftForge.EVENT_BUS.register(new ProfitTracker());
        MinecraftForge.EVENT_BUS.register(new titleUtils());
    }

}


