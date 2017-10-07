package com.sandvoxel.lib.API.inventory;

import com.sandvoxel.lib.common.inventory.InventoryOperation;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public interface IInventoryHandler {
    void saveChanges();

    void onChangeInventory(IInventory inv, int slot, InventoryOperation inventoryOperation, ItemStack removedStack, ItemStack newStack);
}
