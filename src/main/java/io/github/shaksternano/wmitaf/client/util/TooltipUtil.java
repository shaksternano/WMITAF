package io.github.shaksternano.wmitaf.client.util;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtil;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Environment(EnvType.CLIENT)
public final class TooltipUtil {

    private TooltipUtil() {}

    // Item ID of Extra Alchemy's breakable potion.
    public static final String EXTRA_ALCHEMY_BREAKABLE_POTION_ID = "extraalchemy:breakable_potion";

    // Returns the name of the mod that adds the first enchantment on an enchanted book ItemStack or the first effect on a potion.
    @Nullable
    public static String replaceModName(ItemStack stack) {
        Identifier identifier = getIdentifierFromStackData(stack);
        return getModNameFromId(identifier);
    }

    // Returns the Identifier of the first enchantment on an ItemStack.
    @Nullable
    private static Identifier getFirstEnchantmentId(ItemStack stack) {
        Set<Enchantment> enchantments = EnchantmentHelper.get(stack).keySet();
        Iterator<Enchantment> enchantmentsIterator = enchantments.iterator();

        if (enchantmentsIterator.hasNext()) {
            Enchantment enchantment = enchantmentsIterator.next();
            return EnchantmentHelper.getEnchantmentId(enchantment);
        } else {
            return null;
        }
    }

    // Returns the Identifier of the first effect on a potion.
    @Nullable
    private static Identifier getFirstEffectId(ItemStack stack) {
        List<StatusEffectInstance> effectInstances = PotionUtil.getPotionEffects(stack);
        Iterator<StatusEffectInstance> effectInstancesIterator = effectInstances.iterator();

        if (effectInstancesIterator.hasNext()) {
            StatusEffect effect = effectInstancesIterator.next().getEffectType();
            Identifier effectId = Registry.STATUS_EFFECT.getId(effect);

            if (effectId != null) {
                // Don't make potion types from mods with vanilla effects seem like they're from vanilla, for example a breakable potion from Extra Alchemy with the vanilla night vision effect.
                if (effectId.getNamespace().equals(Identifier.DEFAULT_NAMESPACE)) {
                    return Registry.ITEM.getId(stack.getItem());
                } else {
                    return effectId;
                }
            }
        }

        return null;
    }

    // Gets the name of a mod from an Identifier.
    @Nullable
    private static String getModNameFromId(@Nullable Identifier identifier) {
        if (identifier != null) {
            String namespace = identifier.getNamespace();
            Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer(namespace);

            if (modContainer.isPresent()) {
                return modContainer.get().getMetadata().getName();
            } else {
                return namespace;
            }
        } else {
            return null;
        }
    }

    // Returns the Identifier of the first enchantment on an enchanted book, or the Identifier of the first effect on a potion.
    @Nullable
    public static Identifier getIdentifierFromStackData(ItemStack stack) {
        Identifier identifier = null;

        if (stack.isOf(Items.ENCHANTED_BOOK)) {
            identifier = getFirstEnchantmentId(stack);
        } else if (isAPotion(stack)) {
            identifier = getFirstEffectId(stack);
        }

        return identifier;
    }

    // Returns true if the ItemStack is a type of potion, otherwise returns false.
    private static boolean isAPotion(ItemStack stack) {
        return
            stack.isOf(Items.POTION) ||
            stack.isOf(Items.SPLASH_POTION) ||
            stack.isOf(Items.LINGERING_POTION) ||
            Registry.ITEM.getId(stack.getItem()).toString().equals(EXTRA_ALCHEMY_BREAKABLE_POTION_ID);
    }
}
