package io.github.shaksternano.wmitaf.client.plugin.jade.fabric;

import io.github.shaksternano.wmitaf.client.util.fabric.PlayerMessages;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import snownee.jade.api.EntityAccessor;
import snownee.jade.api.IEntityComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.Identifiers;
import snownee.jade.api.config.IPluginConfig;

@Environment(EnvType.CLIENT)
public enum JadePlayerModNameProvider implements IEntityComponentProvider {

    INSTANCE;

    /**
     * Give some players a custom Jade mod name.
     *
     * @param tooltip  The tooltip to modify.
     * @param accessor The accessor for the entity.
     * @param config   The current plugin configuration.
     */
    @Override
    public void appendTooltip(ITooltip tooltip, EntityAccessor accessor, IPluginConfig config) {
        Entity player = accessor.getEntity();
        PlayerMessages.getMessage(player.getUuidAsString()).ifPresent(
                message -> tooltip.add(Text.of(String.format(config.getWailaConfig().getFormatting().getModName(), message)))
        );
    }

    @Override
    public Identifier getUid() {
        return Identifiers.CORE_MOD_NAME;
    }

    @Override
    public int getDefaultPriority() {
        return 15000;
    }
}
