package com.github.mishmash.detritus;

import com.github.mishmash.detritus.block.BlockRegistry;
import com.github.mishmash.detritus.density_function.DensityFunctionRegistry;
import net.fabricmc.api.ModInitializer;

public class DetritusMod implements ModInitializer {

    public static final String MOD_ID = "detritus";

    @Override
    public void onInitialize() {
        BlockRegistry.initialize();
        DensityFunctionRegistry.initialize();
    }
}
