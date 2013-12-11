package mods.nana.cactus.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CMaterial extends Item {

	private final String[] ItemTypes = {"CStick", "CGel", "CStraw", "CSkin", "Ceramic", "Receramic", "CCoal", "Cactusium"};

	private Icon[] ItemIcons;

	public CMaterial(int id) {
		super(id);
		this.setHasSubtypes(true);
	}

	public int getMetadata(int meta)
    {
        return meta;
    }

	public Icon getIconFromDamage(int meta) {
		return this.ItemIcons[meta];
	}

	public String getUnlocalizedName(ItemStack stack) {
		for (int meta = 0; meta < ItemTypes.length; ++meta) {
			if(meta == stack.getItemDamage()) {
				return "item.CMaterial." + ItemTypes[meta];
			}
		}
		return "item.CMaterial.null";
    }

	public void getSubItems(int itemid, CreativeTabs creativetabs, List list) {
		for (int i = 0; i < ItemTypes.length; ++i) {
			ItemStack stack = new ItemStack(itemid, 1, i);
			list.add(stack);
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconregister) {
		ItemIcons = new Icon[ItemTypes.length];

		for (int i = 0; i < ItemTypes.length; ++i) {
			String s = "nana:" + ItemTypes[i];
			this.ItemIcons[i] = iconregister.registerIcon(s);
		}
    }
}
