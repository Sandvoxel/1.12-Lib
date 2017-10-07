package com.sandvoxel.testmod.common.tileentity;

import com.sandvoxel.lib.API.inventory.IInventoryHandler;
import com.sandvoxel.lib.common.inventory.InternalInventory;
import com.sandvoxel.lib.common.inventory.InventoryOperation;
import com.sandvoxel.lib.common.tileentitys.TileInventoryBace;
import com.sandvoxel.testmod.TestMod;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

/**
 * Created by kylekovalchick on 10/3/17.
 */
public class TestTileEntity extends TileInventoryBace implements ITickable {
    public IInventory inventory = new InternalInventory(this,4);

    @Override
    public void update() {
        TestMod.logger.info(inventory.getStackInSlot(0));
    }

    @Override
    public IInventory getInternalInventory() {
        return this.inventory;
    }

    @Override
    public void onChangeInventory(IInventory inv, int slot, InventoryOperation inventoryOperation, ItemStack removedStack, ItemStack newStack) {

    }

    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        int[] slots = new int[1];
        slots[0] = 0;
        return slots;
    }

    @Override
    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
        return true;
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
        return true;
    }
}
