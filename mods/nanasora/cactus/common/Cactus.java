package mods.nanasora.cactus.common;

import java.util.logging.Level;

import mods.nanasora.nnslib.base.*;
import mods.nanasora.nnslib.util.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = "Cactus!!+", name = "Cactus!!+", version = "1.1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Cactus {
	
	public static final CreativeTabs tabsCactus = new CreativeTabCactus("Cactus!!+");

	public static Block CBlock;

	public static Item CStick;
	public static Item CSteak;
	public static Item CSword;
	public static Item CAxe;
	public static Item CHoe;
	public static Item CPickaxe;
	public static Item CSpade;
	public static Item CGel;
	public static Item CStraw;
	public static Item CSkin;
	public static Item Ceramic;
	public static Item Receramic;
	public static Item CeraSword;
	public static Item CeraAxe;
	public static Item CeraHoe;
	public static Item CeraPickaxe;
	public static Item CeraSpade;
	public static Item ReceraSword;
	public static Item ReceraAxe;
	public static Item ReceraHoe;
	public static Item ReceraPickaxe;
	public static Item ReceraSpade;
	public static Item Jelly;
	public static Item CCoal;
	public static Item RCSteak;
	public static Item Cactunium;
	public static Item CNSword;
	public static Item CNAxe;
	public static Item CNHoe;
	public static Item CNPickaxe;
	public static Item CNSpade;

	public static int CBlockID;
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

	

	@PreInit
	public void PreInit(FMLPreInitializationEvent evt) {
		Configuration cfg = new Configuration(
				evt.getSuggestedConfigurationFile());
		try {
			cfg.load();
			Property CBlockProp = cfg.getBlock("CBlock", 3000, "Cactus Block ID : default 3000");
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
			CBlockID = CBlockProp.getInt(3000);
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
		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e,
					"Cactus!!+ has a problem loading it's configuration");
		} finally {
			cfg.save();
		}
	}

	@Init
    public void Init(FMLInitializationEvent evt)
    {
		
        CBlock = new nnsrBlockBase(CBlockID, Material.ground, "nanasora/cactus/sprites:CBlock", CBlockID, 1).setUnlocalizedName("CBlock").setHardness(0.5F).setResistance(10F).setCreativeTab(tabsCactus);
        CStick = new nnsrItemBase(CStickID - 256, "stick", 0x228B22, 64, false).setUnlocalizedName("CStick").setCreativeTab(tabsCactus);
        CSteak = new nnsrFoodBase(CSteakID - 256, 8, false, "porkchopCooked", 0x228B22, 64, false).setUnlocalizedName("CSteak").setCreativeTab(tabsCactus);
        CSword = new nnsrSwordBase(CSwordID - 256, nnsrToolMaterial.ToolCactus, "nanasora/cactus/sprites:CSword", -1, false).setUnlocalizedName("CSword").setCreativeTab(tabsCactus);
        CAxe = new nnsrAxeBase(CAxeID - 256, nnsrToolMaterial.ToolCactus, "nanasora/cactus/sprites:CAxe", -1, false).setUnlocalizedName("CAxe").setCreativeTab(tabsCactus);
        CHoe = new nnsrHoeBase(CHoeID - 256, nnsrToolMaterial.ToolCactus, "nanasora/cactus/sprites:CHoe", -1, false).setUnlocalizedName("CHoe").setCreativeTab(tabsCactus);
        CPickaxe = new nnsrPickaxeBase(CPickaxeID - 256, nnsrToolMaterial.ToolCactus, "nanasora/cactus/sprites:CPickaxe", -1, false).setUnlocalizedName("CPickaxe").setCreativeTab(tabsCactus);
        CSpade = new nnsrSpadeBase(CSpadeID - 256, nnsrToolMaterial.ToolCactus, "nanasora/cactus/sprites:CSpade", -1, false).setUnlocalizedName("CSpade").setCreativeTab(tabsCactus);
        CGel = new nnsrItemBase(CGelID - 256, "nanasora/cactus/sprites:CGel", -1, 64, false).setUnlocalizedName("CGel").setCreativeTab(tabsCactus);
        CStraw = new nnsrItemBase(CStrawID - 256, "nanasora/cactus/sprites:CStraw", -1, 64, false).setUnlocalizedName("CStraw").setCreativeTab(tabsCactus);
        CSkin = new nnsrItemBase(CSkinID - 256, "nanasora/cactus/sprites:CSkin", -1, 64, false).setUnlocalizedName("CSkin").setCreativeTab(tabsCactus);
        Ceramic = new nnsrItemBase(CeramicID - 256, "ingotIron", 0xFFFFE0, 64, false).setUnlocalizedName("Ceramic").setCreativeTab(tabsCactus);
        Receramic = new nnsrItemBase(ReceramicID - 256, "ingotIron", 0xAAD8E6, 64, false).setUnlocalizedName("Receramic").setCreativeTab(tabsCactus);
        CeraSword = new nnsrSwordBase(CeraSwordID - 256, nnsrToolMaterial.ToolCeramic, "nanasora/cactus/sprites:CeraSword", -1, false).setUnlocalizedName("CeraSword").setCreativeTab(tabsCactus);
        CeraAxe = new nnsrAxeBase(CeraAxeID - 256, nnsrToolMaterial.ToolCeramic, "nanasora/cactus/sprites:CeraAxe", -1, false).setUnlocalizedName("CeraAxe").setCreativeTab(tabsCactus);
        CeraHoe = new nnsrHoeBase(CeraHoeID - 256, nnsrToolMaterial.ToolCeramic, "nanasora/cactus/sprites:CeraHoe", -1, false).setUnlocalizedName("CeraHoe").setCreativeTab(tabsCactus);
        CeraPickaxe = new nnsrPickaxeBase(CeraPickaxeID - 256, nnsrToolMaterial.ToolCeramic, "nanasora/cactus/sprites:CeraPickaxe", -1, false).setUnlocalizedName("CeraPickaxe").setCreativeTab(tabsCactus);
        CeraSpade = new nnsrSpadeBase(CeraSpadeID - 256, nnsrToolMaterial.ToolCeramic, "nanasora/cactus/sprites:CeraSpade", -1, false).setUnlocalizedName("CeraSpade").setCreativeTab(tabsCactus);
        ReceraSword = new nnsrSwordBase(ReceraSwordID - 256, nnsrToolMaterial.ToolReceramic, "nanasora/cactus/sprites:ReceraSword", -1, false).setUnlocalizedName("ReceraSword").setCreativeTab(tabsCactus);
        ReceraAxe = new nnsrAxeBase(ReceraAxeID - 256, nnsrToolMaterial.ToolReceramic, "nanasora/cactus/sprites:ReceraAxe", -1, false).setUnlocalizedName("ReceraAxe").setCreativeTab(tabsCactus);
        ReceraHoe = new nnsrHoeBase(ReceraHoeID - 256, nnsrToolMaterial.ToolReceramic, "nanasora/cactus/sprites:ReceraHoe", -1, false).setUnlocalizedName("ReceraHoe").setCreativeTab(tabsCactus);
        ReceraPickaxe = new nnsrPickaxeBase(ReceraPickaxeID - 256, nnsrToolMaterial.ToolReceramic, "nanasora/cactus/sprites:ReceraPickaxe", -1, false).setUnlocalizedName("ReceraPickaxe").setCreativeTab(tabsCactus);
        ReceraSpade = new nnsrSpadeBase(ReceraSpadeID - 256, nnsrToolMaterial.ToolReceramic, "nanasora/cactus/sprites:ReceraSpade", -1, false).setUnlocalizedName("ReceraSpade").setCreativeTab(tabsCactus);
        Jelly = new nnsrFoodBase(JellyID - 256, 6, false, "nanasora/cactus/sprites:Jelly", -1, 64, false).setUnlocalizedName("Jelly").setCreativeTab(tabsCactus);
        CCoal = new nnsrItemBase(CCoalID - 256, "coal", 0x228B22, 64, false).setUnlocalizedName("CCoal").setCreativeTab(tabsCactus);
        RCSteak = new nnsrFoodBase(RCSteakID - 256, 4, false, "porkchopRaw", 0x228B22, 64, false).setUnlocalizedName("RCSteak").setCreativeTab(tabsCactus);
        Cactunium = new nnsrItemBase(CactuniumID - 256, "ingotIron", 0x228B22, 064, false).setUnlocalizedName("Cactunium").setCreativeTab(tabsCactus);
        CNSword = new nnsrSwordBase(CNSwordID - 256, nnsrToolMaterial.ToolCactunium, "nanasora/cactus/sprites:CNAxe", -1, false).setUnlocalizedName("CNSword").setCreativeTab(tabsCactus);
        CNAxe = new nnsrAxeBase(CNAxeID - 256, nnsrToolMaterial.ToolCactunium, "nanasora/cactus/sprites:CNAxe", -1, false).setUnlocalizedName("CNAxe").setCreativeTab(tabsCactus);
        CNHoe = new nnsrHoeBase(CNHoeID - 256, nnsrToolMaterial.ToolCactunium, "nanasora/cactus/sprites:CNHoe", -1, false).setUnlocalizedName("CNHoe").setCreativeTab(tabsCactus);
        CNPickaxe = new nnsrPickaxeBase(CNPickaxeID - 256, nnsrToolMaterial.ToolCactunium, "nanasora/cactus/sprites:CNPickaxe", -1, false).setUnlocalizedName("CNPickaxe").setCreativeTab(tabsCactus);
        CNSpade = new nnsrSpadeBase(CNSpadeID - 256, nnsrToolMaterial.ToolCactunium, "nanasora/cactus/sprites:CNSpade", -1, false).setUnlocalizedName("CNSpade").setCreativeTab(tabsCactus);
        
        GameRegistry.registerBlock(CBlock, "Cactus!!+");
        
        OreDictionary.registerOre("dropUranium", new ItemStack(Cactunium, 1, 0));
        
        nnsrLocalize.addName(CBlock, "Cactus Block", "サボテンブロック");
        nnsrLocalize.addName(CStick, "Cactus Stick", "サボテンスティック");
        nnsrLocalize.addName(CSword, "Cactus Sword", "サボテンソード");
        nnsrLocalize.addName(CAxe, "Cactus Axe", "サボテンの斧");
        nnsrLocalize.addName(CHoe, "Cactus Hoe", "サボテンのクワ");
        nnsrLocalize.addName(CPickaxe, "Cactus Pickaxe", "サボテンのツルハシ");
        nnsrLocalize.addName(CSpade, "Cactus Shovel", "サボテンのシャベル");
        nnsrLocalize.addName(CSteak, "Cactus Steak", "サボテンステーキ");
        nnsrLocalize.addName(CGel, "Gel", "サボテンのゲル");
        nnsrLocalize.addName(CStraw, "Straw", "サボテンのストロー");
        nnsrLocalize.addName(CSkin, "Cactus Skin", "サボテンの皮");
        nnsrLocalize.addName(Ceramic, "Ceramics", "セラミックインゴット");
        nnsrLocalize.addName(Receramic, "Refined Ceramics", "製錬セラミックインゴット");
        nnsrLocalize.addName(CeraSword, "Ceramic Sword", "セラミックの剣");
        nnsrLocalize.addName(CeraAxe, "Ceramic Axe", "セラミックの斧");
        nnsrLocalize.addName(CeraHoe, "Ceramic Hoe", "セラミックのクワ");
        nnsrLocalize.addName(CeraPickaxe, "Ceramic Pickaxe", "セラミックのツルハシ");
        nnsrLocalize.addName(CeraSpade, "Ceramic Shovel", "セラミックのシャベル");
        nnsrLocalize.addName(ReceraSword, "Re-Ceramic Sword", "製錬セラミックの剣");
        nnsrLocalize.addName(ReceraAxe, "Re-Ceramic Axe", "製錬セラミックの斧");
        nnsrLocalize.addName(ReceraHoe, "Re-Ceramic Hoe", "製錬セラミックのクワ");
        nnsrLocalize.addName(ReceraPickaxe, "Re-Ceramic Pickaxe", "製錬セラミックのツルハシ");
        nnsrLocalize.addName(ReceraSpade, "Re-Ceramic Shovel", "製錬セラミックのシャベル");
        nnsrLocalize.addName(Jelly, "Jelly", "ゼリー");
        nnsrLocalize.addName(RCSteak, "Raw Cactus Steak", "生のサボテンステーキ");
        nnsrLocalize.addName(CCoal, "Cactus Coal", "サボ炭");
        nnsrLocalize.addName(Cactunium, "Cactunium Ingot", "カクタニウムインゴット");
        nnsrLocalize.addName(CNSword, "Cactunium Sword", "カクタニウムソード");
        nnsrLocalize.addName(CNAxe, "Cactunium Axe", "カクタニウムアックス");
        nnsrLocalize.addName(CNHoe, "Cactunium Hoe", "カクタニウムクワ");
        nnsrLocalize.addName(CNPickaxe, "Cactunium Pickaxe", "カクタニウムピックアックス");
        nnsrLocalize.addName(CNSpade, "Cactunium Shovel", "カクタニウムシャベル");
        
        GameRegistry.addRecipe(new ItemStack(Block.cactus, 4),
        		new Object[] { "XXX", "XSX", "XXX",
        			'X', Block.sand,
                    'S', Item.seeds
                			});
        GameRegistry.addRecipe(new ItemStack(Block.dirt, 1),
                new Object[] { "#X#",
                        '#', CGel,
                        'X', Block.sand
                             });
        GameRegistry.addRecipe(new ItemStack(Block.grass, 1),
                new Object[] { "###", "#X#", "###",
                        '#', CGel,
                        'X', Block.dirt
                             });
        GameRegistry.addRecipe(new ItemStack(Block.workbench, 1),
                new Object[] { "XX", "##",
                        'X', CSkin,
                        '#', Block.cactus
                             });
        GameRegistry.addRecipe(new ItemStack(CBlock, 1),
                new Object[] { "XX", "XX",
                        'X', Block.cactus
                             });
        GameRegistry.addRecipe(new ItemStack(Block.cactus, 4),
                new Object[] { "#",
                        '#', CBlock
                             });
        GameRegistry.addRecipe(new ItemStack(CStick, 4),
                new Object[] { "#", "#",
                        '#', Block.cactus
                             });
        GameRegistry.addRecipe(new ItemStack(CSkin, 4),
                new Object[] { "#",
                        '#', Block.cactus
                             });
        GameRegistry.addRecipe(new ItemStack(CStraw, 4),
                new Object[] { "#", "#",
                        '#', CStick
                             });
        GameRegistry.addRecipe(new ItemStack(CGel, 2),
                new Object[] { "X", "#",
                        '#', Block.cactus,
                        'X', CStraw
                             });
        GameRegistry.addRecipe(new ItemStack(Jelly, 1),
                new Object[] { "X", "Y",
                        'X', Item.sugar,
                        'Y', CGel
                             });
        GameRegistry.addRecipe(new ItemStack(Item.bucketEmpty, 1),
                new Object[] {"X X", " X ",
                        'X', Receramic
                             });
        GameRegistry.addRecipe(new ItemStack(Block.chest, 1),
                new Object[] { "XXX", "Y Y", "YYY",
                        'X', CSkin,
                        'Y', Block.cactus
                             });
        GameRegistry.addRecipe(new ItemStack(Block.torchWood, 4),
                new Object[] { "#", "S",
                        '#', new ItemStack(Item.coal, 1, 0),
                        'S', CStick
                             });
        GameRegistry.addRecipe(new ItemStack(Block.torchWood, 4),
                new Object[] { "#", "S",
                        '#', new ItemStack(Item.coal, 1, 1),
                        'S', CStick
                             });
        GameRegistry.addRecipe(new ItemStack(RCSteak, 3),
                new Object[] { "XXX",
                        'X', Block.cactus
                             });
        GameRegistry.addRecipe(new ItemStack(Block.torchWood, 4),
                new Object[] { "#", "S",
                        '#', CCoal,
                        'S', CStick
                             });
        GameRegistry.addRecipe(new ItemStack(Block.torchWood, 4),
                new Object[] { "#", "S",
                        '#', CCoal,
                        'S', CStick
                             });
        GameRegistry.addRecipe(new ItemStack(CNSword),
        		new Object[]{ "C", "C", "X",
        				'C', Cactunium,
        				'X', CSword,
        					});
        GameRegistry.addRecipe(new ItemStack(CNAxe),
        		new Object[]{ "CC", "CX", " S",
        				'C', Cactunium,
        				'X', CAxe,
        				'S', CStick
        					});
        GameRegistry.addRecipe(new ItemStack(CNHoe),
        		new Object[]{ "CC", " X", " S",
        				'C', Cactunium,
        				'X', CHoe,
        				'S', CStick
        					});
        GameRegistry.addRecipe(new ItemStack(CNPickaxe),
        		new Object[]{ "CCC", " X ", " S ",
        				'C', Cactunium,
        				'X', CPickaxe,
        				'S', CStick
        					});
        GameRegistry.addRecipe(new ItemStack(CNSpade),
        		new Object[]{ "C", "X", "S",
        				'C', Cactunium,
        				'X', CSpade,
        				'S', CStick
        					});
        
        GameRegistry.addSmelting(RCSteak.itemID, new ItemStack(CSteak, 1), 0.3F);
        GameRegistry.addSmelting(CStick.itemID, new ItemStack(Item.stick, 1), 0.1F);
        GameRegistry.addSmelting(CSkin.itemID, new ItemStack(CCoal, 1), 0.1F);
        GameRegistry.addSmelting(Block.sandStone.blockID, new ItemStack(Ceramic, 1), 0.7F);
        GameRegistry.addSmelting(Ceramic.itemID, new ItemStack(Receramic, 1), 0.9F);
        GameRegistry.addSmelting(CBlock.blockID, new ItemStack(Cactunium, 1), 1.0F);
        
        nnsrRecipe.addToolRecipe(CSword, CAxe, CHoe, CPickaxe, CSpade, Block.cactus, CStick);
        nnsrRecipe.addToolRecipe(CeraSword, CeraAxe, CeraHoe, CeraPickaxe, CeraSpade, Ceramic, Item.stick);
        nnsrRecipe.addToolRecipe(ReceraSword, ReceraAxe, ReceraHoe, ReceraPickaxe, ReceraSpade, Receramic, Item.stick);
        
        GameRegistry.registerFuelHandler(new FuelTime());
    }
}
