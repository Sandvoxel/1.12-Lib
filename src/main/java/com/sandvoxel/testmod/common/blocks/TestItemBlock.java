package com.sandvoxel.testmod.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

/**
 * Created by kylekovalchick on 10/3/17.
 */
public class TestItemBlock extends ItemBlock {
    public TestItemBlock(Block block) {
        super(block);
        this.setMaxDamage(0);
        setRegistryName("wdawdawdad");
    }
}
