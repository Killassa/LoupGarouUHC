package com.green.loupgarouuhc;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.green.loupgarouuhc.menu.RolesMenu;
import com.green.loupgarouuhc.roles.LgRole;
import com.green.loupgarouuhc.roles.Village.Villageois;

public class Main extends JavaPlugin {
	RolesMenu menu;
	
	@Override
	public void onEnable() {
		super.onEnable();
		getLogger().info("Loup garou UHC has been enabled ...");
		
		ArrayList<LgRole> classes = new ArrayList<LgRole>();
		classes.add(new Villageois());
		classes.add(new Villageois());
		classes.add(new Villageois());
		classes.add(new Villageois());
		
		menu = new RolesMenu("Test", classes, this);
		
		/* PluginManager */
		PluginManager pm = getServer().getPluginManager();
		
		Listeners listener = new Listeners(this);
		pm.registerEvents(listener, this);
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
		
		getLogger().info("Loup garou UHC has been disabled ...");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			String cmd = command.getName().toLowerCase();
			player.sendMessage(label);
			switch (cmd) {
				case "config":
					menu.menu.open(player);
					
					player.sendMessage(menu.isRoleEnabled.toString());
					return true;
				default:
					player.sendMessage("Your command was not recognized");
					return true;
			}
		}
		
		return true;
	}
}
