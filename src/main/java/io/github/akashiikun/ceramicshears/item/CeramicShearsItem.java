package io.github.akashiikun.ceramicshears.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Shearable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.event.GameEvent;

public class CeramicShearsItem extends ShearsItem {
    public CeramicShearsItem(int damage) {
        super((new Item.Settings()).maxCount(1).maxDamage(damage).group(ItemGroup.TOOLS));
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (entity.world.isClient)
            return ActionResult.PASS;
        if(entity instanceof Shearable) {
            if (((Shearable) entity).isShearable()) {
                ((Shearable) entity).sheared(SoundCategory.PLAYERS);
                entity.emitGameEvent(GameEvent.SHEAR, user);
                stack.damage(1, user, (p) -> p.sendToolBreakStatus(hand));
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }
}