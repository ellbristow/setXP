package me.ellbristow.setXP;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;

public class vaultBridge {
    
    public static setXP plugin;
    public Economy economy = null;
    public boolean foundEconomy = false;
    public String economyName = "";
    
    public vaultBridge (setXP instance) {
        plugin = instance;
        initEconomy();
    }
    
    public final void initEconomy() {
        RegisteredServiceProvider<Economy> economyProvider = plugin.getServer().getServicesManager().getRegistration(Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }
        if (economy != null) {
            foundEconomy = true;
            economyName = plugin.getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class).getProvider().getName();
            String message = "[Vault] Hooked in to " + economyName + "!";
            plugin.getLogger().info(message);
        } else {
            plugin.getLogger().info("[Vault] No economy plugin found!");
        }
    }
    
}
