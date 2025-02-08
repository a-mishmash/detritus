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
                .add(DetritusBlocks.SLAG)
                .add(DetritusBlocks.BARRSLAG);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(DetritusBlocks.MNEMORA_CHINE)
                .add(DetritusBlocks.MNEMORA_SCOLIOTIC)
                .add(DetritusBlocks.MNEMORA_MARROW)
                .add(DetritusBlocks.MNEMORA_PLANKS);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(DetritusBlocks.SEDIMENT);

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(DetritusBlocks.MNEMORA_POLYPORE);

        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(DetritusBlocks.MNEMORA_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(DetritusBlocks.MNEMORA_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(DetritusBlocks.MNEMORA_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(DetritusBlocks.MNEMORA_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                .add(DetritusBlocks.MNEMORA_DOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(DetritusBlocks.MNEMORA_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                .add(DetritusBlocks.MNEMORA_BUTTON);
        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(DetritusBlocks.MNEMORA_PRESSURE_PLATE);

        getOrCreateTagBuilder(BlockTags.SAPLINGS)
                .add(DetritusBlocks.MNEMORA_FLATCAPS);
    }
}
