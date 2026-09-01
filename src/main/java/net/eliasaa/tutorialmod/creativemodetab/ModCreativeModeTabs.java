package net.eliasaa.tutorialmod.creativemodetab;

import net.eliasaa.tutorialmod.Tutorialod;
import net.eliasaa.tutorialmod.block.ModBlocks;
import net.eliasaa.tutorialmod.item.modItems;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {
    public static final CreativeModeTab FLUORITE_ITEM_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(Tutorialod.MOD_ID, "flourite_items"),
            FabricCreativeModeTab.builder().icon(()-> new ItemStack(modItems.FLUORITE))
                    .title(Component.translatable("creativemodetab.tutorialmod.fluorite_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(modItems.FLUORITE);
                        output.accept(modItems.RAW_FLUORITE);


                    }).build());


    public static final CreativeModeTab FLUORITE_BLOCK_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(Tutorialod.MOD_ID, "flourite_blocks"),
            FabricCreativeModeTab.builder().icon(()-> new ItemStack(ModBlocks.FLUORITE_BLOCK))
                    .title(Component.translatable("creativemodetab.tutorialmod.fluorite_blocks"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.FLUORITE_BLOCK);
                        output.accept(ModBlocks.RAW_FLUORITE_BLOCK);



                    }).build());





    public static void registerModCreativeModeTabs () {
        Tutorialod.LOGGER.info("Registering Creative Mode Tabs for " + Tutorialod.MOD_ID);






    }
}
