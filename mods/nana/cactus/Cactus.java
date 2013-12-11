package mods.nana.cactus;

import mods.nana.cactus.block.CBlock;
import mods.nana.cactus.block.CSlab;
import mods.nana.cactus.block.CStairs;
import mods.nana.cactus.core.CreativeTabCactus;
import mods.nana.cactus.handler.FuelHandler;
import mods.nana.cactus.item.CFood;
import mods.nana.cactus.item.CMaterial;
import mods.nana.cactus.item.ItemCBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(
		modid = "nana_Cactus",
		name = "Cactus++"
)

@NetworkMod(
		clientSideRequired = true,
		serverSideRequired = false
)



public class Cactus {

	public static final CreativeTabs tabsCactus = new CreativeTabCactus("Cactus");

	public static Block cactusBlocks;
	public static int cactusBlocksID;

	public static BlockHalfSlab cactusSlab;
	public static int cactusSlabID;

	public static Block cactusStairs;
	public static int cactusStairsID;

	public static Block cactusFence;
	public static int cactusFenceID;

	public static Item cactusMaterials;
	public static int cactusMaterialsID;

	public static Item cactusFoods;
	public static int cactusFoodsID;

	public static Item cactusSword;
	public static Item cactusShovel;
	public static Item cactusPickaxe;
	public static Item cactusAxe;
	public static Item cactusHoe;
	public static int cactusSwordID;
	public static int cactusShovelID;
	public static int cactusPickaxeID;
	public static int cactusAxeID;
	public static int cactusHoeID;

	public static Item ceraSword;
	public static Item ceraShovel;
	public static Item ceraPickaxe;
	public static Item ceraAxe;
	public static Item ceraHoe;
	public static int ceraSwordID;
	public static int ceraShovelID;
	public static int ceraPickaxeID;
	public static int ceraAxeID;
	public static int ceraHoeID;

	public static Item receraSword;
	public static Item receraShovel;
	public static Item receraPickaxe;
	public static Item receraAxe;
	public static Item receraHoe;
	public static int receraSwordID;
	public static int receraShovelID;
	public static int receraPickaxeID;
	public static int receraAxeID;
	public static int receraHoeID;

	public static Item csSword;
	public static Item csShovel;
	public static Item csPickaxe;
	public static Item csAxe;
	public static Item csHoe;
	public static int csSwordID;
	public static int csShovelID;
	public static int csPickaxeID;
	public static int csAxeID;
	public static int csHoeID;

