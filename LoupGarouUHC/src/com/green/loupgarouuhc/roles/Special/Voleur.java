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
		
		description = "Votre r�le est Voleur et vous devez gagner en solo. "
					+ "Vous disposez de l'effet R�sistance jusqu'� ce que vous voliez un r�le. "
					+ "Vous gagnez le r�le de la premi�re personne que vous tuez et devrez donc gagner avec la "
					+ "condition de victoire de votre nouveau r�le. Si les pouvoirs du r�le r�cup�r� ont d�j� �t� "
					+ "utilis�s, vous ne pourrez plus les utiliser et vous n'obtiendrez pas non plus les objets "
					+ "sp�cifiques du r�le. "
					+ "Bonne chance !";
		
		items = new ArrayList<ItemStack>();		
		effects = new ArrayList<PotionEffect>();
		
		//Strength
		effects.add(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 99999, 1));
		
		victoryCondition = VictoryCondition.Solo;
	}

}
