package mishmash.detritus.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;

public class LimberMarrowBlock extends AbstractPlantStemBlock {
    public static final MapCodec<LimberMarrowBlock> CODEC = createCodec(LimberMarrowBlock::new);
    public static final VoxelShape SHAPE = Block.createCuboidShape(4.0, 9.0, 4.0, 12.0, 16.0, 12.0);

    @Override
    public MapCodec<LimberMarrowBlock> getCodec() {
        return CODEC;
    }

    public LimberMarrowBlock(AbstractBlock.Settings settings) {
        super(settings, Direction.DOWN, SHAPE, false, 0.1);
    }

    @Override
    protected int getGrowthLength(Random random) {
        return VineLogic.getGrowthLength(random);
    }

    @Override
    protected Block getPlant() {
        return DetritusBlocks.LIMBER_MARROW_PLANT;
    }

    @Override
    protected boolean chooseStemState(BlockState state) {
        return VineLogic.isValidForWeepingStem(state);
    }
}