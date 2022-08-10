package io.github.shaksternano.wmitaf.client.plugin.jade.fabric;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerEntity;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaPlugin;

@Environment(EnvType.CLIENT)
public class WmitafJadePlugin implements IWailaPlugin {

    /**
     * Registers the Jade plugins.
     *
     * @param registration The Jade registration.
     */
    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.addItemModNameCallback(JadeItemModNameProvider.INSTANCE);
        registration.registerEntityComponent(JadePlayerModNameProvider.INSTANCE, PlayerEntity.class);
    }
}
