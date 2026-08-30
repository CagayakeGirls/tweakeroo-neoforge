package fi.dy.masa.tweakeroo.mixin.render;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.mojang.blaze3d.vertex.PoseStack;

import fi.dy.masa.tweakeroo.config.Configs;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.SpawnerRenderer;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;

@Mixin(SpawnerRenderer.class)
public abstract class MixinSpawnerRenderer
{
    @Inject(method = "submitEntityInSpawner",
            at = @At("HEAD"), cancellable = true)
    private static void tweakeroo_cancelRender(PoseStack poseStack, SubmitNodeCollector submitNodeCollector,
                                               EntityRenderState renderState, EntityRenderDispatcher dispatcher,
                                               float f, float g, CameraRenderState cameraState, CallbackInfo ci)
    {
        if (Configs.Disable.DISABLE_MOB_SPAWNER_MOB_RENDER.getBooleanValue())
        {
            ci.cancel();
        }
    }
}
