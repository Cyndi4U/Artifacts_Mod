package net.paletteheart.artifacts.block.entity;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.paletteheart.artifacts.ArtifactsMod;
import net.paletteheart.artifacts.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, ArtifactsMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<WaterSpawnerBlockEntity>> WATER_SPAWNER =
            BLOCK_ENTITIES.register("water_spawner", () ->
                    BlockEntityType.Builder.of(WaterSpawnerBlockEntity::new,
                            ModBlocks.WATER_SPAWNER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

}
