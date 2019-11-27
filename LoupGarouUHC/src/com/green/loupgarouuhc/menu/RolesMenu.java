package com.green.loupgarouuhc.menu;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import com.green.loupgarouuhc.roles.LgRole;
import com.green.loupgarouuhc.menu.IconMenu.InventoryClosedEvent;
import com.green.loupgarouuhc.menu.IconMenu.InventoryClosedEventHandler;
import com.green.loupgarouuhc.menu.IconMenu.OptionClickEvent;
import com.green.loupgarouuhc.menu.IconMenu.OptionClickEventHandler;

public class RolesMenu {
	@SuppressWarnings("deprecation")
	public static final byte ENABLED = DyeColor.LIME.getData();
	@SuppressWarnings("deprecation")
	public static final byte DISABLED = DyeColor.RED.getData();
	public IconMenu menu;
	public HashMap<String, Boolean> isRoleEnabled = new HashMap<String, Boolean>();
	
	public RolesMenu(String name, ArrayList<LgRole> roles, Plugin plugin) {
		OptionClickEventHandler handler = new OptionClickEventHandler() {
			@Override
			public void onOptionClick(OptionClickEvent event) {
				//event.getPlayer().sendMessage("You have chosen " + menu.inventory.getItem(event.getPosition()).getItemMeta().getDisplayName());
                
				ItemStack item = menu.inventory.getItem(event.getPosition());
				if (item.getDurability() == ENABLED) {
					item.setDurability(DISABLED);
					isRoleEnabled.put(item.getItemMeta().getDisplayName(), false);
				} else {
					item.setDurability(ENABLED);
					isRoleEnabled.put(item.getItemMeta().getDisplayName(), true);
				}
				
                //menu.setOption(3, item, "MIAAAAAAAAM", "AAAAAAAAdddAAA");
			}
		};
		
		InventoryClosedEventHandler closeHandler = new InventoryClosedEventHandler() {
			@Override
			public void onInventoryClosed(InventoryClosedEvent event) {
				event.mustDestroy = false;
			}
		};
		
		int size = ((((int)(roles.size() / 9.0)) + 1) * 9);
		
		menu = new IconMenu(name, size, handler, closeHandler, plugin);
		
		int i = 0;
		for (LgRole role : roles) {
			i++;
			ItemStack stack = new ItemStack(Material.WOOL);
			stack.setDurability(DISABLED);
			isRoleEnabled.put(role.getName(), false);
			menu.setOption(i, stack, role.getName(), "Role");
		}
	}
}
