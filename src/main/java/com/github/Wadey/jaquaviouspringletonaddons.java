package com.github.Wadey;

import cc.polyfrost.oneconfig.events.event.InitializationEvent;
import cc.polyfrost.oneconfig.utils.commands.CommandManager;
import com.github.Wadey.command.jpaCommand;
import com.github.Wadey.config.jpaConfig;
import me.jpaMain.command.JPAdevMode;
import me.jpaMain.command.fsCommand;
import me.jpaMain.command.testCommand;
import me.jpaMain.dungeonfeatures.DungeonScanner.dungeonScanner;
import me.jpaMain.dungeonfeatures.iceFillSolver.iceFillSolver;
import me.jpaMain.dungeonfeatures.*;
import me.jpaMain.dungeonfeatures.profitTracker.ProfitTracker;
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
    public static final String MODID = "@ID@";
    public static final String NAME = "@NAME@";
    public static final String VERSION = "@VER@";
    @Mod.Instance(MODID)
    public static jaquaviouspringletonaddons INSTANCE; // Adds the instance of the mod, so we can access other variables.
    public static jpaConfig config;


    // Register the config and commands.
    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        config = new jpaConfig();
        CommandManager.INSTANCE.registerCommand(new jpaCommand());
        CommandManager.INSTANCE.registerCommand(new fsCommand());
        CommandManager.INSTANCE.registerCommand(new testCommand());
        CommandManager.INSTANCE.registerCommand(new JPAdevMode());
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
        MinecraftForge.EVENT_BUS.register(new milestoneReminder());
        MinecraftForge.EVENT_BUS.register(config);
    }

}

