package mods.nanacactus.block;

import java.util.Random;

import mods.nanacactus.Cactus;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class CSlab extends CSlabProxy
{
    public CSlab(boolean isDouble)
    {
        super(isDouble, Material.iron);
        useNeighborBrightness = true;
    }

    // getIcon
    public IIcon func_149691_a(int par1, int par2)
    {
        return Cactus.cactus_block.func_149691_a(par1, par2 & 7);
    }

    // getItemDropped
    public Item func_149650_a(int meta, Random rand, int fortune)
    {
        return Item.getItemFromBlock(Cactus.cactus_slab);
    }

    // createStackedBlock
    protected ItemStack func_149644_j(int par1)
    {
        return new ItemStack(Cactus.cactus_slab, 2, par1 & 7);
    }

    @Override public String getUnlocalizedName(int var1)
    {
		return getUnlocalizedName();
	}

    // registerBlockIcons
    public void func_149651_a(IIconRegister par1IconRegister) { }
}
