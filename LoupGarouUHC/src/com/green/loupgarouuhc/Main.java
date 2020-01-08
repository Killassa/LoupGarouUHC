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
import com.green.loupgarouuhc.roles.Special.LoupAmnesique;
import com.green.loupgarouuhc.roles.Special.LoupGarouBlanc;
import com.green.loupgarouuhc.roles.Village.Chasseur;
import com.green.loupgarouuhc.roles.Village.PetiteFille;
import com.green.loupgarouuhc.roles.Village.Renard;
import com.green.loupgarouuhc.roles.Village.Salvateur;
import com.green.loupgarouuhc.roles.Village.Sorciere;
import com.green.loupgarouuhc.roles.Village.Villageois;
import com.green.loupgarouuhc.roles.Village.Voyante;
import com.green.loupgarouuhc.roles.WereWolf.InfectPereDesLoups;
import com.green.loupgarouuhc.roles.WereWolf.LoupGarou;
import com.green.loupgarouuhc.roles.WereWolf.VilainPetitLoup;

public class Main extends JavaPlugin {
	RolesMenu menu;
	ArrayList<LgRole> classes;
	
	@Override
	public void onEnable() {
		super.onEnable();
		getLogger().info("Loup garou UHC has been enabled ...");
		
		menu = new RolesMenu("LGRoles", this);
		
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
	
	@SuppressWarnings("deprecation")
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
					
				case "start":
					rolesDistribution();
					return true;
					
				case "love":
					player1 = Bukkit.getPlayer(firstPlayer);
					player2 = Bukkit.getPlayer(secondPlayer);
					
					if(playerIsValid(playerSender, player1, player2)) {
						
						if(checkRightRole(currentPlayer, Cupidon.class)) {
							getRoleByPlayer(player1).setIsCouple(true);
							getRoleByPlayer(player2).setIsCouple(true);
							playerSender.sendMessage(String.format("%s et %s sont maintenant follement amoureux.", player1.getName(), player2.getName()));
							player1.sendMessage(String.format("Vous êtes tombés follement amoureux de %s.", player2.getName()));
							player2.sendMessage(String.format("Vous êtes tombés follement amoureux de %s.", player1.getName()));
						}
					}	
					return true;
					
				case "master":
					player1 = Bukkit.getPlayer(firstPlayer);
					
					if(playerIsValid(playerSender, player1)) {
						
						if(checkRightRole(currentPlayer, EnfantSauvage.class)) {
							EnfantSauvage enfantSauvage = (EnfantSauvage) currentPlayer;
							enfantSauvage.setMaster(player1);
							playerSender.sendMessage(String.format("%s est maintenant votre maître.", player1.getName()));
						}
					}
					return true;
					
				case "pan":
					player1 = Bukkit.getPlayer(firstPlayer);
					
					if(playerIsValid(playerSender, player1)) {
						if(checkRightRole(currentPlayer, Chasseur.class)) {
							double currentHealth = player1.getHealth();
							
							player1.setHealth(currentHealth / 2);
							player1.sendMessage("Le chasseur vous a tiré dessus !");
						}
					}
					return true;
					
				case "spy":
					if(checkRightRole(currentPlayer, PetiteFille.class)) {
						String playerList = "";
						
						for (org.bukkit.entity.Entity role : currentPlayer.getPlayer().getNearbyEntities(100, 100, 50)) {
							if(role instanceof Player) {
								if(playerList.isEmpty()) {
									playerList = role.getName();
								}
								else {
									playerList += " " + role.getName();
								}
							}
						}
						playerSender.sendMessage(String.format("Les joueurs suivant se trouvent à moins de 100 blocs de vous :%s.", playerList));
					}
					return true;
					
				case "snif":
					player1 = Bukkit.getPlayer(firstPlayer);
					
					if(playerIsValid(playerSender, player1)) {
						if(checkRightRole(currentPlayer, Renard.class)) {
							playerSender.sendMessage(String.format("Ce joueur est %s.", getRoleByPlayer(player1).getName()));
							player1.sendMessage("Vous avez été ressuscité, prenez soin de votre nouvelle vie !");
						}
					}
					
					return true;
					
				case "salvater":
					player1 = Bukkit.getPlayer(firstPlayer);
					
					if(playerIsValid(playerSender, player1)) {
						if(checkRightRole(currentPlayer, Salvateur.class)) {
							player1.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1200, 1));
							playerSender.sendMessage("Vous avez attribué votre bénédiction !");
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
								playerSender.sendMessage(String.format("Vous avez ressuscité %s.", player1.getName()));
							}
							else {
								playerSender.sendMessage("Ce joueur est en vie.");
							}
						}
					}
					
					return true;
					
				case "voir":
					player1 = Bukkit.getPlayer(firstPlayer);
					
					if(playerIsValid(playerSender, player1)) {
						if(checkRightRole(currentPlayer, Voyante.class)) {
							playerSender.sendMessage(String.format("Ce joueur est %s.", getRoleByPlayer(player1).getName()));
						}
					}
					
					return true;
					
				case "infect":
					player1 = Bukkit.getPlayer(firstPlayer);
					
					if(playerIsValid(playerSender, player1)) {
						if(checkRightRole(currentPlayer, InfectPereDesLoups.class)) {
							LgRole infectPlayer = getRoleByPlayer(player1);
							if(infectPlayer.getIsAlive() == false) {
								if(checkKillerWerewolfRole(getRoleByPlayer(infectPlayer.getKiller()))) {
									infectPlayer.setIsAlive(true);
									infectPlayer.setCurrentRole(LoupGarou.class);
									playerSender.sendMessage(String.format("Vous avez ressuscité %s et il fait maintenant partie de votre camp.", player1.getName()));
									player1.sendMessage("Vous avez été ressuscité et faites maintenant partie du camp des loups-garous.");
								}
								else {
									playerSender.sendMessage("Ce joueur n'a pas été tué par les loups-garous.");
								}
							}
							else {
								playerSender.sendMessage("Ce joueur est en vie.");
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
	
	public void rolesDistribution() {
		ArrayList<LgRole> specialRoles = new ArrayList<LgRole>();
		ArrayList<LgRole> villageRoles = new ArrayList<LgRole>();
		ArrayList<LgRole> werewolfRoles = new ArrayList<LgRole>();
		
		for (LgRole role : menu.getGameRoles()) {
			String[] canonicalName = role.getClass().getCanonicalName().split("\\.");
			String currentRoleType = canonicalName[canonicalName.length - 1];
			
			switch (currentRoleType) {
				case "Special":
					specialRoles.add(role);
					
				case "Village":
					villageRoles.add(role);
					
				case "WereWolf":
					werewolfRoles.add(role);
			}
		}
		
		ArrayList<Player> players = new ArrayList<Player>();
		players.addAll(Bukkit.getOnlinePlayers());
		
		for (LgRole role : specialRoles) {
			int randomPlayer = (int) Math.round(Math.random() * players.size());
			
			role.setPlayer(players.get(randomPlayer));
			players.remove(randomPlayer);
		}
		
		classes.addAll(specialRoles);
		
		int villagePlayers = Math.round(players.size() / 3 * 2);
		int werewolfPlayers = players.size() - villagePlayers;
		
		for (int i = 0; i < villagePlayers; i++) {
			int randomPlayer = (int) Math.round(Math.random() * players.size());
			
			if(villageRoles.size() > 0) {
				int randomRole = (int) Math.round(Math.random() * villageRoles.size());
				
				LgRole role = villageRoles.get(randomRole);
				role.setPlayer(players.get(randomPlayer));
				classes.add(role);
				
				villageRoles.remove(randomRole);
			}
			else {
				LgRole role = new Villageois();
				role.setPlayer(players.get(randomPlayer));
				classes.add(role);
			}
			
			players.remove(randomPlayer);
		}
		
		for (int i = 0; i < werewolfPlayers; i++) {
			int randomPlayer = (int) Math.round(Math.random() * players.size());
			
			if(werewolfRoles.size() > 0) {
				int randomRole = (int) Math.round(Math.random() * werewolfRoles.size());
				
				LgRole role = werewolfRoles.get(randomRole);
				role.setPlayer(players.get(randomPlayer));
				classes.add(role);
				
				werewolfRoles.remove(randomRole);
			}
			else {
				LgRole role = new LoupGarou();
				role.setPlayer(players.get(randomPlayer));
				classes.add(role);
			}
			
			players.remove(randomPlayer);
		}
	}
	
	public void commandError(Player playerSender) {
		playerSender.sendMessage("Votre commande n'a pas été reconnu.");
	}
	
	public void commandWrongRole(Player playerSender) {
		playerSender.sendMessage("Vous n'êtes pas autorisé à utiliser cette commande.");
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
	
	public boolean checkRightRole(LgRole currentPlayer, Class<? extends LgRole> type) {
		if(currentPlayer.getClass().isInstance(type)) {
			return true;
		}
		
		commandWrongRole(currentPlayer.getPlayer());
		return false;
	}
	
	public boolean checkKillerWerewolfRole(LgRole killer) {
		if(checkRightRole(killer, InfectPereDesLoups.class) || checkRightRole(killer, LoupGarou.class) || checkRightRole(killer, VilainPetitLoup.class) || checkRightRole(killer, LoupGarouBlanc.class) || checkRightRole(killer, LoupAmnesique.class)) {
			return true;
		}
		
		return false;
	}
}
