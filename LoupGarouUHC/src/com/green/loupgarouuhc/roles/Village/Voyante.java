package com.green.loupgarouuhc.roles.Village;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import com.green.loupgarouuhc.roles.LgRole;

public class Voyante extends LgRole {

	@Override
	public void initValues() {
		name = "Voyante";
		
		description = "Votre rôle est Voyante et vous devez gagner avec le village. "
					+ "Vous disposez de 4 obsidiennes ainsi que 2 bibliothèques. "
					+ "Chaque 30 minutes, après l'attribution des rôles, vous disposez de 2 minutes "
					+ "pour connaître le rôle d'une personne de votre choix. "
					+ "(Commande: /lg voir PlayerName) "
					+ "Bonne chance !";
		
		items = new ArrayList<ItemStack>();
		
		//Obsidian
		items.add(new ItemStack(Material.OBSIDIAN, 4));
		
		//Bookshelf
		items.add(new ItemStack(Material.BOOKSHELF, 2));
		
		effects = new ArrayList<PotionEffect>();
		victoryCondition = VictoryCondition.Village;
	}

}
