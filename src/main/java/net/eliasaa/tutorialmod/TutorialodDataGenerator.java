package net.eliasaa.tutorialmod;

import net.eliasaa.tutorialmod.datagen.ModBlockLootTableProvider;
import net.eliasaa.tutorialmod.datagen.ModBlockTagsProvider;
import net.eliasaa.tutorialmod.datagen.ModModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class TutorialodDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);

		pack.addProvider(ModBlockTagsProvider::new);
		pack.addProvider(ModBlockLootTableProvider::new);

	}
}
