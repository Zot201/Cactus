package mods.nanacactus;

import java.util.List;
import java.util.Map;

import mods.nanacactus.Utils.Dynamic;
import mods.nanacactus.block.CBlock;
import mods.nanacactus.block.CSlab;
import mods.nanacactus.core.CreativeTabCactus;
import mods.nanacactus.handler.FuelHandler;
import mods.nanacactus.handler.SlabTransformer;
import mods.nanacactus.item.CAxe;
import mods.nanacactus.item.CFood;
import mods.nanacactus.item.CMaterial;
import mods.nanacactus.item.CPickaxe;
import mods.nanacactus.item.ItemCBlock;
import mods.nanacactus.item.ItemCSlab;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
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
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraft.launchwrapper.LaunchClassLoader;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.google.common.base.Supplier;
import com.google.common.collect.Maps;

public class Cactus
{
    public static final String MODID = "nanacactus";
    public static final CreativeTabs tabsCactus = new CreativeTabCactus(MODID);
    public static final Block cactus = Block.getBlockFromName("minecraft:cactus");

    public static CBlock cactus_block;
    public static Block cactus_slab;
    public static Block double_cactus_slab;
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

    public static Map<String, ItemStack> cactusItems = Maps.newHashMap();

    final Map<Item, String> itemModels = Maps.newIdentityHashMap();
    Boolean cpw;

    public String fml(String name) {
        return (cpw ? "cpw.mods.fml." : "net.minecraftforge.fml.") + name;
    }

