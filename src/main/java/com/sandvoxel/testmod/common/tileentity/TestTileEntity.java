package com.sandvoxel.testmod.common.tileentity;

import com.sandvoxel.lib.common.inventory.InternalInventory;
import com.sandvoxel.lib.common.tileentitys.TileInventoryBace;
import com.sandvoxel.testmod.TestMod;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

/**
 * Created by kylekovalchick on 10/3/17.
 */
public class TestTileEntity extends TileInventoryBace implements ITickable {
    IInventory inventory = new InternalInventory(4);

    @Override
    public void update() {
        TestMod.logger.info(inventory.getStackInSlot(0));
    }

    @Override
    public IInventory getInternalInventory() {
        return null;
    }
}
