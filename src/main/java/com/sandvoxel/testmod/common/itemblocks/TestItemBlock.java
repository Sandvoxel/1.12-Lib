package com.sandvoxel.testmod.common.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;


public class TestItemBlock extends ItemBlock {
    public TestItemBlock(Block block) {
        super(block);
        this.setMaxDamage(0);
    }
}
