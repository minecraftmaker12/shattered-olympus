package net.mcreator.shatteredolympus.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.shatteredolympus.ShatteredOlympusMod;

import java.util.Map;

public class PredatoryPlantMobplayerCollidesWithPlantProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ShatteredOlympusMod.LOGGER.warn("Failed to load dependency entity for procedure PredatoryPlantMobplayerCollidesWithPlant!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setMotion(0, 0, 0);
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
	}
}
