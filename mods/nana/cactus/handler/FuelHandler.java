package mods.nana.cactus.handler;

import mods.nana.cactus.Cactus;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		if (fuel.itemID == Cactus.getCactusItem("blockCactus").itemID && fuel.getItemDamage() == Cactus.getCactusItem("blockCactus").getItemDamage()) {
			return 2000;
		}
		if (fuel.itemID == Cactus.getCactusItem("CSlab").itemID) {
			return 1000;
		}
		if (fuel.itemID == Cactus.getCactusItem("CStick").itemID && fuel.getItemDamage() == Cactus.getCactusItem("CStick").getItemDamage()) {
			return 100; 
		}
		if (fuel.itemID == Cactus.getCactusItem("CSkin").itemID && fuel.getItemDamage() == Cactus.getCactusItem("CSkin").getItemDamage()) {
			return 50;
		}
		if (fuel.itemID == Cactus.getCactusItem("CCoal").itemID && fuel.getItemDamage() == Cactus.getCactusItem("CCoal").getItemDamage()) {
			return 1600;
		}
		if (fuel.itemID == Block.cactus.blockID) {
			return 200;
		}
		return 0;
	}
}
