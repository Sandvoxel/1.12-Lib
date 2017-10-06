package com.sandvoxel.lib.common.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

import java.util.Iterator;

/**
 * Created by kylekovalchick on 10/6/17.
 */
public class InventoryIterable implements Iterator<ItemStack> {
    final IInventory iInventory;
    final int size;

    int i = 0;

    public InventoryIterable(IInventory iInventory, int size) {
        this.iInventory = iInventory;
        this.size = size;
    }


    @Override
    public boolean hasNext() {
        return this.i < this.size;
    }

    @Override
    public ItemStack next() {
        ItemStack result = this.iInventory.getStackInSlot(this.i);
        this.i++;
        return result;
    }

    @Override
    public void remove() {
        throw new RuntimeException("You cant to that");
    }
}
