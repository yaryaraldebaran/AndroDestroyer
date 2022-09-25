package miui.calculator.pageobject;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MIUICalcBMI {
	public AndroidDriver<MobileElement> driver;
	private double doubExpected=0.0;	
	/*
	 * MobileElement el1 = (MobileElement) driver.findElementById("com.miui.calculator:id/iv_tab_life");
el1.click();
MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]");
el2.click();
	 */
	public MIUICalcBMI(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	public void pindahKeBMI() {
		this.tabLife.click();
		this.tabBMI.click();
	}
	//tab geser
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]")
	private MobileElement tabLife;
	//klik bmi
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]")
	private MobileElement tabBMI;
	// Locator number
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
	
	@AndroidFindBy(accessibility = "clear")
	private MobileElement btnClr;
	
	//BMI
	@AndroidFindBy(id = "com.miui.calculator:id/tv_value_weight")
	private MobileElement valWeight;
	@AndroidFindBy(id = "com.miui.calculator:id/tv_value_height")
	private MobileElement valHeight;
	@AndroidFindBy(id = "com.miui.calculator:id/btn_go")
	private MobileElement goBtn;
	@AndroidFindBy(id = "com.miui.calculator:id/txt_bmi_result")
	private MobileElement bmiResult;
	
	public double hitungBMI(int intBerat,int intTinggicm) throws InterruptedException {
		double doBMI=0.0;
		this.valWeight.click();
		this.btnSeven.click();
		this.btnZero.click();
		this.valHeight.click();
		this.btnOne.click();
		this.btnSix.click();
		this.btnFive.click();
		this.goBtn.click();
		Thread.sleep(1000);
		doBMI=intBerat/Math.pow(((double)intTinggicm/100), 2); 
		doBMI=roundAvoid(doBMI, 2);
		System.out.println(doBMI+" adalah dari java");
		System.out.println(this.bmiResult.getText().toString()+" ini dari android");
		return doBMI;
	}
	public double roundAvoid(double value, int places) {
	    double scale = Math.pow(10, 1);
	    return Math.round(value * scale) / scale;
	}
	public String bmiRes() {
		return this.bmiResult.getText().toString();
	}
}
