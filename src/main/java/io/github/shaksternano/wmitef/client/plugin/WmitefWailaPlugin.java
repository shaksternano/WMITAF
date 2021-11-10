package io.github.shaksternano.wmitef.client.plugin;

import mcp.mobius.waila.api.IRegistrar;
import mcp.mobius.waila.api.IWailaPlugin;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@SuppressWarnings("unused")
@Environment(EnvType.CLIENT)
public class WmitefWailaPlugin implements IWailaPlugin {

    @Override
    public void register(IRegistrar registrar) {
        registrar.addEventListener(EnchantedBookOverride.INSTANCE);
    }
}
