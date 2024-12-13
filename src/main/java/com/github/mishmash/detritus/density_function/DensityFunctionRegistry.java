package com.github.mishmash.detritus.density_function;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.github.mishmash.detritus.DetritusMod.MOD_ID;

public class DensityFunctionRegistry {

    public static void initialize() {
        Registry.register(Registries.DENSITY_FUNCTION_TYPE, Identifier.of(MOD_ID,"double_ridge"), DoubleRidge.CODEC.codec());
        Registry.register(Registries.DENSITY_FUNCTION_TYPE, Identifier.of(MOD_ID,"multi_noise_route"), MultiNoiseRoute.CODEC.codec());
    }
}
