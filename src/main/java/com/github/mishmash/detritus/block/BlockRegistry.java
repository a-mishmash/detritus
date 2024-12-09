package com.github.mishmash.detritus.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import java.util.function.Function;

import static com.github.mishmash.detritus.DetritusMod.MOD_ID;

public class BlockRegistry {

    public static final Block PRIMEVAL_SLAG = register("primeval_slag", Block::new, AbstractBlock.Settings.create().strength(4.0f));
    public static final Block EFFLUVIAN_SAND = register("effluvian_sand", Block::new, AbstractBlock.Settings.create().strength(4.0f));

    public static void initialize() {}

    /** Registers a block with a corresponding item of the same ID. */
    private static Block register(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(MOD_ID, path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

        final Block block = Blocks.register(registryKey, factory, settings);
        Items.register(block);
        return block;
    }
}
