package io.github.shaksternano.wmitaf.client.plugin.topplus.fabric;

import io.github.shaksternano.wmitaf.client.util.fabric.ModNameUtil;
import me.alphamode.top_plus.api.ItemModTooltipCallback;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Formatting;
import net.minecraft.util.registry.Registry;
import org.apache.commons.lang3.StringUtils;

@Environment(EnvType.CLIENT)
public class TopPlusEventHooks {

    /**
     * Registers the client event hooks for The One Probe Plus.
     */
    public static void registerClientEventHooks() {
        /*
        Changes the mod name in the tooltip of an item added by The One Probe Plus
        to the name of the mod that actually adds it.
         */
        ItemModTooltipCallback.EVENT.register((stack, context, lines) -> {
            String itemModId = Registry.ITEM.getId(stack.getItem()).getNamespace();

            return new LiteralText(
                    ModNameUtil.getActualModName(stack).orElse(
                            ModNameUtil.getModNameFromId(itemModId).orElse(
                                    StringUtils.capitalize(itemModId)
                            )
                    )
            ).formatted(Formatting.BLUE).formatted(Formatting.ITALIC);
        });
    }
}
