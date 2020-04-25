package server.HubCore.Commands;

import cn.nukkit.Server;
import cn.nukkit.entity.Entity;
import cn.nukkit.entity.EntityHuman;
import cn.nukkit.nbt.tag.*;
import cn.nukkit.network.protocol.ShowProfilePacket;
import server.HubCore.CommandBase;
import server.HubCore.CoreApi;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.form.element.ElementSlider;
import cn.nukkit.form.window.FormWindowCustom;
import java.nio.charset.StandardCharsets;
import static server.HubCore.Models.staticVars.*;
import java.util.UUID;


public class npc extends CommandBase{

    public npc(CoreApi api){
        super("npc", api);
    }

    public CompoundTag nbt(Player p, String[] args, String name) {
        CompoundTag nbt = new CompoundTag()
                .putList(new ListTag<>("Pos")
                        .add(new DoubleTag("", p.x))
                        .add(new DoubleTag("", p.y))
                        .add(new DoubleTag("", p.z)))
                .putList(new ListTag<DoubleTag>("Motion")
                        .add(new DoubleTag("", 0))
                        .add(new DoubleTag("", 0))
                        .add(new DoubleTag("", 0)))
                .putList(new ListTag<FloatTag>("Rotation")
                        .add(new FloatTag("", (float) p.getYaw()))
                        .add(new FloatTag("", (float) p.getPitch())))
                .putBoolean("Invulnerable", true)
                .putString("NameTag", name)
                .putList(new ListTag<StringTag>("Commands"))
                .putList(new ListTag<StringTag>("PlayerCommands"))
                .putBoolean("npc", true)
                .putFloat("scale", 1);

            CompoundTag skinTag = new CompoundTag()
                    .putByteArray("Data", p.getSkin().getSkinData().data)
                    .putInt("SkinImageWidth", p.getSkin().getSkinData().width)
                    .putInt("SkinImageHeight", p.getSkin().getSkinData().height)
                    .putString("ModelId", p.getSkin().getSkinId())
                    .putString("CapeId", p.getSkin().getCapeId())
                    .putByteArray("CapeData", p.getSkin().getCapeData().data)
                    .putInt("CapeImageWidth", p.getSkin().getCapeData().width)
                    .putInt("CapeImageHeight", p.getSkin().getCapeData().height)
                    .putByteArray("SkinResourcePatch", p.getSkin().getSkinResourcePatch().getBytes(StandardCharsets.UTF_8))
                    .putByteArray("GeometryData", p.getSkin().getGeometryData().getBytes(StandardCharsets.UTF_8))
                    .putByteArray("AnimationData", p.getSkin().getAnimationData().getBytes(StandardCharsets.UTF_8))
                    .putBoolean("PremiumSkin", p.getSkin().isPremium())
                    .putBoolean("PersonaSkin", p.getSkin().isPersona())
                    .putBoolean("CapeOnClassicSkin", p.getSkin().isCapeOnClassic());

            nbt.putCompound("Skin", skinTag);
            nbt.putBoolean("ishuman", true);
            nbt.putString("Item", p.getInventory().getItemInHand().getName());
            nbt.putString("Helmet", p.getInventory().getHelmet().getName());
            nbt.putString("Chestplate", p.getInventory().getChestplate().getName());
            nbt.putString("Leggings", p.getInventory().getLeggings().getName());
            nbt.putString("Boots", p.getInventory().getBoots().getName());

        return nbt;
    }

    public boolean execute(CommandSender sender, String s, String[] args) {
        if (!this.testPermission(sender)) {return false;} //if they have the permission to use this

        if (args.length == 2) {
            Player target = sender.getServer().getPlayerExact(sender.getName());
            Server server = sender.getServer();
            String name = args[0];
            CompoundTag nbt = this.nbt(target, args, name);
            Entity ent = Entity.createEntity("npcPlayer", target.chunk, nbt);
            ent.setNameTag(name);
            if (args[1] == "false") {
                ent.setNameTagVisible(false);
                ent.setNameTagAlwaysVisible(false);
            }
            else {
                ent.setNameTagVisible(true);
                ent.setNameTagAlwaysVisible(true);
            }
            ent.spawnTo(target);
        }
        if (args.length == 1) {
            if (args[0].equals("true")) {
                damageNPC = true;
                sender.sendMessage("Damage turned on!");
            }
            else {
                damageNPC = false;
                sender.sendMessage("Damage turned off!");
            }
        }
        return true;
    }

}



