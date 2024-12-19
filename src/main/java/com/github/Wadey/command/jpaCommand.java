package com.github.Wadey.command;

import cc.polyfrost.oneconfig.utils.commands.annotations.Command;
import cc.polyfrost.oneconfig.utils.commands.annotations.Main;
import com.github.Wadey.jaquaviouspringletonaddons;

/**
 * An example command implementing the Command api of OneConfig.
 * Registered in ExampleMod.java with `CommandManager.INSTANCE.registerCommand(new ExampleCommand());`
 *
 * @see Command
 * @see Main
 * @see jaquaviouspringletonaddons
 */
@Command(value = "jpa", description = "Access the " + jaquaviouspringletonaddons.NAME + " GUI.")
public class jpaCommand {
    @Main
    private void handle() {
        jaquaviouspringletonaddons.config.openGui();
    }
}