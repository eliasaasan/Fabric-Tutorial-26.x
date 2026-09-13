package net.eliasaa.tutorialmod.datagen;

import net.eliasaa.tutorialmod.block.ModBlocks;
import net.eliasaa.tutorialmod.item.modItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.level.ItemLike;


import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider  extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {

                List<ItemLike> FLUORITE_SMELTABLES = List.of(modItems.RAW_FLUORITE, ModBlocks.FLUORITE_ORE, modItems.FLUORITE, ModBlocks.FLUORITE_DEEPSLATE_ORE
                        , ModBlocks.FLUORITE_BLOCK);



                oreSmelting(FLUORITE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS,  modItems.FLUORITE,  0.25f, 200, "fluorite");
                oreBlasting(FLUORITE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS,  modItems.FLUORITE,  0.25f, 100, "fluorite");

                nineBlockStorageRecipes(RecipeCategory.MISC, modItems.FLUORITE, RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLUORITE_BLOCK);

                shaped(RecipeCategory.MISC, ModBlocks.RAW_FLUORITE_BLOCK)
                        .pattern("RR")
                        .pattern("RR")
                        .define('R', modItems.RAW_FLUORITE)
                        .unlockedBy(getHasName(modItems.RAW_FLUORITE), has(modItems.RAW_FLUORITE))
                        .group("fluorite")
                        .save(output);

                shapeless(RecipeCategory.MISC, modItems.RAW_FLUORITE, 9)
                        .requires(ModBlocks.RAW_FLUORITE_BLOCK)
                        .unlockedBy(getHasName(ModBlocks.RAW_FLUORITE_BLOCK), has(ModBlocks.RAW_FLUORITE_BLOCK))
                        .group("fluorite")
                        .save(output);

                shapeless(RecipeCategory.MISC, modItems.RAW_FLUORITE, 4)
                        .requires(modItems.FLUORITE)
                        .requires(Items.STICK)
                        .unlockedBy(getHasName(modItems.FLUORITE), has(modItems.FLUORITE))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .group("fluorite")
                        .save(output, "raw_fluorite_from_fluorite_and_stick");





            }
        };
    }

    @Override
    public String getName() {
        return "TutorialMod Recipes";
    }
}
