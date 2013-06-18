package mods.nnsr.cactus.common;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabCactus extends CreativeTabs {

	public CreativeTabCactus(String label) {
		super(label);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return Block.cactus.blockID;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel()
	{
		return "Cactus!!+";
	}
}
