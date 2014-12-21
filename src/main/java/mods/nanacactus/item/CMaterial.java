package mods.nanacactus.item;

import java.util.List;

import mods.nanacactus.Models;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

@Models({"cactus_stick", "cactus_gel", "cactus_straw", "cactus_skin", "ceramic_ingot", "receramic_ingot", "cactus_coal", "cactusium_ingot", "cactusium_nugget"})
public class CMaterial extends Item
{
    public static final String[] itemTypes = CMaterial.class.getAnnotation(Models.class).value();

    private IIcon[] itemIcons;

    public CMaterial()
    {
        super();
        this.setHasSubtypes(true);
    }

    @Override public int getMetadata(int meta)
    {
        return meta;
    }

    // getIconFromDamage
    public IIcon func_77617_a(int meta)
    {
        return this.itemIcons[meta];
    }

    @Override public String getUnlocalizedName(ItemStack stack)
    {
        for (int meta = 0; meta < itemTypes.length; ++meta)
        {
            if (meta == stack.getItemDamage())
            {
                return "item." + itemTypes[meta];
            }
        }

        return "item.unnamed";
    }

    @SuppressWarnings("unchecked")
    @Override public void getSubItems(Item item, CreativeTabs creativetabs, @SuppressWarnings("rawtypes") List list)
    {
        for (int i = 0; i < itemTypes.length; ++i)
        {
            ItemStack stack = new ItemStack(item, 1, i);
            list.add(stack);
        }
    }

    // registerIcons
    public void func_94581_a(IIconRegister iconregister)
    {
        this.itemIcons = new IIcon[itemTypes.length];

        for (int i = 0; i < itemTypes.length; ++i)
        {
            String s = "nanacactus:" + itemTypes[i];
            this.itemIcons[i] = iconregister.func_94245_a(s);
        }
    }
}
