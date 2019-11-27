package com.green.loupgarouuhc.roles.Village;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import com.green.loupgarouuhc.roles.LgRole;

public class Villageois extends LgRole {

	@Override
	public void initValues() {
		name = "Villageois";
		
		description = "Votre rôle est Villageois et vous devez gagner avec le village. "
					+ "Vous ne disposez que de votre esprit d'enquêteur pour y parvenir. "
					+ "Bonne chance !";
		
		items = new ArrayList<ItemStack>();
		effects = new ArrayList<PotionEffect>();
		victoryCondition = VictoryCondition.Village;
	}
}
