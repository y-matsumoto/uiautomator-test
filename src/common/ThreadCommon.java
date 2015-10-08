package common;

import java.io.File;

import com.android.uiautomator.core.UiDevice;

public class ThreadCommon {
	
	private static final int MAX_LOOP_COUNT = 10;

	private static boolean isApplicationLaunch;
	private static boolean isScreenLaunch;
	
	/**
	 * 該当アプリの起動待ち処理（初回に必ずコールすること。アプリが呼ばれるまで以降の処理を実施しない）　※1秒毎にチェックを行う
	 * @param device
	 * @param targetPackage
	 * @throws InterruptedException
	 */
	public static synchronized void applicationSwitchingPending(UiDevice device,String targetPackage) throws InterruptedException{
		isApplicationLaunch = false;
		do{
			if(targetPackage.equals(device.getCurrentPackageName())){
				isApplicationLaunch = true;
			}
			Thread.sleep(1000);
		}while(!isApplicationLaunch);
	}


	/**
	 * 画面の切り替わり待ち処理（確認最大回数は固定）　※1秒毎にチェックを行う
	 * @param device
	 * @param targetPackage
	 * @param targetActivity
	 * @return
	 * @throws InterruptedException
	 */
	public static synchronized boolean screenSwitchingPending(UiDevice device,String targetPackage,String targetActivity) throws InterruptedException{
		return screenSwitchingPending(device,targetPackage,targetActivity,MAX_LOOP_COUNT);
	}
	
	/**
	 * 画面の切り替わり待ち処理　※1秒毎にチェックを行う　
	 * @param device
	 * @param targetPackage
	 * @param targetActivity
	 * @param maxCount
	 * @return
	 * @throws InterruptedException
	 */
	@SuppressWarnings("deprecation")
	public static synchronized boolean screenSwitchingPending(UiDevice device,String targetPackage,String targetActivity,int maxCount) throws InterruptedException{
		isScreenLaunch = false;
		int loop = 0;
		do{
			if(targetPackage.equals(device.getCurrentPackageName())){
				if(targetActivity.indexOf(device.getCurrentActivityName()) != -1){
					isScreenLaunch = true;
				}
			}
			loop++;
			if(loop == MAX_LOOP_COUNT) {
				return false;
			}
			Thread.sleep(1000);
		}while(!isScreenLaunch);
		return true;
	}
	
	/**
	 * 現在対象のActivityを開いているかどうか
	 * @param device
	 * @param targetActivity
	 * @return
	 */
	public static boolean isActivityEquals(UiDevice device,String targetActivity){
		if(targetActivity.indexOf(device.getCurrentActivityName()) != -1)
			return true;
		return false;
	}
	
}
