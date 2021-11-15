package io.github.shaksternano.wmitef.client.util;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

@Environment(EnvType.CLIENT)
public final class TooltipUtil {

    private TooltipUtil() {}

    // Returns the Identifier of the first enchantment on an ItemStack.
    @Nullable
    public static Identifier getFirstEnchantmentId(ItemStack stack) {
        Set<Enchantment> enchantments = EnchantmentHelper.get(stack).keySet();
        Iterator<Enchantment> enchantmentsIterator = enchantments.iterator();

        if (enchantmentsIterator.hasNext()) {
            Enchantment enchantment = enchantmentsIterator.next();
            return EnchantmentHelper.getEnchantmentId(enchantment);
        } else {
            return null;
        }
    }

    // Returns the name of the mod that adds the first enchantment on an enchanted book ItemStack.
    @Nullable
    public static String replaceEnchantmentModName(ItemStack stack) {
        if (stack.isOf(Items.ENCHANTED_BOOK)) {
            Identifier enchantmentId = getFirstEnchantmentId(stack);

            if (enchantmentId != null) {
                String namespace = enchantmentId.getNamespace();
                Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer(namespace);

                if (modContainer.isPresent()) {
                    return modContainer.get().getMetadata().getName();
                }
            }
        }

        return null;
    }
}
