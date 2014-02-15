package mods.nana.cactus.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CMaterial extends Item
{
    private final String[] ItemTypes = {"cactus_stick", "cactus_gel", "cactus_straw", "cactus_skin", "ceramic_ingot", "receramic_ingot", "cactus_coal", "cactusium_ingot"};

    private IIcon[] ItemIcons;

    public CMaterial()
    {
        super();
        this.setHasSubtypes(true);
    }

    public int getMetadata(int meta)
    {
        return meta;
    }

    public IIcon getIconFromDamage(int meta)
    {
        return this.ItemIcons[meta];
    }

    public String getUnlocalizedName(ItemStack stack)
    {
        for (int meta = 0; meta < ItemTypes.length; ++meta)
        {
            if (meta == stack.getItemDamage())
            {
                return "item." + ItemTypes[meta];
            }
        }

        return "item.unnamed";
    }

    public void getSubItems(Item item, CreativeTabs creativetabs, List list)
    {
        for (int i = 0; i < ItemTypes.length; ++i)
        {
            ItemStack stack = new ItemStack(item, 1, i);
            list.add(stack);
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconregister)
    {
        ItemIcons = new IIcon[ItemTypes.length];

        for (int i = 0; i < ItemTypes.length; ++i)
        {
            String s = "nana.cactus:" + ItemTypes[i];
            this.ItemIcons[i] = iconregister.registerIcon(s);
        }
    }
}
