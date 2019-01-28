package net.bitjump.bukkit.subwhitelister.listeners;

import net.bitjump.bukkit.subwhitelister.SubWhitelister;
import net.bitjump.bukkit.subwhitelister.util.WhitelistManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

public class PlayerListener implements Listener 
{
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent e)
	{
		if(!SubWhitelister.config.getBoolean("enabled")) return;
		
		Player p = e.getPlayer();
		
		if(!p.hasPermission("subwhitelister.exempt"))
		{
			if(!WhitelistManager.getUsers().contains(p.getName().toLowerCase()))
			{
				e.disallow(Result.KICK_WHITELIST, "Вы не в вайтлисте!");
			}
		}
	}
}
