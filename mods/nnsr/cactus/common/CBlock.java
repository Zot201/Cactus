package mods.nnsr.cactus.common;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class CBlock extends Block {
	
	public static final String[] CBLOCK_TYPES = new String[] {"cactus", "ceramic", "receramic", "cactunium"};
	public static final String[] field_94407_b = new String[] {null, "ce", "rce", "cn"};
	@SideOnly(Side.CLIENT)
    private Icon[] field_94408_c;
	private String TexPath;

	public CBlock(int par1, String texpath) {
		super(par1, Material.ground);
		this.TexPath = texpath;
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2)
    {
        if (par2 < 0 || par2 >= field_94407_b.length)
        {
            par2 = 0;
        }

        return this.field_94408_c[par2];
    }
	
	public int damageDropped(int par1)
    {
        return par1;
    }
	
	@SideOnly(Side.CLIENT)
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int j = 0; j < 4; ++j)
        {
            par3List.add(new ItemStack(par1, 1, j));
        }
    }
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
    {
        this.field_94408_c = new Icon[field_94407_b.length];

        for (int i = 0; i < this.field_94408_c.length; ++i)
        {
            String s = this.TexPath;

            if (field_94407_b[i] != null)
            {
                s = s + "_" + field_94407_b[i];
            }

            this.field_94408_c[i] = par1IconRegister.registerIcon(s);
        }
    }}
