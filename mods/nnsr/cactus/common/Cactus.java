package mods.nnsr.cactus.common;

import java.util.logging.Level;

import mods.nnsr.nnslib.nnsLib;
import mods.nnsr.nnslib.base.nnsrAxeBase;
import mods.nnsr.nnslib.base.nnsrFoodBase;
import mods.nnsr.nnslib.base.nnsrHoeBase;
import mods.nnsr.nnslib.base.nnsrItemBase;
import mods.nnsr.nnslib.base.nnsrPickaxeBase;
import mods.nnsr.nnslib.base.nnsrSpadeBase;
import mods.nnsr.nnslib.base.nnsrStairsBase;
import mods.nnsr.nnslib.base.nnsrStepBase;
import mods.nnsr.nnslib.base.nnsrSwordBase;
import mods.nnsr.nnslib.util.nnsrBlocks;
import mods.nnsr.nnslib.util.nnsrEnumHelper;
import mods.nnsr.nnslib.util.nnsrItems;
import mods.nnsr.nnslib.util.nnsrLocalize;
import mods.nnsr.nnslib.util.nnsrRecipe;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMultiTextureTile;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Property;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(
		modid = "Cactus!!+",
		name = "Cactus!!+", 
		version = "1.2.2", 
		dependencies="required-after:nnsLib"
)

@NetworkMod(
		clientSideRequired = true,
		serverSideRequired = false
)

public class Cactus {
	
	public static final CreativeTabs tabsCactus = new CreativeTabCactus("Cactus!!+");

	public static int CBlockID;
	public static int CSlabID;
	public static int CSlabDID;
	public static int CStairsID;
	public static int CStickID;
	public static int CSteakID;
	public static int CSwordID;
	public static int CAxeID;
	public static int CHoeID;
	public static int CPickaxeID;
	public static int CSpadeID;
	public static int CGelID;
	public static int CStrawID;
	public static int CSkinID;
	public static int CeramicID;
	public static int ReceramicID;
	public static int CeraSwordID;
	public static int CeraAxeID;
	public static int CeraHoeID;
	public static int CeraPickaxeID;
	public static int CeraSpadeID;
	public static int ReceraSwordID;
	public static int ReceraAxeID;
	public static int ReceraHoeID;
	public static int ReceraPickaxeID;
	public static int ReceraSpadeID;
	public static int JellyID;
	public static int CCoalID;
	public static int RCSteakID;
	public static int CactuniumID;
	public static int CNSwordID;
	public static int CNAxeID;
	public static int CNHoeID;
	public static int CNPickaxeID;
	public static int CNSpadeID;
	public static int CactusFuel;
	public static int ItemShiftIndex;
	public static boolean Recipe1;
	public static boolean Recipe2;

	

