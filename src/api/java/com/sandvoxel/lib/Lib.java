package com.sandvoxel.lib;

import com.sandvoxel.lib.common.commands.CommandTPS;
import com.sandvoxel.lib.common.commands.CommandWithSubCommands;
import com.sandvoxel.lib.common.util.exception.OutdatedJavaException;
import com.sandvoxel.lib.common.util.logger.Logger;
import com.google.common.base.Stopwatch;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.*;
import org.apache.commons.lang3.JavaVersion;
import org.apache.commons.lang3.SystemUtils;

import java.util.concurrent.TimeUnit;

@Mod(modid = Refrence.MODID, version = Refrence.VERSION)
public class Lib {
    public static Logger LOGGER = new Logger(Refrence.MOD_NAME);

    public static Stopwatch STOPWATCH = Stopwatch.createUnstarted();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        STOPWATCH.start();
        LOGGER.info("Pre-Initialization - Started");

        if (!SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_1_8)) {
            throw new OutdatedJavaException(String.format("%s requires Java 8 or newer, Please update your java", Refrence.MOD_NAME));
        }

        LOGGER.info("Pre-Initialization - Finished - " + STOPWATCH.elapsed(TimeUnit.MILLISECONDS) + "ms");
        STOPWATCH.reset();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        STOPWATCH.start();
        LOGGER.info("Initialization - Started");

        LOGGER.info("Initialization - Finished - " + STOPWATCH.elapsed(TimeUnit.MILLISECONDS) + "ms");
        STOPWATCH.reset();
    }

    @EventHandler
    public void preInit(FMLPostInitializationEvent event) {
        STOPWATCH.start();
        LOGGER.info("Post-Initialization - Started");

        LOGGER.info("Post-Initialization - Finished - " + STOPWATCH.elapsed(TimeUnit.MILLISECONDS) + "ms");
        STOPWATCH.reset();
    }

    @EventHandler
    public void onServerStartup(FMLServerStartingEvent event) {
        CommandWithSubCommands command = new CommandWithSubCommands();
        command.addSubCommand(new CommandTPS());
        event.registerServerCommand(command);

    }
}
