package com.green.loupgarouuhc.roles.Village;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import com.green.loupgarouuhc.roles.LgRole;

public class Citoyen extends LgRole {

	@Override
	public void initValues() {
		name = "Citoyen";
		
		description = "Votre rôle est Citoyen et vous devez gagner avec le village. "
					+ "Vous avez la possibilité de visualiser à 2 reprises les votes des joueurs dans la partie. "
					+ "Vous recevrez un message dans le chat juste avant l'annonce du résultat du vote et lors du clic "
					+ "sur voir vous pourrez savoir quel joueur à voter pour quel joueur. "
					+ "Bonne chance !";
		
		items = new ArrayList<ItemStack>();
		effects = new ArrayList<PotionEffect>();
		victoryCondition = VictoryCondition.Village;
	}

}