    void preInitImpl()
    {
        if (cpw)
        {
            Dynamic.from(getClass().getClassLoader())
                .<List<IClassTransformer>>refer(LaunchClassLoader.class, "transformers")
                .get()
                .add(new SlabTransformer());
        }

        ToolMaterial ToolMaterialCactus = EnumHelper.addToolMaterial("CACTUS", 0, 59, 2.0F, 6.0F, 15);
        ToolMaterial ToolMaterialCeramic = EnumHelper.addToolMaterial("CERAMIC", 1, 131, 4.0F, 1, 15);
        ToolMaterial ToolMaterialReceramic = EnumHelper.addToolMaterial("RECERAMIC", 2, 201, 6.0F, 2, 10);
        ToolMaterial ToolMaterialCactunium = EnumHelper.addToolMaterial("CACTUNIUM", 3, 1561, 12.0F, 8.0F, 25);
        cactus_block = (CBlock) new CBlock().setUnlocalizedName("cactus_block").setHardness(0.5F).setResistance(10F).setCreativeTab(tabsCactus);
        cactus_slab = new CSlab(false).setHardness(0.5F).setResistance(10F).setUnlocalizedName("cactus_slab").setCreativeTab(tabsCactus);
        double_cactus_slab = new CSlab(true).setHardness(0.5F).setResistance(10F).setUnlocalizedName("cactus_slab");

        Supplier<BlockStairs>
        s1 = new Supplier<BlockStairs>() { public BlockStairs get() {
            return new BlockStairs(cactus_block.getDefaultState()) {{
                useNeighborBrightness = true;
            }};
        }},
        s2 = Dynamic.construct(BlockStairs.class).via(Block.class, cactus_block).viaInt(0).assign(Block.class, "field_149783_u", true);
        cactus_stairs = (cpw ? s2 : s1).get().setUnlocalizedName("cactus_stairs").setCreativeTab(tabsCactus);

        Supplier<BlockFence>
        f1 = Dynamic.construct(BlockFence.class).via(Material.class, Material.iron),
        f2 = Dynamic.construct(BlockFence.class).via("nanacactus:cactus_block").via(Material.class, Material.iron);
        cactus_fence = (cpw ? f2 : f1).get().setUnlocalizedName("cactus_fence").setHardness(0.5F).setResistance(10F).setCreativeTab(tabsCactus);

        cactus_material = new CMaterial().setCreativeTab(tabsCactus);
        cactus_food = new CFood().setCreativeTab(tabsCactus);
        cactus_sword = setTextureName("nanacactus:cactus_sword", new ItemSword(ToolMaterialCactus).setUnlocalizedName("cactus_sword")).setCreativeTab(tabsCactus);
        cactus_shovel = setTextureName("nanacactus:cactus_shovel", new ItemSpade(ToolMaterialCactus).setUnlocalizedName("cactus_shovel")).setCreativeTab(tabsCactus);
        cactus_pickaxe = setTextureName("nanacactus:cactus_pickaxe", new CPickaxe(ToolMaterialCactus).setUnlocalizedName("cactus_pickaxe")).setCreativeTab(tabsCactus);
        cactus_axe = setTextureName("nanacactus:cactus_axe", new CAxe(ToolMaterialCactus).setUnlocalizedName("cactus_axe")).setCreativeTab(tabsCactus);
        cactus_hoe = setTextureName("nanacactus:cactus_hoe", new ItemHoe(ToolMaterialCactus).setUnlocalizedName("cactus_hoe")).setCreativeTab(tabsCactus);
        ceramic_sword = setTextureName("nanacactus:ceramic_sword", new ItemSword(ToolMaterialCeramic).setUnlocalizedName("ceramic_sword")).setCreativeTab(tabsCactus);
        ceramic_shovel = setTextureName("nanacactus:ceramic_shovel", new ItemSpade(ToolMaterialCeramic).setUnlocalizedName("ceramic_shovel")).setCreativeTab(tabsCactus);
        ceramic_pickaxe = setTextureName("nanacactus:ceramic_pickaxe", new CPickaxe(ToolMaterialCeramic).setUnlocalizedName("ceramic_pickaxe")).setCreativeTab(tabsCactus);
        ceramic_axe = setTextureName("nanacactus:ceramic_axe", new CAxe(ToolMaterialCeramic).setUnlocalizedName("ceramic_axe")).setCreativeTab(tabsCactus);
        ceramic_hoe = setTextureName("nanacactus:ceramic_hoe", new ItemHoe(ToolMaterialCeramic).setUnlocalizedName("ceramic_hoe")).setCreativeTab(tabsCactus);
        receramic_sword = setTextureName("nanacactus:receramic_sword", new ItemSword(ToolMaterialReceramic).setUnlocalizedName("receramic_sword")).setCreativeTab(tabsCactus);
        receramic_shovel = setTextureName("nanacactus:receramic_shovel", new ItemSpade(ToolMaterialReceramic).setUnlocalizedName("receramic_shovel")).setCreativeTab(tabsCactus);
        receramic_pickaxe = setTextureName("nanacactus:receramic_pickaxe", new CPickaxe(ToolMaterialReceramic).setUnlocalizedName("receramic_pickaxe")).setCreativeTab(tabsCactus);
        receramic_axe = setTextureName("nanacactus:receramic_axe", new CAxe(ToolMaterialReceramic).setUnlocalizedName("receramic_axe")).setCreativeTab(tabsCactus);
        receramic_hoe = setTextureName("nanacactus:receramic_hoe", new ItemHoe(ToolMaterialReceramic).setUnlocalizedName("receramic_hoe")).setCreativeTab(tabsCactus);
        cactusium_sword = setTextureName("nanacactus:cactusium_sword", new ItemSword(ToolMaterialCactunium).setUnlocalizedName("cactusium_sword")).setCreativeTab(tabsCactus);
        cactusium_shovel = setTextureName("nanacactus:cactusium_shovel", new ItemSpade(ToolMaterialCactunium).setUnlocalizedName("cactusium_shovel")).setCreativeTab(tabsCactus);
        cactusium_pickaxe = setTextureName("nanacactus:cactusium_pickaxe", new CPickaxe(ToolMaterialCactunium).setUnlocalizedName("cactusium_pickaxe")).setCreativeTab(tabsCactus);
        cactusium_axe = setTextureName("nanacactus:cactusium_axe", new CAxe(ToolMaterialCactunium).setUnlocalizedName("cactusium_axe")).setCreativeTab(tabsCactus);
        cactusium_hoe = setTextureName("nanacactus:cactusium_hoe", new ItemHoe(ToolMaterialCactunium).setUnlocalizedName("cactusium_hoe")).setCreativeTab(tabsCactus);

        registerBlock(cactus_block, ItemCBlock.class, "cactus_block");
        registerBlock(cactus_slab, ItemCSlab.class, "cactus_slab", cactus_slab, double_cactus_slab);
        registerBlock(double_cactus_slab, ItemBlock.class, "double_cactus_slab");
        registerBlock(cactus_stairs, ItemBlock.class, "cactus_stairs");
        registerBlock(cactus_fence, ItemBlock.class, "cactus_fence");

        itemModels.put(Item.getItemFromBlock(cactus_slab), "nanacactus:cactus_slab");
        itemModels.put(Item.getItemFromBlock(double_cactus_slab), "nanacactus:double_cactus_slab");
        itemModels.put(Item.getItemFromBlock(cactus_stairs), "nanacactus:cactus_stairs");
        itemModels.put(Item.getItemFromBlock(cactus_fence), "nanacactus:cactus_fence");

        registerItem(cactus_material, "cactus_material");
        registerItem(cactus_food, "cactus_food");
        registerItem(cactus_sword, "cactus_sword");
        registerItem(cactus_shovel, "cactus_shovel");
        registerItem(cactus_pickaxe, "cactus_pickaxe");
        registerItem(cactus_axe, "cactus_axe");
        registerItem(cactus_hoe, "cactus_hoe");
        registerItem(ceramic_sword, "ceramic_sword");
        registerItem(ceramic_shovel, "ceramic_shovel");
        registerItem(ceramic_pickaxe, "ceramic_pickaxe");
        registerItem(ceramic_axe, "ceramic_axe");
        registerItem(ceramic_hoe, "ceramic_hoe");
        registerItem(receramic_sword, "receramic_sword");
        registerItem(receramic_shovel, "receramic_shovel");
        registerItem(receramic_pickaxe, "receramic_pickaxe");
        registerItem(receramic_axe, "receramic_axe");
        registerItem(receramic_hoe, "receramic_hoe");
        registerItem(cactusium_sword, "cactusium_sword");
        registerItem(cactusium_shovel, "cactusium_shovel");
        registerItem(cactusium_pickaxe, "cactusium_pickaxe");
        registerItem(cactusium_axe, "cactusium_axe");
        registerItem(cactusium_hoe, "cactusium_hoe");

        registerCactusItems();
    }

