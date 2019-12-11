package com.green.loupgarouuhc.roles.Village;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import com.green.loupgarouuhc.roles.LgRole;

public class MontreurOurs extends LgRole {

	@Override
	public void initValues() {
		name = "Montreur d'ours";
		
		description = "Votre rôle est Montreur d'ours et vous devez gagner avec le village. "
					+ "Vous disposez pour cela d'un pouvoir qui s'active à chaque début de journée. "
					+ "Ce pouvoir affiche un grognement dans le chat pour chaque loup se situant dans un "
					+ "rayon de 50 blocs autour de vous. "
					+ "Bonne chance !";
		
		items = new ArrayList<ItemStack>();
		effects = new ArrayList<PotionEffect>();
		victoryCondition = VictoryCondition.Village;

	}

}
