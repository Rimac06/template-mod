package com.example.block;

import com.example.TemplateMod;
import com.example.block.custom.MagicBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.block.Block;
import net.minecraft.registry.Registry;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            new Block(AbstractBlock.Settings.create().strength(4.0F).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block",
            new Block(AbstractBlock.Settings.create().strength(3.0F).requiresTool()));

    public static final Block PINK_GARNET_ORE = registerBlock("pink_garnet_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3.0F).requiresTool()));

    public static final Block PINK_GARNET_DEEPSLATE_ORE = registerBlock("pink_garnet_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(4.0F).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create().strength(5.0F).requiresTool()));

    private static Block registerBlock(String name, Block block) {
        Registry.register(Registries.BLOCK, Identifier.of(TemplateMod.MOD_ID, name), block);
        registerBlockItem(name, block);
        return block;
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TemplateMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        TemplateMod.LOGGER.info("Registering ModBlocks for " + TemplateMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries ->{
            entries.add(PINK_GARNET_ORE);
            entries.add(PINK_GARNET_DEEPSLATE_ORE);
            entries.add(PINK_GARNET_BLOCK);
            entries.add(RAW_PINK_GARNET_BLOCK);
            entries.add(MAGIC_BLOCK);
        });
    }
}
