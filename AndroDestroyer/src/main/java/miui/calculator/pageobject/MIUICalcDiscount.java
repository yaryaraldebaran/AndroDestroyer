package miui.calculator.pageobject;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MIUICalcDiscount {
	public AndroidDriver<MobileElement> driver;
	private double doubExpected=0.0;	
	/*
	 * MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[6]");
el4.click();

	 */
	public MIUICalcDiscount(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	public void pindahKeDisc() {
		this.tabLife.click();
		this.tabDisc.click();
	}
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]")
	private MobileElement tabLife;
	//klik bmi
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[6]")
	private MobileElement tabDisc;

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
	
	//discount
	@AndroidFindBy(id = "com.miui.calculator:id/txt_value_one")
	private MobileElement valOriginal;
	@AndroidFindBy(id = "com.miui.calculator:id/txt_value_two")
	private MobileElement valDiskon;
	@AndroidFindBy(id = "com.miui.calculator:id/txt_value_three")
	private MobileElement valFinalPrice;
	
	public double hitungDiscount(int intAwal,int intDiskon) {
		double intAkhir=0;
		this.valOriginal.click();
		this.btnEight.click();
		this.valDiskon.click();
		this.btnFour.click();
		
		intAkhir=intAwal*(double)(100-intDiskon)/100;
		System.out.println(intAkhir+" adalah dari java");
		System.out.println(this.valFinalPrice.getText().toString()+" ini dari android");
		return intAkhir;
	}
}
