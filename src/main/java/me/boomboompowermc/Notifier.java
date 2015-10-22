package me.boomboompowermc;
     
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
     
public class Notifier extends JavaPlugin {   
	public static Notifier plugin;
          
	public void onEnable() {
		saveDefaultConfig();
		plugin = this;
		Bukkit.getPluginManager().registerEvents(new Listeners(this), this);
	}
          
	public void onDisable() {
		plugin = null;  
	}    
}
