package com.green.loupgarouuhc.roles.Village;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionType;

import com.green.loupgarouuhc.roles.LgRole;

public class Sorciere extends LgRole {

	@Override
	public void initValues() {
		name = "Sorcière";
		
		description = "Votre rôle est Sorcière et vous devez gagner avec le village. "
					+ "Vous disposez de 3 options de vie, 1 potion de régénération et 3 potions de dégats. "
					+ "Lors de la mort d'un joueur (vous y compris), vous avez la possibilité de le ressusciter. "
					+ "(Commande : /lg revive PlayerName)"
					+ "Bonne chance !";
		
		items = new ArrayList<ItemStack>();
		
		//Instant heal
		ItemStack instantHeal = new Potion(PotionType.INSTANT_HEAL, 1).toItemStack(3);
		items.add(instantHeal);
		
		//Regen
		ItemStack regen = new Potion(PotionType.REGEN, 1).toItemStack(1);
		items.add(regen);
		
		//Instant damage
		ItemStack instantDamage = new Potion(PotionType.INSTANT_DAMAGE, 1).toItemStack(3);
		items.add(instantDamage);
		
		effects = new ArrayList<PotionEffect>();
		victoryCondition = VictoryCondition.Village;
	}

}
