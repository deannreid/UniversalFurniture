package universalfurniture.core.proxy;

import net.minecraft.item.ItemStack;
import universalfurniture.core.proxy.CoreProxy;
import universalfurniture.lib.Reference;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.SidedProxy;


public class CoreProxy {
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CoreProxy proxy;
	
	public String getMinecraftVersion() {
		return Loader.instance().getMinecraftModContainer().getVersion();
}

	/* LOCALIZATION */
	public void addName(Object obj, String s) {
	}
	public void addLocalization(String s1, String string) {
	}
	public String getItemDisplayName(ItemStack newStack) {
		return "";
	}
	public String getCurrentLanguage() {
	return null;
	}

	

}