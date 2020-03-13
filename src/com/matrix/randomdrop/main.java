package com.matrix.randomdrop;

import com.matrix.randomdrop.events.OnPlayerDeath;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import com.matrix.randomdrop.item.createitem;
import com.matrix.randomdrop.command.Command;


public class main extends JavaPlugin {
    private static main plugin;
    @Override
    public void onLoad(){
        plugin=this;
        getLogger().info("RandomDropInventory Loading...");

    }
    @Override
    public void onEnable(){
        try{
            this.saveDefaultConfig();
        }
        catch (Exception e) {e.printStackTrace();}
        Bukkit.getPluginCommand("randomdrop").setExecutor(new Command());
        Bukkit.getPluginManager().registerEvents(new OnPlayerDeath(),this);
        createitem.setItemLore(createitem.item_10p,this.getConfig(),"item_10p");
        createitem.setItemLore(createitem.item_30p,this.getConfig(),"item_30p");
        createitem.setItemLore(createitem.item_50p,this.getConfig(),"item_50p");
        createitem.setItemLore(createitem.item_70p,this.getConfig(),"item_70p");
        getLogger().info("RandomDropInventory Enabled");
    }

    @Override
    public void onDisable(){

    }
    public static main getPlugin(){
        return plugin;
    }
}
