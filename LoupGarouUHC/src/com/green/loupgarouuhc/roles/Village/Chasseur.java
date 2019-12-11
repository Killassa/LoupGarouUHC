package com.green.loupgarouuhc.roles.Village;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import com.green.loupgarouuhc.roles.LgRole;

public class Chasseur extends LgRole {

	@Override
	public void initValues() {
		name = "Chasseur";
		
		description = "Votre rôle est Chasseur et vous devez gagner avec le village. "
					+ "Vous disposez d'un livre Puissance 4 ainsi que de 128 flèches. "
					+ "A votre mort vous avez une minute pour choisir un joueur et lui enlever la moitié de sa vie. "
					+ "(Commande : /lg pan PlayerName)"
					+ "Bonne chance !";
		
		items = new ArrayList<ItemStack>();
		
		//Book
		ItemStack book = new ItemStack(Material.BOOK, 1);
		book.addEnchantment(Enchantment.ARROW_DAMAGE, 4);
		items.add(book);
		
		//Arrow
		items.add(new ItemStack(Material.ARROW, 128));
		
		effects = new ArrayList<PotionEffect>();
		victoryCondition = VictoryCondition.Village;
	}

}
