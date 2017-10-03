package com.sandvoxel.testmod.common.blocks;

import com.sandvoxel.testmod.Reference;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Blocks {
    @GameRegistry.ObjectHolder(Reference.MODID + ":testblock")
    public static TestBlock testblock;
}