	@Mod.EventHandler
	public void PreInit(FMLPreInitializationEvent evt) {
		Configuration cfg = new Configuration(
				evt.getSuggestedConfigurationFile());
		try {
			cfg.load();
			Property CBlockProp = cfg.getBlock("CBlock", 3000, "Cactus Block ID : default 3000");
			Property CSlabProp = cfg.getBlock("CSlab", 3001, "Cactus Slab ID : default 3001");
			Property CSlabDProp = cfg.getBlock("CSlabD", 3002, "Cactus Double Slab ID : default 3002");
			Property CStairsProp = cfg.getBlock("CStairs", 3003, "Cactus Stairs ID : default 3003");
			Property CStickProp = cfg.getItem("CStickID", 30000, "Cactus Stick ID : default 30000");
			Property CSteakProp = cfg.getItem("CSteakID", 30001, "Cactus Steak ID : default 30001");
			Property CSwordProp = cfg.getItem("CSwordID", 30002, "Cactus Sword ID : default 30002");
			Property CAxeProp = cfg.getItem("CAxeID", 30003, "Cactus Axe ID : default 30003");
			Property CHoeProp = cfg.getItem("CHoeID", 30004, "Cactus Hoe ID : default 30004");
			Property CPickaxeProp = cfg.getItem("CPickaxeID", 30005, "Cactus Pickaxe ID : default 30005");
			Property CSpadeProp = cfg.getItem("CSpadeID", 30006, "Cactus Shovel ID : default 30006");
			Property CGelProp = cfg.getItem("CGelID", 30007, "Gel ID : default 30007");
			Property CStrawProp = cfg.getItem("CStrawID", 30008, "Straw ID : default 30008");
			Property CSkinProp = cfg.getItem("CSkinID", 30009, "Cactus Skin ID : default 30009");
			Property CeramicProp = cfg.getItem("CeramicID", 30010, "Ceramics ID : default 30010");
			Property ReceramicProp = cfg.getItem("ReceramicID", 30011, "Refined Ceramics ID : default 30011");
			Property CeraSwordProp = cfg.getItem("CeraSwordID", 30012, "Ceramic Sword ID : default 30012");
			Property CeraAxeProp = cfg.getItem("CeraAxeID", 30013, "Ceramic Axe ID : default 30013");
			Property CeraHoeProp = cfg.getItem("CeraHoeID", 30014, "Ceramic Hoe ID : default 30014");
			Property CeraPickaxeProp = cfg.getItem("CeraPickaxeID", 30015, "Ceramic Pickaxe ID : default 30015");
			Property CeraSpadeProp = cfg.getItem("CeraSpadeID", 30016, "Ceramic Shovel ID : default 30016");
			Property ReceraSwordProp = cfg.getItem("ReceraSwordID", 30017, "Re-Ceramic Sword ID : default 30017");
			Property ReceraAxeProp = cfg.getItem("ReceraAxeID", 30018, "Re-Ceramic Axe ID : default 30018");
			Property ReceraHoeProp = cfg.getItem("ReceraHoeID", 30019, "Re-Ceramic Hoe ID : default 30019");
			Property ReceraPickaxeProp = cfg.getItem("ReceraPickaxeID", 30020, "Re-Ceramic Pickaxe ID : default 30020");
			Property ReceraSpadeProp = cfg.getItem("ReceraSpadeID", 30021, "Re-Ceramic Shovel ID : default 30021");
			Property JellyProp = cfg.getItem("JellyID", 30022, "Jelly ID : default 30022");
			Property CCoalProp = cfg.getItem("CCoalID", 30023, "Cactus Coal ID : default 30023");
			Property RCSteakProp = cfg.getItem("RCSteakID", 30024, "Raw Cactus Steak ID : default 30024");
			Property CactuniumProp = cfg.getItem("CactuniumID", 30025, "Cactunium ID : default 30025");
			Property CNSwordProp = cfg.getItem("CNSwordID", 30026, "Cactus Sword ID : default 30026");
			Property CNAxeProp = cfg.getItem("CNAxeID", 30027, "Cactus Axe ID : default 30027");
			Property CNHoeProp = cfg.getItem("CNHoeID", 30028, "Cactus Hoe ID : default 30028");
			Property CNPickaxeProp = cfg.getItem("CNPickaxeID", 30029, "Cactus Pickaxe ID : default 30029");
			Property CNSpadeProp = cfg.getItem("CNSpadeID", 30030, "Cactus Shovel ID : default 30030");
			Property CactusFuelProp = cfg.get(Configuration.CATEGORY_GENERAL, "CactusFuelTime", 300, "Cactus Fuel Time : default 300");
			Property ISIProp = cfg.get("ShiftIndex", "ItemShiftIndex", 0, "Item Shift Index : default 0");
			Property Recipe1Prop = cfg.get(Configuration.CATEGORY_GENERAL, "enableCraftingBucket", true, "Enable crafting of buckets out of receramic : default true" );
			Property Recipe2Prop = cfg.get(Configuration.CATEGORY_GENERAL, "enableCraftingCactus", true, "Enable crafting of cactus : default true" );
			CBlockID = CBlockProp.getInt(3000);
			CSlabID = CSlabProp.getInt(3001);
			CSlabDID = CSlabDProp.getInt(3002);
			CStairsID = CStairsProp.getInt(3003);
			CStickID = CStickProp.getInt(30000);
			CSteakID = CSteakProp.getInt(30001);
			CSwordID = CSwordProp.getInt(30002);
			CAxeID = CAxeProp.getInt(30003);
			CHoeID = CHoeProp.getInt(30004);
			CPickaxeID = CPickaxeProp.getInt(30005);
			CSpadeID = CSpadeProp.getInt(30006);
			CGelID = CGelProp.getInt(30007);
			CStrawID = CStrawProp.getInt(30008);
			CSkinID = CSkinProp.getInt(30009);
			CeramicID = CeramicProp.getInt(30010);
			ReceramicID = ReceramicProp.getInt(30011);
			CeraSwordID = CeraSwordProp.getInt(30012);
			CeraAxeID = CeraAxeProp.getInt(30013);
			CeraHoeID = CeraHoeProp.getInt(30014);
			CeraPickaxeID = CeraPickaxeProp.getInt(30015);
			CeraSpadeID = CeraSpadeProp.getInt(30016);
			ReceraSwordID = ReceraSwordProp.getInt(30017);
			ReceraAxeID = ReceraAxeProp.getInt(30018);
			ReceraHoeID = ReceraHoeProp.getInt(30019);
			ReceraPickaxeID = ReceraPickaxeProp.getInt(30020);
			ReceraSpadeID = ReceraSpadeProp.getInt(30021);
			JellyID = JellyProp.getInt(30022);
			CCoalID = CCoalProp.getInt(30023);
			RCSteakID = RCSteakProp.getInt(30024);
			CactuniumID = CactuniumProp.getInt(30025);
			CNSwordID = CNSwordProp.getInt(30026);
			CNAxeID = CNAxeProp.getInt(30027);
			CNHoeID = CNHoeProp.getInt(30028);
			CNPickaxeID = CNPickaxeProp.getInt(30029);
			CNSpadeID = CNSpadeProp.getInt(30030);
			CactusFuel = CactusFuelProp.getInt(300);
			ItemShiftIndex = ISIProp.getInt(0);
			Recipe1 = Recipe1Prop.getBoolean(true);
			Recipe2 = Recipe2Prop.getBoolean(true);
		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e,
					"Cactus!!+ has a problem loading it's configuration");
		} finally {
			cfg.save();
		}
		
