package miui.calculator.pageobject;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MIUICalcDecimalToBin {
	public AndroidDriver<MobileElement> driver;
	private double doubExpected=0.0;	
	/*
	 * MobileElement el8 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[9]");
el8.click();
	 */
	public MIUICalcDecimalToBin(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	public void pindahKeNumSys() {
		this.tabLife.click();
		this.tabNumSyst.click();
	}
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]")
	private MobileElement tabLife;
	//klik number system
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[9]")
	private MobileElement tabNumSyst;
	@AndroidFindBy(id = "com.miui.calculator:id/btn_0_container")
	private MobileElement btnZero;
	@AndroidFindBy(id = "com.miui.calculator:id/btn_1")
	private MobileElement btnOne;
	@AndroidFindBy(id = "com.miui.calculator:id/btn_2")
	private MobileElement btnTwo;
	@AndroidFindBy(id = "com.miui.calculator:id/btn_3")
	private MobileElement btnThree;
	@AndroidFindBy(id = "com.miui.calculator:id/btn_4")
	private MobileElement btnFour;
	@AndroidFindBy(id = "com.miui.calculator:id/btn_5")
	private MobileElement btnFive;
	@AndroidFindBy(id = "com.miui.calculator:id/btn_6")
	private MobileElement btnSix;
	@AndroidFindBy(id = "com.miui.calculator:id/btn_7")
	private MobileElement btnSeven;
	@AndroidFindBy(id = "com.miui.calculator:id/btn_8")
	private MobileElement btnEight;
	@AndroidFindBy(id = "com.miui.calculator:id/btn_9")
	private MobileElement btnNine;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.EditText")
	private MobileElement valDecimal;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.EditText")
	private MobileElement valBinary;
	
	public String tryNine(int param){
		setDecimal();
		this.btnNine.click();
		int intNum = Integer.parseInt(getDecimal());
		System.out.println(intNum+" adalah input");
		String biner = Integer.toBinaryString(intNum);
		String binerJava = Integer.toBinaryString(param);
		System.out.println(biner+" adalah output android");
		System.out.println(binerJava+" adalah output java");
		return binerJava;
	}
	public void setDecimal() {
		this.valDecimal.click();
	}
	public String getDecimal() {
		return this.valDecimal.getText().toString();
	}
	public String getBin() {
		return this.valBinary.getText().toString();
	}
}
