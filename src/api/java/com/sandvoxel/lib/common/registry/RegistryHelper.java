package com.sandvoxel.lib.common.registry;


import com.sandvoxel.lib.Lib;
import com.sandvoxel.lib.common.blocks.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import java.util.ArrayList;
import java.util.List;

public class RegistryHelper {

    public static List<Block> blocks = new ArrayList<>();
    public static List<ItemBlock> items = new ArrayList<>();

    public static void addBlockToRegistry(Class<? extends Block> blockClass, Class<? extends ItemBlock> itemBlockClass){
        Block block = null;
        ItemBlock itemBlock;
        Lib.LOGGER.info("this is the reg");

        try {
            block = blockClass.getConstructor().newInstance();
            itemBlock = itemBlockClass.getConstructor(Block.class).newInstance(block);
            blocks.add(block);
            items.add(itemBlock);


        }catch (Exception e){
            Lib.LOGGER.info("this is the reg"+ e );

        }

    }

    public static List<Block> getBlocks() {
        return blocks;
    }

    public static List<ItemBlock> getItems() {
        return items;
    }
}