		nnsrBlocks.CBlock = new CBlock(CBlockID, "nnsr:CBlock").setUnlocalizedName("CBlock").setHardness(0.5F).setResistance(10F).setCreativeTab(tabsCactus);
        nnsrBlocks.CSlab = (BlockHalfSlab) new nnsrStepBase(CSlabID, false, Material.ground, CSlabDID, nnsrBlocks.CBlock).setUnlocalizedName("CSlab").setHardness(0.5F).setResistance(10F).setCreativeTab(tabsCactus);
        nnsrBlocks.CSlabD = (BlockHalfSlab) new nnsrStepBase(CSlabDID, true, Material.ground, CSlabID, nnsrBlocks.CBlock).setUnlocalizedName("CSlabD").setHardness(0.5F).setResistance(10F);
        nnsrBlocks.CStairs = new nnsrStairsBase(CStairsID, nnsrBlocks.CBlock, 0).setUnlocalizedName("CStairs").setHardness(0.5F).setResistance(10F).setCreativeTab(tabsCactus);
        nnsrBlocks.CFence = new BlockFence(3004, "nnsr:CBlock", Material.ground).setUnlocalizedName("CFence").setHardness(0.5F).setResistance(10F).setCreativeTab(tabsCactus);
        
        nnsrItems.CStick = new nnsrItemBase(CStickID - 256 + ItemShiftIndex, "nnsr:CStick", -1, 64, false).setUnlocalizedName("CStick").setCreativeTab(tabsCactus);
        nnsrItems.CSteak = new nnsrFoodBase(CSteakID - 256 + ItemShiftIndex, 8, false, "nnsr:CSteak", -1, 64, false).setUnlocalizedName("CSteak").setCreativeTab(tabsCactus);
        nnsrItems.CSword = new nnsrSwordBase(CSwordID - 256 + ItemShiftIndex, nnsrEnumHelper.ToolCactus, "nnsr:CSword", -1, false).setUnlocalizedName("CSword").setCreativeTab(tabsCactus);
        nnsrItems.CAxe = new nnsrAxeBase(CAxeID - 256 + ItemShiftIndex, nnsrEnumHelper.ToolCactus, "nnsr:CAxe", -1, false).setUnlocalizedName("CAxe").setCreativeTab(tabsCactus);
        nnsrItems.CHoe = new nnsrHoeBase(CHoeID - 256 + ItemShiftIndex, nnsrEnumHelper.ToolCactus, "nnsr:CHoe", -1, false).setUnlocalizedName("CHoe").setCreativeTab(tabsCactus);
        nnsrItems.CPickaxe = new nnsrPickaxeBase(CPickaxeID - 256 + ItemShiftIndex, nnsrEnumHelper.ToolCactus, "nnsr:CPickaxe", -1, false).setUnlocalizedName("CPickaxe").setCreativeTab(tabsCactus);
        nnsrItems.CSpade = new nnsrSpadeBase(CSpadeID - 256 + ItemShiftIndex, nnsrEnumHelper.ToolCactus, "nnsr:CSpade", -1, false).setUnlocalizedName("CSpade").setCreativeTab(tabsCactus);
        nnsrItems.CGel = new nnsrItemBase(CGelID - 256 + ItemShiftIndex, "nnsr:CGel", -1, 64, false).setUnlocalizedName("CGel").setCreativeTab(tabsCactus);
        nnsrItems.CStraw = new nnsrItemBase(CStrawID - 256 + ItemShiftIndex, "nnsr:CStraw", -1, 64, false).setUnlocalizedName("CStraw").setCreativeTab(tabsCactus);
        nnsrItems.CSkin = new nnsrItemBase(CSkinID - 256 + ItemShiftIndex, "nnsr:CSkin", -1, 64, false).setUnlocalizedName("CSkin").setCreativeTab(tabsCactus);
        nnsrItems.Ceramic = new nnsrItemBase(CeramicID - 256 + ItemShiftIndex, "nnsr:Ceramic", -1, 64, false).setUnlocalizedName("Ceramic").setCreativeTab(tabsCactus);
        nnsrItems.Receramic = new nnsrItemBase(ReceramicID - 256 + ItemShiftIndex, "nnsr:Receramic", -1, 64, false).setUnlocalizedName("Receramic").setCreativeTab(tabsCactus);
        nnsrItems.CeraSword = new nnsrSwordBase(CeraSwordID - 256 + ItemShiftIndex, nnsrEnumHelper.ToolCeramic, "nnsr:CeraSword", -1, false).setUnlocalizedName("CeraSword").setCreativeTab(tabsCactus);
        nnsrItems.CeraAxe = new nnsrAxeBase(CeraAxeID - 256 + ItemShiftIndex, nnsrEnumHelper.ToolCeramic, "nnsr:CeraAxe", -1, false).setUnlocalizedName("CeraAxe").setCreativeTab(tabsCactus);
        nnsrItems.CeraHoe = new nnsrHoeBase(CeraHoeID - 256 + ItemShiftIndex, nnsrEnumHelper.ToolCeramic, "nnsr:CeraHoe", -1, false).setUnlocalizedName("CeraHoe").setCreativeTab(tabsCactus);
        nnsrItems.CeraPickaxe = new nnsrPickaxeBase(CeraPickaxeID - 256 + ItemShiftIndex, nnsrEnumHelper.ToolCeramic, "nnsr:CeraPickaxe", -1, false).setUnlocalizedName("CeraPickaxe").setCreativeTab(tabsCactus);
        nnsrItems.CeraSpade = new nnsrSpadeBase(CeraSpadeID - 256 + ItemShiftIndex, nnsrEnumHelper.ToolCeramic, "nnsr:CeraSpade", -1, false).setUnlocalizedName("CeraSpade").setCreativeTab(tabsCactus);
        nnsrItems.ReceraSword = new nnsrSwordBase(ReceraSwordID - 256 + ItemShiftIndex, nnsrEnumHelper.ToolReceramic, "nnsr:ReceraSword", -1, false).setUnlocalizedName("ReceraSword").setCreativeTab(tabsCactus);
        nnsrItems.ReceraAxe = new nnsrAxeBase(ReceraAxeID - 256 + ItemShiftIndex, nnsrEnumHelper.ToolReceramic, "nnsr:ReceraAxe", -1, false).setUnlocalizedName("ReceraAxe").setCreativeTab(tabsCactus);
        nnsrItems.ReceraHoe = new nnsrHoeBase(ReceraHoeID - 256 + ItemShiftIndex, nnsrEnumHelper.ToolReceramic, "nnsr:ReceraHoe", -1, false).setUnlocalizedName("ReceraHoe").setCreativeTab(tabsCactus);
        nnsrItems.ReceraPickaxe = new nnsrPickaxeBase(ReceraPickaxeID - 256 + ItemShiftIndex, nnsrEnumHelper.ToolReceramic, "nnsr:ReceraPickaxe", -1, false).setUnlocalizedName("ReceraPickaxe").setCreativeTab(tabsCactus);
        nnsrItems.ReceraSpade = new nnsrSpadeBase(ReceraSpadeID - 256 + ItemShiftIndex, nnsrEnumHelper.ToolReceramic, "nnsr:ReceraSpade", -1, false).setUnlocalizedName("ReceraSpade").setCreativeTab(tabsCactus);
        nnsrItems.Jelly = new nnsrFoodBase(JellyID - 256 + ItemShiftIndex, 6, false, "nnsr:Jelly", -1, 64, false).setUnlocalizedName("Jelly").setCreativeTab(tabsCactus);
        nnsrItems.CCoal = new nnsrItemBase(CCoalID - 256 + ItemShiftIndex, "coal", 0x228B22, 64, false).setUnlocalizedName("CCoal").setCreativeTab(tabsCactus);
        nnsrItems.RCSteak = new nnsrFoodBase(RCSteakID - 256 + ItemShiftIndex, 4, false, "nnsr:RCSteak", -1, 64, false).setUnlocalizedName("RCSteak").setCreativeTab(tabsCactus);
        nnsrItems.Cactunium = new nnsrItemBase(CactuniumID - 256 + ItemShiftIndex, "nnsr:Cactunium", -1, 64, false).setUnlocalizedName("Cactunium").setCreativeTab(tabsCactus);
        nnsrItems.CNSword = new nnsrSwordBase(CNSwordID - 256 + ItemShiftIndex, nnsrEnumHelper.ToolCactunium, "nnsr:CNSword", -1, false).setUnlocalizedName("CNSword").setCreativeTab(tabsCactus);
        nnsrItems.CNAxe = new nnsrAxeBase(CNAxeID - 256 + ItemShiftIndex, nnsrEnumHelper.ToolCactunium, "nnsr:CNAxe", -1, false).setUnlocalizedName("CNAxe").setCreativeTab(tabsCactus);
        nnsrItems.CNHoe = new nnsrHoeBase(CNHoeID - 256 + ItemShiftIndex, nnsrEnumHelper.ToolCactunium, "nnsr:CNHoe", -1, false).setUnlocalizedName("CNHoe").setCreativeTab(tabsCactus);
        nnsrItems.CNPickaxe = new nnsrPickaxeBase(CNPickaxeID - 256 + ItemShiftIndex, nnsrEnumHelper.ToolCactunium, "nnsr:CNPickaxe", -1, false).setUnlocalizedName("CNPickaxe").setCreativeTab(tabsCactus);
        nnsrItems.CNSpade = new nnsrSpadeBase(CNSpadeID - 256 + ItemShiftIndex, nnsrEnumHelper.ToolCactunium, "nnsr:CNSpade", -1, false).setUnlocalizedName("CNSpade").setCreativeTab(tabsCactus);
	}

	@Mod.EventHandler
    public void Init(FMLInitializationEvent evt)
    {
		
        nnsLib.registerBlock(nnsrBlocks.CBlock);
        nnsLib.registerBlock(nnsrBlocks.CSlab);
        nnsLib.registerBlock(nnsrBlocks.CSlabD);
        nnsLib.registerBlock(nnsrBlocks.CStairs);
        nnsLib.registerBlock(nnsrBlocks.CFence);
        
        nnsLib.registerItem(new ItemStack(nnsrItems.CStick));
        nnsLib.registerItem(new ItemStack(nnsrItems.CSteak));
        nnsLib.registerItem(new ItemStack(nnsrItems.CSword));
        nnsLib.registerItem(new ItemStack(nnsrItems.CAxe));
        nnsLib.registerItem(new ItemStack(nnsrItems.CHoe));
        nnsLib.registerItem(new ItemStack(nnsrItems.CPickaxe));
        nnsLib.registerItem(new ItemStack(nnsrItems.CSpade));
        nnsLib.registerItem(new ItemStack(nnsrItems.CGel));
        nnsLib.registerItem(new ItemStack(nnsrItems.CStraw));
        nnsLib.registerItem(new ItemStack(nnsrItems.CSkin));
        nnsLib.registerItem(new ItemStack(nnsrItems.Ceramic));
        nnsLib.registerItem(new ItemStack(nnsrItems.Receramic));
        nnsLib.registerItem(new ItemStack(nnsrItems.CeraSword));
        nnsLib.registerItem(new ItemStack(nnsrItems.CeraAxe));
        nnsLib.registerItem(new ItemStack(nnsrItems.CeraHoe));
        nnsLib.registerItem(new ItemStack(nnsrItems.CeraPickaxe));
        nnsLib.registerItem(new ItemStack(nnsrItems.CeraSpade));
        nnsLib.registerItem(new ItemStack(nnsrItems.ReceraSword));
        nnsLib.registerItem(new ItemStack(nnsrItems.ReceraAxe));
        nnsLib.registerItem(new ItemStack(nnsrItems.ReceraHoe));
        nnsLib.registerItem(new ItemStack(nnsrItems.ReceraPickaxe));
        nnsLib.registerItem(new ItemStack(nnsrItems.ReceraSpade));
        nnsLib.registerItem(new ItemStack(nnsrItems.Jelly));
        nnsLib.registerItem(new ItemStack(nnsrItems.CCoal));
        nnsLib.registerItem(new ItemStack(nnsrItems.RCSteak));
        nnsLib.registerItem(new ItemStack(nnsrItems.Cactunium));
        nnsLib.registerItem(new ItemStack(nnsrItems.CNSword));
        nnsLib.registerItem(new ItemStack(nnsrItems.CNAxe));
        nnsLib.registerItem(new ItemStack(nnsrItems.CNHoe));
        nnsLib.registerItem(new ItemStack(nnsrItems.CNPickaxe));
        nnsLib.registerItem(new ItemStack(nnsrItems.CNSpade));
        
        OreDictionary.registerOre("dropUranium", new ItemStack(nnsrItems.Cactunium, 1, 0));
        
        Item.itemsList[nnsrBlocks.CSlab.blockID] = new ItemSlab(nnsrBlocks.CSlab.blockID - 256, nnsrBlocks.CSlab, nnsrBlocks.CSlabD, false).setUnlocalizedName("CSlab");
        Item.itemsList[nnsrBlocks.CSlabD.blockID] = new ItemSlab(nnsrBlocks.CSlabD.blockID - 256, nnsrBlocks.CSlab, nnsrBlocks.CSlabD, true).setUnlocalizedName("CSlabD");
        Item.itemsList[nnsrBlocks.CBlock.blockID] = (new ItemMultiTextureTile(nnsrBlocks.CBlock.blockID - 256, nnsrBlocks.CBlock, CBlock.CBLOCK_TYPES)).setUnlocalizedName("CBlock");
        
        MinecraftForge.setBlockHarvestLevel(Block.cactus, "axe", 0);
        MinecraftForge.setBlockHarvestLevel(nnsrBlocks.CBlock, "axe", 0);
        
        MinecraftForge.setToolClass(nnsrItems.CAxe, "axe", 1);
        MinecraftForge.setToolClass(nnsrItems.CPickaxe, "pickaxe", 1);
        MinecraftForge.setToolClass(nnsrItems.CSpade, "shovel", 1);
        MinecraftForge.setToolClass(nnsrItems.CeraAxe, "axe", 2);
        MinecraftForge.setToolClass(nnsrItems.CeraPickaxe, "pickaxe", 2);
        MinecraftForge.setToolClass(nnsrItems.CeraSpade, "shovel", 2);
        MinecraftForge.setToolClass(nnsrItems.ReceraAxe, "axe", 3);
        MinecraftForge.setToolClass(nnsrItems.ReceraPickaxe, "pickaxe", 3);
        MinecraftForge.setToolClass(nnsrItems.ReceraSpade, "shovel", 3);
        MinecraftForge.setToolClass(nnsrItems.CNAxe, "axe", 4);
        MinecraftForge.setToolClass(nnsrItems.CNPickaxe, "pickaxe", 4);
        MinecraftForge.setToolClass(nnsrItems.CNSpade, "spade", 4);
        
        nnsrLocalize.addLocalization("tile.CBlock.cactus.name", "Cactus Block", "サボテンブロック");
        nnsrLocalize.addLocalization("tile.CBlock.ceramic.name", "Ceramic Block", "セラミックブロック");
        nnsrLocalize.addLocalization("tile.CBlock.receramic.name", "Receramic Block", "製錬セラミックブロック");
        nnsrLocalize.addLocalization("tile.CBlock.cactunium.name", "Cactunium Block", "カクタニウムブロック");
        nnsrLocalize.addName(nnsrBlocks.CSlab, "Cactus Slab", "サボテンハーフブロック");
        nnsrLocalize.addName(nnsrBlocks.CSlabD, "Cactus Slab", "サボテンハーフブロック");
        nnsrLocalize.addName(nnsrBlocks.CStairs, "Cactus Stairs", "サボテンの階段");
        nnsrLocalize.addName(nnsrBlocks.CFence, "Cactus Fence", "サボテンフェンス");
        nnsrLocalize.addName(nnsrItems.CStick, "Cactus Stick", "サボテンスティック");
        nnsrLocalize.addName(nnsrItems.CSword, "Cactus Sword", "サボテンソード");
        nnsrLocalize.addName(nnsrItems.CAxe, "Cactus Axe", "サボテンの斧");
        nnsrLocalize.addName(nnsrItems.CHoe, "Cactus Hoe", "サボテンのクワ");
        nnsrLocalize.addName(nnsrItems.CPickaxe, "Cactus Pickaxe", "サボテンのツルハシ");
        nnsrLocalize.addName(nnsrItems.CSpade, "Cactus Shovel", "サボテンのシャベル");
        nnsrLocalize.addName(nnsrItems.CSteak, "Cactus Steak", "サボテンステーキ");
        nnsrLocalize.addName(nnsrItems.CGel, "Gel", "サボテンのゲル");
        nnsrLocalize.addName(nnsrItems.CStraw, "Straw", "サボテンのストロー");
        nnsrLocalize.addName(nnsrItems.CSkin, "Cactus Skin", "サボテンの皮");
        nnsrLocalize.addName(nnsrItems.Ceramic, "Ceramics", "セラミックインゴット");
        nnsrLocalize.addName(nnsrItems.Receramic, "Refined Ceramics", "製錬セラミックインゴット");
        nnsrLocalize.addName(nnsrItems.CeraSword, "Ceramic Sword", "セラミックの剣");
        nnsrLocalize.addName(nnsrItems.CeraAxe, "Ceramic Axe", "セラミックの斧");
        nnsrLocalize.addName(nnsrItems.CeraHoe, "Ceramic Hoe", "セラミックのクワ");
        nnsrLocalize.addName(nnsrItems.CeraPickaxe, "Ceramic Pickaxe", "セラミックのツルハシ");
        nnsrLocalize.addName(nnsrItems.CeraSpade, "Ceramic Shovel", "セラミックのシャベル");
        nnsrLocalize.addName(nnsrItems.ReceraSword, "Re-Ceramic Sword", "製錬セラミックの剣");
        nnsrLocalize.addName(nnsrItems.ReceraAxe, "Re-Ceramic Axe", "製錬セラミックの斧");
        nnsrLocalize.addName(nnsrItems.ReceraHoe, "Re-Ceramic Hoe", "製錬セラミックのクワ");
        nnsrLocalize.addName(nnsrItems.ReceraPickaxe, "Re-Ceramic Pickaxe", "製錬セラミックのツルハシ");
        nnsrLocalize.addName(nnsrItems.ReceraSpade, "Re-Ceramic Shovel", "製錬セラミックのシャベル");
        nnsrLocalize.addName(nnsrItems.Jelly, "Jelly", "ゼリー");
        nnsrLocalize.addName(nnsrItems.RCSteak, "Raw Cactus Steak", "生のサボテンステーキ");
        nnsrLocalize.addName(nnsrItems.CCoal, "Cactus Coal", "サボ炭");
        nnsrLocalize.addName(nnsrItems.Cactunium, "Cactunium Ingot", "カクタニウムインゴット");
        nnsrLocalize.addName(nnsrItems.CNSword, "Cactunium Sword", "カクタニウムソード");
        nnsrLocalize.addName(nnsrItems.CNAxe, "Cactunium Axe", "カクタニウムアックス");
        nnsrLocalize.addName(nnsrItems.CNHoe, "Cactunium Hoe", "カクタニウムクワ");
        nnsrLocalize.addName(nnsrItems.CNPickaxe, "Cactunium Pickaxe", "カクタニウムピックアックス");
        nnsrLocalize.addName(nnsrItems.CNSpade, "Cactunium Shovel", "カクタニウムシャベル");
        
        GameRegistry.addRecipe(new ItemStack(Block.dirt, 1),
                new Object[] { "#X#",
                        '#', nnsrItems.CGel,
                        'X', Block.sand
                             });
        GameRegistry.addRecipe(new ItemStack(Block.grass, 1),
                new Object[] { "###", "#X#", "###",
                        '#', nnsrItems.CGel,
                        'X', Block.dirt
                             });
        GameRegistry.addRecipe(new ItemStack(Block.workbench, 1),
                new Object[] { "XX", "##",
                        'X', nnsrItems.CSkin,
                        '#', Block.cactus
                             });
        GameRegistry.addRecipe(new ItemStack(nnsrBlocks.CBlock, 1, 0),
                new Object[] { "XX", "XX",
                        'X', Block.cactus
                             });
        GameRegistry.addRecipe(new ItemStack(Block.cactus, 4),
                new Object[] { "#",
                        '#', new ItemStack(nnsrBlocks.CBlock, 1, 0)
                             });
        GameRegistry.addRecipe(new ItemStack(nnsrItems.CStick, 4),
                new Object[] { "#", "#",
                        '#', Block.cactus
                             });
        GameRegistry.addRecipe(new ItemStack(nnsrItems.CSkin, 4),
                new Object[] { "#",
                        '#', Block.cactus
                             });
        GameRegistry.addRecipe(new ItemStack(nnsrItems.CStraw, 4),
                new Object[] { "#", "#",
                        '#', nnsrItems.CStick
                             });
        GameRegistry.addRecipe(new ItemStack(nnsrItems.CGel, 2),
                new Object[] { "X", "#",
                        '#', Block.cactus,
                        'X', nnsrItems.CStraw
                             });
        GameRegistry.addRecipe(new ItemStack(nnsrItems.Jelly, 1),
                new Object[] { "X", "Y",
                        'X', Item.sugar,
                        'Y', nnsrItems.CGel
                             });
        
        GameRegistry.addRecipe(new ItemStack(Block.chest, 1),
                new Object[] { "XXX", "Y Y", "YYY",
                        'X', nnsrItems.CSkin,
                        'Y', Block.cactus
                             });
        GameRegistry.addRecipe(new ItemStack(Block.torchWood, 4),
                new Object[] { "#", "S",
                        '#', new ItemStack(Item.coal, 1, 0),
                        'S', nnsrItems.CStick
                             });
        GameRegistry.addRecipe(new ItemStack(Block.torchWood, 4),
                new Object[] { "#", "S",
                        '#', new ItemStack(Item.coal, 1, 1),
                        'S', nnsrItems.CStick
                             });
        GameRegistry.addRecipe(new ItemStack(nnsrItems.RCSteak, 3),
                new Object[] { "XXX",
                        'X', Block.cactus
                             });
        GameRegistry.addRecipe(new ItemStack(Block.torchWood, 4),
                new Object[] { "#", "S",
                        '#', nnsrItems.CCoal,
                        'S', nnsrItems.CStick
                             });
        GameRegistry.addRecipe(new ItemStack(Block.torchWood, 4),
                new Object[] { "#", "S",
                        '#', nnsrItems.CCoal,
                        'S', nnsrItems.CStick
                             });
        GameRegistry.addRecipe(new ItemStack(nnsrItems.CNSword),
        		new Object[]{ "C", "C", "X",
        				'C', nnsrItems.Cactunium,
        				'X', nnsrItems.CSword,
        					});
        GameRegistry.addRecipe(new ItemStack(nnsrItems.CNAxe),
        		new Object[]{ "CC", "CX", " S",
        				'C', nnsrItems.Cactunium,
        				'X', nnsrItems.CAxe,
        				'S', nnsrItems.CStick
        					});
        GameRegistry.addRecipe(new ItemStack(nnsrItems.CNHoe),
        		new Object[]{ "CC", " X", " S",
        				'C', nnsrItems.Cactunium,
        				'X', nnsrItems.CHoe,
        				'S', nnsrItems.CStick
        					});
        GameRegistry.addRecipe(new ItemStack(nnsrItems.CNPickaxe),
        		new Object[]{ "CCC", " X ", " S ",
        				'C', nnsrItems.Cactunium,
        				'X', nnsrItems.CPickaxe,
        				'S', nnsrItems.CStick
        					});
        GameRegistry.addRecipe(new ItemStack(nnsrItems.CNSpade),
        		new Object[]{ "C", "X", "S",
        				'C', nnsrItems.Cactunium,
        				'X', nnsrItems.CSpade,
        				'S', nnsrItems.CStick
        					});
        GameRegistry.addRecipe(new ItemStack(Block.bookShelf),
        		new Object[]{"XXX", "YYY", "XXX",
        				'X', new ItemStack(nnsrBlocks.CBlock, 1, 0),
        				'Y', Item.book
        					});
        GameRegistry.addShapelessRecipe(new ItemStack(Item.book, 1),
        		new Object[] {Item.paper, Item.paper, Item.paper, nnsrItems.CSkin});
        GameRegistry.addRecipe(new ItemStack(Item.bed), 
        		new Object[]{"XXX", "YYY",
        				'X', Block.cloth,
        				'Y', new ItemStack(nnsrBlocks.CBlock, 1, 0)
        					});
        GameRegistry.addRecipe(new ItemStack(nnsrBlocks.CSlab, 6, 0),
        		new Object[]{"XXX",
        				'X', new ItemStack(nnsrBlocks.CBlock, 1, 0)
        					});
        GameRegistry.addRecipe(new ItemStack(nnsrBlocks.CStairs, 4, 0),
        		new Object[]{"X  ", "XX ", "XXX",
        				'X', new ItemStack(nnsrBlocks.CBlock, 1, 0)
        					});
        GameRegistry.addRecipe(new ItemStack(nnsrBlocks.CFence, 2, 0),
        		new Object[]{"XXX", "XXX",
        				'X', nnsrItems.CStick
        					});
        
        nnsrRecipe.addOreStorageRecipe(new ItemStack(nnsrBlocks.CBlock, 1, 1), nnsrItems.Ceramic);
        nnsrRecipe.addOreStorageRecipe(new ItemStack(nnsrBlocks.CBlock, 1, 2), nnsrItems.Receramic);
        nnsrRecipe.addOreStorageRecipe(new ItemStack(nnsrBlocks.CBlock, 1, 3), nnsrItems.Cactunium);
        
        if (Recipe1 == true) {
        	GameRegistry.addRecipe(new ItemStack(Item.bucketEmpty, 1),
        			new Object[] {"X X", " X ",
                        	'X', nnsrItems.Receramic
                             	});
        }
        
        if (Recipe2 == true) {
        	GameRegistry.addRecipe(new ItemStack(Block.cactus, 4),
            		new Object[] { "XXX", "XSX", "XXX",
            			'X', Block.sand,
                        'S', Item.seeds
                    			});
        }
        
        GameRegistry.addSmelting(nnsrItems.RCSteak.itemID, new ItemStack(nnsrItems.CSteak, 1), 0.3F);
        GameRegistry.addSmelting(nnsrItems.CStick.itemID, new ItemStack(Item.stick, 1), 0.1F);
        GameRegistry.addSmelting(nnsrItems.CSkin.itemID, new ItemStack(nnsrItems.CCoal, 1), 0.1F);
        GameRegistry.addSmelting(Block.sandStone.blockID, new ItemStack(nnsrItems.Ceramic, 1), 0.7F);
        GameRegistry.addSmelting(nnsrItems.Ceramic.itemID, new ItemStack(nnsrItems.Receramic, 1), 0.9F);
        FurnaceRecipes.smelting().addSmelting(nnsrBlocks.CBlock.blockID, 0, new ItemStack(nnsrItems.Cactunium, 1), 1.0F);
        
        nnsrRecipe.addToolRecipe(nnsrItems.CSword, nnsrItems.CAxe, nnsrItems.CHoe, nnsrItems.CPickaxe, nnsrItems.CSpade, Block.cactus, nnsrItems.CStick);
        nnsrRecipe.addToolRecipe(nnsrItems.CeraSword, nnsrItems.CeraAxe, nnsrItems.CeraHoe, nnsrItems.CeraPickaxe, nnsrItems.CeraSpade, nnsrItems.Ceramic, Item.stick);
        nnsrRecipe.addToolRecipe(nnsrItems.ReceraSword, nnsrItems.ReceraAxe, nnsrItems.ReceraHoe, nnsrItems.ReceraPickaxe, nnsrItems.ReceraSpade, nnsrItems.Receramic, Item.stick);
        
        GameRegistry.registerFuelHandler(new FuelTime());
    }
}
