package com.green.loupgarouuhc.roles;

import java.util.ArrayList;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public abstract class LgRole {
	protected String name;
	protected String description;
	protected ArrayList<ItemStack> items;
	protected ArrayList<PotionEffect> effects;
	protected VictoryCondition victoryCondition;
	
	public LgRole() {
		initValues();
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public ArrayList<ItemStack> getItems() {
		return items;
	}
	
	public ArrayList<PotionEffect> getEffects() {
		return effects;
	}
	
	public VictoryCondition getVictoryCondition() {
		return victoryCondition;
	}
	
	public void setVictoryCondition(VictoryCondition victoryCondition) {
		this.victoryCondition = victoryCondition;
	}
	
	public abstract void initValues();
	
	public enum VictoryCondition {
		Solo,
		Village,
		Werewolf,
		Cupidon,
		Couple
	}
}
