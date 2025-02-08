package mishmash.detritus;

import mishmash.detritus.block.DetritusBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class   DetritusModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(DetritusBlocks.LIMBER_MARROW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DetritusBlocks.LIMBER_MARROW_PLANT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DetritusBlocks.MNEMORA_FLATCAPS, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(DetritusBlocks.MNEMORA_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DetritusBlocks.MNEMORA_TRAPDOOR, RenderLayer.getCutout());
    }
}
