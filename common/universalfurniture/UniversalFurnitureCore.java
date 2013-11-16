package universalfurniture;

import java.io.File;
import java.util.logging.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import universalfurniture.core.CommandUniversalFurniture;
import universalfurniture.core.CreativeTabUniversalFurniture;
import universalfurniture.core.UniversalFurnitureConfiguration;
import universalfurniture.core.proxy.CoreProxy;
import universalfurniture.lib.Reference;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(name = "Universal Furniture", version = Reference.VERSION_NUMBER, useMetadata = false, modid = Reference.MOD_ID, acceptedMinecraftVersions = "[1.6,1.7)", dependencies = Reference.DEPENDENCIES)
@NetworkMod(clientSideRequired = true, 
			serverSideRequired = false)

public class UniversalFurnitureCore {
@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)

    public static CoreProxy proxy;
    public static CreativeTabs tabUniversalFurniture = new CreativeTabUniversalFurniture(Reference.MOD_ID);
	public static UniversalFurnitureConfiguration mainConfiguration;
	public static final Logger ufLog = Logger.getLogger("UniversalFurniture");
	
@Instance("UniversalFurniture|Core")
	public static UniversalFurnitureCore instance;
	

//////////////////////Blocks and Items//////////////////////

  public static Block blockHedgeBasic;
  public static Block blockHedgeBirch;
  public static Block blockHedgeJungle;
  public static Block blockHedgeSpruce;

  public static Item itemBedSideCabinet;
	public static Item itemCabinet;
	public static Item itemCoffeeTable;
	public static Item itemCouch;
	public static Item itemCurtains;
	public static Item itemDoorBell;
	public static Item itemElectricFence;
	public static Item itemFridge;
	public static Item itemFreezer;
	public static Item itemLamp;
	public static Item itemOven;
	public static Item itemFryer;
	public static Item itemOverheadOven;
	public static Item itemMusicPlayer;
	public static Item itemPath;
	public static Item itemTap;
	public static Item itemTV;
	public static Item itemFence;
	public static Item itemCoolPack;
	public static Item itemLightbulb;
    
	
////////////////////////////////////////////////////////////////////////////////////// EVENT HANDLERS//////////////////////////////////////////////////////////////////////////////////////

////////////////Pre-Initialise////////////////
@EventHandler
	public void loadConfiguration(FMLPreInitializationEvent event) {

	ufLog.setParent(FMLLog.getLogger());
	ufLog.info("Loading Universal Furniture " + Reference.VERSION_NUMBER);
	ufLog.info("Searching For Configuration File");
	ufLog.info("Configuration Found, Loading");
	ufLog.info("Starting UFElectrics");
	ufLog.info("ERROR -- UFElectrics Not Implemented in Version " + Reference.VERSION_NUMBER);
	ufLog.info("Loading Furniture");
	ufLog.info("Loading Items");
	ufLog.info("Loading Food");
	ufLog.info("Loading Completed");       	
	ufLog.info("Copyright (c) Dean Reid, 2013");
	ufLog.info("http://www.uf.deannreid.co.uk/");
	
	mainConfiguration = new UniversalFurnitureConfiguration(new File(event.getModConfigurationDirectory(), "universalfurniture/main.conf"));
	try {
		mainConfiguration.load();
		
		Property updateCheck = UniversalFurnitureCore.mainConfiguration.get(Configuration.CATEGORY_GENERAL, "update.check", true);
		updateCheck.comment = "set to true for version check on startup";
		if (updateCheck.getBoolean(true)) {
			universalfurniture.core.Version.check();
		}
} finally {
	if (mainConfiguration.hasChanged()) {
		mainConfiguration.save();{
		}
	}
}
}
////////////////Initialise////////////////
@EventHandler
		public void Init(FMLInitializationEvent event) {
	
	universalfurniture.core.utils.Localization.addLocalization("/lang/universalfurniture/", universalfurniture.core.DefaultProps.DEFAULT_LANGUAGE);

	itemCoolPack = new universalfurniture.core.items.itemCoolPack(30077).setUnlocalizedName("itemcoolpack");
	LanguageRegistry.addName(itemCoolPack, "Test Item");
	
	itemLightbulb = new universalfurniture.core.items.itemLightbulb(30078).setUnlocalizedName("itemlightbulb");
	LanguageRegistry.addName(itemLightbulb, "LightBulb");

	itemCurtains = new universalfurniture.core.items.itemCurtains(30079).setUnlocalizedName("itemcurtains");
	LanguageRegistry.addName(itemCurtains, "Curtains");

	itemBedSideCabinet = new universalfurniture.core.items.itemBedsideCabinet(30080).setUnlocalizedName("itembedsidecabinet");
	LanguageRegistry.addName(itemBedSideCabinet, "Bedside Cabinet");
	
	
	
	
	/*
	blockHedgeBasic = new universalfurniture.core.blocks.blockHedgeBasic(3348, Material.leaves).setUnlocalizedName("blockhedgebasic");
	GameRegistry.registerBlock(blockHedgeBasic, Reference.MOD_ID + blockHedgeBasic.getUnlocalizedName().substring(5));
	LanguageRegistry.addName(blockHedgeBasic, "Oak Hedge");
	  */  
	    }
	


////////////////Post-Initialise////////////////
@EventHandler
		public void PostInit(FMLPostInitializationEvent event) {

}

////////////////Server-Initialise////////////////
@EventHandler
public void serverStarting(FMLServerStartingEvent event) {
		event.registerServerCommand(new CommandUniversalFurniture());
	}


}