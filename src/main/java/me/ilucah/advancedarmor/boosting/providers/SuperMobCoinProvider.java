package me.ilucah.advancedarmor.boosting.providers;

import me.ilucah.advancedarmor.AdvancedArmor;
import me.ilucah.advancedarmor.armor.BoostType;
import me.ilucah.advancedarmor.boosting.model.BoostProvider;
import me.swanis.mobcoins.events.MobCoinsReceiveEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;

public class SuperMobCoinProvider extends BoostProvider<MobCoinsReceiveEvent> {

    public SuperMobCoinProvider(AdvancedArmor instance) {
        super(instance, BoostType.COIN);
        instance.getAPI().registerBoostProvider(MobCoinsReceiveEvent.class, this);
    }

    @Override
    @EventHandler(priority = EventPriority.LOWEST)
    public void onBoost(MobCoinsReceiveEvent event) {
        event.setAmount((long) resolveNewAmount(event.getProfile().getPlayer(), event.getAmount()));
    }
}
