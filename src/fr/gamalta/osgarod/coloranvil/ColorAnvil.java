package fr.gamalta.osgarod.coloranvil;

import fr.gamalta.lib.config.Configuration;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.plugin.java.JavaPlugin;

public class ColorAnvil extends JavaPlugin implements Listener {

    private String parentFileName = "Color Anvil";
    public Configuration configuration = new Configuration(this, parentFileName, "Settings");

    @Override
    public void onEnable() {

        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        if (event.getWhoClicked() instanceof Player) {

            Player player = (Player) event.getWhoClicked();

            if (event.getInventory().getType() == InventoryType.ANVIL) {

                AnvilInventory inv = (AnvilInventory) event.getInventory();

                AnvilTask task = AnvilTask.getTask(inv);

                if (task == null){

                    task = new AnvilTask(this, inv, player);
                }

                if (event.getRawSlot() == 2) {

                    event.setCurrentItem(Utils.getTranslatedItem(player, inv, task));
                }
            }
        }
    }
}
