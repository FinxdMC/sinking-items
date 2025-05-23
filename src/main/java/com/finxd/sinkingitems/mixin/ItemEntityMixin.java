package com.finxd.sinkingitems.mixin;

import com.finxd.sinkingitems.Config;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)

public abstract class ItemEntityMixin extends Entity{

    public ItemEntityMixin(EntityType<?> p_19870_, Level p_19871_) {
        super(p_19870_, p_19871_);
    }

    @Inject(method = "setUnderwaterMovement", at = @At("HEAD"), cancellable = true)
    private void setUnderwaterMovement(CallbackInfo ci) {
        if (!getCommandSenderWorld().isClientSide) {
            if (Config.ENABLE_MOD.get().equals(true)) {
                if (Config.SLOW_SINKING.get().equals(true)) {
                    this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.001D, 0.0D));
                }
                else {
                    this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.04D, 0.0D));
                }
            }
        }
    }
}
