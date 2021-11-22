package io.github.shaksternano.wmitaf.client.plugin.waila;

import io.github.shaksternano.wmitaf.client.util.ModNameUtil;
import mcp.mobius.waila.Waila;
import mcp.mobius.waila.api.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

import java.util.List;

@SuppressWarnings({"rawtypes", "unchecked"})
@Environment(EnvType.CLIENT)
public enum ItemEntityComponent implements IEntityComponentProvider {

    // This is an enum.
    INSTANCE;

    // Sets the mod name in the Waila tooltip for item entities to be the name of the mod that adds the first enchantment on the item if it's an enchanted book, or the name of the mod that adds the first effect on the item if it's a potion.
    @Override
    public void appendTail(List<Text> tooltip, IEntityAccessor accessor, IPluginConfig config) {
        if (config.get(WailaConstants.CONFIG_SHOW_MOD_NAME)) {
            Entity entity = accessor.getEntity();
            if (entity instanceof ItemEntity) {
                ItemStack stack = ((ItemEntity) entity).getStack();
                String modName = ModNameUtil.actualModName(stack);
                if (modName != null) {
                    ((ITaggableList) tooltip).setTag(WailaConstants.MOD_NAME_TAG, Text.of(String.format(Waila.CONFIG.get().getFormatting().getModName(), modName)));
                }
            }
        }
    }
}
