package server.HubCore.Models;

import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.element.*;
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

    }
}
