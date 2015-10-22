
package me.boomboompowermc;
     
import java.lang.reflect.Array;
import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Sound;     
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;
     
public class Listeners extends JavaPlugin implements Listener {
	public static Notifier plugin;   
	public Listeners(Notifier t) {
		plugin = t;   
	}  
	@SuppressWarnings("deprecation")
	@EventHandler 
	public void ChatEvent(AsyncPlayerChatEvent e) { 
		Player pl = e.getPlayer();
		Player[] arrayOfPlayer;
		// Error is below
		int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length; 
		// Error is above
		for (int i = 0; i < j; i++) { 
			Player p = arrayOfPlayer[i]; 
			if (e.getMessage().contains(p.getName())) { 
				if (getConfig().getBoolean("Sound")) {
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				}
				if (getConfig().getBoolean("Particle")) {
				p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
				}
			} 
		}   
	}     
}