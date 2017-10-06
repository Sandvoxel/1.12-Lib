package com.sandvoxel.lib.common.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by kylekovalchick on 10/6/17.
 */
public class InternalInventory implements IInventory, Iterable<ItemStack> {

    protected NonNullList<ItemStack> itemStacks = NonNullList.create();
    protected int size;
    protected int maxsize = 0;
    public final ItemStack[] inventory;

    public InternalInventory(int size) {
        this.size = size;
        this.inventory = new ItemStack[size];
        this.maxsize = 64;

    }

    @Override
    public boolean isEmpty(){
        for (int i = 0; i < this.size; i++){
            if(this.getStackInSlot(i) != ItemStack.EMPTY)
                return false;
        }
        return true;

    }


    @Override
    public Iterator<ItemStack> iterator() {
        return new InventoryIterable(this,maxsize);
    }

    @Override
    public int getSizeInventory() {
        return this.size;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return this.inventory[index];
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        return null;
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {

    }

    @Override
    public int getInventoryStackLimit() {
        return this.maxsize > 64 ? 64 : this.maxsize;
    }

    @Override
    public void markDirty() {

    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player) {
        return true;
    }

    @Override
    public void openInventory(EntityPlayer player) {

    }

    @Override
    public void closeInventory(EntityPlayer player) {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return true;
    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) {

    }

    public void setMaxsize(int maxsize) {
        this.maxsize = maxsize;
    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public String getName() {
        return "internal";
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public ITextComponent getDisplayName() {
        return null;
    }
}
