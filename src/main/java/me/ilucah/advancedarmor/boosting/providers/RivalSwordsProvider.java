package me.ilucah.advancedarmor.boosting.providers;

import me.ilucah.advancedarmor.AdvancedArmor;
import me.ilucah.advancedarmor.armor.BoostType;
import me.ilucah.advancedarmor.boosting.model.BoostProvider;
import me.rivaldev.mobsword.rivalmobswords.api.SwordEssenceReceivePreEnchantEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;

public class RivalSwordsProvider extends BoostProvider<SwordEssenceReceivePreEnchantEvent> {

    public RivalSwordsProvider(AdvancedArmor instance) {
        super(instance, BoostType.ESSENCE);
        instance.getAPI().registerBoostProvider(SwordEssenceReceivePreEnchantEvent.class, this);
    }

    @Override
    @EventHandler(priority = EventPriority.LOWEST)
    public void onBoost(SwordEssenceReceivePreEnchantEvent event) {
        event.setEssence(resolveNewAmount(event.getPlayer(), event.getEssence()));
    }
}
