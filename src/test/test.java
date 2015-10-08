package test;

import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import common.AppConst;
import common.DeviceCommon;
import common.SelectorCommon;
import common.ThreadCommon;
public class test extends UiAutomatorTestCase  {
	
	private boolean mMainLaunched;
	
    @Override
    protected void setUp() throws Exception {
        super.setUp();

    }
    

    /**
     * シナリオ
     * @throws Exception
     */
	public void test() throws Exception {

		try{
			
			// アプリの表示待ち
			ThreadCommon.applicationSwitchingPending(getUiDevice(), AppConst.TARGET_PKG);
			// アプリ起動時キャプチャ
			DeviceCommon.takeScreenShot(getUiDevice(),"initial");
			
			// MainActivityキャプチャ
			if(!ThreadCommon.isActivityEquals(getUiDevice(), "MainActivity"))
				ThreadCommon.screenSwitchingPending(getUiDevice(),AppConst.TARGET_PKG,"MainActivity",15);
			DeviceCommon.takeScreenShot(getUiDevice(),"MainActivity");
			
			// バックボタンをクリック
			getUiDevice().pressBack();
			
		}catch(Exception e){
			fail(e.getMessage());
		}
		
	}

}
