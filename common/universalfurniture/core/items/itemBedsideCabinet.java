package universalfurniture.core.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import universalfurniture.UniversalFurnitureCore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class itemBedsideCabinet extends Item{
  
    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIcon(ItemStack stack, int pass)
    {
      return itemIcon;
    }
    
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister ir)
    {
      itemIcon = ir.registerIcon( "uf1:itembedsidecabinet");
    } 

    public itemBedsideCabinet(int par1) {
      super(par1);
      this.setCreativeTab(UniversalFurnitureCore.tabUniversalFurniture);
    }
}