package com.green.loupgarouuhc.roles.Special;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.green.loupgarouuhc.roles.LgRole;

public class Voleur extends LgRole {

	@Override
	public void initValues() {
		name = "Voleur";
		
		description = "Votre rôle est Voleur et vous devez gagner en solo. "
					+ "Vous disposez de l'effet Résistance jusqu'à ce que vous voliez un rôle. "
					+ "Vous gagnez le rôle de la première personne que vous tuez et devrez donc gagner avec la "
					+ "condition de victoire de votre nouveau rôle. Si les pouvoirs du rôle récupéré ont déjà été "
					+ "utilisés, vous ne pourrez plus les utiliser et vous n'obtiendrez pas non plus les objets "
					+ "spécifiques du rôle. "
					+ "Bonne chance !";
		
		items = new ArrayList<ItemStack>();		
		effects = new ArrayList<PotionEffect>();
		
		//Strength
		effects.add(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 99999, 1));
		
		victoryCondition = VictoryCondition.Solo;
	}

}
