package com.sandvoxel.lib.common.util;

import net.minecraftforge.fml.common.FMLCommonHandler;

/**
 * Created by kylekovalchick on 10/3/17.
 */
public class Platform {

    public static boolean isClient(){
        return FMLCommonHandler.instance().getEffectiveSide().isClient();
    }

    public static boolean isServer(){
        return FMLCommonHandler.instance().getEffectiveSide().isServer();

    }



}
