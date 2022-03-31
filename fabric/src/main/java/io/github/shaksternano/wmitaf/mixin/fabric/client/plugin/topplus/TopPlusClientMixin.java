package io.github.shaksternano.wmitaf.mixin.fabric.client.plugin.topplus;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import io.github.shaksternano.wmitaf.client.util.fabric.ModNameUtil;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;

@SuppressWarnings("unused")
@Environment(EnvType.CLIENT)
@Pseudo
@Mixin(targets = "me.alphamode.top_plus.TopPlusClient", remap = false)
abstract class TopPlusClientMixin {

    /**
     * Changes the mod ID of an {@link ItemStack} used by TOP Plus
     * to the actual mod ID in order to change the mod name in the
     * tooltip added by TOP Plus to the actual mod name.
     *
     * @param modId The original mod ID used by TOP Plus.
     * @param stack The ItemStack to get the actual mod ID of.
     * @return The actual mod ID of the ItemStack.
     */
    @ModifyExpressionValue(method = "lambda$onInitializeClient$1", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Identifier;getNamespace()Ljava/lang/String;", remap = true), require = 0)
    private static String wmitaf$changeItemStackTooltipModId(String modId, ItemStack stack) {
        return ModNameUtil.getActualModId(stack).orElse(modId);
    }
}
