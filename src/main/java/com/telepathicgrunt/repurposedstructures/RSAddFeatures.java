package com.telepathicgrunt.repurposedstructures;

import com.google.gson.JsonElement;
import com.mojang.serialization.JsonOps;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Optional;

public class RSAddFeatures {

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // MINESHAFTS //

    public static void addMineshafts(BiomeLoadingEvent event) {

        if (RepurposedStructures.RSMineshaftsConfig.birchMineshaftSpawnrate.get() != 0 && event.getName().getPath().contains("birch") &&
                (event.getName().getNamespace().equals("minecraft") || RepurposedStructures.RSMineshaftsConfig.addMineshaftsToModdedBiomes.get())) {
            if (event.getGeneration().getStructures().removeIf((supplier) -> supplier.get().feature == Structure.MINESHAFT)) {
                // replace vanilla mineshaft with our own
                event.getGeneration().getStructures().add(() -> RSConfiguredStructures.BIRCH_MINESHAFT);
            }
        }
        else if (RepurposedStructures.RSMineshaftsConfig.jungleMineshaftSpawnrate.get() != 0 && event.getCategory() == Category.JUNGLE &&
                (event.getName().getNamespace().equals("minecraft") || RepurposedStructures.RSMineshaftsConfig.addMineshaftsToModdedBiomes.get())) {
            if (event.getGeneration().getStructures().removeIf((supplier) -> supplier.get().feature == Structure.MINESHAFT)) {
                // replace vanilla mineshaft with our own
                event.getGeneration().getStructures().add(() -> RSConfiguredStructures.JUNGLE_MINESHAFT);
            }
        }
        else if (RepurposedStructures.RSMineshaftsConfig.desertMineshaftSpawnrate.get() != 0 && event.getCategory() == Category.DESERT &&
                (event.getName().getNamespace().equals("minecraft") || RepurposedStructures.RSMineshaftsConfig.addMineshaftsToModdedBiomes.get())) {
            if (event.getGeneration().getStructures().removeIf((supplier) -> supplier.get().feature == Structure.MINESHAFT)) {
                // replace vanilla mineshaft with our own
                event.getGeneration().getStructures().add(() -> RSConfiguredStructures.DESERT_MINESHAFT);
            }
        }
        else if (RepurposedStructures.RSMineshaftsConfig.stoneMineshaftSpawnrate.get() != 0 && event.getCategory() == Category.EXTREME_HILLS &&
                (event.getName().getNamespace().equals("minecraft") || RepurposedStructures.RSMineshaftsConfig.addMineshaftsToModdedBiomes.get())) {
            if (event.getGeneration().getStructures().removeIf((supplier) -> supplier.get().feature == Structure.MINESHAFT)) {
                // replace vanilla mineshaft with our own
                event.getGeneration().getStructures().add(() -> RSConfiguredStructures.STONE_MINESHAFT);
            }
        }
        else if (RepurposedStructures.RSMineshaftsConfig.savannaMineshaftSpawnrate.get() != 0 && event.getCategory() == Category.SAVANNA &&
                (event.getName().getNamespace().equals("minecraft") || RepurposedStructures.RSMineshaftsConfig.addMineshaftsToModdedBiomes.get())) {
            if (event.getGeneration().getStructures().removeIf((supplier) -> supplier.get().feature == Structure.MINESHAFT)) {
                // replace vanilla mineshaft with our own
                event.getGeneration().getStructures().add(() -> RSConfiguredStructures.SAVANNA_MINESHAFT);
            }
        }
        else if (RepurposedStructures.RSMineshaftsConfig.icyMineshaftSpawnrate.get() != 0 &&
                (event.getCategory() == Category.ICY || event.getName().getPath().contains("snowy")) &&
                (event.getName().getNamespace().equals("minecraft") || RepurposedStructures.RSMineshaftsConfig.addMineshaftsToModdedBiomes.get())) {
            if (event.getGeneration().getStructures().removeIf((supplier) -> supplier.get().feature == Structure.MINESHAFT)) {
                // replace vanilla mineshaft with our own
                event.getGeneration().getStructures().add(() -> RSConfiguredStructures.ICY_MINESHAFT);
            }
        }
        else if (RepurposedStructures.RSMineshaftsConfig.oceanMineshaftSpawnrate.get() != 0 && event.getCategory() == Category.OCEAN &&
                (event.getName().getNamespace().equals("minecraft") || RepurposedStructures.RSMineshaftsConfig.addMineshaftsToModdedBiomes.get())) {
            if (event.getGeneration().getStructures().removeIf((supplier) -> supplier.get().feature == Structure.MINESHAFT)) {
                // replace vanilla mineshaft with our own
                event.getGeneration().getStructures().add(() -> RSConfiguredStructures.OCEAN_MINESHAFT);
            }
        }
        else if (RepurposedStructures.RSMineshaftsConfig.taigaMineshaftSpawnrate.get() != 0 && event.getCategory() == Category.TAIGA &&
                (event.getName().getNamespace().equals("minecraft") || RepurposedStructures.RSMineshaftsConfig.addMineshaftsToModdedBiomes.get())) {
            if (event.getGeneration().getStructures().removeIf((supplier) -> supplier.get().feature == Structure.MINESHAFT)) {
                // replace vanilla mineshaft with our own
                event.getGeneration().getStructures().add(() -> RSConfiguredStructures.TAIGA_MINESHAFT);
            }
        }
        else if (RepurposedStructures.RSMineshaftsConfig.swampAndDarkForestMineshaftSpawnrate.get() != 0 && (event.getCategory() == Category.SWAMP || event.getName().getPath().contains("dark_forest") || event.getName().getPath().contains("dark_oak")) &&
                (event.getName().getNamespace().equals("minecraft") || RepurposedStructures.RSMineshaftsConfig.addMineshaftsToModdedBiomes.get())) {
            if (event.getGeneration().getStructures().removeIf((supplier) -> supplier.get().feature == Structure.MINESHAFT)) {
                // replace vanilla mineshaft with our own
                event.getGeneration().getStructures().add(() -> RSConfiguredStructures.SWAMP_OR_DARK_FOREST_MINESHAFT);
            }
        }
        else if (RepurposedStructures.RSMineshaftsConfig.endMineshaftSpawnrate.get() != 0 &&
                event.getCategory() == Category.THEEND && !event.getName().equals(new ResourceLocation("minecraft:the_end")) &&
                (RepurposedStructures.RSMineshaftsConfig.barrensIslandsEndMineshafts.get() ||
                        (!event.getName().equals(new ResourceLocation("minecraft:end_barrens")) && !event.getName().equals(new ResourceLocation("minecraft:small_end_islands")))) &&
                (event.getName().getNamespace().equals("minecraft") || RepurposedStructures.RSMineshaftsConfig.addMineshaftsToModdedBiomes.get())) {
                event.getGeneration().getStructures().add(() -> RSConfiguredStructures.END_MINESHAFT);
        }
        else if (RepurposedStructures.RSMineshaftsConfig.netherMineshaftSpawnrate.get() != 0 && event.getCategory() == Category.NETHER &&
                (event.getName().getNamespace().equals("minecraft") || RepurposedStructures.RSMineshaftsConfig.addMineshaftsToModdedBiomes.get())) {
            event.getGeneration().getStructures().add(() -> RSConfiguredStructures.NETHER_MINESHAFT);
        }
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // DUNGEONS //

    public static void addDungeons(BiomeLoadingEvent event) {

        if (RepurposedStructures.RSDungeonsConfig.jungleDungeonSpawnrate.get() != 0 &&
                event.getCategory() == Category.JUNGLE && dungeonAllowedByNamespaceAndConfigUA(event.getName())) {

            replaceOrAddDungeon(true, event, RSConfiguredFeatures.JUNGLE_DUNGEONS);
        }
        else if (RepurposedStructures.RSDungeonsConfig.badlandsDungeonSpawnrate.get() != 0 &&
                event.getCategory() == Category.MESA && dungeonAllowedByNamespaceAndConfigUA(event.getName())) {

            replaceOrAddDungeon(true, event, RSConfiguredFeatures.BADLANDS_DUNGEONS);
        }
        else if (RepurposedStructures.RSDungeonsConfig.darkForestDungeonSpawnrate.get() != 0 &&
                event.getName().getPath().contains("dark_forest") && dungeonAllowedByNamespaceAndConfigUA(event.getName())) {

            replaceOrAddDungeon(true, event, RSConfiguredFeatures.DARK_FOREST_DUNGEONS);
        }
        else if (RepurposedStructures.RSDungeonsConfig.desertDungeonSpawnrate.get() != 0 &&
                event.getCategory() == Category.DESERT && dungeonAllowedByNamespaceAndConfigUA(event.getName())) {

            replaceOrAddDungeon(true, event, RSConfiguredFeatures.DESERT_DUNGEONS);
        }
        else if (RepurposedStructures.RSDungeonsConfig.mushroomDungeonSpawnrate.get() != 0 &&
                event.getCategory() == Category.MUSHROOM && dungeonAllowedByNamespaceAndConfigUA(event.getName())) {

            replaceOrAddDungeon(true, event, RSConfiguredFeatures.MUSHROOM_DUNGEONS);
        }
        else if (RepurposedStructures.RSDungeonsConfig.swampDungeonSpawnrate.get() != 0 &&
                event.getCategory() == Category.SWAMP && dungeonAllowedByNamespaceAndConfigUA(event.getName())) {

            replaceOrAddDungeon(true, event, RSConfiguredFeatures.SWAMP_DUNGEONS);
        }
        else if (RepurposedStructures.RSDungeonsConfig.snowDungeonSpawnrate.get() != 0 &&
                event.getCategory() == Category.ICY && dungeonAllowedByNamespaceAndConfigUA(event.getName())) {

            replaceOrAddDungeon(true, event, RSConfiguredFeatures.SNOW_DUNGEONS);
        }
        else if (RepurposedStructures.RSDungeonsConfig.netherDungeonSpawnrate.get() != 0 &&
                event.getCategory() == Category.NETHER && dungeonAllowedByNamespaceAndConfigUA(event.getName())) {

            replaceOrAddDungeon(false, event, RSConfiguredFeatures.NETHER_DUNGEONS);
        }
        else if (RepurposedStructures.RSDungeonsConfig.endDungeonSpawnrate.get() != 0 &&
                (event.getCategory() == Category.THEEND &&
                        !event.getName().equals(new ResourceLocation("minecraft:the_end")) &&
                        !event.getName().equals(new ResourceLocation("minecraft:small_end_islands"))) &&
                dungeonAllowedByNamespaceAndConfigUA(event.getName())) {

            replaceOrAddDungeon(false, event, RSConfiguredFeatures.END_DUNGEONS);
        }
        else if (RepurposedStructures.RSDungeonsConfig.oceanDungeonSpawnrate.get() != 0 &&
                event.getCategory() == Category.OCEAN && dungeonAllowedByNamespaceAndConfig(event.getName())) {

            replaceOrAddDungeon(false, event, RSConfiguredFeatures.OCEAN_DUNGEONS);
        }
    }


    /**
     * Adds RS's dungeon to the biome along with option to remove vanilla dungeon as well.
     */
    private static void replaceOrAddDungeon(boolean replacing, BiomeLoadingEvent event, ConfiguredFeature<?, ?> rsDungeon) {

        //remove vanilla dungeon
        if (replacing) {
            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_STRUCTURES).removeIf(supplier -> supplier.get().feature.equals(Features.MONSTER_ROOM.feature));
        }

        //add given dungeon
        event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_STRUCTURES).add(() -> rsDungeon);
    }


    /**
     * Will not return true for Ultra Amplified Dimension's biomes as that mod already has the dungeon type.
     * <p>
     * And will check if the dungeon is allowed in modded biomes based on config but will always return true for vanilla biomes.
     */
    private static boolean dungeonAllowedByNamespaceAndConfigUA(ResourceLocation biomeID) {
        if (!biomeID.getNamespace().equals("ultra_amplified_dimension")) {
            return dungeonAllowedByNamespaceAndConfig(biomeID);
        }
        return false;
    }


    /**
     * Will check if the dungeon is allowed in modded biomes based on config but will always return true for vanilla biomes.
     */
    private static boolean dungeonAllowedByNamespaceAndConfig(ResourceLocation biomeID) {
        return biomeID.getNamespace().equals("minecraft") || RepurposedStructures.RSDungeonsConfig.addDungeonsToModdedBiomes.get();
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // WELLS //

    public static void addWells(BiomeLoadingEvent event) {

        if (RepurposedStructures.RSWellsConfig.badlandsWellSpawnrate.get() != 10000 &&
                event.getCategory() == Category.MESA && wellAllowedByNamespaceAndConfig(event.getName())) {

            event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES)
                    .add(() -> RSConfiguredFeatures.BADLANDS_WELL);
        }
        else if (RepurposedStructures.RSWellsConfig.netherWellSpawnrate.get() != 10000 &&
                event.getCategory() == Category.NETHER && wellAllowedByNamespaceAndConfig(event.getName())) {

            event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES)
                    .add(() -> RSConfiguredFeatures.NETHER_WELL);
        }
        else if (RepurposedStructures.RSWellsConfig.snowWellSpawnrate.get() != 10000 &&
                (event.getCategory() == Category.ICY || event.getName().getPath().contains("snow")) && wellAllowedByNamespaceAndConfig(event.getName())) {

            event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES)
                    .add(() -> RSConfiguredFeatures.SNOW_WELL);
        }
        else if (RepurposedStructures.RSWellsConfig.mossyStoneWellSpawnrate.get() != 10000 &&
                (event.getCategory() == Category.SWAMP || event.getCategory() == Category.JUNGLE ||
                        event.getName().getPath().contains("dark_forest") || event.getName().getPath().contains("dark_oak")) &&
                wellAllowedByNamespaceAndConfig(event.getName())) {

            event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES)
                    .add(() -> RSConfiguredFeatures.MOSSY_STONE_WELL);
        }
        else if (RepurposedStructures.RSWellsConfig.forestWellSpawnrate.get() != 10000 &&
                (event.getCategory() == Category.FOREST && !(event.getName().getPath().contains("dark_forest") || event.getName().getPath().contains("dark_oak"))) &&
                wellAllowedByNamespaceAndConfig(event.getName())) {

            event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES)
                    .add(() -> RSConfiguredFeatures.FOREST_WELL);
        }
    }


    private static boolean wellAllowedByNamespaceAndConfig(ResourceLocation biomeID) {
        return biomeID.getNamespace().equals("minecraft") || RepurposedStructures.RSWellsConfig.addWellsToModdedBiomes.get();
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // SWAMP TREE FEATURES //

    private static final BaseTreeFeatureConfig TREE_FEATURE_CONFIG = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
            new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
            new BlobFoliagePlacer(FeatureSpread.of(3), FeatureSpread.of(0), 3),
            new StraightTrunkPlacer(5, 3, 0),
            new TwoLayerFeature(1, 0, 1))).build();

    public static void addSwampTreeFeatures(BiomeLoadingEvent event) {

        // Exists in vanilla Swamp and can be in modded swamp biomes
        if (RepurposedStructures.RSMainConfig.hornedSwampTree.get() &&
                (event.getName().equals(new ResourceLocation("minecraft:swamp")) ||
                (RepurposedStructures.RSMainConfig.addLargeSwampTreeModdedBiomes.get() &&
                        event.getCategory() == Category.SWAMP &&
                        !event.getName().getNamespace().equals("ultra_amplified_dimension") &&
                        !event.getName().getNamespace().equals("minecraft")))){

            event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION)
                    .add(() -> RSFeatures.HORNED_SWAMP_TREE.configure(TREE_FEATURE_CONFIG)
                            .decorate(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.7F, 1))
                            .decorate(Features.Placements.SQUARE_HEIGHTMAP)));
        }

        // Only exists in vanilla Swamp Hills biomes
        else if (RepurposedStructures.RSMainConfig.hornedSwampTree.get() &&
                (event.getName().equals(new ResourceLocation("minecraft:swamp_hills")))) {

            // replace the swamp tree with our own
            event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION)
                    .removeIf(configuredFeature -> configuredFeature.get().config instanceof DecoratedFeatureConfig &&
                            serializeAndCompareFeature(configuredFeature.get(), Features.SWAMP_TREE));

            event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION)
                    .add(() -> RSFeatures.HORNED_SWAMP_TREE.configure(TREE_FEATURE_CONFIG)
                            .decorate(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(2, 0.8F, 1))
                            .decorate(Features.Placements.SQUARE_HEIGHTMAP)));
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // BOULDER FEATURES //

    public static void addBoulderFeatures(BiomeLoadingEvent event) {

        if (RepurposedStructures.RSMainConfig.boulderGiant.get() && !event.getName().getNamespace().equals("ultra_amplified_dimension") &&
                ((event.getName().equals(new ResourceLocation("minecraft:giant_spruce_taiga_hills")) || event.getName().equals(new ResourceLocation("minecraft:giant_tree_taiga_hills"))) ||
                        (RepurposedStructures.RSMainConfig.addGiantBouldersModdedBiomes.get() && !event.getName().getNamespace().equals("minecraft") &&
                                ((event.getName().getPath().contains("giant") && event.getName().getPath().contains("taiga")) || event.getName().getPath().contains("redwood"))))) {

            // replace the boulders with our own
            event.getGeneration().getFeatures(GenerationStage.Decoration.LOCAL_MODIFICATIONS)
                    .removeIf(configuredFeature -> configuredFeature.get().config instanceof DecoratedFeatureConfig &&
                            serializeAndCompareFeature(configuredFeature.get(), Features.FOREST_ROCK));

            event.getGeneration().getFeatures(GenerationStage.Decoration.LOCAL_MODIFICATIONS)
                    .add(() -> RSConfiguredFeatures.BOULDER_GIANT);
        }
        else if (RepurposedStructures.RSMainConfig.boulderTiny.get() && !event.getName().getNamespace().equals("ultra_amplified_dimension") &&
                ((event.getName().equals(new ResourceLocation("minecraft:snowy_taiga_mountains")) || event.getName().equals(new ResourceLocation("minecraft:taiga_mountains"))) ||
                        (RepurposedStructures.RSMainConfig.addTinyBouldersModdedBiomes.get() && !event.getName().getNamespace().equals("minecraft") &&
                                event.getName().getPath().contains("taiga") && (event.getName().getPath().contains("mountain") || event.getName().getPath().contains("hill"))))) {

            event.getGeneration().getFeatures(GenerationStage.Decoration.LOCAL_MODIFICATIONS)
                    .add(() -> RSConfiguredFeatures.BOULDER_TINY);
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // STRONGHOLDS //

    public static void addStrongholds(BiomeLoadingEvent event) {

        if (RepurposedStructures.RSStrongholdsConfig.allowStonebrickStronghold.get() &&
                RepurposedStructures.RSStrongholdsConfig.stonebrickStrongholdSpawnrate.get() != 1001 &&
                event.getCategory() != Category.NETHER &&
                (event.getGeneration().getStructures().removeIf((supplier) -> supplier.get().feature.equals(Structure.STRONGHOLD)) ||
                        (!event.getName().getNamespace().equals("minecraft") && RepurposedStructures.RSStrongholdsConfig.addStonebrickStrongholdToModdedBiomes.get()))) {

            //replace vanilla stronghold with ours if vanilla's is present
            event.getGeneration().getStructures().add(() -> RSConfiguredStructures.STONEBRICK_STRONGHOLD);

            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_DECORATION)
                    .add(() -> RSConfiguredFeatures.STONEBRICK_STRONGHOLD_CHAINS);
        }

        else if (RepurposedStructures.RSStrongholdsConfig.netherStrongholdSpawnrate.get() != 1001 && event.getCategory() == Category.NETHER &&
                (event.getName().getNamespace().equals("minecraft") || RepurposedStructures.RSStrongholdsConfig.addNetherStrongholdToModdedBiomes.get())) {

            event.getGeneration().getStructures().add(() -> RSConfiguredStructures.NETHER_STRONGHOLD);

            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_DECORATION)
                    .add(() -> RSConfiguredFeatures.NETHER_STRONGHOLD_CHAINS);
        }
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // OUTPOSTS //

    public static void addOutposts(BiomeLoadingEvent event) {

        //Nether based Outposts
        if(event.getCategory() == Category.NETHER)
        {
            if (RepurposedStructures.RSOutpostsConfig.crimsonOutpostSpawnrate.get() != 1001 &&
                    event.getName().getPath().contains("crimson") &&
                    (event.getName().getNamespace().equals("minecraft") || RepurposedStructures.RSOutpostsConfig.addCrimsonOutpostToModdedBiomes.get())) {
                event.getGeneration().getStructures().add(() -> RSConfiguredStructures.CRIMSON_OUTPOST);
            }
            else if (RepurposedStructures.RSOutpostsConfig.warpedOutpostSpawnrate.get() != 1001 &&
                    event.getName().getPath().contains("warped") &&
                    (event.getName().getNamespace().equals("minecraft") || RepurposedStructures.RSOutpostsConfig.addWarpedOutpostToModdedBiomes.get())) {
                event.getGeneration().getStructures().add(() -> RSConfiguredStructures.WARPED_OUTPOST);
            }
            else if (RepurposedStructures.RSOutpostsConfig.netherBrickOutpostSpawnrate.get() != 1001 &&
                    (event.getName().getNamespace().equals("minecraft") || RepurposedStructures.RSOutpostsConfig.addNetherBrickOutpostToModdedBiomes.get())) {
                event.getGeneration().getStructures().add(() -> RSConfiguredStructures.NETHER_BRICK_OUTPOST);
            }
        }
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // OUTPOSTS //

    public static void addShipwrecks(BiomeLoadingEvent event) {

        if (RepurposedStructures.RSShipwrecksConfig.endShipwreckSpawnrate.get() != 1001 &&
                (event.getName().equals(new ResourceLocation("minecraft:end_highlands")) ||
                (!event.getName().getNamespace().equals("minecraft") && event.getCategory() == Category.THEEND &&
                RepurposedStructures.RSShipwrecksConfig.addEndShipwreckToModdedBiomes.get()))) {
            event.getGeneration().getStructures().add(() -> RSConfiguredStructures.END_SHIPWRECK);
        }


        //Nether based Shipwrecks
        if(event.getCategory() == Category.NETHER)
        {
            if (RepurposedStructures.RSShipwrecksConfig.crimsonShipwreckSpawnrate.get() != 1001 &&
                    event.getName().getPath().contains("crimson") &&
                    (event.getName().getNamespace().equals("minecraft") || RepurposedStructures.RSShipwrecksConfig.addCrimsonShipwreckToModdedBiomes.get())) {

                event.getGeneration().getStructures().add(() -> RSConfiguredStructures.CRIMSON_SHIPWRECK);
            }

            else if (RepurposedStructures.RSShipwrecksConfig.warpedShipwreckSpawnrate.get() != 1001 &&
                    event.getName().getPath().contains("warped") &&
                    (event.getName().getNamespace().equals("minecraft") || RepurposedStructures.RSShipwrecksConfig.addCrimsonShipwreckToModdedBiomes.get())) {

                event.getGeneration().getStructures().add(() -> RSConfiguredStructures.WARPED_SHIPWRECK);
            }

            else if (RepurposedStructures.RSShipwrecksConfig.netherBricksShipwreckSpawnrate.get() != 1001 &&
                    (event.getName().getNamespace().equals("minecraft") || RepurposedStructures.RSShipwrecksConfig.addNetherBricksShipwreckToModdedBiomes.get())) {

                event.getGeneration().getStructures().add(() -> RSConfiguredStructures.NETHER_BRICKS_SHIPWRECK);
            }
        }
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // JUNGLE FORTRESS //

    public static void addJungleFortress(BiomeLoadingEvent event) {
        if(RepurposedStructures.RSMainConfig.jungleFortressSpawnrate.get() != 1001)
        {
            if ( event.getCategory() == Category.JUNGLE &&
                    (event.getName().getNamespace().equals("minecraft") || RepurposedStructures.RSMainConfig.addJungleFortressToModdedBiomes.get())) {
                event.getGeneration().getStructures().add(() -> RSConfiguredStructures.JUNGLE_FORTRESS);
            }
            event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION)
                    .add(() -> RSConfiguredFeatures.JUNGLE_FORTRESS_VINES);

            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES)
                    .add(() -> RSConfiguredFeatures.FORTRESS_BREAKAGE);
        }
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // TEMPLES //

    public static void addTemples(BiomeLoadingEvent event) {

        if (RepurposedStructures.RSTemplesConfig.netherBasaltTempleSpawnrate.get() != 1001 &&
                event.getCategory() == Category.NETHER && (event.getName().getPath().contains("basalt") || event.getName().getPath().contains("blackstone")) &&
                (event.getName().getNamespace().equals("minecraft") || RepurposedStructures.RSTemplesConfig.addNetherBasaltTempleToModdedBiomes.get())) {
            event.getGeneration().getStructures().add(() -> RSConfiguredStructures.NETHER_BASALT_TEMPLE);
        }
        else if (RepurposedStructures.RSTemplesConfig.netherCrimsonTempleSpawnrate.get() != 1001 &&
                event.getCategory() == Category.NETHER && event.getName().getPath().contains("crimson") &&
                (event.getName().getNamespace().equals("minecraft") || RepurposedStructures.RSTemplesConfig.addNetherCrimsonTempleToModdedBiomes.get())) {
            event.getGeneration().getStructures().add(() -> RSConfiguredStructures.NETHER_CRIMSON_TEMPLE);
        }
        else if (RepurposedStructures.RSTemplesConfig.netherWarpedTempleSpawnrate.get() != 1001 &&
                event.getCategory() == Category.NETHER && event.getName().getPath().contains("warped") &&
                (event.getName().getNamespace().equals("minecraft") || RepurposedStructures.RSTemplesConfig.addNetherWarpedTempleToModdedBiomes.get())) {
            event.getGeneration().getStructures().add(() -> RSConfiguredStructures.NETHER_WARPED_TEMPLE);
        }
        else if (RepurposedStructures.RSTemplesConfig.netherSoulTempleSpawnrate.get() != 1001 &&
                event.getCategory() == Category.NETHER && event.getName().getPath().contains("soul") &&
                (event.getName().getNamespace().equals("minecraft") || RepurposedStructures.RSTemplesConfig.addNetherSoulTempleToModdedBiomes.get())) {
            event.getGeneration().getStructures().add(() -> RSConfiguredStructures.NETHER_SOUL_TEMPLE);
        }
        else if (RepurposedStructures.RSTemplesConfig.netherWastelandTempleSpawnrate.get() != 1001 &&
                event.getCategory() == Category.NETHER &&
                (event.getName().getNamespace().equals("minecraft") || RepurposedStructures.RSTemplesConfig.addNetherWastelandTempleToModdedBiomes.get())) {
            event.getGeneration().getStructures().add(() -> RSConfiguredStructures.NETHER_WASTELAND_TEMPLE);
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Pyramids //

    public static void addPyramids(BiomeLoadingEvent event) {

        if (RepurposedStructures.RSTemplesConfig.netherPyramidSpawnrate.get() != 1001 && event.getCategory() == Category.NETHER &&
                (event.getName().getNamespace().equals("minecraft") || RepurposedStructures.RSTemplesConfig.addNetherPyramidToModdedBiomes.get())) {
            event.getGeneration().getStructures().add(() -> RSConfiguredStructures.NETHER_PYRAMID);
        }

        if (RepurposedStructures.RSTemplesConfig.badlandsPyramidSpawnrate.get() != 1001 && event.getCategory() == Category.MESA &&
                (event.getName().getNamespace().equals("minecraft") || RepurposedStructures.RSTemplesConfig.addBadlandsPyramidToModdedBiomes.get())) {
            event.getGeneration().getStructures().add(() -> RSConfiguredStructures.BADLANDS_TEMPLE);
        }
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // IGLOOS //

    public static void addIgloos(BiomeLoadingEvent event) {
        if (RepurposedStructures.RSMainConfig.grassyIglooSpawnrate.get() != 1001) {
            if ((event.getCategory() == Category.FOREST || event.getCategory() == Category.PLAINS) &&
                    (event.getName().getNamespace().equals("minecraft") || RepurposedStructures.RSMainConfig.addGrassyIglooToModdedBiomes.get())) {
                event.getGeneration().getStructures().add(() -> RSConfiguredStructures.GRASSY_IGLOO);
            }
        }

        if (RepurposedStructures.RSMainConfig.stoneIglooSpawnrate.get() != 1001) {
            if ((event.getCategory() == Category.TAIGA && event.getName().getPath().contains("giant")) &&
                    (event.getName().getNamespace().equals("minecraft") || RepurposedStructures.RSMainConfig.addStoneIglooToModdedBiomes.get())) {
                event.getGeneration().getStructures().add(() -> RSConfiguredStructures.STONE_IGLOO);
            }
        }
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // VILLAGES //

    public static void addVillages(BiomeLoadingEvent event) {
        if ((event.getCategory() == Category.MESA && !event.getName().getPath().contains("plateau")) &&
                (event.getName().getNamespace().equals("minecraft") || RepurposedStructures.RSVillagesConfig.addVillagesToModdedBiomes.get())) {
            if (RepurposedStructures.RSVillagesConfig.badlandsVillageSpawnrate.get() != 1001) {
                event.getGeneration().getStructures().add(() -> RSConfiguredStructures.BADLANDS_VILLAGE);
            }
        }

        else if (event.getName().getPath().contains("birch") && (event.getName().getNamespace().equals("minecraft") ||
                RepurposedStructures.RSVillagesConfig.addVillagesToModdedBiomes.get())) {
            if (RepurposedStructures.RSVillagesConfig.birchVillageSpawnrate.get() != 1001) {
                event.getGeneration().getStructures().add(() -> RSConfiguredStructures.BIRCH_VILLAGE);
            }
        }

        else if (event.getName().getPath().contains("dark_forest") && (event.getName().getNamespace().equals("minecraft") ||
                RepurposedStructures.RSVillagesConfig.addVillagesToModdedBiomes.get())) {
            if (RepurposedStructures.RSVillagesConfig.darkForestVillageSpawnrate.get() != 1001) {
                event.getGeneration().getStructures().add(() -> RSConfiguredStructures.DARK_FOREST_VILLAGE);
            }
        }

        else if (event.getCategory() == Category.JUNGLE && (event.getName().getNamespace().equals("minecraft") ||
                RepurposedStructures.RSVillagesConfig.addVillagesToModdedBiomes.get())) {
            if (RepurposedStructures.RSVillagesConfig.jungleVillageSpawnrate.get() != 1001) {
                event.getGeneration().getStructures().add(() -> RSConfiguredStructures.JUNGLE_VILLAGE);
                event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION)
                        .add(() -> RSConfiguredFeatures.JUNGLE_VILLAGE_VINES);
            }
        }

        else if (event.getCategory() == Category.SWAMP && (event.getName().getNamespace().equals("minecraft") ||
                RepurposedStructures.RSVillagesConfig.addVillagesToModdedBiomes.get())) {
            if (RepurposedStructures.RSVillagesConfig.swampVillageSpawnrate.get() != 1001) {
                event.getGeneration().getStructures().add(() -> RSConfiguredStructures.SWAMP_VILLAGE);
                event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION)
                        .add(() -> RSConfiguredFeatures.SWAMP_VILLAGE_VINES);
            }
        }

        else if (event.getCategory() == Category.EXTREME_HILLS && (event.getName().getNamespace().equals("minecraft") ||
                RepurposedStructures.RSVillagesConfig.addVillagesToModdedBiomes.get())) {
            if (RepurposedStructures.RSVillagesConfig.mountainsVillageSpawnrate.get() != 1001) {
                event.getGeneration().getStructures().add(() -> RSConfiguredStructures.MOUNTAINS_VILLAGE);
            }
        }

        else if ((event.getName().equals(new ResourceLocation("minecraft:giant_spruce_taiga")) || event.getName().equals(new ResourceLocation("minecraft:giant_tree_taiga"))) ||
                (!event.getName().getNamespace().equals("minecraft") &&
                  RepurposedStructures.RSVillagesConfig.addVillagesToModdedBiomes.get() &&
                ((event.getName().getPath().contains("giant") && event.getName().getPath().contains("taiga")) || event.getName().getPath().contains("redwood")))) {
            if (RepurposedStructures.RSVillagesConfig.giantTaigaVillageSpawnrate.get() != 1001) {
                event.getGeneration().getStructures().add(() -> RSConfiguredStructures.GIANT_TAIGA_VILLAGE);
            }
        }
        else if (RepurposedStructures.RSVillagesConfig.crimsonVillageSpawnrate.get() != 1001 &&
                event.getCategory() == Category.NETHER && event.getName().getPath().contains("crimson") &&
                (event.getName().getNamespace().equals("minecraft") || RepurposedStructures.RSVillagesConfig.addVillagesToModdedBiomes.get())) {
            event.getGeneration().getStructures().add(() -> RSConfiguredStructures.CRIMSON_VILLAGE);
        }
        else if (RepurposedStructures.RSVillagesConfig.warpedVillageSpawnrate.get() != 1001 &&
                event.getCategory() == Category.NETHER && event.getName().getPath().contains("warped") &&
                (event.getName().getNamespace().equals("minecraft") || RepurposedStructures.RSVillagesConfig.addVillagesToModdedBiomes.get())) {
            event.getGeneration().getStructures().add(() -> RSConfiguredStructures.WARPED_VILLAGE);
        }
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // GENERAL UTILITIES //

    /**
     * Will serialize (if possible) both features and check if they are the same feature.
     * If cannot serialize, compare the feature itself to see if it is the same.
     */
    private static boolean serializeAndCompareFeature(ConfiguredFeature<?, ?> configuredFeature1, ConfiguredFeature<?, ?> configuredFeature2) {

        Optional<JsonElement> configuredFeatureJSON1 = ConfiguredFeature.CODEC.encode(() -> configuredFeature1, JsonOps.INSTANCE, JsonOps.INSTANCE.empty()).get().left();
        Optional<JsonElement> configuredFeatureJSON2 = ConfiguredFeature.CODEC.encode(() -> configuredFeature2, JsonOps.INSTANCE, JsonOps.INSTANCE.empty()).get().left();

        // One of the configuredfeatures cannot be serialized which
        // shouldn't be possible but still good to do a sanity check.
        if(!configuredFeatureJSON1.isPresent() || !configuredFeatureJSON2.isPresent())
        {
            if ((configuredFeature1.config instanceof DecoratedFeatureConfig && configuredFeature2.config instanceof DecoratedFeatureConfig) &&
                    ((DecoratedFeatureConfig) configuredFeature1.config).feature.get().feature == ((DecoratedFeatureConfig) configuredFeature2.config).feature.get().feature) {
                return true;
            }
        }

        // Compare the JSON to see if it's the same ConfiguredFeature in the end.
        return configuredFeatureJSON1.equals(configuredFeatureJSON2);
    }

}
