package com.matrix.randomdrop.item;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class createitem {
    public static ItemStack item_10p = new ItemStack(Material.PAPER,1);
    public static ItemStack item_30p = new ItemStack(Material.PAPER,1);
    public static ItemStack item_50p = new ItemStack(Material.PAPER,1);
    public static ItemStack item_70p = new ItemStack(Material.PAPER,1);
    public static void setItemLore(ItemStack itemStack, FileConfiguration config, String name) {
        List<String> lore = config.getStringList("Property."+name+".lore");
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(config.getString("Property."+name+".name"));
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
    }
}
