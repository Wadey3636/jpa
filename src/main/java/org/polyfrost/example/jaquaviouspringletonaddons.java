package org.polyfrost.example;


import me.jpaMain.command.getWorldType;
import me.jpaMain.command.resetMidDetector;
import me.jpaMain.dungeonfeatures.mapChecker;
import me.jpaMain.dungeonfeatures.midDetector;
import me.jpaMain.dungeonfeatures.positionalMessages;
import me.jpaMain.utils.locationUtils;
import net.minecraftforge.common.MinecraftForge;
import org.polyfrost.example.command.jpaCommand;
import org.polyfrost.example.config.jpaConfig;
import cc.polyfrost.oneconfig.events.event.InitializationEvent;
import net.minecraftforge.fml.common.Mod;
import cc.polyfrost.oneconfig.utils.commands.CommandManager;
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
        CommandManager.INSTANCE.registerCommand(new resetMidDetector());
        CommandManager.INSTANCE.registerCommand(new getWorldType());
        MinecraftForge.EVENT_BUS.register(new mapChecker());
        MinecraftForge.EVENT_BUS.register(new positionalMessages());
        MinecraftForge.EVENT_BUS.register(new midDetector());
        MinecraftForge.EVENT_BUS.register(new locationUtils());
    }

}

