package io.github.shaksternano.wmitef.mixin.client;

import io.github.shaksternano.wmitef.client.util.TooltipUtil;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.plugin.client.entry.ItemEntryDefinition;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Pseudo
@Mixin(ItemEntryDefinition.class)
abstract class ItemEntryDefinitionMixin {

    // Sets the mod name in the REI tooltip of an enchanted book to be the mod name of it's first enchantment.
    @Inject(method = "getIdentifier(Lme/shedaniel/rei/api/common/entry/EntryStack;Lnet/minecraft/item/ItemStack;)Lnet/minecraft/util/Identifier;", at = @At("HEAD"), cancellable = true, require = 0)
    private void enchantedBookModNameOverride(EntryStack<ItemStack> entry, ItemStack value, CallbackInfoReturnable<Identifier> cir) {
        if (value.isOf(Items.ENCHANTED_BOOK)) {
            Identifier enchantmentId = TooltipUtil.getFirstEnchantmentId(value);
            if (enchantmentId != null) {
                cir.setReturnValue(enchantmentId);
            }
        }
    }
}