	public static int itemShiftIndex;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent evt) {
		Configuration cfg = new Configuration(evt.getSuggestedConfigurationFile());

		cactusBlocksID = cfg.getBlock(cfg.CATEGORY_BLOCK, "cactusBlockID", 3000).getInt(3000);
		cactusSlabID = cfg.getBlock(cfg.CATEGORY_BLOCK, "cactusSlabID", 3001).getInt(3001);
		cactusStairsID = cfg.getBlock(cfg.CATEGORY_BLOCK, "cactusStairsID", 3002).getInt(3002);
		cactusFenceID = cfg.getBlock(cfg.CATEGORY_BLOCK, "cactusFenceID", 3003).getInt(3003);
		cactusMaterialsID = cfg.getItem(cfg.CATEGORY_ITEM, "cactusMaterialID", 30000).getInt(30000);
		cactusFoodsID = cfg.getItem(cfg.CATEGORY_ITEM, "cactusFoodID", 30001).getInt(30001);

		cactusSwordID = cfg.getItem(cfg.CATEGORY_ITEM, "cactusSwordID", 30002).getInt(30002);
		cactusShovelID = cfg.getItem(cfg.CATEGORY_ITEM, "cactusShovelID", 30003).getInt(30003);
		cactusPickaxeID = cfg.getItem(cfg.CATEGORY_ITEM, "cactusPickaxeID", 30004).getInt(30004);
		cactusAxeID = cfg.getItem(cfg.CATEGORY_ITEM, "cactusAxeID", 30005).getInt(30005);
		cactusHoeID = cfg.getItem(cfg.CATEGORY_ITEM, "cactusHoeID", 30006).getInt(30006);

		ceraSwordID = cfg.getItem(cfg.CATEGORY_ITEM, "ceramicSwordID", 30007).getInt(30007);
		ceraShovelID = cfg.getItem(cfg.CATEGORY_ITEM, "ceramicShovelID", 30008).getInt(30008);
		ceraPickaxeID = cfg.getItem(cfg.CATEGORY_ITEM, "ceramicPickaxeID", 30009).getInt(30009);
		ceraAxeID = cfg.getItem(cfg.CATEGORY_ITEM, "ceramicAxeID", 30010).getInt(30010);
		ceraHoeID = cfg.getItem(cfg.CATEGORY_ITEM, "ceramicHoeID", 30011).getInt(30011);

		receraSwordID = cfg.getItem(cfg.CATEGORY_ITEM, "receramicSwordID", 30012).getInt(30012);
		receraShovelID = cfg.getItem(cfg.CATEGORY_ITEM, "receramicShovelID", 30013).getInt(30013);
		receraPickaxeID = cfg.getItem(cfg.CATEGORY_ITEM, "receramicPickaxeID", 30014).getInt(30014);
		receraAxeID = cfg.getItem(cfg.CATEGORY_ITEM, "receramicAxeID", 30015).getInt(30015);
		receraHoeID = cfg.getItem(cfg.CATEGORY_ITEM, "receramicHoeID", 30016).getInt(30016);

		csSwordID = cfg.getItem(cfg.CATEGORY_ITEM, "cactusiumSwordID", 30017).getInt(30017);
		csShovelID = cfg.getItem(cfg.CATEGORY_ITEM, "cactsniumShovelID", 30018).getInt(30018);
		csPickaxeID = cfg.getItem(cfg.CATEGORY_ITEM, "cactusiumPickaxeID", 30019).getInt(30019);
		csAxeID = cfg.getItem(cfg.CATEGORY_ITEM, "cactusiumAxeID", 30020).getInt(30020);
		csHoeID = cfg.getItem(cfg.CATEGORY_ITEM, "cactusiumHoeID", 30021).getInt(30021);

		itemShiftIndex = cfg.get(cfg.CATEGORY_GENERAL, "itemShiftIndex", 0).getInt(0);

		cfg.save();
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent evt) {

		EnumToolMaterial ToolMaterialCactus = EnumHelper.addToolMaterial("CACTUS", 0, 59, 2.0F, 6.0F, 15);
		EnumToolMaterial ToolMaterialCeramic = EnumHelper.addToolMaterial("CERAMIC", 1, 131, 4.0F, 1, 15);
		EnumToolMaterial ToolMaterialReceramic = EnumHelper.addToolMaterial("RECERAMIC", 2, 201, 6.0F, 2, 10);
		EnumToolMaterial ToolMaterialCactunium = EnumHelper.addToolMaterial("CACTUNIUM", 3, 1561, 12.0F, 8.0F, 25);

		int i = - 256 + itemShiftIndex;
		cactusBlocks = new CBlock(cactusBlocksID).setUnlocalizedName("CBlock").setHardness(0.5F).setResistance(10F).setCreativeTab(tabsCactus);
		cactusSlab = (BlockHalfSlab) new CSlab(cactusSlabID, false).setHardness(0.5F).setResistance(10F).setUnlocalizedName("CSlab").setCreativeTab(tabsCactus);
		cactusStairs = new CStairs(cactusStairsID, cactusBlocks, 0).setUnlocalizedName("CStairs").setCreativeTab(tabsCactus);
		cactusFence = new BlockFence(cactusFenceID, "nana:CBlock_Cactus", Material.iron).setUnlocalizedName("CFence").setHardness(0.5F).setResistance(10F).setCreativeTab(tabsCactus);

		cactusMaterials = new CMaterial(cactusMaterialsID + i).setCreativeTab(tabsCactus);
		cactusFoods = new CFood(cactusFoodsID + i).setCreativeTab(tabsCactus);
		cactusSword = new ItemSword(cactusSwordID + i, ToolMaterialCactus).setUnlocalizedName("CSword").setTextureName("nana:CSword").setCreativeTab(tabsCactus);
		cactusShovel = new ItemSpade(cactusShovelID + i, ToolMaterialCactus).setUnlocalizedName("CShovel").setTextureName("nana:CSpade").setCreativeTab(tabsCactus);
		cactusPickaxe = new ItemPickaxe(cactusPickaxeID + i, ToolMaterialCactus).setUnlocalizedName("CPickaxe").setTextureName("nana:CPickaxe").setCreativeTab(tabsCactus);
		cactusAxe = new ItemAxe(cactusAxeID + i, ToolMaterialCactus).setUnlocalizedName("CAxe").setTextureName("nana:CAxe").setCreativeTab(tabsCactus);
		cactusHoe = new ItemHoe(cactusHoeID + i, ToolMaterialCactus).setUnlocalizedName("CHoe").setTextureName("nana:CHoe").setCreativeTab(tabsCactus);
		ceraSword = new ItemSword(ceraSwordID + i, ToolMaterialCeramic).setUnlocalizedName("CeraSword").setTextureName("nana:CeraSword").setCreativeTab(tabsCactus);
		ceraShovel = new ItemSpade(ceraShovelID + i, ToolMaterialCeramic).setUnlocalizedName("CeraShovel").setTextureName("nana:CeraSpade").setCreativeTab(tabsCactus);
		ceraPickaxe = new ItemPickaxe(ceraPickaxeID + i, ToolMaterialCeramic).setUnlocalizedName("CeraPickaxe").setTextureName("nana:CeraPickaxe").setCreativeTab(tabsCactus);
		ceraAxe = new ItemAxe(ceraAxeID + i, ToolMaterialCeramic).setUnlocalizedName("CeraAxe").setTextureName("nana:CeraAxe").setCreativeTab(tabsCactus);
		ceraHoe = new ItemHoe(ceraHoeID + i, ToolMaterialCeramic).setUnlocalizedName("CeraHoe").setTextureName("nana:CeraHoe").setCreativeTab(tabsCactus);
		receraSword = new ItemSword(receraSwordID + i, ToolMaterialReceramic).setUnlocalizedName("ReceraSword").setTextureName("nana:ReceraSword").setCreativeTab(tabsCactus);
		receraShovel = new ItemSpade(receraShovelID + i, ToolMaterialReceramic).setUnlocalizedName("ReceraShovel").setTextureName("nana:ReceraSpade").setCreativeTab(tabsCactus);
		receraPickaxe = new ItemPickaxe(receraPickaxeID + i, ToolMaterialReceramic).setUnlocalizedName("ReceraPickaxe").setTextureName("nana:ReceraPickaxe").setCreativeTab(tabsCactus);
		receraAxe = new ItemAxe(receraAxeID + i, ToolMaterialReceramic).setUnlocalizedName("ReceraAxe").setTextureName("nana:ReceraAxe").setCreativeTab(tabsCactus);
		receraHoe = new ItemHoe(receraHoeID + i, ToolMaterialReceramic).setUnlocalizedName("ReceraHoe").setTextureName("nana:ReceraHoe").setCreativeTab(tabsCactus);
		csSword = new ItemSword(csSwordID + i, ToolMaterialCactunium).setUnlocalizedName("CSSword").setTextureName("nana:CSSword").setCreativeTab(tabsCactus);
		csShovel = new ItemSpade(csShovelID + i, ToolMaterialCactunium).setUnlocalizedName("CSShovel").setTextureName("nana:CSSpade").setCreativeTab(tabsCactus);
		csPickaxe = new ItemPickaxe(csPickaxeID + i, ToolMaterialCactunium).setUnlocalizedName("CSPickaxe").setTextureName("nana:CSPickaxe").setCreativeTab(tabsCactus);
		csAxe = new ItemAxe(csAxeID + i, ToolMaterialCactunium).setUnlocalizedName("CSAxe").setTextureName("nana:CSAxe").setCreativeTab(tabsCactus);
		csHoe = new ItemHoe(csHoeID + i, ToolMaterialCactunium).setUnlocalizedName("CSHoe").setTextureName("nana:CSHoe").setCreativeTab(tabsCactus);

		GameRegistry.registerBlock(cactusBlocks, ItemCBlock.class, "CBlock");
		GameRegistry.registerBlock(cactusSlab, "CSlab");
		GameRegistry.registerBlock(cactusStairs, "CStairs");
		GameRegistry.registerBlock(cactusFence, "CFence");

		registerItem(new ItemStack(cactusBlocks, 1, 0), "blockCactus");
		registerItem(new ItemStack(cactusBlocks, 1, 1), "blockCeramic");
		registerItem(new ItemStack(cactusBlocks, 1, 2), "blockReceramic");
		registerItem(new ItemStack(cactusBlocks, 1, 3), "blockCactusium");
		registerItem(new ItemStack(cactusSlab), "CSlab");
		registerItem(new ItemStack(cactusStairs), "CStairs");
		registerItem(new ItemStack(cactusFence), "CFence");
		registerItem(new ItemStack(cactusMaterials, 1, 0), "CStick");
		registerItem(new ItemStack(cactusMaterials, 1, 1), "CGel");
		registerItem(new ItemStack(cactusMaterials, 1, 2), "CStraw");
		registerItem(new ItemStack(cactusMaterials, 1, 3), "CSkin");
		registerItem(new ItemStack(cactusMaterials, 1, 4), "Ceramic");
		registerItem(new ItemStack(cactusMaterials, 1, 5), "Receramic");
		registerItem(new ItemStack(cactusMaterials, 1, 6), "CCoal");
		registerItem(new ItemStack(cactusMaterials, 1, 7), "Cactusium");
		registerItem(new ItemStack(cactusFoods, 1, 0), "CSteak");
		registerItem(new ItemStack(cactusFoods, 1, 1), "Jelly");
		registerItem(new ItemStack(cactusFoods, 1, 2), "RCSteak");
		registerItem(new ItemStack(cactusSword), "CSword");
		registerItem(new ItemStack(cactusShovel), "CShovel");
		registerItem(new ItemStack(cactusPickaxe), "CPickaxe");
		registerItem(new ItemStack(cactusAxe), "CAxe");
		registerItem(new ItemStack(cactusHoe), "CHoe");
		registerItem(new ItemStack(ceraSword), "CeraSword");
		registerItem(new ItemStack(ceraShovel), "CeraShovel");
		registerItem(new ItemStack(ceraPickaxe), "CeraPickaxe");
		registerItem(new ItemStack(ceraAxe), "CeraAxe");
		registerItem(new ItemStack(ceraHoe), "CeraHoe");
		registerItem(new ItemStack(receraSword), "ReceraSword");
		registerItem(new ItemStack(receraShovel), "ReceraShovel");
		registerItem(new ItemStack(receraPickaxe), "ReceraPickaxe");
		registerItem(new ItemStack(receraAxe), "ReceraAxe");
		registerItem(new ItemStack(receraHoe), "ReceraHoe");
		registerItem(new ItemStack(csSword), "CSSword");
		registerItem(new ItemStack(csShovel), "CSShovel");
		registerItem(new ItemStack(csPickaxe), "CSPickaxe");
		registerItem(new ItemStack(csAxe), "CSAxe");
		registerItem(new ItemStack(csHoe), "CSHoe");

		OreDictionary.registerOre("blockCactus", getCactusItem("blockCactus"));
		OreDictionary.registerOre("blockCeramic", getCactusItem("blockCeramic"));
		OreDictionary.registerOre("blockReceramic", getCactusItem("blockReceramic"));
		OreDictionary.registerOre("blockCactusium", getCactusItem("blockCactusium"));
		OreDictionary.registerOre("stickCactus", getCactusItem("CStick"));
		OreDictionary.registerOre("cactusRod", getCactusItem("CStick"));
		OreDictionary.registerOre("skinCactus", getCactusItem("CSkin"));
		OreDictionary.registerOre("ingotCeramic", getCactusItem("ingotCeramic"));
		OreDictionary.registerOre("ingotReceramic", getCactusItem("ingotReceramic"));
		OreDictionary.registerOre("coalCactus", getCactusItem("CCoal"));
		OreDictionary.registerOre("ingotCactusium", getCactusItem("ingotCactusium"));
		OreDictionary.registerOre("ingotCactusium", getCactusItem("ingotCactus"));
		OreDictionary.registerOre("fleshCactus", getCactusItem("RCSteak"));

		addLocalization("itemGroup.Cactus", "Cactus++", "Cactus++");
		addLocalization("tile.CBlock.Cactus.name", "Block of Cactus", "サボテンブロック");
		addLocalization("tile.CBlock.Ceramic.name", "Block of Ceramic", "セラミックブロック");
		addLocalization("tile.CBlock.Receramic.name", "Block of Receramic", "リセラミックブロック");
		addLocalization("tile.CBlock.Cactusium.name", "Block of Cactusium", "カクタシウムブロック");
		addLocalization("tile.CSlab.name", "Cactus Slab", "サボテンハーフブロック");
		addLocalization("tile.CStairs.name", "Cactus Ctairs", "サボテンの階段");
		addLocalization("tile.CFence.name", "Cactus Fence", "サボテンの柵");

		addLocalization("item.CMaterial.CStick.name", "Cactus Stick", "サボテンの棒");
		addLocalization("item.CMaterial.CGel.name", "Cactus Gel", "サボテンジェル");
		addLocalization("item.CMaterial.CStraw.name", "Cactus Straw", "サボテンのストロー");
		addLocalization("item.CMaterial.CSkin.name", "Cactus Skin", "サボテンの皮");
		addLocalization("item.CMaterial.Ceramic.name", "Ceramic Ingot", "セラミックインゴット");
		addLocalization("item.CMaterial.Receramic.name", "Receramic Ingot", "リセラミックインゴット");
		addLocalization("item.CMaterial.CCoal.name", "Cactus Coal", "サボ炭");
		addLocalization("item.CMaterial.Cactusium.name", "Cactusium Ingot", "カクタシウムインゴット");
		addLocalization("item.CFood.CSteak.name", "Cactus Steak", "サボテンステーキ");
		addLocalization("item.CFood.Jelly.name", "Jelly", "ゼリー");
		addLocalization("item.CFood.RCSteak.name", "Flesh of Cactus", "サボテンの果肉");
		addLocalization("item.CSword.name", "Cactus Sword", "サボテンの剣");
		addLocalization("item.CShovel.name", "Cactus Shovel", "サボテンのシャベル");
		addLocalization("item.CPickaxe.name", "Cactus Pickaxe", "サボテンのツルハシ");
		addLocalization("item.CAxe.name", "Cactus Axe", "サボテンの斧");
		addLocalization("item.CHoe.name", "Cactus Hoe", "サボテンのクワ");
		addLocalization("item.CeraSword.name", "Ceramic Sword", "セラミックの剣");
		addLocalization("item.CeraShovel.name", "Ceramic Shovel", "セラミックのシャベル");
		addLocalization("item.CeraPickaxe.name", "Ceramic Pickaxe", "セラミックのツルハシ");
		addLocalization("item.CeraAxe.name", "Ceramic Axe", "セラミックの斧");
		addLocalization("item.CeraHoe.name", "Ceramic Hoe", "セラミックのクワ");
		addLocalization("item.ReceraSword.name", "Receramic Sword", "リセラミックの剣");
		addLocalization("item.ReceraShovel.name", "Receramic Shovel", "リセラミックのシャベル");
		addLocalization("item.ReceraPickaxe.name", "Receramic Pickaxe", "リセラミックのツルハシ");
		addLocalization("item.ReceraAxe.name", "Receramic Axe", "リセラミックの斧");
		addLocalization("item.ReceraHoe.name", "Receramic Hoe", "リセラミックのクワ");
		addLocalization("item.CSSword.name", "Cactunium Sword", "カクタシウムの剣");
		addLocalization("item.CSShovel.name", "Cactunium Shovel", "カクタシウムのシャベル");
		addLocalization("item.CSPickaxe.name", "Cactunium Pickaxe", "カクタシウムのツルハシ");
		addLocalization("item.CSAxe.name", "Cactunium Axe", "カクタシウムの斧");
		addLocalization("item.CSHoe.name", "Cactunium Hoe", "カクタシウムのクワ");

		addOreStorageRecipe(new ItemStack(Block.cactus), getCactusItem("blockCactus"));
		addOreStorageRecipe(getCactusItem("Ceramic"), getCactusItem("blockCeramic"));
		addOreStorageRecipe(getCactusItem("Receramic"), getCactusItem("blockReceramic"));
		addOreStorageRecipe(getCactusItem("Cactusium"), getCactusItem("blockCactusium"));

		FurnaceRecipes.smelting().addSmelting(getCactusItem("blockCeramic").itemID, getCactusItem("blockCeramic").getItemDamage(), getCactusItem("blockReceramic"), 1.0F);

		GameRegistry.addRecipe(getCactusItem("CSlab", 6), new Object[] {"XXX", 'X', getCactusItem("blockCactus")});
		GameRegistry.addRecipe(getCactusItem("blockCactus"), new Object[] {"X", "X", 'X', getCactusItem("CSlab")});

		GameRegistry.addRecipe(getCactusItem("CStairs", 4), new Object[] {"X  ", "XX ", "XXX", 'X', getCactusItem("blockCactus")});

		GameRegistry.addRecipe(getCactusItem("CFence", 2), new Object[] {"XXX", "XXX", 'X', getCactusItem("CStick")});

		GameRegistry.addRecipe(getCactusItem("CStick", 4), new Object[] {"X", "X", 'X', Block.cactus});

		GameRegistry.addRecipe(getCactusItem("CGel"), new Object[] {"X", "Y", 'X', getCactusItem("CStraw"), 'Y', Block.cactus});

		GameRegistry.addRecipe(getCactusItem("CStraw", 2), new Object[] {"X", "X", 'X', getCactusItem("CStick")});

		GameRegistry.addRecipe(getCactusItem("CSkin", 4), new Object[] {"X", 'X', Block.cactus});

		GameRegistry.addSmelting(Block.sandStone.blockID, getCactusItem("Ceramic"), 0.7F);

		FurnaceRecipes.smelting().addSmelting(getCactusItem("Ceramic").itemID, getCactusItem("Ceramic").getItemDamage(), getCactusItem("Receramic"), 1.0F);

		FurnaceRecipes.smelting().addSmelting(getCactusItem("blockCactus").itemID, getCactusItem("blockCactus").getItemDamage(), getCactusItem("Cactusium"), 1.0F);

		GameRegistry.addRecipe(getCactusItem("Jelly"), new Object[] {"X", "Y", 'X', Item.sugar, 'Y', getCactusItem("CGel")});

		GameRegistry.addRecipe(getCactusItem("RCSteak", 3), new Object[] {"XXX", 'X', Block.cactus});

		addToolRecipe(new ItemStack(Block.cactus), getCactusItem("CStick"), getCactusItem("CSword"), getCactusItem("CShovel"), getCactusItem("CPickaxe"), getCactusItem("CAxe"), getCactusItem("CHoe"));
		addToolRecipe(getCactusItem("Ceramic"), new ItemStack(Item.stick), getCactusItem("CeraSword"), getCactusItem("CeraShovel"), getCactusItem("CeraPickaxe"), getCactusItem("CeraAxe"), getCactusItem("CeraHoe"));
		addToolRecipe(getCactusItem("Receramic"), new ItemStack(Item.stick), getCactusItem("ReceraSword"), getCactusItem("ReceraShovel"), getCactusItem("ReceraPickaxe"), getCactusItem("ReceraAxe"), getCactusItem("ReceraHoe"));

		GameRegistry.addRecipe(getCactusItem("CSSword"), new Object[] {"X", "X", "Y", 'X', getCactusItem("Cactusium"), 'Y', getCactusItem("CSword")});
		GameRegistry.addRecipe(getCactusItem("CSShovel"), new Object[] {"X", "Y", "Z", 'X', getCactusItem("Cactusium"), 'Y', getCactusItem("CShovel"), 'Z', getCactusItem("CStick")});
		GameRegistry.addRecipe(getCactusItem("CSPickaxe"), new Object[] {"XXX", " Y ", " Z ", 'X', getCactusItem("Cactusium"), 'Y', getCactusItem("CPickaxe"), 'Z', getCactusItem("CStick")});
		GameRegistry.addRecipe(getCactusItem("CSAxe"), new Object[] {"XX", "XY", " Z", 'X', getCactusItem("Cactusium"), 'Y', getCactusItem("CAxe"), 'Z', getCactusItem("CStick")});
		GameRegistry.addRecipe(getCactusItem("CSHoe"), new Object[] {"XX", " Y", " Z", 'X', getCactusItem("Cactusium"), 'Y', getCactusItem("CHoe"), 'Z', getCactusItem("CStick")});

		GameRegistry.addRecipe(new ItemStack(Block.dirt), new Object[] {"XYX", 'X', getCactusItem("CGel"), 'Y', Block.sand});
		GameRegistry.addRecipe(new ItemStack(Block.grass), new Object[] {"XXX", "XYX", "XXX", 'X', getCactusItem("CGel"), 'Y', Block.dirt});

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Block.workbench), new Object[] {"XX", "YY", 'X', "barkCactus", 'Y', Block.cactus}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Block.chest), new Object[] {"XXX", "Y Y", "YYY", 'X', "barkCactus", 'Y', Block.cactus}));

		GameRegistry.addRecipe(new ItemStack(Block.torchWood, 4), new Object[] {"X", "Y", 'X', getCactusItem("CCoal"), 'Y', getCactusItem("CStick")});

		GameRegistry.addRecipe(new ItemStack(Block.bookShelf), new Object[] {"XXX", "YYY", "XXX", 'X', getCactusItem("CSlab"), 'Y', Item.book});
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Item.book), new Object[] {Item.paper, Item.paper, Item.paper, "barkCactus"}));

		FurnaceRecipes.smelting().addSmelting(getCactusItem("CStick").itemID, getCactusItem("CStick").getItemDamage(), new ItemStack(Item.stick), 0.1F);

		GameRegistry.addRecipe(new ItemStack(Block.pistonBase), new Object[] {"XXX", "YZY", "YAY", 'X', getCactusItem("CSlab"), 'Y', Block.cobblestone, 'Z', getCactusItem("Receramic"), 'A', Item.redstone});

		GameRegistry.addShapelessRecipe(new ItemStack(Block.cactus, 2), Block.cactus, new ItemStack(Item.dyePowder, 1, 15));

		GameRegistry.addRecipe(new ItemStack(Item.bucketEmpty), new Object[] {"X X", " X ", 'X', getCactusItem("Receramic")});

		GameRegistry.registerFuelHandler(new FuelHandler());
	}

	@Mod.EventHandler
	public static void PostInit(FMLPostInitializationEvent evt) {
		for (int i = 0; i < OreDictionary.getOres("barkCactus").size(); i++) {
			FurnaceRecipes.smelting().addSmelting(OreDictionary.getOres("barkCactus").get(i).itemID, OreDictionary.getOres("barkCactus").get(i).getItemDamage(), getCactusItem("CCoal"), 0.15F);
		}
		for (int i = 0; i < OreDictionary.getOres("fleshCactus").size(); i++) {
			FurnaceRecipes.smelting().addSmelting(OreDictionary.getOres("fleshCactus").get(i).itemID, OreDictionary.getOres("fleshCactus").get(i).getItemDamage(), getCactusItem("CSteak"), 0.35F);
		}
	}

	public static void addLocalization(String key, String enname, String jpname){
		LanguageRegistry.instance().addStringLocalization(key, "en_US", enname);
		LanguageRegistry.instance().addStringLocalization(key, "ja_JP", jpname);
	}

	public static void registerItem(ItemStack itemStack, String item) {
		GameRegistry.registerCustomItemStack(item, itemStack);
	}

	public static ItemStack getModItem(String modid, String item, int stacksize) {
		if ((item == null) || (item.equals(""))) {
			return null;
		}
	    ItemStack stack = null;
	    try {
	    	stack = GameRegistry.findItemStack(modid, item, stacksize);
	    } catch(Throwable e) {
	    }
	    if (stack == null) {
	    	return null;
	    }
	    if (stack.getItem() == null) {
	    	return null;
	    }
		return stack;
	}

	public static ItemStack getCactusItem(String item, int stacksize) {
		return getModItem("nana_Cactus", item, stacksize);
	}

	public static ItemStack getCactusItem(String item) {
		return getCactusItem(item, 1);
	}

	public static void addOreStorageRecipe(ItemStack item, ItemStack block) {
		GameRegistry.addRecipe(
				block,
				new Object[] {
					"XXX", "XXX", "XXX",
					'X', item
				}
		);

		item.stackSize = 9;

		GameRegistry.addRecipe(
				item,
				new Object[] {
					"X",
					'X', block
				}
		);
	}

	public static void addToolRecipe(ItemStack material, ItemStack stick, ItemStack sword, ItemStack shovel, ItemStack pickaxe, ItemStack axe, ItemStack hoe) {
		GameRegistry.addRecipe(sword, new Object[] {"X", "X", "Y", 'X', material, 'Y', stick});
		GameRegistry.addRecipe(shovel, new Object[] {"X", "Y", "Y", 'X', material, 'Y', stick});
		GameRegistry.addRecipe(pickaxe, new Object[] {"XXX", " Y ", " Y ", 'X', material, 'Y', stick});
		GameRegistry.addRecipe(axe, new Object[] {"XX", "XY", " Y", 'X', material, 'Y', stick});
		GameRegistry.addRecipe(hoe, new Object[] {"XX", " Y", " Y", 'X', material, 'Y', stick});
	}
}
