package io.github.shaksternano.wmitaf.mixin.client;

import io.github.shaksternano.wmitaf.client.util.TooltipUtil;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.plugin.client.entry.ItemEntryDefinition;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.ItemStack;
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

    // Sets the mod name in the REI tooltip to be the name of the mod that adds the first enchantment on an item if it's an enchanted book, or the name of the mod that adds the first effect on an item if it's a potion.
    @Inject(method = "getIdentifier(Lme/shedaniel/rei/api/common/entry/EntryStack;Lnet/minecraft/item/ItemStack;)Lnet/minecraft/util/Identifier;", at = @At("HEAD"), cancellable = true, require = 0)
    private void reiModNameOverride(EntryStack<ItemStack> entry, ItemStack value, CallbackInfoReturnable<Identifier> cir) {
        Identifier identifier = TooltipUtil.getIdentifierFromStackData(value);
        if (identifier != null) {
            cir.setReturnValue(identifier);
        }
    }
}
