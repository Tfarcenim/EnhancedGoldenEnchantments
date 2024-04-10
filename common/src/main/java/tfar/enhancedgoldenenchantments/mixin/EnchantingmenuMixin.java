package tfar.enhancedgoldenenchantments.mixin;

import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.EnchantmentMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tfar.enhancedgoldenenchantments.EnhancedGoldenEnchantments;

import java.util.List;

@Mixin(EnchantmentMenu.class)
public class EnchantingmenuMixin {

    @Shadow @Final private ContainerLevelAccess access;

    @Inject(method = "getEnchantmentList",at = @At("RETURN"))
    private void modifyEnchants(ItemStack pStack, int pEnchantSlot, int pLevel, CallbackInfoReturnable<List<EnchantmentInstance>> cir) {
        EnhancedGoldenEnchantments.enhanceIfGold(access.evaluate((level, pos) -> level).orElse(null),pStack,pEnchantSlot,pLevel,cir.getReturnValue());
    }

}
