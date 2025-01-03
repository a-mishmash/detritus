package com.github.mishmash.detritus.datagen;

import com.github.mishmash.detritus.block.DetritusBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Blocks;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.TexturedModel;

public class DetritusModelProvider extends FabricModelProvider {

    public DetritusModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerAxisRotated(DetritusBlocks.BARRSLAG, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(DetritusBlocks.SEDIMENT);

        blockStateModelGenerator.registerLog(DetritusBlocks.OSSIFIED_LOG).log(DetritusBlocks.OSSIFIED_LOG).wood(DetritusBlocks.OSSIFIED_WOOD);
        blockStateModelGenerator.registerLog(DetritusBlocks.STRIPPED_OSSIFIED_LOG).log(DetritusBlocks.STRIPPED_OSSIFIED_LOG).wood(DetritusBlocks.STRIPPED_OSSIFIED_WOOD);

        BlockStateModelGenerator.BlockTexturePool ossified_set_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(DetritusBlocks.OSSIFIED_PLANKS);
        ossified_set_pool.stairs(DetritusBlocks.OSSIFIED_STAIRS);
        ossified_set_pool.slab(DetritusBlocks.OSSIFIED_SLAB);
        ossified_set_pool.button(DetritusBlocks.OSSIFIED_BUTTON);
        ossified_set_pool.pressurePlate(DetritusBlocks.OSSIFIED_PRESSURE_PLATE);
        ossified_set_pool.fence(DetritusBlocks.OSSIFIED_FENCE);
        ossified_set_pool.fenceGate(DetritusBlocks.OSSIFIED_FENCE_GATE);

        blockStateModelGenerator.registerDoor(DetritusBlocks.OSSIFIED_DOOR);
        blockStateModelGenerator.registerTrapdoor(DetritusBlocks.OSSIFIED_TRAPDOOR);

        blockStateModelGenerator.registerSimpleCubeAll(DetritusBlocks.MARROW);
        blockStateModelGenerator.registerPlantPart(DetritusBlocks.LIMBER_MARROW, DetritusBlocks.LIMBER_MARROW_PLANT, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerItemModel(DetritusBlocks.LIMBER_MARROW, "_plant");
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(DetritusBlocks.OSSIFIED_DOOR.asItem());
    }
}
