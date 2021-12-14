package io.github.shaksternano.wmitaf.mixin.client.plugin;

import io.github.shaksternano.wmitaf.client.util.ModNameUtil;
import me.shedaniel.rei.impl.AbstractEntryStack;
import me.shedaniel.rei.impl.ItemEntryStack;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@SuppressWarnings("UnstableApiUsage")
@Environment(EnvType.CLIENT)
@Pseudo
@Mixin(ItemEntryStack.class)
abstract class ItemEntryStackMixin extends AbstractEntryStack {

    // Sets the mod name in the REI tooltip to be the name of the mod that adds the first enchantment on an item if it's an enchanted book, or the name of the mod that adds the first effect on an item if it's a potion.
    @Redirect(method = "getTooltip", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Identifier;getNamespace()Ljava/lang/String;"), require = 0)
    private String reiModNameOverrideOld(Identifier getId) {
        String modId = ModNameUtil.getActualModId((ItemStack) getObject());
        return modId == null ? Registry.ITEM.getId(getItem()).getNamespace() : modId;
    }
}
