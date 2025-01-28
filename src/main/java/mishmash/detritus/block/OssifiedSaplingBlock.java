package mishmash.detritus.block;

import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class OssifiedSaplingBlock extends SaplingBlock {

    public OssifiedSaplingBlock(SaplingGenerator generator, Settings settings) {
        super(generator, settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(DetritusBlocks.BARRSLAG);
    }
}
