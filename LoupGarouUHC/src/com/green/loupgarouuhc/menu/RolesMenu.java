package com.green.loupgarouuhc.menu;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import com.green.loupgarouuhc.roles.LgRole;
import com.green.loupgarouuhc.roles.Special.Assassin;
import com.green.loupgarouuhc.roles.Special.Cupidon;
import com.green.loupgarouuhc.roles.Special.EnfantSauvage;
import com.green.loupgarouuhc.roles.Special.LoupAmnesique;
import com.green.loupgarouuhc.roles.Special.LoupGarouBlanc;
import com.green.loupgarouuhc.roles.Special.Mercenaire;
import com.green.loupgarouuhc.roles.Special.Voleur;
import com.green.loupgarouuhc.roles.Village.Ancien;
import com.green.loupgarouuhc.roles.Village.Chasseur;
import com.green.loupgarouuhc.roles.Village.Citoyen;
import com.green.loupgarouuhc.roles.Village.Mineur;
import com.green.loupgarouuhc.roles.Village.MontreurOurs;
import com.green.loupgarouuhc.roles.Village.PetiteFille;
import com.green.loupgarouuhc.roles.Village.Renard;
import com.green.loupgarouuhc.roles.Village.Salvateur;
import com.green.loupgarouuhc.roles.Village.Soeur;
import com.green.loupgarouuhc.roles.Village.Sorciere;
import com.green.loupgarouuhc.roles.Village.Voyante;
import com.green.loupgarouuhc.roles.WereWolf.InfectPereDesLoups;
import com.green.loupgarouuhc.roles.WereWolf.VilainPetitLoup;
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
	public HashMap<Class<? extends LgRole>, Boolean> isRoleEnabled = new HashMap<Class<? extends LgRole>, Boolean>();
	public HashMap<String, Class<? extends LgRole>> roleName = new HashMap<String, Class<? extends LgRole>>();
	public ArrayList<Class<? extends LgRole>> defaultActivate = new ArrayList<Class<? extends LgRole>>();
	public ArrayList<LgRole> roles = new ArrayList<LgRole>();
	
	public RolesMenu(String name, Plugin plugin) {
		OptionClickEventHandler handler = new OptionClickEventHandler() {
			@Override
			public void onOptionClick(OptionClickEvent event) {          
				ItemStack item = menu.inventory.getItem(event.getPosition());
				if (item.getDurability() == ENABLED) {
					item.setDurability(DISABLED);
					isRoleEnabled.put(roleName.get(item.getItemMeta().getDisplayName()), false);
				} else {
					item.setDurability(ENABLED);
					isRoleEnabled.put(roleName.get(item.getItemMeta().getDisplayName()), true);
				}
			}
		};
		
		InventoryClosedEventHandler closeHandler = new InventoryClosedEventHandler() {
			@Override
			public void onInventoryClosed(InventoryClosedEvent event) {
				event.mustDestroy = false;
			}
		};
		
		initRoles();
		
		int size = ((((int)(roles.size() / 9.0)) + 1) * 9);
		menu = new IconMenu(name, size, handler, closeHandler, plugin);
		
		initDefaultActivateRole();
		
		int i = 0;
		for (LgRole role : roles) {
			ItemStack stack = new ItemStack(Material.WOOL);
			Class<? extends LgRole> currentClass = role.getClass();
			
			roleName.put(role.getName(), currentClass);
			
			if(defaultActivate.contains(currentClass)) {
				stack.setDurability(ENABLED);
				isRoleEnabled.put(currentClass, true);
			}
			else {
				stack.setDurability(DISABLED);
				isRoleEnabled.put(currentClass, false);
			}
			
			menu.setOption(i, stack, role.getName(), "Role");
			i++;		
		}
	}
	
	public void initRoles() {
		//Special
		roles.add(new Assassin());
		roles.add(new Cupidon());
		roles.add(new EnfantSauvage());
		roles.add(new LoupAmnesique());
		roles.add(new LoupGarouBlanc());
		roles.add(new Mercenaire());
		roles.add(new Voleur());
		
		//Village
		roles.add(new Ancien());
		roles.add(new Chasseur());
		roles.add(new Citoyen());
		roles.add(new Mineur());
		roles.add(new MontreurOurs());
		roles.add(new PetiteFille());
		roles.add(new Renard());
		roles.add(new Salvateur());
		roles.add(new Soeur());
		roles.add(new Sorciere());
		roles.add(new Voyante());
		
		//WereWolf
		roles.add(new InfectPereDesLoups());
		roles.add(new VilainPetitLoup());
	}
	
	public void initDefaultActivateRole() {
		//Special
		defaultActivate.add(Assassin.class);
		defaultActivate.add(Cupidon.class);
		defaultActivate.add(LoupGarouBlanc.class);
		defaultActivate.add(Voleur.class);
		
		//Village
		defaultActivate.add(Ancien.class);
		defaultActivate.add(Mineur.class);
		defaultActivate.add(PetiteFille.class);
		defaultActivate.add(Renard.class);
		defaultActivate.add(Salvateur.class);
		defaultActivate.add(Sorciere.class);
		defaultActivate.add(Voyante.class);
		
		//WereWolf
		defaultActivate.add(InfectPereDesLoups.class);
		defaultActivate.add(VilainPetitLoup.class);
	}
	
	public ArrayList<LgRole> getGameRoles() {
		ArrayList<LgRole> gameRoles = new ArrayList<LgRole>();
		
		for (LgRole lgRole : roles) {
			if(isRoleEnabled.get(lgRole.getClass())) {
				gameRoles.add(lgRole);
			}
		}

		return gameRoles;
	}
}
