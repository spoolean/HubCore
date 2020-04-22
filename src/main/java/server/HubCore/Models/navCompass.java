package server.HubCore.Models;

import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.item.ItemCompass;

public class navCompass extends ItemCompass {
    public navCompass() {
        name = "Navigate";
    }

    public static void rightClick(PlayerInteractEvent e) {
        navForm temp = new navForm();
        e.getPlayer().showFormWindow(temp);
    }
}
