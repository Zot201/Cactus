package mods.nana.cactus.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CFood extends ItemFood {

	private final String[] itemTypes = {"CSteak", "Jelly", "RCSteak"};

	private final int[] healAmount = {8, 6, 4};

	private Icon[] itemIcons;

	public CFood(int id) {
		super(id, 0, false);
		this.setHasSubtypes(true);
	}

	public int getMetadata(int meta)
    {
        return meta;
    }

	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
    {
        --stack.stackSize;
        player.getFoodStats().addStats(healAmount[stack.getItemDamage()], 0);
        world.playSoundAtEntity(player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
        return stack;
    }

	public Icon getIconFromDamage(int meta) {
		return this.itemIcons[meta];
	}

	public String getUnlocalizedName(ItemStack stack) {
		for (int meta = 0; meta < itemTypes.length; ++meta) {
			if(meta == stack.getItemDamage()) {
				return "item.CFood." + itemTypes[meta];
			}
		}
		return "item.CFood.null";
    }

	public void getSubItems(int itemid, CreativeTabs creativetabs, List list) {
		for (int i = 0; i < itemTypes.length; ++i) {
			ItemStack stack = new ItemStack(itemid, 1, i);
			list.add(stack);
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconregister) {
		itemIcons = new Icon[itemTypes.length];

		for (int i = 0; i < itemTypes.length; ++i) {
			String s = "nana:" + itemTypes[i];
			this.itemIcons[i] = iconregister.registerIcon(s);
		}
    }
}
