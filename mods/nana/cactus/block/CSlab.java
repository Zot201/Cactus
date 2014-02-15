package mods.nana.cactus.block;

import java.util.Random;

import mods.nana.cactus.Cactus;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CSlab extends BlockSlab
{
    public CSlab(boolean par2)
    {
        super(par2, Material.iron);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
        return Cactus.cactus_block.getIcon(par1, par2 & 7);
    }

    public Item getItemDropped(int meta, Random rand, int fortune)
    {
        return Item.getItemFromBlock(Cactus.cactus_slab);
    }

    protected ItemStack createStackedBlock(int par1)
    {
        return new ItemStack(Cactus.cactus_slab, 2, par1 & 7);
    }

    @Override
	public String func_150002_b(int var1) {
		return super.getUnlocalizedName();
	}

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister) {}
}
