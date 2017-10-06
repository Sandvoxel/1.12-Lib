package com.sandvoxel.testmod.common.blocks;

import com.sandvoxel.lib.common.blocks.BlockTileBace;
import com.sandvoxel.testmod.Reference;
import com.sandvoxel.testmod.common.tileentity.TestTileEntity;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class TestBlock extends BlockTileBace {

    public TestBlock() {
        super(Material.ROCK,"testblock", Reference.MODID);
        setInternalName("testblock");
        setCreativeTab(CreativeTabs.TRANSPORTATION);
        setTileEntity(TestTileEntity.class);
    }
}