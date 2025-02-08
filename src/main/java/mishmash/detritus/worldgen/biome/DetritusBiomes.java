package mishmash.detritus.worldgen.biome;

import mishmash.detritus.worldgen.feature.DetritusFeatures;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

import static mishmash.detritus.DetritusMod.MOD_ID;

public class DetritusBiomes {

    public static final RegistryKey<Biome> SOULSWEPT_FLATS =
            RegistryKey.of(RegistryKeys.BIOME, Identifier.of(MOD_ID, "soulswept_flats"));
    public static final RegistryKey<Biome> MEMORY_PLATEAU_FOREST =
            RegistryKey.of(RegistryKeys.BIOME, Identifier.of(MOD_ID, "memory_plateau_forest"));
    public static final RegistryKey<Biome> MEMORY_PLATEAU_PLAINS =
            RegistryKey.of(RegistryKeys.BIOME, Identifier.of(MOD_ID, "memory_plateau_plains"));

    public static void initializeBiomes(Registerable<Biome> context) {
        RegistryEntryLookup<PlacedFeature> placedFeatureLookup =
                context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        RegistryEntryLookup<ConfiguredCarver<?>> carverLookup =
                context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER);

        context.register(SOULSWEPT_FLATS, soulsweptFlats(placedFeatureLookup, carverLookup));
        context.register(MEMORY_PLATEAU_FOREST, memoryPlateauForest(placedFeatureLookup, carverLookup));
        context.register(MEMORY_PLATEAU_PLAINS, memoryPlateauPlains(placedFeatureLookup, carverLookup));
    }

    private static Biome soulsweptFlats(RegistryEntryLookup<PlacedFeature> placedFeatureLookup, RegistryEntryLookup<ConfiguredCarver<?>> carverLookup) {
        GenerationSettings.LookupBackedBuilder generationSettingsBuilder =
                new GenerationSettings.LookupBackedBuilder(placedFeatureLookup, carverLookup);

        SpawnSettings.Builder spawnSettingsBuilder = new SpawnSettings.Builder();

        return new Biome.Builder()
                .effects(new BiomeEffects.Builder()
                        .fogColor(0)
                        .foliageColor(10445890)
                        .grassColor(10445890)
                        .waterColor(0)
                        .waterFogColor(0)
                        .skyColor(0)
                        .particleConfig(new BiomeParticleConfig(ParticleTypes.ASH, 0.01f))
                        .build()
                )
                .precipitation(false)
                .temperature(1.0f)
                .downfall(0.0f)
                .spawnSettings(spawnSettingsBuilder.build())
                .generationSettings(generationSettingsBuilder.build())
                .build();
    }

    private static Biome memoryPlateauForest(RegistryEntryLookup<PlacedFeature> placedFeatureLookup, RegistryEntryLookup<ConfiguredCarver<?>> carverLookup) {
        GenerationSettings.LookupBackedBuilder generationSettingsBuilder =
                new GenerationSettings.LookupBackedBuilder(placedFeatureLookup, carverLookup);
        generationSettingsBuilder.feature(
                GenerationStep.Feature.VEGETAL_DECORATION,
                DetritusFeatures.MNEMORA_GROWTH_PLACED_KEY
        );
        generationSettingsBuilder.feature(
                GenerationStep.Feature.VEGETAL_DECORATION,
                DetritusFeatures.MNEMORA_FLATCAPS_PLACED_KEY
        );

        SpawnSettings.Builder spawnSettingsBuilder = new SpawnSettings.Builder();
        // spawnSettingsBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.WITHER_SKELETON, 2, 3, 5));

        return new Biome.Builder()
                .effects(new BiomeEffects.Builder()
                        .fogColor(0)
                        .foliageColor(10445890)
                        .grassColor(10445890)
                        .waterColor(0)
                        .waterFogColor(0)
                        .skyColor(0)
                        .particleConfig(new BiomeParticleConfig(ParticleTypes.ASH, 0.01f))
                        .build()
                )
                .precipitation(false)
                .temperature(1.0f)
                .downfall(0.0f)
                .spawnSettings(spawnSettingsBuilder.build())
                .generationSettings(generationSettingsBuilder.build())
                .build();
    }

    private static Biome memoryPlateauPlains(RegistryEntryLookup<PlacedFeature> placedFeatureLookup, RegistryEntryLookup<ConfiguredCarver<?>> carverLookup) {
        GenerationSettings.LookupBackedBuilder generationSettingsBuilder =
                new GenerationSettings.LookupBackedBuilder(placedFeatureLookup, carverLookup);
        generationSettingsBuilder.feature(
                GenerationStep.Feature.VEGETAL_DECORATION,
                DetritusFeatures.MNEMORA_FLATCAPS_PLACED_KEY
        );

        SpawnSettings.Builder spawnSettingsBuilder = new SpawnSettings.Builder();

        return new Biome.Builder()
                .effects(new BiomeEffects.Builder()
                        .fogColor(0)
                        .foliageColor(10445890)
                        .grassColor(10445890)
                        .waterColor(0)
                        .waterFogColor(0)
                        .skyColor(0)
                        .particleConfig(new BiomeParticleConfig(ParticleTypes.ASH, 0.01f))
                        .build()
                )
                .precipitation(false)
                .temperature(1.0f)
                .downfall(0.0f)
                .spawnSettings(spawnSettingsBuilder.build())
                .generationSettings(generationSettingsBuilder.build())
                .build();
    }
}
