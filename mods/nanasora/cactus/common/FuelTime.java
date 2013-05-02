package mods.nanasora.cactus.common;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelTime implements IFuelHandler{

	@Override
	public int getBurnTime(ItemStack fuel) {
		if (fuel.itemID == Cactus.CStick.itemID) {
			return 100;
		}
		if (fuel.itemID == Block.cactus.blockID) {
			return Cactus.CactusFuel;
		}
		if (fuel.itemID == Cactus.CSkin.itemID){
			return Cactus.CactusFuel / 4;
		}
		if (fuel.itemID == Cactus.CCoal.itemID) {
			return 1600;
		}
		return 0;
	}

}
