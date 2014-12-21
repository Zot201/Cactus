package mods.nanacactus.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemCSlabProxy extends ItemSlab
{
    ItemCSlabProxy(Block block, BlockSlab singleSlab, BlockSlab doubleSlab, boolean isDouble)
    {
        super(block, singleSlab, doubleSlab);
    }
}
