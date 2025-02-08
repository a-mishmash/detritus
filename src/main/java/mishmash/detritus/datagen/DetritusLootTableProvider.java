package mishmash.detritus.datagen;

import mishmash.detritus.block.DetritusBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class DetritusLootTableProvider extends FabricBlockLootTableProvider {

    public DetritusLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(DetritusBlocks.SLAG);
        addDrop(DetritusBlocks.BARRSLAG);
        addDrop(DetritusBlocks.SEDIMENT);

        addDrop(DetritusBlocks.MNEMORA_CHINE);
        addDrop(DetritusBlocks.MNEMORA_SCOLIOTIC);
        addDrop(DetritusBlocks.MNEMORA_MARROW);
        addDrop(DetritusBlocks.MNEMORA_PLANKS);
        addDrop(DetritusBlocks.MNEMORA_STAIRS);
        addDrop(DetritusBlocks.MNEMORA_SLAB, slabDrops(DetritusBlocks.MNEMORA_SLAB));
        addDrop(DetritusBlocks.MNEMORA_DOOR, doorDrops(DetritusBlocks.MNEMORA_DOOR));
        addDrop(DetritusBlocks.MNEMORA_TRAPDOOR);
        addDrop(DetritusBlocks.MNEMORA_BUTTON);
        addDrop(DetritusBlocks.MNEMORA_PRESSURE_PLATE);
        addDrop(DetritusBlocks.MNEMORA_FENCE);
        addDrop(DetritusBlocks.MNEMORA_FENCE_GATE);

        addDrop(DetritusBlocks.MNEMORA_POLYPORE);
        addDrop(DetritusBlocks.LIMBER_MARROW);
        addDrop(DetritusBlocks.LIMBER_MARROW_PLANT, DetritusBlocks.LIMBER_MARROW);
        addDrop(DetritusBlocks.MNEMORA_FLATCAPS);
    }
}
