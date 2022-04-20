package net.paletteheart.artifacts.block;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.paletteheart.artifacts.ArtifactsMod;
import net.paletteheart.artifacts.block.custom.AlphaGrassBlock;
import net.paletteheart.artifacts.block.custom.BOESBlock;
import net.paletteheart.artifacts.block.custom.WaterSpawnerBlock;
import net.paletteheart.artifacts.item.ModCreativeModeTab;
import net.paletteheart.artifacts.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ArtifactsMod.MOD_ID);


    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_RED)
                    .strength(5f, 6f).requiresCorrectToolForDrops().sound(SoundType.METAL)), ModCreativeModeTab.ARTIFACTS_TAB);

    public static final RegistryObject<Block> ALPHA_GRASS_BLOCK = registerBlock("alpha_grass_block",
            () -> new AlphaGrassBlock(BlockBehaviour.Properties.of(Material.GRASS).randomTicks()
                    .strength(0.6F).sound(SoundType.GRASS)), ModCreativeModeTab.ARTIFACTS_TAB);

    public static final RegistryObject<Block> ROSE = registerBlock("rose",
            () -> new FlowerBlock(MobEffects.WITHER, 4,
                    BlockBehaviour.Properties.copy(Blocks.DANDELION)), ModCreativeModeTab.ARTIFACTS_TAB);

    public static final RegistryObject<Block> CYAN_ROSE = registerBlock("cyan_rose",
            () -> new FlowerBlock(MobEffects.WITHER, 4,
                    BlockBehaviour.Properties.copy(Blocks.DANDELION)), ModCreativeModeTab.ARTIFACTS_TAB);

    public static final RegistryObject<Block> PAEONIA = registerBlock("paeonia",
            () -> new FlowerBlock(MobEffects.WITHER, 4,
                    BlockBehaviour.Properties.copy(Blocks.DANDELION)), ModCreativeModeTab.ARTIFACTS_TAB);

    public static final RegistryObject<Block> RAINBOW_WOOL = registerBlock("rainbow_wool",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.COLOR_RED)
                    .strength(0.8F).sound(SoundType.WOOL)), ModCreativeModeTab.ARTIFACTS_TAB);

    public static final RegistryObject<Block> UNKNOWN_ELEMENT = registerBlock("unknown_element",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK)
                    .strength(0F)), ModCreativeModeTab.ARTIFACTS_TAB);

    //public static final RegistryObject<Block> NETHERITE_STAIRS = registerBlock("netherite_stairs",
    //        () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLACK)
    //                .strength(50f, 1200f).requiresCorrectToolForDrops()), ModCreativeModeTab.ARTIFACTS_TAB);

    //public static final RegistryObject<Block> BOES = registerBlock("boes",
    //        () -> new BOESBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_RED)
    //                .strength(0.8F)), ModCreativeModeTab.ARTIFACTS_TAB);

    //public static final RegistryObject<Block> WATER_SPAWNER = registerBlock("water_spawner",
    //        () -> new WaterSpawnerBlock(BlockBehaviour.Properties.of(Material.WATER)
    //                .instabreak()), ModCreativeModeTab.ARTIFACTS_TAB);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
