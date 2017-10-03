package com.sandvoxel.testmod.common.blocks;

import com.sandvoxel.lib.API.util.IBlockRender;
import com.sandvoxel.lib.common.blocks.BlockBase;
import com.sandvoxel.testmod.Reference;
import com.sandvoxel.testmod.TestMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TestBlock extends BlockBase{

    public TestBlock() {
        super(Material.ROCK,"", Reference.MODID);
        setInternalName("testblock");
        setCreativeTab(CreativeTabs.TRANSPORTATION);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }


}