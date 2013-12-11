package mods.nana.cactus.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CBlock extends Block {

	public static final String[] BlockTypes = {"Cactus", "Ceramic", "Receramic", "Cactusium"};
	private Icon[] BlockIcons;

	public CBlock(int id) {
		super(id, Material.iron);
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		if (BlockIcons[meta] != null) {
			return BlockIcons[meta];
		}
		return super.getIcon(side, meta);
	}

	public int damageDropped(int meta)
    {
        return meta;
    }

	@SideOnly(Side.CLIENT)
    public void getSubBlocks(int id, CreativeTabs creativetabs, List list)
    {
        for (int meta = 0; meta < BlockTypes.length; ++meta)
        {
            list.add(new ItemStack(id, 1, meta));
        }
    }

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconregister)
    {
        this.BlockIcons = new Icon[BlockTypes.length];

        for (int meta = 0; meta < this.BlockIcons.length; ++meta)
        {
            String s = "nana:CBlock";

            if (BlockTypes[meta] != null)
            {
                s = s + "_" + BlockTypes[meta];
            }

            BlockIcons[meta] = iconregister.registerIcon(s);
        }
    }
}
