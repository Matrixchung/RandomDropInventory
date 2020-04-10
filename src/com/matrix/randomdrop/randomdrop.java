package com.matrix.randomdrop;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class randomdrop {
    //玩家物品栏第一行 9
    //玩家物品栏第三行 35 共27格
    public void generateDropList(Inventory inv, Player player, double percentage){

        Random random = new Random();
        int randomSlots=9,setSize=0;
        int times=0;
        HashSet<Integer> oldSet = new HashSet<>();
        List<Integer> itemSet = new ArrayList<>();
        World world = player.getWorld();
        Location loc = player.getLocation();
        ItemStack drop;
        for (int i=9;i<=35;i++) {
            if(inv.getItem(i)!=null){
                itemSet.add(i);
            }
        }
        setSize=itemSet.size();
        times= (int) Math.round(setSize*percentage);
        for(int i=0;i<times;i++){
            randomSlots = itemSet.get(random.nextInt(setSize));
            if(oldSet.contains(randomSlots)){
                i--;
                continue;
            }
            else{
                oldSet.add(randomSlots);
                try{
                    drop=inv.getItem(randomSlots);
                    inv.clear(randomSlots);
                    world.dropItemNaturally(loc,drop);
                }
                catch(Exception e){e.printStackTrace();}
            }
        }
    }
}
