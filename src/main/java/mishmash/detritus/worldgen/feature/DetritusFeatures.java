package mishmash.detritus.worldgen.feature;

import mishmash.detritus.block.DetritusBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;

import java.util.List;

import static mishmash.detritus.DetritusMod.MOD_ID;

public class DetritusFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> OSSIFIED_TREE_KEY = registerKeyConfigured("ossified_tree");
    public static final RegistryKey<PlacedFeature> OSSIFIED_TREE_PLACED_KEY = registerKeyPlaced("ossified_tree_placed");

    public static void initializeConfiguredFeatures(Registerable<ConfiguredFeature<?, ?>> context) {

        TreeFeatureConfig config = new TreeFeatureConfig.Builder(
                BlockStateProvider.of(DetritusBlocks.OSSIFIED_LOG),
                new ForkingTrunkPlacer(2, 3, 5),
                BlockStateProvider.of(DetritusBlocks.MARROW),
                new BlobFoliagePlacer(
                        UniformIntProvider.create(3, 4),
                        ConstantIntProvider.create(0),
                        0
                ),
                new TwoLayersFeatureSize(1, 0, 1)
        ).dirtProvider(BlockStateProvider.of(DetritusBlocks.BARRSLAG)).build();

        context.register(OSSIFIED_TREE_KEY, new ConfiguredFeature<>(Feature.TREE, config));
    }

    public static void initializePlacedFeatures(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        context.register(
                OSSIFIED_TREE_PLACED_KEY,
                new PlacedFeature(
                    configuredFeatures.getOrThrow(OSSIFIED_TREE_KEY),
                    VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                            PlacedFeatures.createCountExtraModifier(22, 0.1f, 2),
                            DetritusBlocks.OSSIFIED_SAPLING
                    )
                )
        );
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKeyConfigured(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(MOD_ID, name));
    }

    public static RegistryKey<PlacedFeature> registerKeyPlaced(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MOD_ID, name));
    }
}
