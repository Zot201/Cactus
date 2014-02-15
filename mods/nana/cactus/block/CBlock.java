package mods.nana.cactus.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CBlock extends Block
{
    public static final String[] BlockTypes = {"cactus_block", "ceramic_block", "receramic_block", "cactusium_block"};
    private IIcon[] BlockIcons;

    public CBlock()
    {
        super(Material.iron);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        if (BlockIcons[meta] != null)
        {
            return BlockIcons[meta];
        }

        return super.getIcon(side, meta);
    }

    public int damageDropped(int meta)
    {
        return meta;
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativetabs, List list)
    {
        for (int meta = 0; meta < BlockTypes.length; ++meta)
        {
            list.add(new ItemStack(item, 1, meta));
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconregister)
    {
        this.BlockIcons = new IIcon[BlockTypes.length];

        for (int meta = 0; meta < this.BlockIcons.length; ++meta)
        {
            String s = "nana.cactus:";

            if (BlockTypes[meta] != null)
            {
                s = s + BlockTypes[meta];
            }

            BlockIcons[meta] = iconregister.registerIcon(s);
        }
    }
}
