package mishmash.detritus.datagen;

import mishmash.detritus.block.DetritusBlocks;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.TexturedModel;
import net.minecraft.util.Identifier;

import static mishmash.detritus.DetritusMod.MOD_ID;

public class DetritusModelProvider extends FabricModelProvider {

    public DetritusModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerAxisRotated(DetritusBlocks.SLAG, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(DetritusBlocks.BARRSLAG, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(DetritusBlocks.SEDIMENT);

        blockStateModelGenerator.registerLog(DetritusBlocks.MNEMORA_CHINE).log(DetritusBlocks.MNEMORA_CHINE).wood(DetritusBlocks.MNEMORA_SCOLIOTIC);
        blockStateModelGenerator.registerSimpleCubeAll(DetritusBlocks.MNEMORA_MARROW);

        BlockStateModelGenerator.BlockTexturePool ossified_set_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(DetritusBlocks.MNEMORA_PLANKS);
        ossified_set_pool.stairs(DetritusBlocks.MNEMORA_STAIRS);
        ossified_set_pool.slab(DetritusBlocks.MNEMORA_SLAB);
        ossified_set_pool.button(DetritusBlocks.MNEMORA_BUTTON);
        ossified_set_pool.pressurePlate(DetritusBlocks.MNEMORA_PRESSURE_PLATE);
        ossified_set_pool.fence(DetritusBlocks.MNEMORA_FENCE);
        ossified_set_pool.fenceGate(DetritusBlocks.MNEMORA_FENCE_GATE);

        blockStateModelGenerator.registerDoor(DetritusBlocks.MNEMORA_DOOR);
        blockStateModelGenerator.registerTrapdoor(DetritusBlocks.MNEMORA_TRAPDOOR);

        blockStateModelGenerator.registerSingleton(DetritusBlocks.MNEMORA_POLYPORE, TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerPlantPart(DetritusBlocks.LIMBER_MARROW, DetritusBlocks.LIMBER_MARROW_PLANT, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerItemModel(DetritusBlocks.LIMBER_MARROW, "_plant");
        blockStateModelGenerator.registerFlowerbed(DetritusBlocks.MNEMORA_FLATCAPS);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        
    }
}
