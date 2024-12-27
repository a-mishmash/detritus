package com.github.mishmash.detritus.worldgen.feature;

import com.github.mishmash.detritus.block.DetritusBlocks;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import static com.github.mishmash.detritus.DetritusMod.MOD_ID;

public class DetritusFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> OSSIFIED_TREE_KEY = registerKey("ossified_tree");

    public static void initialize() {

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(MOD_ID, name));
    }
}
