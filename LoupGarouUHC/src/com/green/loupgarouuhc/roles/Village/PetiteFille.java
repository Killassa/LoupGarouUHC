package com.green.loupgarouuhc.roles.Village;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.green.loupgarouuhc.roles.LgRole;

public class PetiteFille extends LgRole {

	@Override
	public void initValues() {
		name = "PetiteFille";
		
		description = "Votre rôle est PetiteFille et vous devez gagner avec le village. "
					+ "Vous disposez des effets Invisibilité, Faiblesse et Rapidité la nuit. "
					+ "Vous avez accès aux noms de tous les joueurs qui se trouvent dans un rayon de 100 blocs. "
					+ "(Commande : /lg spy) "
					+ "Bonne chance !";
		
		items = new ArrayList<ItemStack>();
		effects = new ArrayList<PotionEffect>();
		
		//Invisibility
		effects.add(new PotionEffect(PotionEffectType.INVISIBILITY, 99999, 1));
		
		//Weakness
		effects.add(new PotionEffect(PotionEffectType.WEAKNESS, 99999, 1));
		
		//Speed
		effects.add(new PotionEffect(PotionEffectType.SPEED, 99999, 1));
		
		victoryCondition = VictoryCondition.Village;
	}

}
