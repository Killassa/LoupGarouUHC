package com.green.loupgarouuhc.roles.Village;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.green.loupgarouuhc.roles.LgRole;

public class Renard extends LgRole {

	@Override
	public void initValues() {
		name = "Renard";
		
		description = "Votre r�le est Renard et vous devez gagner avec le village. "
					+ "Vous disposez de l'effet Rapidit�. "
					+ "Vous avez la possibilit� de flairer 3 personnes diff�rentes se trouvant dans un rayon "
					+ "de 10 blocs autour de vous au cours de la partie, vous saurez ainsi si celui-ci est un "
					+ "loup ou un innocent. Cependant vous ne verez en tant que loup que les r�les ayant 'loup' "
					+ "dans leur nom de r�le. "
					+ "(Commande : lg snif PlayerName) "
					+ "Bonne chance !";
		
		items = new ArrayList<ItemStack>();
		effects = new ArrayList<PotionEffect>();
		
		//Speed
		effects.add(new PotionEffect(PotionEffectType.SPEED, 99999, 1));
		
		victoryCondition = VictoryCondition.Village;
	}

}
