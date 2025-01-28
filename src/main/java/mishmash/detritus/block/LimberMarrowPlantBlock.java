package mishmash.detritus.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

public class LimberMarrowPlantBlock extends AbstractPlantBlock {
    public static final MapCodec<LimberMarrowPlantBlock> CODEC = createCodec(LimberMarrowPlantBlock::new);
    public static final VoxelShape SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 16.0, 15.0);

    @Override
    public MapCodec<LimberMarrowPlantBlock> getCodec() {
        return CODEC;
    }

    public LimberMarrowPlantBlock(AbstractBlock.Settings settings) {
        super(settings, Direction.DOWN, SHAPE, false);
    }

    @Override
    protected AbstractPlantStemBlock getStem() {
        return (AbstractPlantStemBlock) DetritusBlocks.LIMBER_MARROW;
    }
}
