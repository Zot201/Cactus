package mods.nana.cactus.handler;

import mods.nana.cactus.Cactus;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler
{
    @Override
    public int getBurnTime(ItemStack fuel)
    {
        if (fuel.getItem() == Cactus.getCactusItem("blockCactus").getItem() && fuel.getItemDamage() == Cactus.getCactusItem("blockCactus").getItemDamage())
        {
            return 2000;
        }

        if (fuel.getItem() == Cactus.getCactusItem("CSlab").getItem())
        {
            return 1000;
        }

        if (fuel.getItem() == Cactus.getCactusItem("CStick").getItem() && fuel.getItemDamage() == Cactus.getCactusItem("CStick").getItemDamage())
        {
            return 100;
        }

        if (fuel.getItem() == Cactus.getCactusItem("CSkin").getItem() && fuel.getItemDamage() == Cactus.getCactusItem("CSkin").getItemDamage())
        {
            return 50;
        }

        if (fuel.getItem() == Cactus.getCactusItem("CCoal").getItem() && fuel.getItemDamage() == Cactus.getCactusItem("CCoal").getItemDamage())
        {
            return 1600;
        }

        if (fuel.getItem() == Item.getItemFromBlock(Blocks.cactus))
        {
            return 200;
        }

        return 0;
    }
}
