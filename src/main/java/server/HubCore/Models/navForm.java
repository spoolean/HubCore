package server.HubCore.Models;

import cn.nukkit.Player;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.element.*;
import cn.nukkit.form.response.FormResponseSimple;
import cn.nukkit.form.window.FormWindowSimple;

import java.util.ArrayList;

public class navForm extends FormWindowSimple {
    public navForm(){
        super("Navigation","",new ArrayList<ElementButton>(){{
            add(new ElementButton("Capture The Flag"));
            add(new ElementButton("Future Game"));
            add(new ElementButton("Leave Server"));
        }
        });
    }

    public static void handleResponse(PlayerFormRespondedEvent e) {
        if (e.getResponse() instanceof FormResponseSimple) {
            Player player = e.getPlayer();
            FormResponseSimple temp = (FormResponseSimple) e.getResponse();
            switch (temp.getClickedButton().getText()) {
                case "Capture The Flag":
                    player.sendTitle("Sending to ctf");
                    break;
                case "Future Game":
                    player.sendTitle("Sending to future game");
                    break;
                case "Leave Server":
                    player.kick("Come again soon!");
            }
        }
    }
}
