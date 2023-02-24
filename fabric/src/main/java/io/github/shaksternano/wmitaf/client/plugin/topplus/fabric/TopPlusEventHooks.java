package io.github.shaksternano.wmitaf.client.plugin.topplus.fabric;

import io.github.shaksternano.wmitaf.client.util.fabric.ModNameUtil;
import me.alphamode.top_plus.api.ItemModTooltipCallback;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Environment(EnvType.CLIENT)
public class TopPlusEventHooks {

    /**
     * Registers the client event hooks for The One Probe Plus.
     */
    public static void registerClientEventHooks() {
        ItemModTooltipCallback.EVENT.register(TopPlusEventHooks::setActualModName);
    }

    /**
     * Changes the mod name in the tooltip of an item added by The One Probe Plus
     * to the name of the mod that actually adds it.
     *
     * @param stack   The item stack to get the mod name of.
     * @param context The tooltip context.
     * @param lines   The tooltip lines.
     * @return The changed mod name.
     */
    @SuppressWarnings("unused")
    private static Text setActualModName(ItemStack stack, TooltipContext context, List<Text> lines) {
        return Text.literal(ModNameUtil.getActualModId(stack).orElseGet(() -> {
            String modId = Registries.ITEM.getId(stack.getItem()).getNamespace();
            return ModNameUtil.getModNameFromId(modId).orElseGet(() -> StringUtils.capitalize(modId));
        })).formatted(Formatting.BLUE, Formatting.ITALIC);
    }
}
