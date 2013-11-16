package universalfurniture.core;

import java.io.File;

import universalfurniture.UniversalFurnitureCore;
import universalfurniture.lib.Reference;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;


public class UniversalFurnitureConfiguration extends Configuration {


	public UniversalFurnitureConfiguration(File file) {
		super(file);
	}

						public void save() 
						{
						Property versionProp = get(CATEGORY_GENERAL, "version", Reference.VERSION_NUMBER);
						versionProp.set(Reference.VERSION_NUMBER);
		
//Items
						@SuppressWarnings("unused")
						Property itemCoolPackId = UniversalFurnitureCore.mainConfiguration.getItem("coolpack.id", universalfurniture.core.DefaultProps.COOL_PACK_ID);						
						
//Blocks						
						@SuppressWarnings("unused")
						Property blockBasicHedgeId = UniversalFurnitureCore.mainConfiguration.getBlock("basichedge.id", universalfurniture.core.DefaultProps.HEDGE_BASIC_ID);
					//	Property blockBirchHedgeId = UniversalFurnitureCore.mainConfiguration.getBlock("birchhedge.id", universalfurniture.core.DefaultProps.HEDGE_BIRCH_ID);						
					//	Property blockJungleHedgeId = UniversalFurnitureCore.mainConfiguration.getBlock("junglehedge.id", universalfurniture.core.DefaultProps.HEDGE_JUNGLE_ID);						
					//	Property blockSpruceHedgeId = UniversalFurnitureCore.mainConfiguration.getBlock("sprucehedge.id", universalfurniture.core.DefaultProps.HEDGE_SPRUCE_ID);						
						
						
						super.save();
						}

}