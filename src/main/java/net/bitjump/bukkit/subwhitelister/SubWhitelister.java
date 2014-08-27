package net.bitjump.bukkit.subwhitelister;

import java.util.logging.Logger;

import net.bitjump.bukkit.subwhitelister.listeners.PlayerListener;
import net.bitjump.bukkit.subwhitelister.util.ConfigManager;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class SubWhitelister extends JavaPlugin
{
	public static JavaPlugin instance;
	
	private Logger log;

	public static FileConfiguration config;
	public static PluginDescriptionFile pdf;

	public static String name;
	public static String version;
	public static String author;
	
	public void onEnable()
	{
		log = getLogger();
		
		log.info("Plugin initializing...");
		
		pdf = getDescription();

		name = pdf.getName();
		version = pdf.getVersion();
		author = pdf.getAuthors().get(0);
		
		config = ConfigManager.setupConfig();
		
		log.info("Setting up commands...");
		
		log.info("Setting up listeners...");
		getServer().getPluginManager().registerEvents(new PlayerListener(), this);
		
		instance = this;
	}
	
	public void onDisable()
	{
		
	}
}
