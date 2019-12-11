package com.green.loupgarouuhc.roles.Village;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import com.green.loupgarouuhc.roles.LgRole;

public class Soeur extends LgRole {

	@Override
	public void initValues() {
		name = "Soeur";
		
		description = "Votre r�le est Soeur et vous devez gagner avec le village. "
					+ "Vous disposez pour cela de l'effet R�sistance lorsque vous vous situez "
					+ "� moins de 10 blocs de votre soeur et vous avez �galement la possibilit� "
					+ "de conna�tre le r�le du meurtrier de votre soeur. "
					+ "Bonne chance !";
		
		items = new ArrayList<ItemStack>();
		effects = new ArrayList<PotionEffect>();
		victoryCondition = VictoryCondition.Village;
	}

}
