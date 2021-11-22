package io.github.shaksternano.wmitaf.client.util;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
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
public final class ModNameUtil {

    private ModNameUtil() {}

    // Item ID of Extra Alchemy's breakable potion.
    private static final String EXTRA_ALCHEMY_BREAKABLE_POTION_ID = "extraalchemy:breakable_potion";
    // Item ID of Patchouli's guide book.
    private static final String PATCHOULI_BOOK_ID = "patchouli:guide_book";
    // The ID of the NBT tag storing the Patchouli book ID.
    private static final String PATCHOULI_BOOK_TAG = "patchouli:book";

    // Returns the name of the mod that adds the first enchantment on an enchanted book ItemStack or the first effect on a potion.
    @Nullable
    public static String actualModName(ItemStack stack) {
        Identifier identifier = getIdentifierFromStackData(stack);
        return getModNameFromId(identifier);
    }

    // Returns the Identifier of the first enchantment on an enchanted book, or the Identifier of the first effect on a potion.
    @Nullable
    public static Identifier getIdentifierFromStackData(ItemStack stack) {
        Identifier identifier = null;

        if (stack.getItem().equals(Items.ENCHANTED_BOOK)) {
            identifier = getFirstEnchantmentId(stack);
        } else if (hasStatusEffects(stack)) {
            identifier = getFirstEffectId(stack);
        } else if (hasId(stack.getItem(), PATCHOULI_BOOK_ID)) {
            identifier = getPatchouliBookId(stack);
        }

        return identifier;
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

    // Returns the Identifier of the first enchantment on an ItemStack.
    @Nullable
    private static Identifier getFirstEnchantmentId(ItemStack stack) {
        Set<Enchantment> enchantments = EnchantmentHelper.get(stack).keySet();
        Iterator<Enchantment> enchantmentsIterator = enchantments.iterator();

        if (enchantmentsIterator.hasNext()) {
            Enchantment enchantment = enchantmentsIterator.next();
            return Registry.ENCHANTMENT.getId(enchantment);
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
                if (effectId.getNamespace().equals("minecraft")) {
                    return Registry.ITEM.getId(stack.getItem());
                } else {
                    return effectId;
                }
            }
        }

        return null;
    }

    // Returns the book Identifier in stored in the NBT of a Patchouli book.
    @SuppressWarnings("ConstantConditions")
    @Nullable
    private static Identifier getPatchouliBookId(ItemStack stack) {
        if (stack.hasTag()) {
            String bookId = stack.getTag().getString(PATCHOULI_BOOK_TAG);
            if (!bookId.equals("")) {
                return new Identifier(bookId);
            }
        }

        return null;
    }

    // Returns true if the ItemStack is a type of item that carries status effects, otherwise returns false.
    private static boolean hasStatusEffects(ItemStack stack) {
        return
            stack.getItem().equals(Items.POTION) ||
            stack.getItem().equals(Items.SPLASH_POTION) ||
            stack.getItem().equals(Items.LINGERING_POTION) ||
            stack.getItem().equals(Items.TIPPED_ARROW) ||
            hasId(stack.getItem(), EXTRA_ALCHEMY_BREAKABLE_POTION_ID);
    }

    // Returns true if the ID of the item matches the string passed as an argument.
    private static boolean hasId(Item item, String id) {
        return Registry.ITEM.getId(item).toString().equals(id);
    }
}
