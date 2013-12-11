package mods.nana.cactus.block;

import java.util.Random;

import mods.nana.cactus.Cactus;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CSlab extends BlockHalfSlab{

	public CSlab(int par1, boolean par2) {
		super(par1, par2, Material.iron);
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2)
    {
        return Cactus.cactusBlocks.getIcon(par1, par2 & 7);
    }
	
	public int idDropped(int meta, Random rand, int fortune)
    {
        return Cactus.cactusSlab.blockID;
    }
	
	protected ItemStack createStackedBlock(int par1)
    {
        return new ItemStack(Cactus.cactusSlab.blockID, 2, par1 & 7);
    }

	@Override
	public String getFullSlabName(int i) {
		return super.getUnlocalizedName();
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {}

}
