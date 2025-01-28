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
        addDrop(DetritusBlocks.BARRSLAG);
        addDrop(DetritusBlocks.SEDIMENT);

        addDrop(DetritusBlocks.OSSIFIED_LOG);
        addDrop(DetritusBlocks.OSSIFIED_WOOD);
        addDrop(DetritusBlocks.STRIPPED_OSSIFIED_LOG);
        addDrop(DetritusBlocks.STRIPPED_OSSIFIED_WOOD);
        addDrop(DetritusBlocks.OSSIFIED_PLANKS);
        addDrop(DetritusBlocks.OSSIFIED_STAIRS);
        addDrop(DetritusBlocks.OSSIFIED_SLAB, slabDrops(DetritusBlocks.OSSIFIED_SLAB));
        addDrop(DetritusBlocks.OSSIFIED_DOOR, doorDrops(DetritusBlocks.OSSIFIED_DOOR));
        addDrop(DetritusBlocks.OSSIFIED_TRAPDOOR);
        addDrop(DetritusBlocks.OSSIFIED_BUTTON);
        addDrop(DetritusBlocks.OSSIFIED_PRESSURE_PLATE);
        addDrop(DetritusBlocks.OSSIFIED_FENCE);
        addDrop(DetritusBlocks.OSSIFIED_FENCE_GATE);
        addDrop(DetritusBlocks.OSSIFIED_SAPLING);

        addDrop(DetritusBlocks.MARROW);
        addDrop(DetritusBlocks.LIMBER_MARROW);
        addDrop(DetritusBlocks.LIMBER_MARROW_PLANT, DetritusBlocks.LIMBER_MARROW);
    }
}
