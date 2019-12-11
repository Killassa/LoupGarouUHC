package com.green.loupgarouuhc.roles.Special;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.green.loupgarouuhc.roles.LgRole;

public class LoupGarouBlanc extends LgRole {

	@Override
	public void initValues() {
		name = "Loup-Garou blanc";
		
		description = "Votre rôle est Loup-Garou blanc et vous devez gagner en solo. "
					+ "Vous disposez de l'effet Force la nuit ainsi que de 5 coeurs supplémentaires. "
					+ "Bonne chance !";
		
		items = new ArrayList<ItemStack>();		
		effects = new ArrayList<PotionEffect>();
		
		//Strength
		effects.add(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 99999, 1));
		
		victoryCondition = VictoryCondition.Solo;
		life = 30;
	}

}
