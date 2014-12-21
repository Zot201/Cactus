package mods.nanacactus.item;

import mods.nanacactus.block.CBlock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemCBlock extends ItemBlock
{
    public ItemCBlock(Block block)
    {
        super(block);
        this.setHasSubtypes(true);
    }

    @Override public int getMetadata(int meta)
    {
        return meta;
    }

    @Override public String getUnlocalizedName(ItemStack stack)
    {
        for (int meta = 0; meta < CBlock.blockTypes.length; ++meta)
        {
            if (meta == stack.getItemDamage())
            {
                return "tile." + CBlock.blockTypes[meta];
            }
        }

        return "tile.unnamed";
    }
}
