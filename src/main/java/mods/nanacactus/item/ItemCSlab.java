package mods.nanacactus.item;

import mods.nanacactus.block.CSlab;
import net.minecraft.block.Block;

public class ItemCSlab extends ItemCSlabProxy
{
    public ItemCSlab(Block block, CSlab singleSlab, CSlab doubleSlab)
    {
        super(block, singleSlab, doubleSlab, false);
    }
}
