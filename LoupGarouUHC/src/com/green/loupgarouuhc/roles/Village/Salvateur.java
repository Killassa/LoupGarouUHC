package com.green.loupgarouuhc.roles.Village;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import com.green.loupgarouuhc.roles.LgRole;

public class Salvateur extends LgRole {

	@Override
	public void initValues() {
		name = "Salvateur";
		
		description = "Votre rôle est Salvateur et vous devez gagner avec le village. "
					+ "Vous avez la possibilité, chaque 20 minutes, de choisir un joueur à qui vous conférez "
					+ "l'effet résistance ainsi que la possibilité de ne pas prendre de dégats de chute."
					+ "Vous ne disposez que de 2 minutes pour effectuer cette commande après l'annonce. "
					+ "(Commande : /lg salvater PlayerName) "
					+ "Bonne chance !";
		
		items = new ArrayList<ItemStack>();
		effects = new ArrayList<PotionEffect>();
		
		victoryCondition = VictoryCondition.Village;
	}

}
