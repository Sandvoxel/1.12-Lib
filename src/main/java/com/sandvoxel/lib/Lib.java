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
public class Lib
{
    public static Logger logger = new Logger(Refrence.MOD_NAME);

    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        final Stopwatch watch = Stopwatch.createStarted();
        logger.info("Pre Initialization ( started )");

        if (!SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_1_8)) {
            throw new OutdatedJavaException(String.format("%s requires Java 8 or newer, Please update your java", Refrence.MOD_NAME));
        }

        logger.info("Pre Initialization ( ended after " + watch.elapsed(TimeUnit.MILLISECONDS) + "ms )");
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        final Stopwatch watch = Stopwatch.createStarted();
        logger.info("Initialization ( started )");

        logger.info("Initialization ( ended after " + watch.elapsed(TimeUnit.MILLISECONDS) + "ms )");
    }

    @EventHandler
    public void preInit(FMLPostInitializationEvent event){
        final Stopwatch watch = Stopwatch.createStarted();
        logger.info("Post Initialization ( started )");

        logger.info("Post Initialization ( ended after " + watch.elapsed(TimeUnit.MILLISECONDS) + "ms )");
    }

    @EventHandler
    public void onServerStartup(FMLServerStartingEvent event){
        CommandWithSubCommands command = new CommandWithSubCommands();
        command.addSubCommand(new CommandTPS());
        event.registerServerCommand(command);

    }
}
