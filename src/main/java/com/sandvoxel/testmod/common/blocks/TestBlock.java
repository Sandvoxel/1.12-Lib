package com.sandvoxel.testmod.common.blocks;

import com.sandvoxel.lib.common.blocks.BlockBase;
import com.sandvoxel.testmod.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class TestBlock extends BlockBase {

    public TestBlock() {
        super(Material.ROCK,"testblock", Reference.MODID);
        setInternalName("testblock");
        setCreativeTab(CreativeTabs.TRANSPORTATION);
    }
}