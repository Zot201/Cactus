package mods.nana.cactus;

import mods.nana.cactus.block.CBlock;
import mods.nana.cactus.block.CSlab;
import mods.nana.cactus.block.CStairs;
import mods.nana.cactus.core.CreativeTabCactus;
import mods.nana.cactus.handler.FuelHandler;
import mods.nana.cactus.item.CAxe;
import mods.nana.cactus.item.CFood;
import mods.nana.cactus.item.CMaterial;
import mods.nana.cactus.item.CPickaxe;
import mods.nana.cactus.item.ItemCBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(
    modid = "nana_Cactus",
    name = "Cactus++"
)

public class Cactus
{
    public static final CreativeTabs tabsCactus = new CreativeTabCactus("Cactus");

    public static Block cactus_block;
    public static BlockSlab cactus_slab;
    public static Block cactus_stairs;
    public static Block cactus_fence;

    public static Item cactus_material;
    public static Item cactus_food;

    public static Item cactus_sword;
    public static Item cactus_shovel;
    public static Item cactus_pickaxe;
    public static Item cactus_axe;
    public static Item cactus_hoe;

    public static Item ceramic_sword;
    public static Item ceramic_shovel;
    public static Item ceramic_pickaxe;
    public static Item ceramic_axe;
    public static Item ceramic_hoe;

    public static Item receramic_sword;
    public static Item receramic_shovel;
    public static Item receramic_pickaxe;
    public static Item receramic_axe;
    public static Item receramic_hoe;

