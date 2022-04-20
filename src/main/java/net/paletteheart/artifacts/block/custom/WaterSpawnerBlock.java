package net.paletteheart.artifacts.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.util.ForgeSoundType;

import java.util.Random;

public class WaterSpawnerBlock extends Block {
    public WaterSpawnerBlock(Properties sound) {
        super(BlockBehaviour.Properties.of(Material.WATER)
                .sound(new ForgeSoundType(1.0f, 1.0f, () -> new SoundEvent(new ResourceLocation("ambient.underwater.exit")),
                        () -> new SoundEvent(new ResourceLocation("block.water.ambient")),
                        () -> new SoundEvent(new ResourceLocation("ambient.underwater.enter")),
                        () -> new SoundEvent(new ResourceLocation("ambient.underwater.exit")),
                        () -> new SoundEvent(new ResourceLocation("ambient.underwater.exit"))))
        );
    }

    public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, Random random) {
        super.tick(blockstate, world, pos, random);
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        if ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.AIR) {
            world.setBlock(new BlockPos((int) (x + 1), (int) y, (int) z), Blocks.WATER.defaultBlockState(), 3);
        }
        if ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.AIR) {
            world.setBlock(new BlockPos((int) (x - 1), (int) y, (int) z), Blocks.WATER.defaultBlockState(), 3);
        }
        if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.AIR) {
            world.setBlock(new BlockPos((int) x, (int) y, (int) (z + 1)), Blocks.WATER.defaultBlockState(), 3);
        }
        if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.AIR) {
            world.setBlock(new BlockPos((int) x, (int) y, (int) (z - 1)), Blocks.WATER.defaultBlockState(), 3);
        }
    }
}
