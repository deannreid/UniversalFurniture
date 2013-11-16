package universalfurniture.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class CreativeTabUniversalFurniture extends CreativeTabs {


		public static CreativeTabs tabUniversalFurniture;

		public CreativeTabUniversalFurniture(String label) {
			super(label);
		}

		@Override
	    public ItemStack getIconItemStack() {
			return new ItemStack(Item.bed);
		}
		
		@Override
	    public String getTranslatedTabLabel() {
			return "Universal Furniture 1";
		}
	}


