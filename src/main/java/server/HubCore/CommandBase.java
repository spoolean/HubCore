package server.HubCore;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;

public abstract class CommandBase extends Command {

    protected CoreApi api;

    public CommandBase(String name, CoreApi api) {
        super(name);
        this.setPermission("MinecraftCore." + name);
        CorePluginManager.plugin.getLogger().info(TextFormat.GREEN + name + " permission enabled!");
        this.api = api;
    }

    protected CoreApi getApi(){
        return api;
    }

    protected void sendUser(CommandSender sender, String name) {
        sender.sendMessage(name+" has been used!");
    }

}
