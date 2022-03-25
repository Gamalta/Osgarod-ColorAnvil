package fr.gamalta.osgarod.coloranvil;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Utils {

    public static ItemStack getTranslatedItem(Player player, AnvilInventory inv, AnvilTask task) {

        ItemStack outputItem = inv.getItem(2);

        if (outputItem != null && outputItem.hasItemMeta() && outputItem.getItemMeta().hasDisplayName()) {

            ItemMeta outputItemMeta = outputItem.getItemMeta();
            outputItemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', outputItemMeta.getDisplayName()));
            outputItem.setItemMeta(outputItemMeta);
        }
        return outputItem;
    }
}
