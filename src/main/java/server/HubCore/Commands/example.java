package server.HubCore.Commands;

import server.HubCore.CommandBase;
import server.HubCore.CoreApi;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.form.element.ElementSlider;
import cn.nukkit.form.window.FormWindowCustom;


public class example extends CommandBase{

    public example(CoreApi api){
        super("clear", api);
    }

    public boolean execute(CommandSender sender, String s, String[] args) {
        if (!this.testPermission(sender)) {return false;} //if they have the permission to use this

        Player target = sender.getServer().getPlayerExact(sender.getName());
        target.sendMessage("Command working!");

        return true;
    }

}



