package net.paletteheart.artifacts.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class WaterSpawnerBlockEntity extends BlockEntity {

    public WaterSpawnerBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(ModBlockEntities.WATER_SPAWNER.get(), pWorldPosition,pBlockState);
    }

    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, WaterSpawnerBlockEntity pBlockEntity) {
        int x = pPos.getX();
        int y = pPos.getY();
        int z = pPos.getZ();

        if ((pLevel.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.AIR) {
            pLevel.setBlock(new BlockPos((int) (x + 1), (int) y, (int) z), Blocks.WATER.defaultBlockState(), 3);
        }
        if ((pLevel.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.AIR) {
            pLevel.setBlock(new BlockPos((int) (x - 1), (int) y, (int) z), Blocks.WATER.defaultBlockState(), 3);
        }
        if ((pLevel.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.AIR) {
            pLevel.setBlock(new BlockPos((int) x, (int) y, (int) (z + 1)), Blocks.WATER.defaultBlockState(), 3);
        }
        if ((pLevel.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.AIR) {
            pLevel.setBlock(new BlockPos((int) x, (int) y, (int) (z - 1)), Blocks.WATER.defaultBlockState(), 3);
        }

    }


}
