package com.github.mishmash.detritus;

import com.github.mishmash.detritus.datagen.DetritusBlockTagProvider;
import com.github.mishmash.detritus.datagen.DetritusItemTagProvider;
import com.github.mishmash.detritus.datagen.DetritusLootTableProvider;
import com.github.mishmash.detritus.datagen.DetritusModelProvider;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

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
    }
}
