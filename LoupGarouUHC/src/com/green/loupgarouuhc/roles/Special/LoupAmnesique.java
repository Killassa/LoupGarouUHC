package com.green.loupgarouuhc.roles.Special;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.green.loupgarouuhc.roles.LgRole;
import com.green.loupgarouuhc.roles.Village.Villageois;

public class LoupAmnesique extends LgRole {

	@Override
	public void initValues() {
		name = "Villageois";
		
		description = "Votre r�le est Villageois et vous devez gagner avec le village. "
					+ "Vous ne disposez que de votre esprit d'enqu�teur et votre chance pour y parvenir. "
					+ "Bonne chance !";
		
		items = new ArrayList<ItemStack>();
		effects = new ArrayList<PotionEffect>();
		victoryCondition = VictoryCondition.Village;
		
		currentRole = Villageois.class;
	}
	
	public void updateRole() {
		name = "Loup amn�sique";
		
		description = "Vous avez r�cup�r� la m�moire ! "
					+ "Votre r�le est maintenant Loup amn�sique et vous devez gagner avec les Loups-Garous. "
					+ "Vous disposez de l'effet Force la nuit. "
					+ "Bonne chance !";
		
		items = new ArrayList<ItemStack>();
		effects = new ArrayList<PotionEffect>();
		
		//Strength
		effects.add(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 99999, 1));
		
		victoryCondition = VictoryCondition.Werewolf;
		
		currentRole = this.getClass();
	}

}
