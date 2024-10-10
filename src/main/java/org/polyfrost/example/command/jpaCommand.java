package org.polyfrost.example.command;

import org.polyfrost.example.jaquaviouspringletonaddons;
import cc.polyfrost.oneconfig.utils.commands.annotations.Command;
import cc.polyfrost.oneconfig.utils.commands.annotations.Main;
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
        jaquaviouspringletonaddons.INSTANCE.config.openGui();
    }
}