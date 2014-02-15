package mods.nana.cactus.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CFood extends ItemFood
{
    private final String[] itemTypes = {"cactus_steak", "jelly", "cactus_flesh"};

    private final int[] healAmount = {8, 6, 4};

    private IIcon[] itemIcons;

    public CFood()
    {
        super(0, false);
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

    public IIcon getIconFromDamage(int meta)
    {
        return this.itemIcons[meta];
    }

    public String getUnlocalizedName(ItemStack stack)
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

    public void getSubItems(Item item, CreativeTabs creativetabs, List list)
    {
        for (int i = 0; i < itemTypes.length; ++i)
        {
            ItemStack stack = new ItemStack(item, 1, i);
            list.add(stack);
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconregister)
    {
        itemIcons = new IIcon[itemTypes.length];

        for (int i = 0; i < itemTypes.length; ++i)
        {
            String s = "nana.cactus:" + itemTypes[i];
            this.itemIcons[i] = iconregister.registerIcon(s);
        }
    }
}
