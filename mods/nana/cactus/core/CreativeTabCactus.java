package mods.nana.cactus.core;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabCactus extends CreativeTabs {

	public CreativeTabCactus(String label) {
		super(label);
	}

	public int getTabIconItemIndex() {
        return Block.cactus.blockID;
    }
}