    void initImpl()
    {
        if (!cpw)
        {
            try
            {
                ItemModelMesher imm = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();

                for (Map.Entry<Item, String> entry : this.itemModels.entrySet())
                {
                    imm.register(entry.getKey(), 0, new ModelResourceLocation(entry.getValue(), "inventory"));
                    ModelBakery.addVariantName(entry.getKey(), entry.getValue());
                }

                for (Object obj : new Object[] {cactus_block, cactus_food, cactus_material})
                {
                    Item i = obj instanceof Item ? (Item) obj : Item.getItemFromBlock((Block) obj);
                    String[] models = obj.getClass().getAnnotation(Models.class).value();

                    for (int j = 0; j < models.length; j++)
                    {
                        String s = "nanacactus:" + models[j];
                        imm.register(i, j, new ModelResourceLocation(s, "inventory"));
                        ModelBakery.addVariantName(i, s);
                    }
                }
            }
            catch (NoClassDefFoundError ignored)
            {
                ;
            }
        }

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

        ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(Item.getItemFromBlock(cactus), 0, 10, 20, 10));
        ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(getCactusItem("ceramic_ingot"), 1, 5, 10));
        ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(getCactusItem("cactus_coal"), 3, 6, 14));
        ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(getCactusItem("cactusium_ingot"), 1, 3, 3));

        addRecipe(getCactusItem("cactus_block"), "XX", "XX", 'X', cactus);
        addRecipe(getCactusItem("ceramic_block"), "XXX", "XXX", "XXX", 'X', getCactusItem("ceramic_ingot"));
        addRecipe(getCactusItem("receramic_block"), "XXX", "XXX", "XXX", 'X', getCactusItem("receramic_ingot"));
        addRecipe(getCactusItem("cactusium_block"), "XXX", "XXX", "XXX", 'X', getCactusItem("cactusium_ingot"));
        addShapelessRecipe(new ItemStack(cactus, 4), getCactusItem("cactus_block"));
        addShapelessRecipe(getCactusItem("ceramic_ingot", 9), getCactusItem("ceramic_block"));
        addShapelessRecipe(getCactusItem("receramic_ingot", 9), getCactusItem("receramic_block"));
        addShapelessRecipe(getCactusItem("cactusium_ingot", 9), getCactusItem("cactusium_block"));
        addSmelting(getCactusItem("ceramic_ingot"), getCactusItem("receramic_ingot"), 1.0F);
        addRecipe(new ItemStack(cactus_slab, 6), "XXX", 'X', getCactusItem("cactus_block"));
        addRecipe(getCactusItem("cactus_block"), "X", "X", 'X', cactus_slab);
        addRecipe(new ItemStack(cactus_stairs, 4), "X  ", "XX ", "XXX", 'X', getCactusItem("cactus_block"));
        addRecipe(new ItemStack(cactus_fence, 2), "XXX", "XXX", 'X', getCactusItem("cactus_stick"));
        addRecipe(getCactusItem("cactus_stick", 4), "X", "X", 'X', cactus);
        addRecipe(getCactusItem("cactus_gel"), "X", "Y", 'X', getCactusItem("cactus_straw"), 'Y', cactus);
        addRecipe(getCactusItem("cactus_straw", 2), "X", "X", 'X', getCactusItem("cactus_stick"));
        addRecipe(getCactusItem("cactus_skin", 4), "X", 'X', cactus);
        addSmelting(getCactusItem("ceramic_ingot"), getCactusItem("receramic_ingot"), 1.0F);
        addSmelting(getCactusItem("cactus_block"), getCactusItem("cactusium_nugget"), 1.0F);
        addRecipe(getCactusItem("jelly"), "X", "Y", 'X', Items.sugar, 'Y', getCactusItem("cactus_gel"));
        addRecipe(getCactusItem("cactus_flesh", 3), "XXX", 'X', cactus);
        addRecipe(getCactusItem("cactusium_ingot"), "XXX", "XXX", "XXX", 'X', getCactusItem("cactusium_nugget"));
        addToolRecipe(new ItemStack(cactus), getCactusItem("cactus_stick"), cactus_sword, cactus_shovel, cactus_pickaxe, cactus_axe, cactus_hoe);
        addToolRecipe(getCactusItem("ceramic_ingot"), new ItemStack(Items.stick), ceramic_sword, ceramic_shovel, ceramic_pickaxe, ceramic_axe, ceramic_hoe);
        addToolRecipe(getCactusItem("receramic_ingot"), new ItemStack(Items.stick), receramic_sword, receramic_shovel, receramic_pickaxe, receramic_axe, receramic_hoe);
        addRecipe(new ItemStack(cactusium_sword), "X", "X", "Y", 'X', getCactusItem("cactusium_ingot"), 'Y', cactus_sword);
        addRecipe(new ItemStack(cactusium_shovel), "X", "Y", "Z", 'X', getCactusItem("cactusium_ingot"), 'Y', cactus_shovel, 'Z', getCactusItem("cactus_stick"));
        addRecipe(new ItemStack(cactusium_pickaxe), "XXX", " Y ", " Z ", 'X', getCactusItem("cactusium_ingot"), 'Y', cactus_pickaxe, 'Z', getCactusItem("cactus_stick"));
        addRecipe(new ItemStack(cactusium_axe), "XX", "XY", " Z", 'X', getCactusItem("cactusium_ingot"), 'Y', cactus_axe, 'Z', getCactusItem("cactus_stick"));
        addRecipe(new ItemStack(cactusium_hoe), "XX", " Y", " Z", 'X', getCactusItem("cactusium_ingot"), 'Y', cactus_hoe, 'Z', getCactusItem("cactus_stick"));
        addRecipe(new ItemStack(Blocks.dirt), "XYX", 'X', getCactusItem("cactus_gel"), 'Y', Blocks.sand);
        addRecipe(new ItemStack(Blocks.grass), "XXX", "XYX", "XXX", 'X', getCactusItem("cactus_gel"), 'Y', Blocks.dirt);
        addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.crafting_table), "XX", "YY", 'X', "skinCactus", 'Y', cactus));
        addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.chest), "XXX", "Y Y", "YYY", 'X', "skinCactus", 'Y', cactus));
        addRecipe(new ItemStack(Blocks.torch, 4), "X", "Y", 'X', getCactusItem("cactus_coal"), 'Y', getCactusItem("cactus_stick"));
        addRecipe(new ItemStack(Blocks.bookshelf), "XXX", "YYY", "XXX", 'X', cactus_slab, 'Y', Items.book);
        addRecipe(new ShapelessOreRecipe(new ItemStack(Items.book), Items.paper, Items.paper, Items.paper, "skinCactus"));
        addSmelting(getCactusItem("cactus_stick"), new ItemStack(Items.stick), 0.1F);
        addRecipe(new ItemStack(Blocks.piston), "XXX", "YZY", "YAY", 'X', cactus_slab, 'Y', Blocks.cobblestone, 'Z', Items.iron_ingot, 'A', Items.redstone);
        addRecipe(new ItemStack(Items.bucket), "X X", " X ", 'X', getCactusItem("receramic_ingot"));

        String iFuelHandler = fml("common.IFuelHandler");
        Dynamic.<Void>invoke(fml("common.registry.GameRegistry"), "registerFuelHandler").via(iFuelHandler, FuelHandler.createProxy(iFuelHandler)).get();
    }

    void postInitImpl()
    {
        for (int i = 0; i < getOres("skinCactus").size(); i++)
        {
            addSmelting(getOres("skinCactus").get(i), getCactusItem("cactus_coal"), 0.15F);
        }

        for (int i = 0; i < getOres("fleshCactus").size(); i++)
        {
            addSmelting(getOres("fleshCactus").get(i), getCactusItem("cactus_steak"), 0.35F);
        }
    }

    private static void registerCactusItems()
    {
        for (int i = 0; i < CBlock.blockTypes.length; i++)
        {
            cactusItems.put(CBlock.blockTypes[i], new ItemStack(cactus_block, 1, i));
        }
        for (int i = 0; i < CMaterial.itemTypes.length; i++)
        {
            cactusItems.put(CMaterial.itemTypes[i], new ItemStack(cactus_material, 1, i));
        }
        for (int i = 0; i < CFood.itemTypes.length; i++)
        {
            cactusItems.put(CFood.itemTypes[i], new ItemStack(cactus_food, 1, i));
        }
    }

    public static ItemStack getCactusItem(String name, int amount)
    {
        ItemStack s = cactusItems.get(name).copy();
        s.stackSize = amount;
        return s;
    }

    public static ItemStack getCactusItem(String name)
    {
        return getCactusItem(name, 1);
    }

    private void addToolRecipe(ItemStack material, ItemStack stick, Item sword, Item shovel, Item pickaxe, Item axe, Item hoe)
    {
        addRecipe(new ItemStack(sword), "X", "X", "Y", 'X', material, 'Y', stick);
        addRecipe(new ItemStack(shovel), "X", "Y", "Y", 'X', material, 'Y', stick);
        addRecipe(new ItemStack(pickaxe), "XXX", " Y ", " Y ", 'X', material, 'Y', stick);
        addRecipe(new ItemStack(axe), "XX", "XY", " Y", 'X', material, 'Y', stick);
        addRecipe(new ItemStack(hoe), "XX", " Y", " Y", 'X', material, 'Y', stick);
    }

    private Item setTextureName(String name, Item i)
    {
        if (!cpw)
        {
            itemModels.put(i, name);
            return i;
        }
        return Dynamic.from(i).<Item>invoke(Item.class, "func_111206_d").via(name).get();
    }

    private void registerBlock(Block b, Class<? extends ItemBlock> itemClass, String name, Object... args)
    {
        Dynamic.<Void>invoke(fml("common.registry.GameRegistry"), "registerBlock").via(Block.class, b).via(itemClass).via(name).via(args).get();
    }

    private void registerItem(Item i, String name)
    {
        Dynamic.<Void>invoke(fml("common.registry.GameRegistry"), "registerItem").via(Item.class, i).via(name).get();
    }

    private void addRecipe(ItemStack item, Object... ingredients)
    {
        Dynamic.<Void>invoke(fml("common.registry.GameRegistry"), "addRecipe").via(item).via(ingredients).get();
    }

    private void addShapelessRecipe(ItemStack item, Object... ingredients)
    {
        Dynamic.<Void>invoke(fml("common.registry.GameRegistry"), "addShapelessRecipe").via(item).via(ingredients).get();
    }

    private void addRecipe(IRecipe recipe)
    {
        Dynamic.<Void>invoke(fml("common.registry.GameRegistry"), "addRecipe").via(IRecipe.class, recipe).get();
    }

    private void addSmelting(ItemStack input, ItemStack output, float exp)
    {
        Dynamic.<Void>invoke(fml("common.registry.GameRegistry"), "addSmelting").via(input).via(output).viaFloat(exp).get();
    }

    private List<ItemStack> getOres(String name)
    {
        return Dynamic.<List<ItemStack>>invoke(OreDictionary.class, "getOres").via(name).get();
    }
}
