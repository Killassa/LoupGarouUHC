package com.green.loupgarouuhc.roles.Village;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import com.green.loupgarouuhc.roles.LgRole;

public class Citoyen extends LgRole {

	@Override
	public void initValues() {
		name = "Citoyen";
		
		description = "Votre r�le est Citoyen et vous devez gagner avec le village. "
					+ "Vous avez la possibilit� de visualiser � 2 reprises les votes des joueurs dans la partie. "
					+ "Vous recevrez un message dans le chat juste avant l'annonce du r�sultat du vote et lors du clic "
					+ "sur voir vous pourrez savoir quel joueur � voter pour quel joueur. "
					+ "Bonne chance !";
		
		items = new ArrayList<ItemStack>();
		effects = new ArrayList<PotionEffect>();
		victoryCondition = VictoryCondition.Village;
	}

}
