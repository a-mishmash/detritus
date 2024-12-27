package com.github.mishmash.detritus.datagen;

import com.github.mishmash.detritus.block.DetritusBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class DetritusItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public DetritusItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.COMPLETES_FIND_TREE_TUTORIAL)
                .add(DetritusBlocks.OSSIFIED_LOG.asItem());
    }
}
