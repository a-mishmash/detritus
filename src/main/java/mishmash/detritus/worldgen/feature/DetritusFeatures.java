package mishmash.detritus.worldgen.feature;

import com.mojang.serialization.codecs.DispatchedMapCodec;
import mishmash.detritus.block.DetritusBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.AttachedToLeavesTreeDecorator;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;

import java.util.Collections;
import java.util.List;

import static mishmash.detritus.DetritusMod.MOD_ID;

public class DetritusFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> MNEMORA_GROWTH_KEY = registerKeyConfigured("mnemora_growth");
    public static final RegistryKey<PlacedFeature> MNEMORA_GROWTH_PLACED_KEY = registerKeyPlaced("mnemora_growth");

    public static void initializeConfiguredFeatures(Registerable<ConfiguredFeature<?, ?>> context) {

        // Mnemora Growth
        TreeFeatureConfig config = new TreeFeatureConfig.Builder(
                BlockStateProvider.of(DetritusBlocks.MNEMORA_CHINE),
                new ForkingTrunkPlacer(2, 3, 5),
                BlockStateProvider.of(DetritusBlocks.MNEMORA_POLYPORE),
                new BlobFoliagePlacer(
                        UniformIntProvider.create(3, 4),
                        ConstantIntProvider.create(0),
                        0
                ),
                new TwoLayersFeatureSize(1, 0, 1)
        )
                .dirtProvider(BlockStateProvider.of(DetritusBlocks.SLAG))
                .decorators(Collections.singletonList(new AttachedToLeavesTreeDecorator(
                        1f, 1, 3,
                        BlockStateProvider.of(DetritusBlocks.LIMBER_MARROW),
                        2,
                        Collections.singletonList(Direction.DOWN)
                )))
                .build();
        context.register(MNEMORA_GROWTH_KEY, new ConfiguredFeature<>(Feature.TREE, config));
    }

    public static void initializePlacedFeatures(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        context.register(
                MNEMORA_GROWTH_PLACED_KEY,
                new PlacedFeature(
                    configuredFeatures.getOrThrow(MNEMORA_GROWTH_KEY),
                    VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                            PlacedFeatures.createCountExtraModifier(32, 0.1f, 2),
                            DetritusBlocks.MNEMORA_FLATCAPS
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
