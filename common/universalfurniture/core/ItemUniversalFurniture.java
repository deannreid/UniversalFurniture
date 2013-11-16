package universalfurniture.core;

import universalfurniture.core.utils.StringUtils;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemUniversalFurniture extends Item {

	private String iconName;
	
	public ItemUniversalFurniture (int i) {
		super(i);
		
		setCreativeTab(CreativeTabUniversalFurniture.tabUniversalFurniture);
	}

	@Override
	public String getItemDisplayName(ItemStack itemstack) {
		return StringUtils.localize(getUnlocalizedName(itemstack));
	}

	@Override
	public  Item setUnlocalizedName(String par1Str) {
		iconName = par1Str;
		return super.setUnlocalizedName(par1Str);
	}

	
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("universalfurniture:" + iconName);
    }
}
