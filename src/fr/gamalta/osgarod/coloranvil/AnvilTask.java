package fr.gamalta.osgarod.coloranvil;

import java.util.HashMap;
import org.bukkit.entity.Player;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.scheduler.BukkitRunnable;

public class AnvilTask extends BukkitRunnable {

    private static HashMap<AnvilInventory, AnvilTask> anvilTasks = new HashMap<>();
    private AnvilInventory inv;
    private Player player;

    public AnvilTask(ColorAnvil main, AnvilInventory inv, Player player) {
        this.inv = inv;
        this.player = player;
        anvilTasks.put(inv, this);
        runTaskTimer(main, 1L, 3L);
    }


    public void run() {
        if (this.inv.getViewers().size() == 0)
            cancel();
        Utils.getTranslatedItem(this.player, this.inv, this);
    }


    public static AnvilTask getTask(AnvilInventory inv) {
        return (AnvilTask)anvilTasks.get(inv);
    }
}
