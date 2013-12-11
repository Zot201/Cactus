package mods.nana.cactus.item;

import mods.nana.cactus.block.CBlock;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemCBlock extends ItemBlock {

	public ItemCBlock(int id) {
		super(id);
		this.setHasSubtypes(true);
	}
	
	public int getMetadata(int meta) {
		return meta;
	}
	
	public String getUnlocalizedName(ItemStack stack) {
		for (int meta = 0; meta < CBlock.BlockTypes.length; ++meta) {
			if(meta == stack.getItemDamage()) {
				return "tile.CBlock." + CBlock.BlockTypes[meta];
			}
		}
		return "tile.CBlock.null";
    }
}
