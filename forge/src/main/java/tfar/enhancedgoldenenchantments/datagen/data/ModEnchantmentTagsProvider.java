package tfar.enhancedgoldenenchantments.datagen.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import tfar.enhancedgoldenenchantments.EnhancedGoldenEnchantments;

import java.util.concurrent.CompletableFuture;

public class ModEnchantmentTagsProvider extends IntrinsicHolderTagsProvider<Enchantment>  {
    public ModEnchantmentTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(output, Registries.ENCHANTMENT, lookupProvider,
                enchantment -> BuiltInRegistries.ENCHANTMENT.createIntrusiveHolder(enchantment).key(), modId, existingFileHelper);
    }
    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(EnhancedGoldenEnchantments.BLOCKED).add(Enchantments.DEPTH_STRIDER);
    }
}
