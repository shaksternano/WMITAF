package io.github.shaksternano.wmitaf.mixin.client;

import io.github.shaksternano.wmitaf.client.util.TooltipUtil;
import mcp.mobius.waila.WailaClient;
import mcp.mobius.waila.utils.ModIdentification;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Environment(EnvType.CLIENT)
@Pseudo
@Mixin(WailaClient.class)
abstract class WailaClientMixin {

    // Sets the mod name in the Waila tooltip for items to be the name of the mod that adds the first enchantment on the item if it's an enchanted book, or the name of the mod that adds the first effect on the item if it's a potion.
    @Redirect(method = "onItemTooltip", at = @At(value = "INVOKE", target = "Lmcp/mobius/waila/utils/ModIdentification$Info;getName()Ljava/lang/String;"), require = 0)
    private static String wailaModNameOverride(ModIdentification.Info getModInfo, ItemStack stack) {
        String modName = TooltipUtil.actualModName(stack);
        if (modName != null) {
            return modName;
        } else {
            return ModIdentification.getModInfo(stack).getName();
        }
    }
}
