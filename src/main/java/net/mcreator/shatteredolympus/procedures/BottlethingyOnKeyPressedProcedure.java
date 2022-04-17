package net.mcreator.shatteredolympus.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.shatteredolympus.item.RainwaterBottleItem;
import net.mcreator.shatteredolympus.ShatteredOlympusMod;

import java.util.Map;

public class BottlethingyOnKeyPressedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ShatteredOlympusMod.LOGGER.warn("Failed to load dependency world for procedure BottlethingyOnKeyPressed!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ShatteredOlympusMod.LOGGER.warn("Failed to load dependency x for procedure BottlethingyOnKeyPressed!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ShatteredOlympusMod.LOGGER.warn("Failed to load dependency y for procedure BottlethingyOnKeyPressed!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ShatteredOlympusMod.LOGGER.warn("Failed to load dependency z for procedure BottlethingyOnKeyPressed!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ShatteredOlympusMod.LOGGER.warn("Failed to load dependency entity for procedure BottlethingyOnKeyPressed!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
				&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
						.equals(new ResourceLocation("shattered_olympus:tear_grasslands"))
				&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == Items.GLASS_BOTTLE) {
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(RainwaterBottleItem.block);
				_setstack.setCount((int) 1);
				((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
		}
	}
}
