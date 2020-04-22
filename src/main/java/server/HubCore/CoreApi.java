package server.HubCore;

import cn.nukkit.AdventureSettings;
import cn.nukkit.IPlayer;
import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.block.Block;
import cn.nukkit.command.CommandSender;
import cn.nukkit.entity.weather.EntityLightning;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemArmor;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;
import cn.nukkit.level.Location;
import cn.nukkit.level.Position;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.math.Vector3;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.nbt.tag.DoubleTag;
import cn.nukkit.nbt.tag.FloatTag;
import cn.nukkit.nbt.tag.ListTag;
import cn.nukkit.permission.PermissionAttachmentInfo;
import cn.nukkit.plugin.PluginLogger;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.ConfigSection;

public class CoreApi {
    private static CoreApi instance = null;
    private CorePluginManager plugin;
    private Vector3 vector3 = new Vector3();
    public CoreApi(CorePluginManager plugin){
        instance = this;
        this.plugin = plugin;
    }

    public Server getServer() {
        return plugin.getServer();
    }

    public Position getHighestStandablePositionAt(Position pos) {
        int x = pos.getFloorX();
        int z = pos.getFloorZ();
        for (int y = 255; y >= 0; y--) {
            if (pos.level.getBlock(this.vector3.setComponents(x,y,z)).isSolid()) {
                return new Position(x + 0.5, pos.level.getBlock(this.vector3.setComponents(x, y, z)).getBoundingBox().getMaxY(), z + 0.5, pos.level);
            }
        }
        return null;
    }

}
