package com.green.loupgarouuhc.roles;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public abstract class LgRole {
	protected String name;
	protected String description;
	protected ArrayList<ItemStack> items;
	protected ArrayList<PotionEffect> effects;
	protected VictoryCondition victoryCondition;
	protected double strengthDamageRatio = 0.6;
	protected int life = 20;
	protected boolean isCouple = false;
	protected Player player = null;
	protected boolean isAlive = true;
	
	public LgRole() {
		initValues();
	}
	
	//Get
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
	
	public abstract void initValues();
	
	public enum VictoryCondition {
		Solo,
		Village,
		Werewolf,
		Cupidon,
		Couple
	}
}
