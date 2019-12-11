package com.green.loupgarouuhc.roles.Special;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.green.loupgarouuhc.roles.LgRole;

public class LoupAmnesique extends LgRole {

	@Override
	public void initValues() {
		name = "Villageois";
		
		description = "Votre rôle est Villageois et vous devez gagner avec le village. "
					+ "Vous ne disposez que de votre esprit d'enquêteur et votre chance pour y parvenir. "
					+ "Bonne chance !";
		
		items = new ArrayList<ItemStack>();
		effects = new ArrayList<PotionEffect>();
		victoryCondition = VictoryCondition.Village;
	}
	
	public void updateRole() {
		name = "Loup amnésique";
		
		description = "Vous avez récupéré la mémoire ! "
					+ "Votre rôle est maintenant Loup amnésique et vous devez gagner avec les Loups-Garous. "
					+ "Vous disposez de l'effet Force la nuit. "
					+ "Bonne chance !";
		
		items = new ArrayList<ItemStack>();
		effects = new ArrayList<PotionEffect>();
		
		//Strength
		effects.add(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 99999, 1));
		
		victoryCondition = VictoryCondition.Werewolf;
	}

}
