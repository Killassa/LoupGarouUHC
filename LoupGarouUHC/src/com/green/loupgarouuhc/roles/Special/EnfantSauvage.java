package com.green.loupgarouuhc.roles.Special;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.green.loupgarouuhc.roles.LgRole;

public class EnfantSauvage extends LgRole {

	Player master = null;
	
	@Override
	public void initValues() {
		name = "Enfant sauvage";
		
		description = "Votre rôle est Enfant sauvage et vous devez gagner avec le village. "
					+ "Vous devez désigner un maître et si celui-ci meurt vous deviendrez un Loup-Garou "
					+ "et devrez gagner avec les loups. "
					+ "(Commande: /lg master PlayerName) "
					+ "Bonne chance !";
		
		items = new ArrayList<ItemStack>();
		effects = new ArrayList<PotionEffect>();
		victoryCondition = VictoryCondition.Village;
	}

	public void setMaster(Player master) {
		this.master = master;
	}
	
	public boolean masterAlive(Player deadPlayer) {
		if(deadPlayer == master) {
			description = "Votre maître est mort ! "
						+ "Vous devenez donc un Loup-Garou et vous devez gagner avec les Loups-Garous.";
			
			//Strength
			effects.add(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 99999, 1));
			
			victoryCondition = VictoryCondition.Werewolf;
			
			return false;
		}
		
		return true;
	}
	
}
