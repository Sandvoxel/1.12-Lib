package com.sandvoxel.testmod.common.tileentity;

import com.sandvoxel.testmod.TestMod;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

/**
 * Created by kylekovalchick on 10/3/17.
 */
public class TestTileEntity extends TileEntity implements ITickable {
    @Override
    public void update() {
        TestMod.logger.info("meme");
    }
}
