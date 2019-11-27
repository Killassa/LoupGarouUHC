package com.green.loupgarouuhc.roles.WereWolf;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.green.loupgarouuhc.roles.LgRole;

public class LoupGarou extends LgRole {

	@Override
	public void initValues() {
		name = "Loup-Garou";
		
		description = "Votre rôle est Loup-Garou et vous devez gagner avec les Loups-Garous. "
					+ "Vous disposez de l'effet Force la nuit. "
					+ "Bonne chance !";
		
		items = new ArrayList<ItemStack>();
		effects = new ArrayList<PotionEffect>();
		
		//Strength
		effects.add(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 99999, 1));
		
		victoryCondition = VictoryCondition.Werewolf;
		strengthDamageRatio = 0.6;
	}
}
