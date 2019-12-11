package com.green.loupgarouuhc.roles.Village;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import com.green.loupgarouuhc.roles.LgRole;

public class Soeur extends LgRole {

	@Override
	public void initValues() {
		name = "Soeur";
		
		description = "Votre rôle est Soeur et vous devez gagner avec le village. "
					+ "Vous disposez pour cela de l'effet Résistance lorsque vous vous situez "
					+ "à moins de 10 blocs de votre soeur et vous avez également la possibilité "
					+ "de connaître le rôle du meurtrier de votre soeur. "
					+ "Bonne chance !";
		
		items = new ArrayList<ItemStack>();
		effects = new ArrayList<PotionEffect>();
		victoryCondition = VictoryCondition.Village;
	}

}
