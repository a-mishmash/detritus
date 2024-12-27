package com.github.mishmash.detritus.worldgen.density_function;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.github.mishmash.detritus.DetritusMod.MOD_ID;

public class DetritusDensityFunctions {

    public static void initialize() {
        Registry.register(Registries.DENSITY_FUNCTION_TYPE, Identifier.of(MOD_ID,"double_ridge"), DoubleRidge.CODEC.codec());
    }
}
