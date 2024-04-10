package tfar.enhancedgoldenenchantments.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import tfar.enhancedgoldenenchantments.datagen.data.ModBlockTagsProvider;
import tfar.enhancedgoldenenchantments.datagen.data.ModItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModDatagen {

    public static void start(GatherDataEvent e) {
        DataGenerator generator = e.getGenerator();
        ExistingFileHelper helper = e.getExistingFileHelper();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = e.getLookupProvider();

        if (e.includeServer()) {

            ModBlockTagsProvider blockTags = new ModBlockTagsProvider(output,lookupProvider, helper);
            generator.addProvider(true,blockTags);
            generator.addProvider(true,new ModItemTagsProvider(output,lookupProvider,blockTags.contentsGetter(),helper));
          //  generator.addProvider(true,new ModEnchantmentTagsProvider(output,lookupProvider, EnhancedGoldenEnchantments.MOD_ID,helper));
        }
    }
}
