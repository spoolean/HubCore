package server.HubCore;

import cn.nukkit.Player;
import cn.nukkit.blockentity.BlockEntityItemFrame;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.player.*;
import cn.nukkit.form.window.FormWindowCustom;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemMap;
import cn.nukkit.permission.PermissionAttachment;
import cn.nukkit.utils.TextFormat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import server.HubCore.Models.*;

public class Events implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.getPlayer().getServer().broadcastMessage("Welcome to the server "+e.getPlayer().getName());
        e.getPlayer().getInventory().setItem(4, new navCompass());
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        if(e.getItem() instanceof navCompass){
            navCompass.rightClick(e);
        }
    }

    @EventHandler
    public void onFormResponse(PlayerFormRespondedEvent e) {
        if(e.getWindow() instanceof navForm) {

            navForm.handleResponse(e);
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {

    }

}

