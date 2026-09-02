package net.eliasaa.tutorialmod.datagen;


import net.eliasaa.tutorialmod.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.Tag;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;


import static net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.FLUORITE_BLOCK.get())
                .add(ModBlocks.RAW_FLUORITE_BLOCK.get())
                .add(ModBlocks.FLUORITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.FLUORITE_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.FLUORITE_DEEPSLATE_ORE)

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.FLUORITE_ORE)




    }


}
