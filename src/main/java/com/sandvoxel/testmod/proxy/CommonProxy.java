package com.sandvoxel.testmod.proxy;

import com.sandvoxel.lib.common.registry.RegistryHelper;
import com.sandvoxel.lib.common.util.logger.Logger;
import com.sandvoxel.testmod.TestMod;
import com.sandvoxel.testmod.common.blocks.Blocks;
<<<<<<< Updated upstream
import com.sandvoxel.testmod.common.blocks.TestBlock;
=======
import com.sandvoxel.testmod.common.blocks.NiggerFaggot;
import com.sandvoxel.testmod.common.blocks.TestItemBlock;
>>>>>>> Stashed changes
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

@Mod.EventBusSubscriber
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event){
        RegistryHelper.addBlockToRegistry(NiggerFaggot.class, TestItemBlock.class);

    }
    public void init(FMLInitializationEvent event){

    }
    public void postInit(FMLPostInitializationEvent event){

    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
<<<<<<< Updated upstream
        event.getRegistry().register(new TestBlock());
    }
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(Blocks.testblock).setRegistryName(Blocks.testblock.getRegistryName()));
=======

        for (Block block : RegistryHelper.getBlocks()){
            event.getRegistry().register(block);
            TestMod.logger.info(block);
        }
    }
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        for (ItemBlock itemBlock : RegistryHelper.getItems())
            event.getRegistry().register(itemBlock);
>>>>>>> Stashed changes
    }

}
