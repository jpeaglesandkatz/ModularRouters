package me.desht.modularrouters.integration.jei;

import me.desht.modularrouters.client.gui.module.AbstractModuleScreen;
import me.desht.modularrouters.container.FilterSlot;
import mezz.jei.api.gui.handlers.IGhostIngredientHandler;
import mezz.jei.api.ingredients.ITypedIngredient;
import net.minecraft.world.inventory.Slot;

import java.util.ArrayList;
import java.util.List;

public class ModuleScreenGhost implements IGhostIngredientHandler<AbstractModuleScreen> {
    @Override
    public <I> List<Target<I>> getTargetsTyped(AbstractModuleScreen gui, ITypedIngredient<I> ingredient, boolean doStart) {
        List<Target<I>> res = new ArrayList<>();
        for (int i = 0; i < gui.getMenu().slots.size(); i++) {
            Slot s = gui.getMenu().getSlot(i);
            if (s instanceof FilterSlot) {
                res.add(new GhostTarget<>(gui, s));
            }
        }
        return res;
    }

    @Override
    public void onComplete() {
    }
}
