package com.telepathicgrunt.repurposedstructures.world.structures;

import com.mojang.serialization.Codec;
import com.telepathicgrunt.repurposedstructures.RSFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class VillageNetherStructure extends VillageBaseStructure {
    public VillageNetherStructure(Codec<NoFeatureConfig> config, ResourceLocation poolRL, int structureSize) {
        super(config, poolRL, structureSize);
    }

    @Override
    protected boolean shouldStartAt(ChunkGenerator chunkGenerator, BiomeProvider biomeSource, long seed, SharedSeedRandom chunkRandom, int chunkX, int chunkZ, Biome biome, ChunkPos chunkPos, NoFeatureConfig defaultFeatureConfig) {
        for (int curChunkX = chunkX - 10; curChunkX <= chunkX + 10; curChunkX++) {
            for (int curChunkZ = chunkZ - 10; curChunkZ <= chunkZ + 10; curChunkZ++) {
                ChunkPos chunkPos2 = RSFeatures.WARPED_OUTPOST.func_236392_a_(chunkGenerator.getConfig().func_236197_a_(RSFeatures.WARPED_OUTPOST), seed, chunkRandom, curChunkX, curChunkZ);
                if (curChunkX == chunkPos2.x && curChunkZ == chunkPos2.z) {
                    return false;
                }
                chunkPos2 = RSFeatures.CRIMSON_OUTPOST.func_236392_a_(chunkGenerator.getConfig().func_236197_a_(RSFeatures.CRIMSON_OUTPOST), seed, chunkRandom, curChunkX, curChunkZ);
                if (curChunkX == chunkPos2.x && curChunkZ == chunkPos2.z) {
                    return false;
                }
                chunkPos2 = RSFeatures.NETHER_BRICK_OUTPOST.func_236392_a_(chunkGenerator.getConfig().func_236197_a_(RSFeatures.NETHER_BRICK_OUTPOST), seed, chunkRandom, curChunkX, curChunkZ);
                if (curChunkX == chunkPos2.x && curChunkZ == chunkPos2.z) {
                    return false;
                }
            }
        }
        return super.shouldStartAt(chunkGenerator, biomeSource, seed, chunkRandom, chunkX, chunkZ, biome, chunkPos, defaultFeatureConfig);
    }

    public class Start extends MainStart {
        public Start(Structure<NoFeatureConfig> structureIn, int chunkX, int chunkZ, MutableBoundingBox mutableBoundingBox, int referenceIn, long seedIn) {
            super(structureIn, chunkX, chunkZ, mutableBoundingBox, referenceIn, seedIn);
        }

        public void init(ChunkGenerator chunkGenerator, TemplateManager structureManager, int chunkX, int chunkZ, Biome biome, NoFeatureConfig NoFeatureConfig) {
            super.init(chunkGenerator, structureManager, chunkX, chunkZ, biome, NoFeatureConfig);

            BlockPos lowestLandPos = getHighestLand(chunkGenerator, this.bounds);
            if (lowestLandPos.getY() >= 108 || lowestLandPos.getY() <= 33) {
                this.func_214626_a(this.rand, 20, 21);
            }
            else {
                this.func_214626_a(this.rand, lowestLandPos.getY() - 13, lowestLandPos.getY() - 12);
            }
        }

    }


    //Helper methods//

    public static BlockPos getHighestLand(ChunkGenerator chunkGenerator, MutableBoundingBox bounds) {
        BlockPos.Mutable mutable = new BlockPos.Mutable().setPos(bounds.func_215126_f().getX(), 108, bounds.func_215126_f().getZ());
        IBlockReader blockView = chunkGenerator.getColumnSample(mutable.getX(), mutable.getZ());
        BlockState currentBlockstate;
        while (mutable.getY() > 33) {
            currentBlockstate = blockView.getBlockState(mutable);
            if (!currentBlockstate.isFullCube(blockView, mutable)) {
                mutable.move(Direction.DOWN);
                continue;
            }
            else if (blockView.getBlockState(mutable.add(0, 3, 0)).getMaterial() == Material.AIR &&
                    isValidBlock(currentBlockstate)) {
                break;
            }
            mutable.move(Direction.DOWN);
        }

        return mutable;
    }

    private static boolean isValidBlock(BlockState currentBlockstate) {
        return BlockTags.field_241278_aD_.contains(currentBlockstate.getBlock()) ||
                BlockTags.VALID_SPAWN.contains(currentBlockstate.getBlock()) ||
                BlockTags.SAND.contains(currentBlockstate.getBlock()) ||
                BlockTags.field_232873_an_.contains(currentBlockstate.getBlock()) ||
                BlockTags.ICE.contains(currentBlockstate.getBlock()) ||
                BlockTags.PLANKS.contains(currentBlockstate.getBlock()) ||
                BlockTags.STONE_BRICKS.contains(currentBlockstate.getBlock()) ||
                BlockTags.WITHER_IMMUNE.contains(currentBlockstate.getBlock()) ||
                BlockTags.WOOL.contains(currentBlockstate.getBlock()) ||
                currentBlockstate.getMaterial() == Material.SAND ||
                currentBlockstate.getMaterial() == Material.ROCK ||
                currentBlockstate.getMaterial() == Material.EARTH;
    }
}