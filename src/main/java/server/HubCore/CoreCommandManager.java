package server.HubCore;

import server.HubCore.Commands.*;
import cn.nukkit.command.CommandMap;

public class CoreCommandManager {
    public static void registerAll(CoreApi api) {
        CommandMap map = api.getServer().getCommandMap();
        map.register("CoreApi", new npc(api));  //CassFile() //how to register commands
        map.register("CoreApi", new test(api));
    }
}
