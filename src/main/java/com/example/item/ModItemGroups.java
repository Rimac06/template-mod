package com.example.item;

import com.example.TemplateMod;
import com.example.block.ModBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup PINK_GARNET_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TemplateMod.MOD_ID, "pink_garnet_items_group"),
            FabricItemGroup.builder().icon(()-> new ItemStack(ModItems.PINK_GARNET))
                    .displayName(Text.translatable("itemgroup.template-mod.pink_garnet_items"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModItems.PINK_GARNET);
                        entries.add(ModItems.RAW_PINK_GARNET);

                        entries.add(ModItems.CHISEL);
                        entries.add(ModItems.CAULIFLOWER);
                        entries.add(ModItems.STARLIGHT_ASHES);
                    }))
                    .build()
    );

    public static final ItemGroup PINK_GARNET_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TemplateMod.MOD_ID, "pink_garnet_blocks_group"),
            FabricItemGroup.builder().icon(()-> new ItemStack(ModBlocks.PINK_GARNET_BLOCK))
                    .displayName(Text.translatable("itemgroup.template-mod.pink_garnet_blocks"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModBlocks.PINK_GARNET_ORE);
                        entries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
                        entries.add(ModBlocks.PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
                    }))
                    .build()
    );

    public static void registerItemGroups() {
        TemplateMod.LOGGER.info("Registering ItemGroups for " + TemplateMod.MOD_ID);
    }
}
