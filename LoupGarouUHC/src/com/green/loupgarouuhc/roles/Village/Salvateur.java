package com.green.loupgarouuhc.roles.Village;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import com.green.loupgarouuhc.roles.LgRole;

public class Salvateur extends LgRole {

	@Override
	public void initValues() {
		name = "Salvateur";
		
		description = "Votre r�le est Salvateur et vous devez gagner avec le village. "
					+ "Vous avez la possibilit�, chaque 20 minutes, de choisir un joueur � qui vous conf�rez "
					+ "l'effet r�sistance ainsi que la possibilit� de ne pas prendre de d�gats de chute."
					+ "Vous ne disposez que de 2 minutes pour effectuer cette commande apr�s l'annonce. "
					+ "(Commande : /lg salvater PlayerName) "
					+ "Bonne chance !";
		
		items = new ArrayList<ItemStack>();
		effects = new ArrayList<PotionEffect>();
		
		victoryCondition = VictoryCondition.Village;
	}

}
