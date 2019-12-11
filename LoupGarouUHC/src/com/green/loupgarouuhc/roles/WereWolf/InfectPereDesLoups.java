package com.green.loupgarouuhc.roles.WereWolf;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.green.loupgarouuhc.roles.LgRole;

public class InfectPereDesLoups extends LgRole {

	@Override
	public void initValues() {
		name = "Infect père des loups";
		
		description = "Votre rôle est Infect père des loups et vous devez gagner avec les Loups-Garous. "
					+ "Vous disposez de l'effet Force la nuit ainsi que Rapidité pendant 2 minutes lorsque vous "
					+ "tuez un joueur. "
					+ "Lorsque les loups tuent un joueur, vous avez la possibilité de le ressusciter, celui-ci "
					+ "devient donc un loup-garou tout en conservant ses anciens pouvoirs. "
					+ "(Commande: /lg infect PlayerName) "
					+ "Bonne chance !";
		
		items = new ArrayList<ItemStack>();
		effects = new ArrayList<PotionEffect>();
		
		//Strength
		effects.add(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 99999, 1));
		
		victoryCondition = VictoryCondition.Werewolf;
	}

}
