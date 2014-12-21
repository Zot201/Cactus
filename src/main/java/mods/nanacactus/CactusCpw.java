package mods.nanacactus;

import mods.nanacactus.Utils.Dynamic;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLMissingMappingsEvent;
import cpw.mods.fml.common.event.FMLMissingMappingsEvent.MissingMapping;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(
    modid = Cactus.MODID,
    name = "Cactus++"
)
public class CactusCpw extends Cactus
{
    @Mod.EventHandler public void preInit(FMLPreInitializationEvent evt)
    {
        cpw = true;
        preInitImpl();
    }

    @Mod.EventHandler public void init(FMLInitializationEvent evt)
    {
        initImpl();
    }

    @Mod.EventHandler public void postInit(FMLPostInitializationEvent evt)
    {
        postInitImpl();
    }

    @Mod.EventHandler public void onMappingMiss(FMLMissingMappingsEvent evt)
    {
        for (MissingMapping missing : evt.getAll())
            if (missing.name.startsWith("nana_Cactus:"))
            {
                String s = "nanacactus:" + missing.name.substring("nana_Cactus:".length());
                boolean isItem = Dynamic.from(missing).<Enum<?>>refer(MissingMapping.class, "type").get().name().equals("ITEM");
                Object remapTarget = (isItem ? Item.itemRegistry : Block.blockRegistry).getObject(s);

                if (remapTarget != null)
                {
                    Class<?> clz = isItem ? Item.class : Block.class;
                    Dynamic.from(missing).<Void>invoke(MissingMapping.class, "remap").via(clz.getName(), remapTarget).get();
                }
            }
    }
}
