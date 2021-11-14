package io.github.shaksternano.wmitef.client.plugin.waila;

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

import java.util.Map;
import java.util.Optional;

@Environment(EnvType.CLIENT)
public final class TooltipUtil {

    private TooltipUtil() {}

    // Returns the name of the mod that adds the first registered enchantment on an enchanted book.
    @Nullable
    public static String replaceEnchantmentModName(ItemStack stack) {
        if (stack.isOf(Items.ENCHANTED_BOOK)) {
            Map<Enchantment, Integer> enchantments = EnchantmentHelper.get(stack);

            for (Enchantment enchantment : enchantments.keySet()) {
                Identifier enchantmentId = EnchantmentHelper.getEnchantmentId(enchantment);

                if (enchantmentId != null) {
                    String namespace = enchantmentId.getNamespace();

                    // Return "Minecraft" if it's a vanilla enchantment.
                    if (namespace.equals(Identifier.DEFAULT_NAMESPACE)) {
                        return "Minecraft";
                    } else {
                        Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer(namespace);

                        if (modContainer.isPresent()) {
                            return modContainer.get().getMetadata().getName();
                        }
                    }
                }
            }
        }

        return null;
    }
}
