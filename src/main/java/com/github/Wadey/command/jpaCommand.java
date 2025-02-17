package com.github.Wadey.command;


import com.github.Wadey.config.JpaConfig;
import com.github.Wadey.jaquaviouspringletonaddons;
import org.polyfrost.oneconfig.api.commands.v1.factories.annotated.Command;
import org.polyfrost.oneconfig.utils.v1.dsl.ScreensKt;


@Command(value = "jpa", description = "Access the " + jaquaviouspringletonaddons.NAME + " GUI.")
public class jpaCommand {
    @Command
    private void handle() {
        ScreensKt.openUI(JpaConfig.INSTANCE);
    }
}