package mishmash.detritus.datagen;

import mishmash.detritus.block.DetritusBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class DetritusBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public DetritusBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(DetritusBlocks.BARRSLAG);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(DetritusBlocks.OSSIFIED_LOG)
                .add(DetritusBlocks.OSSIFIED_WOOD)
                .add(DetritusBlocks.STRIPPED_OSSIFIED_LOG)
                .add(DetritusBlocks.STRIPPED_OSSIFIED_WOOD)
                .add(DetritusBlocks.OSSIFIED_PLANKS);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(DetritusBlocks.SEDIMENT);

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(DetritusBlocks.MARROW);

        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(DetritusBlocks.OSSIFIED_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(DetritusBlocks.OSSIFIED_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(DetritusBlocks.OSSIFIED_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(DetritusBlocks.OSSIFIED_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                .add(DetritusBlocks.OSSIFIED_DOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(DetritusBlocks.OSSIFIED_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                .add(DetritusBlocks.OSSIFIED_BUTTON);
        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(DetritusBlocks.OSSIFIED_PRESSURE_PLATE);

        getOrCreateTagBuilder(BlockTags.SAPLINGS)
                .add(DetritusBlocks.OSSIFIED_SAPLING);
    }
}
