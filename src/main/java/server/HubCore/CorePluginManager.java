package server.HubCore;

import cn.nukkit.entity.Entity;
import cn.nukkit.permission.PermissionAttachment;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;
import server.HubCore.Models.npcPlayer;

import java.util.HashMap;
import java.util.UUID;


public class CorePluginManager extends PluginBase{ //extends pluginbase allows for the use of plugin
    public static CorePluginManager plugin;

    private CoreApi api; //this is an api, we have to make it as an api

    @Override
    public void onEnable(){
        plugin = this;
        this.api = new CoreApi(this); // set the api to an instance of the CoreApi
        CoreCommandManager.registerAll(this.api); //will load all the commands
        this.getServer().getPluginManager().registerEvents(new Events(), this);
        this.getLogger().info(TextFormat.GREEN + "Plugin Enabled");
        Entity.registerEntity(npcPlayer.class.getSimpleName(), npcPlayer.class);
    }
    @Override
    public void onDisable()
    {
        this.getLogger().info(TextFormat.RED + "Plugin Disabled");
    }
}

