package tfar.enhancedgoldenenchantments.datagen.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import tfar.enhancedgoldenenchantments.EnhancedGoldenEnchantments;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput dataGenerator, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator,lookupProvider, blockTagProvider, EnhancedGoldenEnchantments.MOD_ID, existingFileHelper);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(EnhancedGoldenEnchantments.GOLDEN_ITEMS).add(
                Items.GOLDEN_AXE,
                Items.GOLDEN_BOOTS,
                Items.GOLDEN_CHESTPLATE,
                Items.GOLDEN_HELMET,
                Items.GOLDEN_HOE,
                Items.GOLDEN_LEGGINGS,
                Items.GOLDEN_PICKAXE,
                Items.GOLDEN_SHOVEL,
                Items.GOLDEN_SWORD
                );
    }
}
