package server.HubCore.Models;

import cn.nukkit.Player;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.element.*;
import cn.nukkit.form.response.FormResponseSimple;
import cn.nukkit.form.window.FormWindowSimple;
import org.itxtech.synapseapi.SynapseAPI;
import org.itxtech.synapseapi.SynapsePlayer;

import java.util.ArrayList;

public class navForm extends FormWindowSimple {
    public navForm(){
        super("Navigation","",new ArrayList<ElementButton>(){
            {
            add(new ElementButton("Hub", new ElementButtonImageData("path","textures/blocks/tnt_side")));
            add(new ElementButton("CTF Spawn", new ElementButtonImageData("path","textures/blocks/tnt_side")));
            add(new ElementButton("Airport Spawn", new ElementButtonImageData("path","textures/blocks/tnt_side")));
            add(new ElementButton("Capture The Flag", new ElementButtonImageData("path","textures/blocks/tnt_side")));
            add(new ElementButton("Leave Server", new ElementButtonImageData("path","textures/blocks/tnt_side")));
            }
        });
    }

    public static void handleResponse(PlayerFormRespondedEvent e) {
        if (e.getResponse() instanceof FormResponseSimple) {
            Player player = e.getPlayer();
            FormResponseSimple temp = (FormResponseSimple) e.getResponse();
            switch (temp.getClickedButton().getText()) {
                case "Hub":
                    player.teleport(player.getLevel().getSpawnLocation());
                    break;
                case "CTF Spawn":
                    player.teleport(player.getServer().getLevelByName("world").getSpawnLocation());
                    break;
                case "Airport Spawn":
                    player.teleport(player.getServer().getLevelByName("airport").getSpawnLocation());
                    break;
                case "Capture The Flag":
                    SynapsePlayer p = (SynapsePlayer) player;
                    p.transferByDescription("ctf");
                    break;
                case "Leave Server":
                    player.kick("Come again soon!");
            }
        }
    }
}
