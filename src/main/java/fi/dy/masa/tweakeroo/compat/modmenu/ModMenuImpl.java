package fi.dy.masa.tweakeroo.compat.modmenu;

import fi.dy.masa.tweakeroo.gui.GuiConfigs;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

public class ModMenuImpl
{
    public IConfigScreenFactory getModConfigScreenFactory()
    {
        return (modContainer, screen) -> {
            GuiConfigs gui = new GuiConfigs();
            gui.setParent(screen);
            return gui;
        };
    }
}
