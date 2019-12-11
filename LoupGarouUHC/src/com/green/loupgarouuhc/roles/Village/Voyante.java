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
		
		description = "Votre r�le est Voyante et vous devez gagner avec le village. "
					+ "Vous disposez de 4 obsidiennes ainsi que 2 biblioth�ques. "
					+ "Chaque 30 minutes, apr�s l'attribution des r�les, vous disposez de 2 minutes "
					+ "pour conna�tre le r�le d'une personne de votre choix. "
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
