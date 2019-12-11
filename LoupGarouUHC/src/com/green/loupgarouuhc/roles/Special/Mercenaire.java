package com.green.loupgarouuhc.roles.Special;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import com.green.loupgarouuhc.roles.LgRole;

public class Mercenaire extends LgRole {

	@Override
	public void initValues() {
		name = "Mercenaire";
		
		description = "Votre rôle est Mercenaire et vous devez gagner avec les Loups-Garous. "
					+ "Vous n'avez pas accès à la liste des loups et les loups ne vous connaissent pas non plus. "
					+ "A vous de trouver un moyen d'aider les loups tout en évitant qu'ils vous tuent. "
					+ "Bonne chance !";
		
		items = new ArrayList<ItemStack>();
		effects = new ArrayList<PotionEffect>();
		
		victoryCondition = VictoryCondition.Werewolf;
	}

}
