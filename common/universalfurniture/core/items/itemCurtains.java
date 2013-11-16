package universalfurniture.core.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import universalfurniture.UniversalFurnitureCore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;



public class itemCurtains extends Item{
  
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
      itemIcon = ir.registerIcon( "uf1:itemcurtains");
    } 

    public itemCurtains(int par1) {
      super(par1);
      this.setCreativeTab(UniversalFurnitureCore.tabUniversalFurniture);
    }

    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10, Block BlockCurtains)
    {
        if (par3World.getBlockId(par4, par5, par6) != Block.glass.blockID)
        {
            if (par7 == 0)
            {
                --par5;
            }

            if (par7 == 1)
            {
                ++par5;
            }

            if (par7 == 2)
            {
                --par6;
            }

            if (par7 == 3)
            {
                ++par6;
            }

            if (par7 == 4)
            {
                --par4;
            }

            if (par7 == 5)
            {
                ++par4;
            }

            if (!par3World.isAirBlock(par4, par5, par6))
            {
                return false;
            }
        }

        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
        {
            return false;
        }
        else
        {
            if (BlockCurtains.canPlaceBlockAt(par3World, par4, par5, par6))
            {
                --par1ItemStack.stackSize;
                par3World.setBlock(par4, par5, par6, BlockCurtains.blockID);
            }

            return true;
        }
    }
}

