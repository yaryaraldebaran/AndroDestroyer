package coid.nexsoft.app.pageobject;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Calculator {

	public AndroidDriver<MobileElement> driver;

	public Calculator(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	// Locator number
	@AndroidFindBy(accessibility = "0")
	private MobileElement btnNol;
	@AndroidFindBy(accessibility = "1")
	private MobileElement btnSatu;
	@AndroidFindBy(accessibility = "2")
	private MobileElement btnDua;
	@AndroidFindBy(accessibility = "3")
	private MobileElement btnTiga;
	@AndroidFindBy(accessibility = "4")
	private MobileElement btnEmpat;
	@AndroidFindBy(accessibility = "5")
	private MobileElement btnLima;
	@AndroidFindBy(accessibility = "6")
	private MobileElement btnEnam;
	@AndroidFindBy(accessibility = "7")
	private MobileElement btnTujuh;
	@AndroidFindBy(accessibility = "8")
	private MobileElement btnDelapan;
	@AndroidFindBy(accessibility = "9")
	private MobileElement btnSembilan;

	// locator aritmatika
	
	@AndroidFindBy(accessibility = "plus")
	private MobileElement btnTambah;
	@AndroidFindBy(accessibility = "minus")
	private MobileElement btnKurang;
	@AndroidFindBy(accessibility = "multiply")
	private MobileElement btnKali;
	@AndroidFindBy(accessibility = "divide")
	private MobileElement btnBagi;
	@AndroidFindBy(id = "com.google.android.calculator:id/eq")
	private MobileElement btnSamaDengan;
	@AndroidFindBy(id = "com.google.android.calculator:id/clr")
	private MobileElement btnClear;

	// locator result
	@AndroidFindBy(id = "com.google.android.calculator:id/result_final")
	private MobileElement result;

	// Method
	public void jumlahSatuLimaSembilan() {
		btnSatu.click();
		btnTambah.click();
		btnLima.click();
		btnTambah.click();
		btnSembilan.click();
		btnSamaDengan.click();
	}
	public void calcAdd() {
		btnSatu.click();
		btnTambah.click();
		btnDua.click();
		btnSamaDengan.click();
	}

	public void calcMul() {
		btnEmpat.click();
		btnKurang.click();
		btnTiga.click();
		btnSamaDengan.click();
	}

	public void calcDiv() {
		btnEmpat.click();
		btnBagi.click();
		btnDua.click();
		btnSamaDengan.click();
	}

	public void calcEq() {
		btnEmpat.click();
		btnKali.click();
		btnDua.click();
		btnSamaDengan.click();
	}

	//
	public String getTxtResult() {
		return result.getText();
	}

	public void clear() {
		btnClear.click();
	}
}