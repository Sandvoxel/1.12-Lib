package com.sandvoxel.testmod.proxy;

import com.sandvoxel.lib.common.registry.RegistryHelper;
import com.sandvoxel.testmod.TestMod;
import com.sandvoxel.testmod.common.blocks.TestBlock;

import com.sandvoxel.testmod.common.blocks.TestItemBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@Mod.EventBusSubscriber
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event){
        RegistryHelper.addBlockToRegistry(TestBlock.class, TestItemBlock.class);

    }
    public void init(FMLInitializationEvent event){

    }
    public void postInit(FMLPostInitializationEvent event){

    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        TestMod.logger.info(RegistryHelper.getBlocks());

        for (Block block : RegistryHelper.getBlocks()){

            event.getRegistry().register(block);
            TestMod.logger.info(block);
        }

    }
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        for (ItemBlock itemBlock : RegistryHelper.getItems())
            event.getRegistry().register(itemBlock);
    }

}
