package mods.nana.cactus.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class CreativeTabCactus extends CreativeTabs
{
    public CreativeTabCactus(String label)
    {
        super(label);
    }

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(Blocks.cactus);
	}
}
