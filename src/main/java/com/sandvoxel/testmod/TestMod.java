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

@Mod(modid = Reference.MODID, version = Reference.VERSION, name = Reference.MOD_NAME)
public class TestMod {

    @SidedProxy(clientSide = "com.sandvoxel.testmod.proxy.ClientProxy", serverSide = "com.sandvoxel.testmod.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static TestMod instance;
    public static Logger logger = new Logger(Reference.MODID);

    public void preInit(FMLPreInitializationEvent event){
        final Stopwatch watch = Stopwatch.createStarted();
        logger.info("Pre Initialization - Started");

        if (!SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_1_8)) {
            throw new OutdatedJavaException(String.format("%s requires Java 8 or newer, Please update your java", "testMod"));
        }

        proxy.preInit(event);

        logger.info("Pre Initialization - Finished - " + watch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        final Stopwatch watch = Stopwatch.createStarted();
        logger.info("Initialization - Started");

        proxy.init(event);

        logger.info("Initialization - Finished - " + watch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Mod.EventHandler
    public void preInit(FMLPostInitializationEvent event){
        final Stopwatch watch = Stopwatch.createStarted();
        logger.info("Post Initialization - Started");

        proxy.postInit(event);

        logger.info("Post Initialization - Finished - " + watch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }



}
