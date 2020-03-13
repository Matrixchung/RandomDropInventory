package com.matrix.randomdrop.command;

import com.matrix.randomdrop.item.createitem;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

import static org.bukkit.Bukkit.getLogger;

public class Command implements CommandExecutor {

    List<String> itemList = Arrays.asList("item_10p", "item_30p", "item_50p", "item_70p");
    @Override
    @Deprecated
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String s, String[] args) {
        if (!(command.getName().equalsIgnoreCase("randomdrop"))) {return true;}
        if (args.length==0){
            sender.sendMessage(command.getUsage());
            return true;
        }
        if (args.length==1 && args[0].equalsIgnoreCase("get")){
            if(!(sender instanceof Player)) {getLogger().info("§c[RandomDrop] 请指定您要给予道具的玩家!");}
            else if((sender instanceof Player) && !(sender.hasPermission("randomdrop.op"))) {sender.sendMessage("§c[RandomDrop] 你没有权限获取道具!");}
            else{
                sender.sendMessage("§c[RandomDrop] 请指定你要获取的道具!");
            }
            return true;
        }
        if (args.length==2&&(args[0].equalsIgnoreCase("get"))){
            sender.sendMessage("§c[RandomDrop] 请指定您要给予玩家的道具!");
            return true;
        }

        if(args.length==3&&args[0].equalsIgnoreCase("get"))
        {
            if((sender instanceof Player) && !(sender.hasPermission("randomdrop.op"))) {sender.sendMessage("§c[RandomDrop] 你没有权限获取道具!");}
            else{
            Player playerGiven ;
            playerGiven = Bukkit.getPlayerExact(args[1]);
            if(playerGiven == null) {sender.sendMessage("§c[RandomDrop] 玩家不存在!");}
            else if(itemList.contains(args[2])){
                switch(args[2])
                {
                    case "item_10p" :
                        playerGiven.getInventory().addItem(createitem.item_10p);
                        break;
                    case "item_30p" :
                        playerGiven.getInventory().addItem(createitem.item_30p);
                        break;
                    case "item_50p" :
                        playerGiven.getInventory().addItem(createitem.item_50p);
                        break;
                    case "item_70p" :
                        playerGiven.getInventory().addItem(createitem.item_70p);
                        break;
                }
                sender.sendMessage("§b[RandomDrop] 物品已给予!");
                return true;
            }
        else {sender.sendMessage("§c[RandomDrop] 物品不存在!");return true;}
        }}
        if (args.length>3||(args.length>0 && !(args[0].equalsIgnoreCase("get")))) {
            sender.sendMessage("§c[RandomDrop] 参数过多或不正确!");
            sender.sendMessage(command.getUsage());
            return true;
        }
        return true;
    }
}
