package universalfurniture.core.utils;

import universalfurniture.core.utils.Localization;

public class StringUtils {

	public static String localize(String key) {
		return Localization.get(key);
	}
}

