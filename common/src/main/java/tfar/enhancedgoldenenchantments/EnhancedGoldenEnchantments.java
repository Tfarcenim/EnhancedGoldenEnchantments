package tfar.enhancedgoldenenchantments;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.level.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

// This class is part of the common project meaning it is shared between all supported loaders. Code written here can only
// import and access the vanilla codebase, libraries used by vanilla, and optionally third party libraries that provide
// common compatible binaries. This means common code can not directly use loader specific concepts such as Forge events
// however it will be compatible with all supported mod loaders.
public class EnhancedGoldenEnchantments {

    public static final String MOD_ID = "enhancedgoldenenchantments";
    public static final String MOD_NAME = "EnhancedGoldenEnchantments";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);
    public static final TagKey<Item> GOLDEN_ITEMS = TagKey.create(Registries.ITEM,new ResourceLocation(MOD_ID,"golden_items"));
    public static final TagKey<Enchantment> BLOCKED = TagKey.create(Registries.ENCHANTMENT,new ResourceLocation(MOD_ID,"blocked"));

    public static void init() {
        ModGamerules.poke();
    }

    public static void enhanceIfGold(Level level, ItemStack pStack, int pEnchantSlot, int pLevel, List<EnchantmentInstance> returnValue) {
        if (pStack.is(GOLDEN_ITEMS)) {
            for (int i = 0; i < returnValue.size(); i++) {
                EnchantmentInstance enchantmentInstance = returnValue.get(i);
                if (enchantmentInstance.enchantment.getMaxLevel() == 1) continue;

                returnValue.set(i,new EnchantmentInstance(enchantmentInstance.enchantment,enchantmentInstance.level * level.getGameRules().getInt(ModGamerules.goldenMultiplier)));
            }
        }
    }
}