package team.cagayakegirls.tweakerge;

import fi.dy.masa.tweakeroo.Tweakeroo;
import fi.dy.masa.tweakeroo.compat.modmenu.ModMenuImpl;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = Tweakerge.MOD_ID, dist = Dist.CLIENT)
public class Tweakerge {
    public static final String MOD_ID = "tweakerge";

    public Tweakerge(ModContainer modContainer) {
        modContainer.registerExtensionPoint(IConfigScreenFactory.class, new ModMenuImpl().getModConfigScreenFactory());
        new Tweakeroo().onInitialize();
    }
}
