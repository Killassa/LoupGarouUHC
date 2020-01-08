package com.green.loupgarouuhc.roles;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public abstract class LgRole {
	protected String name;
	protected String description;
	protected String moreInfo;
	protected ArrayList<ItemStack> items;
	protected ArrayList<PotionEffect> effects;
	protected VictoryCondition victoryCondition;
	protected double strengthDamageRatio;
	protected int life;
	protected boolean isCouple;
	protected Player player;
	protected boolean isAlive;
	protected Player killer;
	protected Class<? extends LgRole> currentRole;
	
	public LgRole() {
		defaultValues();
		initValues();
	}
	
	//Get
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getMoreInfo() {
		return moreInfo;
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
	
	public double getStrengthDamageRatio() {
		return strengthDamageRatio;
	}
	
	public int getLife() {
		return life;
	}
	
	public boolean getIsCouple() {
		return isCouple;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public boolean getIsAlive() {
		return isAlive;
	}
	
	public Player getKiller() {
		return killer;
	}
	
	public Class<? extends LgRole> getCurrentRole() {
		return currentRole;
	}
	
	//Set
	public void setVictoryCondition(VictoryCondition victoryCondition) {
		this.victoryCondition = victoryCondition;
	}
	
	public void setIsCouple(boolean isCouple) {
		this.isCouple = isCouple;
		this.victoryCondition = VictoryCondition.Couple;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	public void setKiller(Player killer) {
		this.killer = killer;
	}
	
	public void setCurrentRole(Class<? extends LgRole> currentRole) {
		this.currentRole = currentRole;
	}
	
	//Function
	public abstract void initValues();
	
	private void defaultValues() {
		moreInfo = "";
		strengthDamageRatio = 0.6;
		life = 20;
		isCouple = false;
		player = null;
		isAlive = true;
		killer = null;
		currentRole = this.getClass();
	}
	
	public enum VictoryCondition {
		Solo,
		Village,
		Werewolf,
		Cupidon,
		Couple
	}
}
