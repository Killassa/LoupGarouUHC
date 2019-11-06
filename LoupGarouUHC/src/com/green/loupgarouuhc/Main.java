package com.green.loupgarouuhc;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.green.loupgarouuhc.menu.RolesMenu;
import com.green.loupgarouuhc.roles.BaseClass;

public class Main extends JavaPlugin {
	RolesMenu menu;
	
	@Override
	public void onEnable() {
		super.onEnable();
		getLogger().info("Loup garou UHC has been enabled ...");
		
		ArrayList<BaseClass> classes = new ArrayList<BaseClass>();
		classes.add(new BaseClass("test1"));
		classes.add(new BaseClass("test2"));
		classes.add(new BaseClass("test3"));
		classes.add(new BaseClass("test4"));
		
		menu = new RolesMenu("Test", classes, this);
		
		/* IconMenu 
		menu = new IconMenu("My Fancy Menu", 9, new IconMenu.OptionClickEventHandler() {
            @Override
            public void onOptionClick(IconMenu.OptionClickEvent event) {
                event.getPlayer().sendMessage("You have chosen " + menu.inventory.getItem(event.getPosition()).getItemMeta().getDisplayName());
                
                menu.setOption(3, new ItemStack(Material.GOLDEN_APPLE), "MIAM", "AAAAAAAAAAA");
                
                event.setAction(IconMenu.OptionClickEvent.ActionClick.Nothing);
            }
        }, this)
        .setOption(3, new ItemStack(Material.APPLE, 1), "Food", "The food is delicious")
        .setOption(4, new ItemStack(Material.IRON_SWORD, 1), "Weapon", "Weapons are for awesome people")
        .setOption(5, new ItemStack(Material.EMERALD, 1), "Money", "Money brings happiness");*/
		
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
				case "test":
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
