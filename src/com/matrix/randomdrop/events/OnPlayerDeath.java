package com.matrix.randomdrop.events;

import com.matrix.randomdrop.item.createitem;
import com.matrix.randomdrop.main;
import com.matrix.randomdrop.randomdrop;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;

import java.util.List;

public class OnPlayerDeath implements Listener {
    List<String> worldList = main.getPlugin().getConfig().getStringList("disabledWorld");
    randomdrop RandomDrop = new randomdrop();
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player player = e.getEntity();
        if(player.hasPermission("randomdrop.enable")&&!(player.getWorld().equals(worldList))) {
            if(!e.getKeepInventory()) {
                e.setKeepInventory(true);
                e.setKeepLevel(true);
            }
            e.setDroppedExp(0);
            Inventory inv = player.getInventory();
            if(inv.contains(createitem.item_10p)){inv.remove(createitem.item_10p);RandomDrop.generateDropList(inv,player,0.1);}
            else if(inv.contains(createitem.item_30p)) {inv.remove(createitem.item_30p);RandomDrop.generateDropList(inv,player,0.3);}
            else if(inv.contains(createitem.item_50p)) {inv.remove(createitem.item_50p);RandomDrop.generateDropList(inv,player,0.5);}
            else if(inv.contains(createitem.item_70p)) {inv.remove(createitem.item_70p);RandomDrop.generateDropList(inv,player,0.7);}
            else {RandomDrop.generateDropList(inv,player,0.8);}
        }
    }
}