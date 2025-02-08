package mishmash.detritus.block;

import mishmash.detritus.worldgen.feature.sapling.DetritusSaplingGenerators;
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

    // region TERRAIN
    public static final Block SLAG = register(
            "slag", PillarBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.BROWN)
                    .strength(1.5f, 6.0f)
                    .sounds(BlockSoundGroup.MUD_BRICKS)
                    .requiresTool()
    );
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

    // region MNEMORA SET
    public static final BlockSetType MNEMORA_SET_TYPE = BlockSetTypeBuilder.copyOf(BlockSetType.CRIMSON)
            .register(Identifier.of(DetritusMod.MOD_ID, "rhachis"));
    public static final WoodType MNEMORA_WOOD_TYPE = WoodTypeBuilder.copyOf(WoodType.CRIMSON)
            .register(Identifier.of(DetritusMod.MOD_ID, "rhachis"), MNEMORA_SET_TYPE);

    public static final Block MNEMORA_CHINE = register(
            "mnemora_chine", PillarBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_BROWN)
                    .sounds(BlockSoundGroup.ANCIENT_DEBRIS)
                    .strength(4.0f) // placeholder
    );
    public static final Block MNEMORA_SCOLIOTIC = register(
            "mnemora_scoliotic", PillarBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.OAK_TAN)
                    .sounds(BlockSoundGroup.ANCIENT_DEBRIS)
                    .strength(4.0f) // placeholder
    );
    public static final Block MNEMORA_MARROW = register(
            "mnemora_marrow", PillarBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .sounds(BlockSoundGroup.WART_BLOCK)
                    .strength(4.0f) // placeholder
    );
    public static final Block MNEMORA_PLANKS = register(
            "mnemora_planks", Block::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .strength(4.0f) // placeholder
    );
    public static final Block MNEMORA_STAIRS = register(
            "mnemora_stairs",
            properties -> new StairsBlock(MNEMORA_PLANKS.getDefaultState(), properties),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .strength(4.0f) // placeholder
    );
    public static final Block MNEMORA_SLAB = register(
            "mnemora_slab",
            SlabBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .strength(4.0f) // placeholder
    );
    public static final Block MNEMORA_FENCE = register(
            "mnemora_fence",
            FenceBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .strength(4.0f) // placeholder
    );
    public static final Block MNEMORA_FENCE_GATE = register(
            "mnemora_fence_gate",
            properties -> new FenceGateBlock(MNEMORA_WOOD_TYPE, properties),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .strength(4.0f) // placeholder
    );
    public static final Block MNEMORA_DOOR = register(
            "mnemora_door",
            properties -> new DoorBlock(MNEMORA_SET_TYPE, properties),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .strength(4.0f) // placeholder
    );
    public static final Block MNEMORA_TRAPDOOR = register(
            "mnemora_trapdoor",
            properties -> new TrapdoorBlock(MNEMORA_SET_TYPE, properties),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .strength(4.0f) // placeholder
    );
    public static final Block MNEMORA_BUTTON = register(
            "mnemora_button",
            properties -> new ButtonBlock(MNEMORA_SET_TYPE, 3, properties),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .strength(4.0f) // placeholder
    );
    public static final Block MNEMORA_PRESSURE_PLATE = register(
            "mnemora_pressure_plate",
            properties -> new PressurePlateBlock(MNEMORA_SET_TYPE, properties),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .strength(4.0f) // placeholder
    );
    // endregion


    // region PSEUDOFOLIAGE
    public static final Block MNEMORA_POLYPORE = register(
            "mnemora_polypore", Block::new,
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
    public static final Block MNEMORA_FLATCAPS = register(
            "mnemora_flatcaps", (properties) -> (new MnemoraFlatcapsBlock(DetritusSaplingGenerators.MNEMORA, properties)),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DULL_RED)
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.WEEPING_VINES) // placeholder
                    .pistonBehavior(PistonBehavior.DESTROY)
    );
    public static final Block OYSTER_MUSHROOMS = register(
            "oyster_mushrooms", OysterMushroomsBlock::new,
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
        StrippableBlockRegistry.register(MNEMORA_CHINE, MNEMORA_MARROW);
        StrippableBlockRegistry.register(MNEMORA_SCOLIOTIC, MNEMORA_MARROW);
    }
}
