package mishmash.detritus;

import mishmash.detritus.datagen.*;
import mishmash.detritus.datagen.*;
import mishmash.detritus.worldgen.biome.DetritusBiomes;
import mishmash.detritus.worldgen.feature.DetritusFeatures;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

@Environment(EnvType.CLIENT)
public class DetritusDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(DetritusBlockTagProvider::new);
        pack.addProvider(DetritusItemTagProvider::new);
        pack.addProvider(DetritusLootTableProvider::new);
        pack.addProvider(DetritusModelProvider::new);
        // pack.addProvider(DetritusRecipeProvider::new);
        pack.addProvider(DetritusRegistryProvider::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder
                .addRegistry(RegistryKeys.BIOME, DetritusBiomes::initializeBiomes)
                .addRegistry(RegistryKeys.CONFIGURED_FEATURE, DetritusFeatures::initializeConfiguredFeatures)
                .addRegistry(RegistryKeys.PLACED_FEATURE, DetritusFeatures::initializePlacedFeatures);
    }
}
