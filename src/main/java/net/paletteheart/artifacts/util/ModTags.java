package net.paletteheart.artifacts.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.paletteheart.artifacts.ArtifactsMod;

public class ModTags {

    public static void register() {
        Blocks.registerBlockTags();
        Items.registerItemTags();
    }

    public static class Blocks {
        //public static final Tags.IOptionalNamedTag<Block> DOWSING_ROD_VALUABLES =
        //        tag("dowsing_rod_valuables");

        private static Tags.IOptionalNamedTag<Block> tag(String name) {
            return BlockTags.createOptional(new ResourceLocation(ArtifactsMod.MOD_ID, name));
        }

        private static Tags.IOptionalNamedTag<Block> forgeTag(String name) {
            return BlockTags.createOptional(new ResourceLocation("forge", name));
        }

        public static void registerBlockTags() {

        }
    }


    public static class Items {
        public static final Tags.IOptionalNamedTag<Item> RUBY_GEMS = forgeTag("gems/ruby");

        private static Tags.IOptionalNamedTag<Item> tag(String name) {
            return ItemTags.createOptional(new ResourceLocation(ArtifactsMod.MOD_ID, name));
        }

        private static Tags.IOptionalNamedTag<Item> forgeTag(String name) {
            return ItemTags.createOptional(new ResourceLocation("forge", name));
        }

        public static void registerItemTags() {

        }
    }
}
