package com.green.loupgarouuhc.roles.Village;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.green.loupgarouuhc.roles.LgRole;

public class Mineur extends LgRole {

	@Override
	public void initValues() {
		name = "Mineur";
		
		description = "Votre rôle est Mineur et vous devez gagner avec le village. "
					+ "Vous disposez des effets Scélérité ainsi que d'une pioche en diamant Efficacité 2. "
					+ "Bonne chance !";
		
		items = new ArrayList<ItemStack>();
		
		//Pickaxe
		ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE, 1);
		pickaxe.addEnchantment(Enchantment.DIG_SPEED, 2);
		items.add(pickaxe);
		
		effects = new ArrayList<PotionEffect>();
		
		//Haste
		effects.add(new PotionEffect(PotionEffectType.FAST_DIGGING, 99999, 2));
		
		victoryCondition = VictoryCondition.Village;

	}

}
