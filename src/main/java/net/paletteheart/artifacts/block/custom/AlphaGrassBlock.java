package net.paletteheart.artifacts.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SpreadingSnowyDirtBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.IPlantable;

import java.util.List;
import java.util.Random;

public class AlphaGrassBlock extends SpreadingSnowyDirtBlock implements BonemealableBlock {
    public AlphaGrassBlock(BlockBehaviour.Properties p_53685_) {
        super(p_53685_);
    }

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction direction, IPlantable plantable) {
        return true;
    }


    /**
     * @return whether bonemeal can be used on this block
     */
    public boolean isValidBonemealTarget(BlockGetter pLevel, BlockPos pPos, BlockState pState, boolean pIsClient) {
        return pLevel.getBlockState(pPos.above()).isAir();
    }

    public boolean isBonemealSuccess(Level pLevel, Random pRand, BlockPos pPos, BlockState pState) {
        return true;
    }

    public void performBonemeal(ServerLevel pLevel, Random pRand, BlockPos pPos, BlockState pState) {
        BlockPos blockpos = pPos.above();
        BlockState blockstate = Blocks.GRASS.defaultBlockState();

        label46:
        for(int i = 0; i < 128; ++i) {
            BlockPos blockpos1 = blockpos;

            for(int j = 0; j < i / 16; ++j) {
                blockpos1 = blockpos1.offset(pRand.nextInt(3) - 1, (pRand.nextInt(3) - 1) * pRand.nextInt(3) / 2, pRand.nextInt(3) - 1);
                if (!pLevel.getBlockState(blockpos1.below()).is(this) || pLevel.getBlockState(blockpos1).isCollisionShapeFullBlock(pLevel, blockpos1)) {
                    continue label46;
                }
            }

            BlockState blockstate1 = pLevel.getBlockState(blockpos1);
            if (blockstate1.is(blockstate.getBlock()) && pRand.nextInt(10) == 0) {
                ((BonemealableBlock)blockstate.getBlock()).performBonemeal(pLevel, pRand, blockpos1, blockstate1);
            }

            if (blockstate1.isAir()) {
                PlacedFeature placedfeature;
                if (pRand.nextInt(8) == 0) {
                    List<ConfiguredFeature<?, ?>> list = pLevel.getBiome(blockpos1).getGenerationSettings().getFlowerFeatures();
                    if (list.isEmpty()) {
                        continue;
                    }

                    placedfeature = ((RandomPatchConfiguration)list.get(0).config()).f_191304_().get();
                } else {
                    placedfeature = VegetationPlacements.f_195459_;
                }

                placedfeature.m_191782_(pLevel, pLevel.getChunkSource().getGenerator(), pRand, blockpos1);
            }
        }

    }
}
