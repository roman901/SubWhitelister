package net.bitjump.bukkit.subwhitelister.commands;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import net.bitjump.bukkit.subwhitelister.SubWhitelister;
import net.bitjump.bukkit.subwhitelister.util.WhitelistManager;

public class ExportCommand extends Subcommand 
{
	public ExportCommand()
	{
		this.name = "export";
		this.description = "Exports whitelisted users.";
		this.permission = "subwhitelister.export";
	}
	
	public void perform()
	{
		File f = new File(SubWhitelister.instance.getDataFolder(), "users.txt");
		
		try 
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter(f.getAbsoluteFile()));
			for(String s : WhitelistManager.getUsers())
			{
				bw.write(s);
			}
			
			bw.close();
			sender.sendMessage("Remote whitelist written to file.");
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
