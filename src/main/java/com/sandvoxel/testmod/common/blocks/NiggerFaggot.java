package com.sandvoxel.testmod.common.blocks;

import com.sandvoxel.testmod.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class NiggerFaggot extends Block {

    public NiggerFaggot() {
        super(Material.ROCK);
        setCreativeTab(CreativeTabs.TRANSPORTATION);
        setUnlocalizedName(Reference.MODID + ".niggerfaggot");
        setRegistryName("niggerfaggot");
    }
}