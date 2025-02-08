package mishmash.detritus.block;

import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.function.BiFunction;

public class MnemoraFlatcapsBlock extends SaplingBlock implements Fertilizable {

    public static final DirectionProperty FACING;
    public static final IntProperty FLOWER_AMOUNT;
    public static final IntProperty STAGE;
    private static final BiFunction<Direction, Integer, VoxelShape> FACING_AND_AMOUNT_TO_SHAPE;

    protected MnemoraFlatcapsBlock(SaplingGenerator generator, Settings settings) {
        super(generator, settings);
        this.setDefaultState(((this.stateManager.getDefaultState()).with(FACING, Direction.NORTH)).with(FLOWER_AMOUNT, 1).with(STAGE, 0));
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(DetritusBlocks.SLAG);
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        return !context.shouldCancelInteraction() && context.getStack().isOf(this.asItem()) && state.get(FLOWER_AMOUNT) < 4 || super.canReplace(state, context);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return FACING_AND_AMOUNT_TO_SHAPE.apply(state.get(FACING), state.get(FLOWER_AMOUNT));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos());
        return blockState.isOf(this) ? blockState.with(FLOWER_AMOUNT, Math.min(4, blockState.get(FLOWER_AMOUNT) + 1)) : this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, FLOWER_AMOUNT, STAGE);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        int i = state.get(FLOWER_AMOUNT);
        if (i < 4) {
            world.setBlockState(pos, state.with(FLOWER_AMOUNT, i + 1), 2);
        } else {
            this.generate(world, pos, state, random);
        }
    }

    public void generate(ServerWorld world, BlockPos pos, BlockState state, Random random) {
        if (state.get(STAGE) == 0) {
            world.setBlockState(pos, state.cycle(STAGE), 4);
        } else {
            this.generator.generate(world, world.getChunkManager().getChunkGenerator(), pos, state, random);
        }

    }

    static {
        FACING = Properties.HORIZONTAL_FACING;
        FLOWER_AMOUNT = Properties.FLOWER_AMOUNT;
        STAGE = Properties.STAGE;
        FACING_AND_AMOUNT_TO_SHAPE = Util.memoize((facing, flowerAmount) -> {
            VoxelShape[] voxelShapes = new VoxelShape[]{
                    Block.createCuboidShape(8.0, 0.0, 8.0, 16.0, 3.0, 16.0),
                    Block.createCuboidShape(8.0, 0.0, 0.0, 16.0, 3.0, 8.0),
                    Block.createCuboidShape(0.0, 0.0, 0.0, 8.0, 3.0, 8.0),
                    Block.createCuboidShape(0.0, 0.0, 8.0, 8.0, 3.0, 16.0)};
            VoxelShape voxelShape = VoxelShapes.empty();

            for(int i = 0; i < flowerAmount; ++i) {
                int j = Math.floorMod(i - facing.getHorizontal(), 4);
                voxelShape = VoxelShapes.union(voxelShape, voxelShapes[j]);
            }

            return voxelShape.asCuboid();
        });
    }
}
