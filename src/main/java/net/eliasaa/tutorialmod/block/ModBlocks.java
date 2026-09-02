package net.eliasaa.tutorialmod.block;

import net.eliasaa.tutorialmod.Tutorialod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class ModBlocks {
    public static final Block FLUORITE_BLOCK = registerBlock("fluorite_block",
            properties -> new Block(properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final Block RAW_FLUORITE_BLOCK = registerBlock("raw_fluorite_block",
            properties -> new Block(properties.strength(3f)
                    .requiresCorrectToolForDrops()));

    public static final Block FLUORITE_ORE = registerBlock("fluorite_ore",
            properties -> new DropExperienceBlock(UniformInt.of(2, 5),
                    properties.strength(3f).requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE)));

    public static final Block FLUORITE_DEEPSLATE_ORE = registerBlock("fluorite_deepslate_ore",
            properties -> new DropExperienceBlock(UniformInt.of(3, 6),
                    properties.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHER_ORE)));

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function){
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Tutorialod.MOD_ID, name))));

        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(Tutorialod.MOD_ID, name),toRegister);

    }


    private static void registerBlockItem(String name, Block block){

        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Tutorialod.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Tutorialod.MOD_ID, name)))));
    }

    public static ResourceKey<Block> getKey(Block block) {
        return ResourceKey.create(Registries.BLOCK, BuiltInRegistries.BLOCK.getKey(block));
    }

    public static void registerModBlocks (){
        Tutorialod.LOGGER.info("Registering Mod Blocks for " + Tutorialod.MOD_ID);




    }
}
