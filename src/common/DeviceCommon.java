package common;

import java.io.File;

import com.android.uiautomator.core.UiDevice;

public class DeviceCommon {

	public static void takeScreenShot(UiDevice device){
		File filePath = new File(AppConst.PICTURE_BASE_PATH + "ev" + String.valueOf(System.currentTimeMillis()) + ".png");
		device.takeScreenshot(filePath);
	}
	
	public static void takeScreenShot(UiDevice device,String filename){
		File filePath = new File(AppConst.PICTURE_BASE_PATH + filename + ".png");
		device.takeScreenshot(filePath);
	}

}
