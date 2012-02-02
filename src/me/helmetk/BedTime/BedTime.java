package me.helmetk.BedTime;

import java.util.logging.Logger;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class BedTime extends JavaPlugin {
	// El logger es el objeto que muestra mensajes en la consola.
	// El metodo log.info(string) muestra el mensaje string en consola
	Logger log = Logger.getLogger("Minecraft"); 
	// Acciones ejecutadas cuando el plugin se activa
	public void onEnable(){
		log.info("[BedTime] Enabled");
	}
	// Cuando se desactiva
	public void onDisable(){
		log.info("[BedTime] Disabled");
	}
	// En este método configuramos los diferentes comandos que puede tener el plugin
	public boolean onCommand(	CommandSender sender,
								Command cmd, 
								String commandLabel, 
								String[] args){
				
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
