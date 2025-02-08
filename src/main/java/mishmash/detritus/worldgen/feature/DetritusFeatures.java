package mishmash.detritus.worldgen.feature;

import mishmash.detritus.block.DetritusBlocks;
import mishmash.detritus.block.MnemoraFlatcapsBlock;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.treedecorator.AttachedToLeavesTreeDecorator;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;

import java.util.Collections;

import static mishmash.detritus.DetritusMod.MOD_ID;

public class DetritusFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> MNEMORA_GROWTH_KEY = registerKeyConfigured("mnemora_growth");
    public static final RegistryKey<PlacedFeature> MNEMORA_GROWTH_PLACED_KEY = registerKeyPlaced("mnemora_growth");

    public static final RegistryKey<ConfiguredFeature<?, ?>> MNEMORA_FLATCAPS_KEY = registerKeyConfigured("mnemora_flatcaps");
    public static final RegistryKey<PlacedFeature> MNEMORA_FLATCAPS_PLACED_KEY = registerKeyPlaced("mnemora_flatcaps");

    public static void initializeConfiguredFeatures(Registerable<ConfiguredFeature<?, ?>> context) {

        // Mnemora Growth
        TreeFeatureConfig mnemoraGrowthConfig = new TreeFeatureConfig.Builder(
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
        context.register(MNEMORA_GROWTH_KEY, new ConfiguredFeature<>(Feature.TREE, mnemoraGrowthConfig));

        DataPool.Builder<BlockState> builder = DataPool.builder();
        for (int i = 1; i <= 4; i++) {
            for (Direction direction : Direction.Type.HORIZONTAL) {
                builder.add(DetritusBlocks.MNEMORA_FLATCAPS.getDefaultState()
                        .with(MnemoraFlatcapsBlock.MUSHROOM_AMOUNT, i)
                        .with(MnemoraFlatcapsBlock.FACING, direction), 1);
            }
        }
        RandomPatchFeatureConfig mnemoraFlatcapsConfig = new RandomPatchFeatureConfig(
                96, 6, 2, PlacedFeatures.createEntry(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(builder)))
        );
        context.register(MNEMORA_FLATCAPS_KEY, new ConfiguredFeature<>(Feature.RANDOM_PATCH, mnemoraFlatcapsConfig));
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

        context.register(
                MNEMORA_FLATCAPS_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(MNEMORA_FLATCAPS_KEY),
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
