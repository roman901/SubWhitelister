package net.bitjump.bukkit.subwhitelister.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.bukkit.Bukkit;

import net.bitjump.bukkit.subwhitelister.SubWhitelister;
import org.bukkit.entity.Player;

public class WhitelistManager 
{
	private static final HashSet<String> users = new HashSet<String>();
	
	public static void initialize()
	{
		Bukkit.getScheduler().runTaskTimerAsynchronously(SubWhitelister.instance, new Runnable()
		{
			public void run()
			{
				updateRemoteWhitelists();
			}
		}, 0l, SubWhitelister.config.getInt("whitelist.delay") * 20l);
	}
	
	public static HashSet<String> getUsers()
	{
		return users;
	}
	
	public static void updateRemoteWhitelists()
	{
		BufferedReader in = null;
		try
		{
			in = new BufferedReader(new InputStreamReader(new URL(SubWhitelister.config.getString("whitelist.url")).openStream()));
			String l;

			while ((l = in.readLine()) != null)
			{
				users.add(l.trim().toLowerCase());
			}
		}
		catch (IOException e)
		{
			SubWhitelister.getLog().severe("[SubWhitelister] Uh oh. The website could be down. We'll keep trying.");
			SubWhitelister.getLog().severe("[SubWhitelister] Give the following crash log to @Bitjump_ for diagnostics!");
			e.printStackTrace();
		}
		finally
		{
			if(in != null)
			{
				try
				{
					in.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}

			if(SubWhitelister.config.getBoolean("enabled")) {
				for (final Player p : Bukkit.getServer().getOnlinePlayers()) {
					if (!users.contains(p.getName().toLowerCase()) && !p.hasPermission("subwhitelister.exempt")) {
						Bukkit.getScheduler().runTask(SubWhitelister.instance, new Runnable() {
							public void run() {
								p.kickPlayer("Вы больше не в вайтлисте!");
							}
						});
					}
				}
			}
		}
	}

}
