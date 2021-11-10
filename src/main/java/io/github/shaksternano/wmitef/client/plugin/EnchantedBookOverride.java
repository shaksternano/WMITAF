package io.github.shaksternano.wmitef.client.plugin;

import mcp.mobius.waila.api.IEventListener;
import mcp.mobius.waila.api.IPluginConfig;
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
public class EnchantedBookOverride implements IEventListener {

    public static final IEventListener INSTANCE = new EnchantedBookOverride();

    // Replaces "Minecraft" with the name of the mod that adds the enchantment on enchanted books.
    @Override
    @Nullable
    public String getHoveredItemModName(ItemStack stack, IPluginConfig config) {
        if (stack.isOf(Items.ENCHANTED_BOOK)) {
            Map<Enchantment, Integer> enchantments = EnchantmentHelper.get(stack);

            for (Enchantment enchantment : enchantments.keySet()) {
                Identifier enchantmentId = EnchantmentHelper.getEnchantmentId(enchantment);

                if (enchantmentId != null) {
                    String namespace = enchantmentId.getNamespace();

                    // Don't need to do anything if it's a vanilla enchantment.
                    if (!namespace.equals(Identifier.DEFAULT_NAMESPACE)) {
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
