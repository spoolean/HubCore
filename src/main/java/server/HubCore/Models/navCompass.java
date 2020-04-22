package server.HubCore.Models;

import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.item.ItemCompass;
import cn.nukkit.utils.TextFormat;

public class navCompass extends ItemCompass {
    public navCompass() {
        setCustomName(TextFormat.GREEN+ "Navigate");
    }

    public static void rightClick(PlayerInteractEvent e) {
        navForm temp = new navForm();
        e.getPlayer().showFormWindow(temp);
    }
}
