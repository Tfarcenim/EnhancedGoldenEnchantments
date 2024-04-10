package tfar.enhancedgoldenenchantments;

import net.minecraft.world.level.GameRules;

public class ModGamerules {
    public static GameRules.Key<GameRules.IntegerValue> goldenMultiplier = GameRules.register(EnhancedGoldenEnchantments.MOD_ID+":golden_multiplier",
            GameRules.Category.MISC, GameRules.IntegerValue.create(2));
    public static void poke() {}
}
