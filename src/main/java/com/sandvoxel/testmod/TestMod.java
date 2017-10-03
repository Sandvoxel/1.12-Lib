package com.sandvoxel.testmod;

import com.google.common.base.Stopwatch;
import com.sandvoxel.lib.common.util.exception.OutdatedJavaException;
import com.sandvoxel.lib.common.util.logger.Logger;
import com.sandvoxel.testmod.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.commons.lang3.JavaVersion;
import org.apache.commons.lang3.SystemUtils;

import java.util.concurrent.TimeUnit;

@Mod(modid = "test",version ="1.0")
public class TestMod {
    public static Logger logger = new Logger("testMod");

    @SidedProxy(clientSide = "com.sandvoxel.testmod.proxy.ClientProxy", serverSide = "com.sandvoxel.testmod.proxy.ServerProxy")
    public static CommonProxy proxy;




    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        final Stopwatch watch = Stopwatch.createStarted();
        logger.info("Pre Initialization ( started )");

        if (!SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_1_8)) {
            throw new OutdatedJavaException(String.format("%s requires Java 8 or newer, Please update your java", "testMod"));
        }

        proxy.preInit(event);

        logger.info("Pre Initialization ( ended after " + watch.elapsed(TimeUnit.MILLISECONDS) + "ms )");
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        final Stopwatch watch = Stopwatch.createStarted();
        logger.info("Initialization ( started )");

        proxy.init(event);

        logger.info("Initialization ( ended after " + watch.elapsed(TimeUnit.MILLISECONDS) + "ms )");
    }

    @Mod.EventHandler
    public void preInit(FMLPostInitializationEvent event){
        final Stopwatch watch = Stopwatch.createStarted();
        logger.info("Post Initialization ( started )");

        proxy.PostInit(event);

        logger.info("Post Initialization ( ended after " + watch.elapsed(TimeUnit.MILLISECONDS) + "ms )");
    }



}
