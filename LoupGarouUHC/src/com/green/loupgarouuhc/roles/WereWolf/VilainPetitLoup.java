package com.green.loupgarouuhc.roles.WereWolf;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.green.loupgarouuhc.roles.LgRole;

public class VilainPetitLoup extends LgRole {

	@Override
	public void initValues() {
		name = "Vilain petit loup";
		
		description = "Votre rôle est Vilain petit loup et vous devez gagner avec les Loups-Garous. "
					+ "Vous disposez de l'effet Rapidité la nuit. "
					+ "Bonne chance !";
		
		items = new ArrayList<ItemStack>();
		effects = new ArrayList<PotionEffect>();
		
		//Speed
		effects.add(new PotionEffect(PotionEffectType.SPEED, 99999, 1));
		
		victoryCondition = VictoryCondition.Werewolf;
	}

}
