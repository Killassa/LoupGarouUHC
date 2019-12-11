package com.green.loupgarouuhc;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.green.loupgarouuhc.menu.RolesMenu;
import com.green.loupgarouuhc.roles.LgRole;
import com.green.loupgarouuhc.roles.Special.Cupidon;
import com.green.loupgarouuhc.roles.Special.EnfantSauvage;
import com.green.loupgarouuhc.roles.Village.Chasseur;
import com.green.loupgarouuhc.roles.Village.PetiteFille;
import com.green.loupgarouuhc.roles.Village.Renard;
import com.green.loupgarouuhc.roles.Village.Salvateur;
import com.green.loupgarouuhc.roles.Village.Sorciere;
import com.green.loupgarouuhc.roles.Village.Villageois;
import com.green.loupgarouuhc.roles.Village.Voyante;
import com.green.loupgarouuhc.roles.WereWolf.InfectPereDesLoups;

public class Main extends JavaPlugin {
	RolesMenu menu;
	ArrayList<LgRole> classes;
	
	@Override
	public void onEnable() {
		super.onEnable();
		getLogger().info("Loup garou UHC has been enabled ...");
		
		classes = new ArrayList<LgRole>();
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
			Player playerSender = (Player) sender;
			playerSender.sendMessage(label);
			
			LgRole currentPlayer = getRoleByPlayer(playerSender);
			String cmd = command.getName().toLowerCase();
			String firstPlayer = "";
			String secondPlayer = "";
			
			if(cmd.startsWith("lg")) {
				String[] cmdPart = cmd.split(" ");
				cmd = cmdPart[1];
				firstPlayer = cmdPart[2];
				secondPlayer = cmdPart[3];
			}
			
			Player player1 = null;
			Player player2 = null;
			
			switch (cmd) {
				case "config":
					menu.menu.open(playerSender);
					
					playerSender.sendMessage(menu.isRoleEnabled.toString());
					return true;
					
				case "love":
					player1 = Bukkit.getPlayer(firstPlayer);
					player2 = Bukkit.getPlayer(secondPlayer);
					
					if(playerIsValid(playerSender, player1, player2)) {
						
						if(checkRightRole(currentPlayer, Cupidon.class)) {
							getRoleByPlayer(player1).setIsCouple(true);
							getRoleByPlayer(player2).setIsCouple(true);
						}
					}	
					return true;
					
				case "master":
					player1 = Bukkit.getPlayer(firstPlayer);
					
					if(playerIsValid(playerSender, player1)) {
						
						if(checkRightRole(currentPlayer, EnfantSauvage.class)) {
							EnfantSauvage enfantSauvage = (EnfantSauvage) currentPlayer;
							enfantSauvage.setMaster(player1);
						}
					}
					return true;
					
				case "pan":
					player1 = Bukkit.getPlayer(firstPlayer);
					
					if(playerIsValid(playerSender, player1)) {
						if(checkRightRole(currentPlayer, Chasseur.class)) {
							double currentHealth = player1.getHealth();
							
							player1.setHealth(currentHealth / 2);
						}
					}
					return true;
					
				case "spy":
					if(checkRightRole(currentPlayer, PetiteFille.class)) {
						
					}
					return true;
					
				case "snif":
					player1 = Bukkit.getPlayer(firstPlayer);
					
					if(playerIsValid(playerSender, player1)) {
						if(checkRightRole(currentPlayer, Renard.class)) {
							///Envoi du message au joueur
							getRoleByPlayer(player1).getName();
						}
					}
					
					return true;
					
				case "salvater":
					player1 = Bukkit.getPlayer(firstPlayer);
					
					if(playerIsValid(playerSender, player1)) {
						if(checkRightRole(currentPlayer, Salvateur.class)) {
							player1.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1200, 1));
						}
					}
					
					return true;
					
				case "revive":
					player1 = Bukkit.getPlayer(firstPlayer);
					
					if(playerIsValid(playerSender, player1)) {
						if(checkRightRole(currentPlayer, Sorciere.class)) {
							LgRole revivePlayer = getRoleByPlayer(player1);
							if(revivePlayer.getIsAlive() == false) {
								getRoleByPlayer(player1).setIsAlive(true);
							}
							else {
								playerSender.sendMessage("This player is already alive");
							}
						}
					}
					
					return true;
					
				case "voir":
					player1 = Bukkit.getPlayer(firstPlayer);
					
					if(playerIsValid(playerSender, player1)) {
						if(checkRightRole(currentPlayer, Voyante.class)) {
							///Envoi du message au joueur
							getRoleByPlayer(player1).getName();
						}
					}
					
					return true;
					
				case "infect":
					player1 = Bukkit.getPlayer(firstPlayer);
					
					if(playerIsValid(playerSender, player1)) {
						if(checkRightRole(currentPlayer, InfectPereDesLoups.class)) {
							LgRole infectPlayer = getRoleByPlayer(player1);
							if(infectPlayer.getIsAlive() == false) {
								//Check qui a tué le joueur
								if(true) {
									getRoleByPlayer(player1).setIsAlive(true);
								}
								else {
									playerSender.sendMessage("This player wasn't kill by the werewolfs");
								}
							}
							else {
								playerSender.sendMessage("This player is already alive");
							}
						}
					}
					
					return true;
					
				default:
					commandError(playerSender);
					return true;
			}
		}
		
		return true;
	}
	
	public void commandError(Player playerSender) {
		playerSender.sendMessage("Your command was not recognized");
	}
	
	public void commandWrongRole(Player playerSender) {
		playerSender.sendMessage("You are not authorize to use that command");
	}
	
	public boolean playerIsValid(Player playerSender, Player player1) {
		return playerIsValid(playerSender, player1, null);
	}
	
	public boolean playerIsValid(Player playerSender, Player player1, Player player2) {
		if(player1.isValid() && player2 == null || player1.isValid() && player2.isValid()) {
			return true;
		}
		
		commandError(playerSender);
		return false;
	}
	
	public LgRole getRoleByPlayer(Player player) {
		return classes.get(classes.indexOf(player));
	}
	
	public boolean checkRightRole(LgRole currentPlayer, Class<?> type) {
		if(currentPlayer.getClass().isInstance(type)) {
			return true;
		}
		
		commandWrongRole(currentPlayer.getPlayer());
		return false;
	}
}
