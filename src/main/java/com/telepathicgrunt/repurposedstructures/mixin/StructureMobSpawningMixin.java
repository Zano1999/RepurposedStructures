package com.telepathicgrunt.repurposedstructures.mixin;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.telepathicgrunt.repurposedstructures.RSFeatures;
import net.minecraft.entity.EntityClassification;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.NoiseChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(NoiseChunkGenerator.class)
public class StructureMobSpawningMixin {

    @Inject(
            method = "getEntitySpawnList(Lnet/minecraft/world/biome/Biome;Lnet/minecraft/world/gen/feature/structure/StructureManager;Lnet/minecraft/entity/EntityClassification;Lnet/minecraft/util/math/BlockPos;)Ljava/util/List;",
            at = @At(value = "HEAD"),
            cancellable = true
    )
    private void locateRSStrongholds(Biome biome, StructureManager accessor, EntityClassification group, BlockPos pos, CallbackInfoReturnable<List<Biome.SpawnListEntry>> cir) {
        List<Biome.SpawnListEntry> list = getStructureSpawns(biome, accessor, group, pos);
        if(list != null) cir.setReturnValue(list);
    }


    private static List<Biome.SpawnListEntry>  getStructureSpawns(Biome biome, StructureManager accessor, EntityClassification group, BlockPos pos){
        if (group == EntityClassification.MONSTER) {
            if (accessor.func_235010_a_(pos, true, RSFeatures.NETHER_BRICK_OUTPOST).isValid()) {
               return RSFeatures.NETHER_BRICK_OUTPOST.getSpawnList();
            }

            if (accessor.func_235010_a_(pos, true, RSFeatures.WARPED_OUTPOST).isValid()) {
                return RSFeatures.WARPED_OUTPOST.getSpawnList();
            }

            if (accessor.func_235010_a_(pos, true, RSFeatures.CRIMSON_OUTPOST).isValid()) {
                return RSFeatures.CRIMSON_OUTPOST.getSpawnList();
            }


            if (accessor.func_235010_a_(pos, true, RSFeatures.NETHER_STRONGHOLD).isValid()) {
                return RSFeatures.NETHER_STRONGHOLD.getSpawnList();
            }

            if (accessor.func_235010_a_(pos, true, RSFeatures.JUNGLE_FORTRESS).isValid()) {
                return Lists.newArrayList(Iterators.concat(biome.getSpawns(EntityClassification.MONSTER).iterator(), RSFeatures.JUNGLE_FORTRESS.getSpawnList().iterator()));
            }

            if (accessor.func_235010_a_(pos, true, RSFeatures.END_MINESHAFT).isValid()) {
                return Lists.newArrayList(Iterators.concat(biome.getSpawns(EntityClassification.MONSTER).iterator(), RSFeatures.END_MINESHAFT.getSpawnList().iterator()));
            }
        }

        return null;
    }
}