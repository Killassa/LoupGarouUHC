package com.green.loupgarouuhc.roles.Special;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.green.loupgarouuhc.roles.LgRole;

public class Assassin extends LgRole {

	@Override
	public void initValues() {
		name = "Assassin";
		
		description = "Votre rôle est Assassin et vous devez gagner en solo. "
					+ "Vous disposez de l'effet Force le jour ainsi que des livres Protection 3, Tranchant 3 et Puissance 3. "
					+ "Bonne chance !";
		
		items = new ArrayList<ItemStack>();
		
		//Book Protection
		ItemStack bookProt = new ItemStack(Material.BOOK, 1);
		bookProt.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		items.add(bookProt);
		
		//Book Sharpness
		ItemStack bookSharp = new ItemStack(Material.BOOK, 1);
		bookSharp.addEnchantment(Enchantment.DAMAGE_ALL, 3);
		items.add(bookSharp);
		
		//Book Power
		ItemStack BookPow = new ItemStack(Material.BOOK, 1);
		BookPow.addEnchantment(Enchantment.ARROW_DAMAGE, 3);
		items.add(BookPow);
		
		effects = new ArrayList<PotionEffect>();
		
		//Strength
		effects.add(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 99999, 1));
		
		victoryCondition = VictoryCondition.Solo;
	}

}
