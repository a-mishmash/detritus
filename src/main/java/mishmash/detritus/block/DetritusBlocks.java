package mishmash.detritus.block;

import mishmash.detritus.worldgen.feature.DetritusSaplingGenerators;
import mishmash.detritus.DetritusMod;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class DetritusBlocks {

    // region MISC
    public static final Block BARRSLAG = register(
            "barrslag", PillarBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.BLACK)
                    .strength(2.5f, 6.0f)
                    .sounds(BlockSoundGroup.DEEPSLATE)
                    .requiresTool()
    );
    public static final Block SEDIMENT = register(
            "sediment", Block::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.GRAY)
                    .sounds(BlockSoundGroup.GRAVEL)
                    .strength(4.0f) // placeholder
    );
    // endregion

    // region OSSIFIED SET
    public static final BlockSetType OSSIFIED_SET_TYPE = BlockSetTypeBuilder.copyOf(BlockSetType.CRIMSON)
            .register(Identifier.of(DetritusMod.MOD_ID, "ossified"));
    public static final WoodType OSSIFIED_WOOD_TYPE = WoodTypeBuilder.copyOf(WoodType.CRIMSON)
            .register(Identifier.of(DetritusMod.MOD_ID, "ossified"), OSSIFIED_SET_TYPE);

    public static final Block OSSIFIED_LOG = register(
            "ossified_log", PillarBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_BROWN)
                    .sounds(BlockSoundGroup.ANCIENT_DEBRIS)
                    .strength(4.0f) // placeholder
    );
    public static final Block OSSIFIED_WOOD = register(
            "ossified_wood", PillarBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.OAK_TAN)
                    .sounds(BlockSoundGroup.ANCIENT_DEBRIS)
                    .strength(4.0f) // placeholder
    );
    public static final Block STRIPPED_OSSIFIED_LOG = register(
            "stripped_ossified_log", PillarBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .sounds(BlockSoundGroup.WART_BLOCK)
                    .strength(4.0f) // placeholder
    );
    public static final Block STRIPPED_OSSIFIED_WOOD = register(
            "stripped_ossified_wood", PillarBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .sounds(BlockSoundGroup.WART_BLOCK)
                    .strength(4.0f) // placeholder
    );
    public static final Block OSSIFIED_PLANKS = register(
            "ossified_planks", Block::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .strength(4.0f) // placeholder
    );
    public static final Block OSSIFIED_STAIRS = register(
            "ossified_stairs",
            properties -> new StairsBlock(OSSIFIED_PLANKS.getDefaultState(), properties),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .strength(4.0f) // placeholder
    );
    public static final Block OSSIFIED_SLAB = register(
            "ossified_slab",
            SlabBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .strength(4.0f) // placeholder
    );
    public static final Block OSSIFIED_FENCE = register(
            "ossified_fence",
            FenceBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .strength(4.0f) // placeholder
    );
    public static final Block OSSIFIED_FENCE_GATE = register(
            "ossified_fence_gate",
            properties -> new FenceGateBlock(OSSIFIED_WOOD_TYPE, properties),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .strength(4.0f) // placeholder
    );
    public static final Block OSSIFIED_DOOR = register(
            "ossified_door",
            properties -> new DoorBlock(OSSIFIED_SET_TYPE, properties),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .strength(4.0f) // placeholder
    );
    public static final Block OSSIFIED_TRAPDOOR = register(
            "ossified_trapdoor",
            properties -> new TrapdoorBlock(OSSIFIED_SET_TYPE, properties),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .strength(4.0f) // placeholder
    );
    public static final Block OSSIFIED_BUTTON = register(
            "ossified_button",
            properties -> new ButtonBlock(OSSIFIED_SET_TYPE, 3, properties),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .strength(4.0f) // placeholder
    );
    public static final Block OSSIFIED_PRESSURE_PLATE = register(
            "ossified_pressure_plate",
            properties -> new PressurePlateBlock(OSSIFIED_SET_TYPE, properties),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .strength(4.0f) // placeholder
    );
    public static final Block OSSIFIED_SAPLING = register(
            "ossified_sapling",
            properties -> new OssifiedSaplingBlock(DetritusSaplingGenerators.OSSIFIED, properties),
            AbstractBlock.Settings.copy(Blocks.CRIMSON_FUNGUS)
    );
    // endregion


    // region MARROW BLOCKS
    public static final Block MARROW = register(
            "marrow", Block::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DULL_RED)
                    .strength(4.0f) // placeholder
                    .nonOpaque()
    );
    public static final Block LIMBER_MARROW = register(
            "limber_marrow", LimberMarrowBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DULL_RED)
                    .ticksRandomly()
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.WEEPING_VINES) // placeholder
                    .pistonBehavior(PistonBehavior.DESTROY)
    );
    public static final Block LIMBER_MARROW_PLANT = registerWithoutItem(
            "limber_marrow_plant", LimberMarrowPlantBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DULL_RED)
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.WEEPING_VINES) // placeholder
                    .pistonBehavior(PistonBehavior.DESTROY)
    );
    // endregion

    // initialize mod blocks
    public static void initialize() {
        registerStrippableBlocks();
    };

    // registers a block with a corresponding item of the same ID.
    private static Block register(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(DetritusMod.MOD_ID, path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

        final Block block = Blocks.register(registryKey, factory.apply(settings));
        Items.register(block);
        return block;
    }

    // registers a block without a corresponding item of the same ID.
    private static Block registerWithoutItem(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(DetritusMod.MOD_ID, path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

        return Blocks.register(registryKey, factory.apply(settings));
    }

    public static void registerStrippableBlocks() {
        StrippableBlockRegistry.register(OSSIFIED_LOG, STRIPPED_OSSIFIED_LOG);
        StrippableBlockRegistry.register(OSSIFIED_WOOD, STRIPPED_OSSIFIED_WOOD);
    }
}
