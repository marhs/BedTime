package me.helmetk.BedTime;

import java.util.logging.Logger;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class BedTime extends JavaPlugin {
	Logger log = Logger.getLogger("Minecraft"); 
	public void onEnable(){
		log.info("BedTime has been enabled");
	}
	public void onDisable(){
		log.info("BedTime has been disabled");
	}
	public boolean onCommand(	CommandSender sender,
								Command cmd, 
								String commandLabel, 
								String[] args){
		// Si el jugador escribe el comando /bed hace el doSomething
		
		Player player = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("bed")){
			Player[] players = this.getServer().getOnlinePlayers();
			String stBed = "";
			String stNoBed = "";
			for(Player p:players){
				if(p.isSleeping())
					stBed = stBed + p.getDisplayName() + "  ";
				else
					stNoBed = stNoBed + p.getDisplayName() + "  ";
					
			}
			
			player.sendMessage("[BedTime]");
			player.sendMessage("Bed:");
			if(stBed != "")
				player.sendMessage(stBed);
			player.sendMessage("No Bed:");
			if(stNoBed != "")
			player.sendMessage(stNoBed);

			return true;
		}
		
		return false;
	}
}