    public static Item cactusium_sword;
    public static Item cactusium_shovel;
    public static Item cactusium_pickaxe;
    public static Item cactusium_axe;
    public static Item cactusium_hoe;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent evt)
    {
        Configuration cfg = new Configuration(evt.getSuggestedConfigurationFile());

        cfg.save();

        ToolMaterial ToolMaterialCactus = EnumHelper.addToolMaterial("CACTUS", 0, 59, 2.0F, 6.0F, 15);
        ToolMaterial ToolMaterialCeramic = EnumHelper.addToolMaterial("CERAMIC", 1, 131, 4.0F, 1, 15);
        ToolMaterial ToolMaterialReceramic = EnumHelper.addToolMaterial("RECERAMIC", 2, 201, 6.0F, 2, 10);
        ToolMaterial ToolMaterialCactunium = EnumHelper.addToolMaterial("CACTUNIUM", 3, 1561, 12.0F, 8.0F, 25);
        cactus_block = new CBlock().setBlockName("cactus_block").setHardness(0.5F).setResistance(10F).setCreativeTab(tabsCactus);
        cactus_slab = (BlockSlab) new CSlab(false).setHardness(0.5F).setResistance(10F).setBlockName("cactus_slab").setCreativeTab(tabsCactus);
        cactus_stairs = new CStairs(cactus_block, 0).setBlockName("cactus_stairs").setCreativeTab(tabsCactus);
        cactus_fence = new BlockFence("nana.cactus:cactus_block", Material.iron).setBlockName("cactus_fence").setHardness(0.5F).setResistance(10F).setCreativeTab(tabsCactus);
        cactus_material = new CMaterial().setCreativeTab(tabsCactus);
        cactus_food = new CFood().setCreativeTab(tabsCactus);
        cactus_sword = new ItemSword(ToolMaterialCactus).setUnlocalizedName("cactus_sword").setTextureName("nana.cactus:cactus_sword").setCreativeTab(tabsCactus);
        cactus_shovel = new ItemSpade(ToolMaterialCactus).setUnlocalizedName("cactus_shovel").setTextureName("nana.cactus:cactus_shovel").setCreativeTab(tabsCactus);
        cactus_pickaxe = new CPickaxe(ToolMaterialCactus).setUnlocalizedName("cactus_pickaxe").setTextureName("nana.cactus:cactus_pickaxe").setCreativeTab(tabsCactus);
        cactus_axe = new CAxe(ToolMaterialCactus).setUnlocalizedName("cactus_axe").setTextureName("nana.cactus:cactus_axe").setCreativeTab(tabsCactus);
        cactus_hoe = new ItemHoe(ToolMaterialCactus).setUnlocalizedName("cactus_hoe").setTextureName("nana.cactus:cactus_hoe").setCreativeTab(tabsCactus);
        ceramic_sword = new ItemSword(ToolMaterialCeramic).setUnlocalizedName("ceramic_sword").setTextureName("nana.cactus:ceramic_sword").setCreativeTab(tabsCactus);
        ceramic_shovel = new ItemSpade(ToolMaterialCeramic).setUnlocalizedName("ceramic_shovel").setTextureName("nana.cactus:ceramic_shovel").setCreativeTab(tabsCactus);
        ceramic_pickaxe = new CPickaxe(ToolMaterialCeramic).setUnlocalizedName("ceramic_pickaxe").setTextureName("nana.cactus:ceramic_pickaxe").setCreativeTab(tabsCactus);
        ceramic_axe = new CAxe(ToolMaterialCeramic).setUnlocalizedName("ceramic_axe").setTextureName("nana.cactus:ceramic_axe").setCreativeTab(tabsCactus);
        ceramic_hoe = new ItemHoe(ToolMaterialCeramic).setUnlocalizedName("ceramic_hoe").setTextureName("nana.cactus:ceramic_hoe").setCreativeTab(tabsCactus);
        receramic_sword = new ItemSword(ToolMaterialReceramic).setUnlocalizedName("receramic_sword").setTextureName("nana.cactus:receramic_sword").setCreativeTab(tabsCactus);
        receramic_shovel = new ItemSpade(ToolMaterialReceramic).setUnlocalizedName("receramic_shovel").setTextureName("nana.cactus:receramic_shovel").setCreativeTab(tabsCactus);
        receramic_pickaxe = new CPickaxe(ToolMaterialReceramic).setUnlocalizedName("receramic_pickaxe").setTextureName("nana.cactus:receramic_pickaxe").setCreativeTab(tabsCactus);
        receramic_axe = new CAxe(ToolMaterialReceramic).setUnlocalizedName("receramic_axe").setTextureName("nana.cactus:receramic_axe").setCreativeTab(tabsCactus);
        receramic_hoe = new ItemHoe(ToolMaterialReceramic).setUnlocalizedName("receramic_hoe").setTextureName("nana.cactus:receramic_hoe").setCreativeTab(tabsCactus);
        cactusium_sword = new ItemSword(ToolMaterialCactunium).setUnlocalizedName("cactusium_sword").setTextureName("nana.cactus:cactusium_sword").setCreativeTab(tabsCactus);
        cactusium_shovel = new ItemSpade(ToolMaterialCactunium).setUnlocalizedName("cactusium_shovel").setTextureName("nana.cactus:cactusium_shovel").setCreativeTab(tabsCactus);
        cactusium_pickaxe = new CPickaxe(ToolMaterialCactunium).setUnlocalizedName("cactusium_pickaxe").setTextureName("nana.cactus:cactusium_pickaxe").setCreativeTab(tabsCactus);
        cactusium_axe = new CAxe(ToolMaterialCactunium).setUnlocalizedName("cactusium_axe").setTextureName("nana.cactus:cactusium_axe").setCreativeTab(tabsCactus);
        cactusium_hoe = new ItemHoe(ToolMaterialCactunium).setUnlocalizedName("cactusium_hoe").setTextureName("nana.cactus:cactusium_hoe").setCreativeTab(tabsCactus);
        GameRegistry.registerBlock(cactus_block, ItemCBlock.class, "cactus_block");
        GameRegistry.registerBlock(cactus_slab, "cactus_slab");
        GameRegistry.registerBlock(cactus_stairs, "cactus_stairs");
        GameRegistry.registerBlock(cactus_fence, "cactus_fence");
        registerItem(new ItemStack(cactus_block, 1, 0), "cactus_block");
        registerItem(new ItemStack(cactus_block, 1, 1), "ceramic_block");
        registerItem(new ItemStack(cactus_block, 1, 2), "receramic_block");
        registerItem(new ItemStack(cactus_block, 1, 3), "cactusium_block");
        registerItem(new ItemStack(cactus_slab), "cactus_slab");
        registerItem(new ItemStack(cactus_stairs), "cactus_stairs");
        registerItem(new ItemStack(cactus_fence), "cactus_fance");
        registerItem(new ItemStack(cactus_material, 1, 0), "cactus_stick", "cactus_material");
        registerItem(new ItemStack(cactus_material, 1, 1), "cactus_gel");
        registerItem(new ItemStack(cactus_material, 1, 2), "cactus_straw");
        registerItem(new ItemStack(cactus_material, 1, 3), "cactus_skin");
        registerItem(new ItemStack(cactus_material, 1, 4), "ceramic_ingot");
        registerItem(new ItemStack(cactus_material, 1, 5), "receramic_ingot");
        registerItem(new ItemStack(cactus_material, 1, 6), "cactus_coal");
        registerItem(new ItemStack(cactus_material, 1, 7), "cactusium_ingot");
        registerItem(new ItemStack(cactus_food, 1, 0), "cactus_steak", "cactus_food");
        registerItem(new ItemStack(cactus_food, 1, 1), "jelly");
        registerItem(new ItemStack(cactus_food, 1, 2), "cactus_flesh");
        registerItem(new ItemStack(cactus_sword), "cactus_sword");
        registerItem(new ItemStack(cactus_shovel), "cactus_shovel");
        registerItem(new ItemStack(cactus_pickaxe), "cactus_pickaxe");
        registerItem(new ItemStack(cactus_axe), "cactus_axe");
        registerItem(new ItemStack(cactus_hoe), "cactus_hoe");
        registerItem(new ItemStack(ceramic_sword), "ceramic_sword");
        registerItem(new ItemStack(ceramic_shovel), "ceramic_shovel");
        registerItem(new ItemStack(ceramic_pickaxe), "ceramic_pickaxe");
        registerItem(new ItemStack(ceramic_axe), "ceramic_axe");
        registerItem(new ItemStack(ceramic_hoe), "ceramic_hoe");
        registerItem(new ItemStack(receramic_sword), "receramic_sword");
        registerItem(new ItemStack(receramic_shovel), "receramic_shovel");
        registerItem(new ItemStack(receramic_pickaxe), "receramic_pickaxe");
        registerItem(new ItemStack(receramic_axe), "receramic_axe");
        registerItem(new ItemStack(receramic_hoe), "receramic_hoe");
        registerItem(new ItemStack(cactusium_sword), "cactusium_sword");
        registerItem(new ItemStack(cactusium_shovel), "cactusium_shovel");
        registerItem(new ItemStack(cactusium_pickaxe), "cactusium_pickaxe");
        registerItem(new ItemStack(cactusium_axe), "cactusium_axe");
        registerItem(new ItemStack(cactusium_hoe), "cactusium_hoe");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent evt)
    {
        OreDictionary.registerOre("blockCactus", getCactusItem("cactus_block"));
        OreDictionary.registerOre("blockCeramic", getCactusItem("ceramic_block"));
        OreDictionary.registerOre("blockReceramic", getCactusItem("receramic_block"));
        OreDictionary.registerOre("blockCactusium", getCactusItem("cactusium_block"));
        OreDictionary.registerOre("stickCactus", getCactusItem("cactus_stick"));
        OreDictionary.registerOre("cactusRod", getCactusItem("cactus_stick"));
        OreDictionary.registerOre("skinCactus", getCactusItem("cactus_skin"));
        OreDictionary.registerOre("ingotCeramic", getCactusItem("ceramic_ingot"));
        OreDictionary.registerOre("ingotReceramic", getCactusItem("receramic_ingot"));
        OreDictionary.registerOre("coalCactus", getCactusItem("cactus_coal"));
        OreDictionary.registerOre("ingotCactusium", getCactusItem("cactusium_ingot"));
        OreDictionary.registerOre("ingotCactus", getCactusItem("cactusium_ingot"));
        OreDictionary.registerOre("fleshCactus", getCactusItem("cactus_flesh"));
        ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.cactus), 0, 10, 20, 10));
        ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(getCactusItem("receramic_ingot"), 1, 5, 10));
        ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(getCactusItem("cactus_coal"), 3, 6, 14));
        ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(getCactusItem("cactusium_ingot"), 1, 3, 3));
        addOreStorageRecipe(new ItemStack(Blocks.cactus), getCactusItem("cactus_block"));
        addOreStorageRecipe(getCactusItem("ceramic_ingot"), getCactusItem("ceramic_ingot"));
        addOreStorageRecipe(getCactusItem("receramic_ingot"), getCactusItem("receramic_ingot"));
        addOreStorageRecipe(getCactusItem("cactusium_ingot"), getCactusItem("cactusium_ingot"));
        FurnaceRecipes.smelting().func_151394_a(getCactusItem("ceramic_ingot"), getCactusItem("receramic_ingot"), 1.0F);
        GameRegistry.addRecipe(getCactusItem("cactus_slab", 6), new Object[] {"XXX", 'X', getCactusItem("cactus_block")});
        GameRegistry.addRecipe(getCactusItem("cactus_block"), new Object[] {"X", "X", 'X', getCactusItem("cactus_slab")});
        GameRegistry.addRecipe(getCactusItem("cactus_stairs", 4), new Object[] {"X  ", "XX ", "XXX", 'X', getCactusItem("cactus_block")});
        GameRegistry.addRecipe(getCactusItem("cactus_frnce", 2), new Object[] {"XXX", "XXX", 'X', getCactusItem("cactus_stick")});
        GameRegistry.addRecipe(getCactusItem("cactus_stick", 4), new Object[] {"X", "X", 'X', Blocks.cactus});
        GameRegistry.addRecipe(getCactusItem("cactus_gel"), new Object[] {"X", "Y", 'X', getCactusItem("cactus_straw"), 'Y', Blocks.cactus});
        GameRegistry.addRecipe(getCactusItem("cactus_straw", 2), new Object[] {"X", "X", 'X', getCactusItem("cactus_stick")});
        GameRegistry.addRecipe(getCactusItem("cactus_skin", 4), new Object[] {"X", 'X', Blocks.cactus});
        GameRegistry.addSmelting(Blocks.sandstone, getCactusItem("ceramic_ingot"), 0.7F);
        FurnaceRecipes.smelting().func_151394_a(getCactusItem("ceramic_ingot"), getCactusItem("receramic_ingot"), 1.0F);
        FurnaceRecipes.smelting().func_151394_a(getCactusItem("cactus_block"), getCactusItem("cactusium_ingot"), 1.0F);
        GameRegistry.addRecipe(getCactusItem("jelly"), new Object[] {"X", "Y", 'X', Items.sugar, 'Y', getCactusItem("cactus_gel")});
        GameRegistry.addRecipe(getCactusItem("cactus_flesh", 3), new Object[] {"XXX", 'X', Blocks.cactus});
        addToolRecipe(new ItemStack(Blocks.cactus), getCactusItem("cactus_stick"), getCactusItem("cactus_sword"), getCactusItem("cactus_shovel"), getCactusItem("cactus_pickaxe"), getCactusItem("cactus_axe"), getCactusItem("cactus_hoe"));
        addToolRecipe(getCactusItem("ceramic_ingot"), new ItemStack(Items.stick), getCactusItem("ceramic_sword"), getCactusItem("ceramic_shovel"), getCactusItem("ceramic_pickaxe"), getCactusItem("ceramic_axe"), getCactusItem("ceramic_hoe"));
        addToolRecipe(getCactusItem("receramic_ingot"), new ItemStack(Items.stick), getCactusItem("receramic_sword"), getCactusItem("receramic_shovel"), getCactusItem("receramic_pickaxe"), getCactusItem("receramic_axe"), getCactusItem("receramic_hoe"));
        GameRegistry.addRecipe(getCactusItem("cactusium_sword"), new Object[] {"X", "X", "Y", 'X', getCactusItem("cactusium_ingot"), 'Y', getCactusItem("cactus_sword")});
        GameRegistry.addRecipe(getCactusItem("cactusium_shovel"), new Object[] {"X", "Y", "Z", 'X', getCactusItem("cactusium_ingot"), 'Y', getCactusItem("cactus_shovel"), 'Z', getCactusItem("cactus_stick")});
        GameRegistry.addRecipe(getCactusItem("cactusium_pickaxe"), new Object[] {"XXX", " Y ", " Z ", 'X', getCactusItem("cactusium_ingot"), 'Y', getCactusItem("cactus_pickaxe"), 'Z', getCactusItem("cactus_stick")});
        GameRegistry.addRecipe(getCactusItem("cactusium_axe"), new Object[] {"XX", "XY", " Z", 'X', getCactusItem("cactusium_ingot"), 'Y', getCactusItem("cactus_axe"), 'Z', getCactusItem("cactus_stick")});
        GameRegistry.addRecipe(getCactusItem("cactusium_hoe"), new Object[] {"XX", " Y", " Z", 'X', getCactusItem("cactusium_ingot"), 'Y', getCactusItem("cactus_hoe"), 'Z', getCactusItem("cactus_stick")});
        GameRegistry.addRecipe(new ItemStack(Blocks.dirt), new Object[] {"XYX", 'X', getCactusItem("cactus_gel"), 'Y', Blocks.sand});
        GameRegistry.addRecipe(new ItemStack(Blocks.grass), new Object[] {"XXX", "XYX", "XXX", 'X', getCactusItem("cactus_gel"), 'Y', Blocks.dirt});
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.crafting_table), new Object[] {"XX", "YY", 'X', "skinCactus", 'Y', Blocks.cactus}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.chest), new Object[] {"XXX", "Y Y", "YYY", 'X', "skinCactus", 'Y', Blocks.cactus}));
        GameRegistry.addRecipe(new ItemStack(Blocks.torch, 4), new Object[] {"X", "Y", 'X', getCactusItem("cactus_coal"), 'Y', getCactusItem("cactus_stick")});
        GameRegistry.addRecipe(new ItemStack(Blocks.bookshelf), new Object[] {"XXX", "YYY", "XXX", 'X', getCactusItem("cactus_slab"), 'Y', Items.book});
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.book), new Object[] {Items.paper, Items.paper, Items.paper, "skinCactus"}));
        FurnaceRecipes.smelting().func_151394_a(getCactusItem("cactus_stick"), new ItemStack(Items.stick), 0.1F);
        GameRegistry.addRecipe(new ItemStack(Blocks.piston), new Object[] {"XXX", "YZY", "YAY", 'X', getCactusItem("cactus_slab"), 'Y', Blocks.cobblestone, 'Z', getCactusItem("receramic_ingot"), 'A', Items.redstone});
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.cactus, 2), Blocks.cactus, new ItemStack(Items.dye, 1, 15));
        GameRegistry.addRecipe(new ItemStack(Items.bucket), new Object[] {"X X", " X ", 'X', getCactusItem("receramic_ingot")});
        GameRegistry.registerFuelHandler(new FuelHandler());
    }

    @Mod.EventHandler
    public static void PostInit(FMLPostInitializationEvent evt)
    {
        for (int i = 0; i < OreDictionary.getOres("skinCactus").size(); i++)
        {
            FurnaceRecipes.smelting().func_151394_a(OreDictionary.getOres("skinCactus").get(i), getCactusItem("CCoal"), 0.15F);
        }

        for (int i = 0; i < OreDictionary.getOres("fleshCactus").size(); i++)
        {
            FurnaceRecipes.smelting().func_151394_a(OreDictionary.getOres("fleshCactus").get(i), getCactusItem("CSteak"), 0.35F);
        }
    }

    public static void registerItem(ItemStack itemStack, String item, String name)
    {
        GameRegistry.registerCustomItemStack(item, itemStack);
        if (itemStack.getItemDamage() == 0) {
        	if (!(itemStack.getItem() instanceof ItemBlock)) {
        		GameRegistry.registerItem(itemStack.getItem(), name);
        	}
        }
    }

    public static void registerItem(ItemStack itemStack, String item) {
    	registerItem(itemStack, item, item);
    }

    public static ItemStack getModItem(String modid, String item, int stacksize)
    {
        if ((item == null) || (item.equals("")))
        {
            return null;
        }

        ItemStack stack = null;

        try
        {
            stack = GameRegistry.findItemStack(modid, item, stacksize);
        }
        catch (Throwable e)
        {
        }

        if (stack == null)
        {
            return null;
        }

        if (stack.getItem() == null)
        {
            return null;
        }

        return stack;
    }

    public static ItemStack getCactusItem(String item, int stacksize)
    {
        return getModItem("nana_Cactus", item, stacksize);
    }

    public static ItemStack getCactusItem(String item)
    {
        return getCactusItem(item, 1);
    }

    public static void addOreStorageRecipe(ItemStack item, ItemStack block)
    {
        GameRegistry.addRecipe(
            block,
            new Object[]
            {
                "XXX", "XXX", "XXX",
                'X', item
            }
        );
        item.stackSize = 9;
        GameRegistry.addRecipe(
            item,
            new Object[]
            {
                "X",
                'X', block
            }
        );
    }

    public static void addToolRecipe(ItemStack material, ItemStack stick, ItemStack sword, ItemStack shovel, ItemStack pickaxe, ItemStack axe, ItemStack hoe)
    {
        GameRegistry.addRecipe(sword, new Object[] {"X", "X", "Y", 'X', material, 'Y', stick});
        GameRegistry.addRecipe(shovel, new Object[] {"X", "Y", "Y", 'X', material, 'Y', stick});
        GameRegistry.addRecipe(pickaxe, new Object[] {"XXX", " Y ", " Y ", 'X', material, 'Y', stick});
        GameRegistry.addRecipe(axe, new Object[] {"XX", "XY", " Y", 'X', material, 'Y', stick});
        GameRegistry.addRecipe(hoe, new Object[] {"XX", " Y", " Y", 'X', material, 'Y', stick});
    }
}
