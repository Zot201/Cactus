package mods.nanacactus.item;

import java.util.List;

import mods.nanacactus.Models;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

@Models({"cactus_steak", "jelly", "cactus_flesh"})
public class CFood extends ItemFood
{
    public static final String[] itemTypes = CFood.class.getAnnotation(Models.class).value();

    private final int[] healAmount = {8, 6, 4};

    private IIcon[] itemIcons;

    public CFood()
    {
        super(0, false);
        this.setHasSubtypes(true);
    }

    @Override public int getMetadata(int meta)
    {
        return meta;
    }

    @Override public ItemStack onItemUseFinish(ItemStack stack, World world, EntityPlayer player)
    {
        --stack.stackSize;
        player.getFoodStats().addStats(healAmount[stack.getItemDamage()], 0);
        world.playSoundAtEntity(player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
        return stack;
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
