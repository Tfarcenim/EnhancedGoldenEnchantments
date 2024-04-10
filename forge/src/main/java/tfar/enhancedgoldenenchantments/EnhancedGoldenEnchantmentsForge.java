package tfar.enhancedgoldenenchantments;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import tfar.enhancedgoldenenchantments.datagen.ModDatagen;

@Mod(EnhancedGoldenEnchantments.MOD_ID)
public class EnhancedGoldenEnchantmentsForge {
    
    public EnhancedGoldenEnchantmentsForge() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(ModDatagen::start);
        EnhancedGoldenEnchantments.init();
    }
}