package me.helmetk.BedTime;

import java.util.LinkedList;
import java.util.List;
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
			//Creo que esto no es necesario.
			List<Player> bed = new LinkedList<Player>();
			List<Player> nobed = new LinkedList<Player>();

			for(Player p:players){
				if(p.isSleeping())
					bed.add(p);
				else
					nobed.add(p);
					
			}
			//Los strings
			String stBed = "";
			for(Player p:bed){
				stBed = stBed + p.getDisplayName() + "  ";
			}
			String stNoBed = "";
			for(Player p:nobed){
				stNoBed = stNoBed + p.getDisplayName() + "  ";
			}
			player.sendMessage("[BedTime]");
			player.sendMessage("Bed:");
			if(stBed != "")
				player.sendMessage(stBed);
			player.sendMessage("No Bed:");
			if(stNoBed != "")
			player.sendMessage(stNoBed);
			bed.clear();
			nobed.clear();
			return true;
		}
		
		return false;
	}
}
