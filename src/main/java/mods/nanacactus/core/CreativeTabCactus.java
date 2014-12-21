package mods.nanacactus.core;

import mods.nanacactus.Cactus;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabCactus extends CreativeTabs
{
    public CreativeTabCactus(String label)
    {
        super(label);
    }

	@Override public Item getTabIconItem()
	{
		return Item.getItemFromBlock(Cactus.cactus);
	}
}
