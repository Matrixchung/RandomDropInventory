package com.matrix.randomdrop.events;

import com.matrix.randomdrop.item.createitem;
import com.matrix.randomdrop.main;
import com.matrix.randomdrop.randomdrop;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class OnPlayerDeath implements Listener {
    List<String> worldList = main.getPlugin().getConfig().getStringList("disabledWorld");
    randomdrop RandomDrop = new randomdrop();
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player player = e.getEntity();
        DamageCause cause = e.getEntity().getLastDamageCause().getCause();
        if(player.hasPermission("randomdrop.enable")&&!(worldList.contains(player.getWorld().getName()))&&!(cause==DamageCause.VOID||cause==DamageCause.LAVA)) {
            if(!e.getKeepInventory()) {
                e.setKeepInventory(true);
                e.setKeepLevel(true);
            }
            e.setDroppedExp(0);
            Inventory inv = player.getInventory();
            RandomDrop.generateDropList(inv,player,checkItems(inv));
        }
    }
    public double checkItems(Inventory inv){
        try{
            ItemStack[] stack = inv.getContents();
            for(ItemStack it:stack){
                if(it.isSimilar(createitem.item_10p)) {it.setAmount(it.getAmount()-1);return 0.1;}
                else if(it.isSimilar(createitem.item_30p)) {it.setAmount(it.getAmount()-1);return 0.3;}
                else if(it.isSimilar(createitem.item_50p)) {it.setAmount(it.getAmount()-1);return 0.5;}
                else if(it.isSimilar(createitem.item_70p)) {it.setAmount(it.getAmount()-1);return 0.7;}
            }
            return 0.8;
        }
        catch (Exception e){
            return 0.8;
        }
    }
}