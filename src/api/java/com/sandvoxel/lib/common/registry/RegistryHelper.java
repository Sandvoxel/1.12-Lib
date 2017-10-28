package com.sandvoxel.lib.common.registry;


import com.sandvoxel.lib.API.util.IBlockRender;
import com.sandvoxel.lib.Lib;
import com.sandvoxel.lib.common.blocks.BlockBase;
import com.sandvoxel.lib.common.util.Platform;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RegistryHelper {

    public static List<Block> blocks = new ArrayList<>();
    public static List<ItemBlock> items = new ArrayList<>();

    public static void addBlockToRegistry(String modid ,Class<? extends Block> blockClass, Class<? extends ItemBlock> itemBlockClass){
        Block block;
        ItemBlock itemBlock;
        String internalName;

        try {
            block = blockClass.getConstructor().newInstance();
            itemBlock = itemBlockClass.getConstructor(Block.class).newInstance(block);

            internalName = ((BlockBase) block).getInternalName();

            if (!internalName.equals(internalName.toLowerCase(Locale.US)))
                throw new IllegalArgumentException(String.format("InternalName names need to be all lowercase! Item: %s", internalName));

            if (internalName.isEmpty())
                throw new IllegalArgumentException(String.format("InternalName name cannot be blank! Item: %s", blockClass.getCanonicalName()));


            block.setRegistryName(modid,internalName);
            block.setUnlocalizedName(internalName);
            itemBlock.setRegistryName(block.getRegistryName());

            blocks.add(block);
            items.add(itemBlock);


            if (block instanceof IBlockRender && Platform.isClient()){
                ((IBlockRender) block).registerBlockRenderer();
                ((IBlockRender) block).registerBlockItemRenderer();
            }




        }catch (Exception e){
            Lib.LOGGER.info(String.format("Block %s has had a error : %s",blockClass.getCanonicalName(),e) );

        }




    }

    public static List<Block> getBlocks() {
        return blocks;
    }

    public static List<ItemBlock> getItems() {
        return items;
    }
}
