package com.sandvoxel.lib.common.blocks;

import com.sandvoxel.lib.API.util.IBlockRender;
import com.sandvoxel.lib.Lib;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class BlockBase extends Block implements IBlockRender {

   protected final String modid;
   protected String resourcePath;
   protected String internalName = "";

    public BlockBase(Material blockMaterialIn, String resourcePath, String modid) {
        super(blockMaterialIn);
        this.resourcePath = resourcePath;
        this.modid = modid;
    }

    public String getInternalName(){
        return internalName;
    }

    public void setInternalName(String internalName){
        this.internalName = internalName;
    }

    @Override
    public String getUnlocalizedName() {
        String blockName = getUnwrappedUnlocalizedName(super.getUnlocalizedName());

        return String.format("tile.%s.%s", modid, blockName);
    }

    private String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @Override
    public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest) {
        return willHarvest || super.removedByPlayer(state, world, pos, player, false);
    }

    @Override
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack) {
        super.harvestBlock(worldIn, player, pos, state, te, stack);
        worldIn.setBlockToAir(pos);
    }


    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockRenderer() {
        
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockItemRenderer() {

    }
}
