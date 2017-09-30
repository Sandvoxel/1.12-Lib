package com.example.examplemod;

import com.example.examplemod.util.exception.OutdatedJavaException;
import com.example.examplemod.util.logger.Logger;
import com.google.common.base.Stopwatch;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.commons.lang3.JavaVersion;
import org.apache.commons.lang3.SystemUtils;

import java.util.concurrent.TimeUnit;

@Mod(modid = Refrence.MODID, version = Refrence.VERSION)
public class ExampleMod
{
    Logger logger = new Logger(Refrence.MOD_NAME);

    
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
        // some example code
        System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());
    }
    @EventHandler
    public void preInit(FMLPostInitializationEvent event){

    }
}
