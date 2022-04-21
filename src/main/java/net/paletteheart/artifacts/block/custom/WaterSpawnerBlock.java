package net.paletteheart.artifacts.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.paletteheart.artifacts.block.entity.ModBlockEntities;
import net.paletteheart.artifacts.block.entity.WaterSpawnerBlockEntity;
import org.jetbrains.annotations.Nullable;

public class WaterSpawnerBlock extends BaseEntityBlock {

    public WaterSpawnerBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return null;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return  BaseEntityBlock.createTickerHelper(pBlockEntityType, ModBlockEntities.WATER_SPAWNER.get(), WaterSpawnerBlockEntity::tick);
    }
}
