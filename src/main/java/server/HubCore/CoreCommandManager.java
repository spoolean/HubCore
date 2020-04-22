package server.HubCore;

import server.HubCore.Commands.*;
import cn.nukkit.command.CommandMap;

public class CoreCommandManager {
    public static void registerAll(CoreApi api) {
        CommandMap map = api.getServer().getCommandMap();
        map.register("CoreApi", new example(api));  //CassFile() //how to register commands
    }
}
