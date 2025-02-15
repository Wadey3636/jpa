package com.github.Wadey.command;


import com.github.Wadey.config.jpaConfig;
import com.github.Wadey.jaquaviouspringletonaddons;
import org.polyfrost.oneconfig.api.commands.v1.factories.annotated.Command;
import org.polyfrost.oneconfig.utils.v1.dsl.ScreensKt;

/**
 * An example command implementing the Command api of OneConfig.
 * Registered in ExampleMod.java with `CommandManager.INSTANCE.registerCommand(new ExampleCommand());`
 *
 * @see Command
 * @see jaquaviouspringletonaddons
 */
@Command(value = "jpa", description = "Access the " + jaquaviouspringletonaddons.NAME + " GUI.")
public class jpaCommand {
    @Command
    private void handle() {
        ScreensKt.openUI(jpaConfig.INSTANCE);
    }
}