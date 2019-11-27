package com.green.loupgarouuhc.roles.Village;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.green.loupgarouuhc.roles.LgRole;
import com.green.loupgarouuhc.roles.LgRole.VictoryCondition;

public class Ancien extends LgRole {

	@Override
	public void initValues() {
		name = "Ancien";
		
		description = "Votre rôle est Ancien et vous devez gagner avec le village. "
					+ "Vous disposez de l'effet résistance 1 et vous ressusciter lors de votre première mort. "
					+ "Bonne chance !";
		
		items = new ArrayList<ItemStack>();
		effects = new ArrayList<PotionEffect>();
		
		//Resistance
		effects.add(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 99999, 1));
		
		victoryCondition = VictoryCondition.Village;
	}

}
