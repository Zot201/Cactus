package mods.nanacactus.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import mods.nanacactus.Cactus;
import mods.nanacactus.Utils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.google.common.reflect.Reflection;

public class FuelHandler implements InvocationHandler
{
    private FuelHandler() { }

    public static Object createProxy(String iFuelHandler)
    {
        try
        {
            return Reflection.newProxy(Class.forName(iFuelHandler), new FuelHandler());
        }
        catch (Throwable t)
        {
            throw Utils.propagate(t);
        }
    }

    @Override public Object invoke(Object proxy, Method method, Object[] args)
    {
        return getBurnTime((ItemStack) args[0]);
    }

    public int getBurnTime(ItemStack fuel)
    {
        if (fuel.getItem() == Item.getItemFromBlock(Cactus.cactus_block) && fuel.getItemDamage() == Cactus.getCactusItem("cactus_block").getItemDamage())
        {
            return 1000;
        }

        if (fuel.getItem() == Item.getItemFromBlock(Cactus.cactus_slab))
        {
            return 500;
        }

        if (fuel.getItem() == Item.getItemFromBlock(Cactus.double_cactus_slab))
        {
            return 1000;
        }

        if (fuel.getItem() == Item.getItemFromBlock(Cactus.cactus_stairs))
        {
            return 1000;
        }

        if (fuel.getItem() == Item.getItemFromBlock(Cactus.cactus_fence))
        {
            return 1000;
        }

        if (fuel.getItem() == Cactus.cactus_material && fuel.getItemDamage() == Cactus.getCactusItem("cactus_stick").getItemDamage())
        {
            return 100;
        }

        if (fuel.getItem() == Cactus.cactus_material && fuel.getItemDamage() == Cactus.getCactusItem("cactus_skin").getItemDamage())
        {
            return 50;
        }

        if (fuel.getItem() == Cactus.cactus_material && fuel.getItemDamage() == Cactus.getCactusItem("cactus_coal").getItemDamage())
        {
            return 1600;
        }

        if (fuel.getItem() == Item.getItemFromBlock(Cactus.cactus))
        {
            return 200;
        }

        return 0;
    }
}
