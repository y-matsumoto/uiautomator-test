package common;

import java.io.File;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;

public class SelectorCommon {

	/**
	 * ボタンをクリック
	 * @param resouceId
	 */
	public static void uiClick(String resouceId) {
		UiSelector criteria = new UiSelector().resourceId(resouceId);
		UiObject object = new UiObject(criteria);
		try {
			if (object != null)
				object.click();
		} catch (Exception e) {
			// noop
		}
	}

}
