package server.HubCore.Commands;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.CommandSender;
import cn.nukkit.entity.Entity;
import cn.nukkit.nbt.tag.*;
import server.HubCore.CommandBase;
import server.HubCore.CoreApi;

import java.nio.charset.StandardCharsets;


public class test extends CommandBase{

    public test(CoreApi api){
        super("test", api);
    }

    public boolean execute(CommandSender sender, String s, String[] args) {
        if (!this.testPermission(sender)) {return false;} //if they have the permission to use this

        Player target = sender.getServer().getPlayerExact(sender.getName());
        for (String temp : args)
        target.sendMessage(temp);

        return true;
    }

}



