package io.github.shaksternano.wmitaf.client.plugin.waila;

import mcp.mobius.waila.Waila;
import mcp.mobius.waila.api.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.text.Text;

import java.util.List;

@SuppressWarnings({"rawtypes", "unchecked"})
@Environment(EnvType.CLIENT)
public enum OtherClientPlayerEntityComponent implements IEntityComponentProvider {

    // This is an enum.
    INSTANCE;

    // ShaksterNano
    private static final String DEVELOPER_UUID = "65972a6e-02b9-4701-96a7-0f76c08c2e5d";

    // Give dev custom Waila name formatting.
    @Override
    public void appendHead(List<Text> tooltip, IEntityAccessor accessor, IPluginConfig config) {
        Entity entity = accessor.getEntity();
        if (entity.getUuidAsString().equals(DEVELOPER_UUID)) {
            String displayName = "§c§n" + entity.getDisplayName().getString() + "§n§c";
            ((ITaggableList) tooltip).setTag(WailaConstants.OBJECT_NAME_TAG, Text.of(String.format(accessor.getEntityNameFormat(), displayName)));
        }
    }

    // Give dev custom Waila mod name.
    @Override
    public void appendTail(List<Text> tooltip, IEntityAccessor accessor, IPluginConfig config) {
        if (config.get(WailaConstants.CONFIG_SHOW_MOD_NAME)) {
            Entity entity = accessor.getEntity();
            if (entity.getUuidAsString().equals(DEVELOPER_UUID)) {
                ((ITaggableList) tooltip).setTag(WailaConstants.MOD_NAME_TAG, Text.of(String.format(Waila.CONFIG.get().getFormatting().getModName(), "WMITAF Developer")));
            }
        }
    }
}
