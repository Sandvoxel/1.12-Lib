package com.sandvoxel.lib.common.util;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventoryHelper {
    public static ItemStack addItemStackToInventory(ItemStack itemIn, IInventory inventory, int slotStart, int slotEnd) {
        return addItemStackToInventory(itemIn, inventory, slotStart, slotEnd, false);
    }

    public static ItemStack addItemStackToInventory(ItemStack itemIn, IInventory inventory, int slotStart, int slotEnd, boolean simulate) {
        if (itemIn == ItemStack.EMPTY) return ItemStack.EMPTY;
        ItemStack itemOut = itemIn.copy();

        for (int i = slotStart; i <= slotEnd; i++) {

            ItemStack slotItemStack = ItemStack.areItemsEqual(inventory.getStackInSlot(i), ItemStack.EMPTY) ? ItemStack.EMPTY : inventory.getStackInSlot(i).copy();
            if (itemOut == ItemStack.EMPTY) return ItemStack.EMPTY;

            if (ItemStack.areItemStacksEqual(slotItemStack , ItemStack.EMPTY)) {

                if (!simulate) inventory.setInventorySlotContents(i, itemOut);
                return ItemStack.EMPTY;
            }

            if (!(ItemStack.areItemsEqual(itemOut, slotItemStack))) continue;

            if (slotItemStack.getCount() == slotItemStack.getMaxStackSize()) continue;

            if (itemOut.getCount() + slotItemStack.getCount() >= slotItemStack.getMaxStackSize()) {
                int sizeRemaining = slotItemStack.getMaxStackSize() - slotItemStack.getCount();
                itemOut.shrink(sizeRemaining);
                if (!simulate) slotItemStack.grow(sizeRemaining);
                if (!simulate) inventory.setInventorySlotContents(i, slotItemStack);
                if (itemOut.getCount() == 0) itemOut = ItemStack.EMPTY;
                continue;
            }

            slotItemStack.grow(itemOut.getCount());
            itemOut = ItemStack.EMPTY;
            if (!simulate) inventory.setInventorySlotContents(i, slotItemStack);
            break;
        }

        if (itemOut != ItemStack.EMPTY)
            return itemOut;

        return ItemStack.EMPTY;
    }
}
