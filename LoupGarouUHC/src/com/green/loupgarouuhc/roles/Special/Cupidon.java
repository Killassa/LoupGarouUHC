package com.green.loupgarouuhc.roles.Special;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import com.green.loupgarouuhc.roles.LgRole;

public class Cupidon extends LgRole {

	@Override
	public void initValues() {
		name = "Cupidon";
		
		description = "Votre rôle est Cupidon et vous devez gagner avec le village ou avec le couple. "
					+ "Vous disposez d'un arc Recul 2 ainsi que de 64 flèches. "
					+ "Vous avez 10 minutes pour désigner 2 personnes que vous mettrez en couple. "
					+ "(Commande: /lg love Player1 Player2) "
					+ "Bonne chance !";
		
		items = new ArrayList<ItemStack>();
		
		//Bow
		ItemStack bow = new ItemStack(Material.BOW, 1);
		bow.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
		items.add(bow);
		
		//Arrow
		items.add(new ItemStack(Material.ARROW, 64));
		
		effects = new ArrayList<PotionEffect>();
		victoryCondition = VictoryCondition.Cupidon;
	}

}
