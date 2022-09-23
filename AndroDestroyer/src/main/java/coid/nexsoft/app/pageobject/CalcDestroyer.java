package coid.nexsoft.app.pageobject;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CalcDestroyer {

	public AndroidDriver<MobileElement> driver;
	private double doubExpected=0.0;	
	
	public CalcDestroyer(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	// Locator number
	//tambah elemen nol
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_0")
	private MobileElement btnZero;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_1")
	private MobileElement btnOne;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_2")
	private MobileElement btnTwo;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_3")
	private MobileElement btnThree;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_4")
	private MobileElement btnFour;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_5")
	private MobileElement btnFive;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_6")
	private MobileElement btnSix;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_7")
	private MobileElement btnSeven;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_8")
	private MobileElement btnEight;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_9")
	private MobileElement btnNine;
	
	// locator aritmatika
	@AndroidFindBy(id = "com.google.android.calculator:id/op_add")
	private MobileElement btnAdd;
	@AndroidFindBy(id = "com.google.android.calculator:id/op_sub")
	private MobileElement btnSubstract;
	@AndroidFindBy(id = "com.google.android.calculator:id/op_mul")
	private MobileElement btnMultiply;
	@AndroidFindBy(id = "com.google.android.calculator:id/op_div")
	private MobileElement btnDivide;
//	@AndroidFindBy(id = "com.google.android.calculator:id/eq")
	@AndroidFindBy(accessibility ="equals")
	private MobileElement btnEquals;
	@AndroidFindBy(id = "com.google.android.calculator:id/clr")
	private MobileElement btnClear;

	// locator result
//	@AndroidFindBy(accessibility =  "results")
	@AndroidFindBy(id = "com.google.android.calculator:id/result_final")
	private MobileElement resultCalc;

	public int getNumber(int number)
	{
		//tambah untuk 0
		if(number ==0) {
			btnZero.click();
			return 0;
		}
//		tambah untuk 0
		else if(number==1)
		{			
			btnOne.click();
			return 1;
		}
		else if(number==2)
		{
			btnTwo.click();
			return 2;
		}
		else if(number==3)
		{
			btnThree.click();
			return 3;
		}else if(number==4)
		{
			btnFour.click();
			return 4;
		}else if(number==5)
		{
			btnFive.click();
			return 5;
		}else if(number==6)
		{
			btnSix.click();
			return 6;
		}
		else if(number==7)
		{
			btnSeven.click();
			return 7;
		}
		else if(number==8)
		{
			btnEight.click();
			return 8;
		}
		else 
		{
			btnNine.click();
			return 9;
		}
	}
	
	public double getResult(double result,int number, int operator)
	{
		if(operator==0)
		{			
			btnMultiply.click();
			getNumber(number);
			btnEquals.click();
//			System.out.println("result "+result+" * number "+number+" = "+(result*number));
			result = result * (double)number;
		}
		else if(operator==1)
		{
			btnDivide.click();
			getNumber(number);
			btnEquals.click();
//			System.out.println("result "+result+" / number "+number+" = "+(result/(double)number));
			result = result / (double)number;
			
		}
		else if(operator == 2)
		{
			btnAdd.click();
			getNumber(number);
			btnEquals.click();
//			System.out.println("result "+result+" + number "+number+" = "+(result+(double)number));
			result = result + (double)number;
			
		}
		else
		{
			//ganti dari btnAdd ke btnSubstract
			btnSubstract.click();
			getNumber(number);
			btnEquals.click();
//			System.out.println("result "+result+" - number "+number+" = "+(result-number));
			result = result - (double)number;
			
		}
		
		return result;
	}
	
	public double initCalc(int numberX , int numberY, int operator)
	{
		if(operator==0)
		{	
			getNumber(numberX);
			btnMultiply.click();
			getNumber(numberY);
			btnEquals.click();
//			System.out.println("numberX "+numberX+" * numberY "+numberY+" = "+((double)numberX * (double)numberY));
			doubExpected = (double)numberX * (double)numberY;
		}
		else if(operator==1)
		{
			getNumber(numberX);
			btnDivide.click();
			getNumber(numberY);
			btnEquals.click();
//			System.out.println("numberX "+numberX+" / numberY "+numberY+" = "+((double)numberX / (double)numberY));
			doubExpected = (double)numberX / (double)numberY;
		}
		else if(operator == 2)
		{
			getNumber(numberX);
			btnAdd.click();
			getNumber(numberY);
			btnEquals.click();
//			System.out.println("numberX "+numberX+" + numberY "+numberY+" = "+((double)numberX + (double)numberY));
			doubExpected = (double)numberX + (double)numberY;
		}
		else
		{
			getNumber(numberX);
			btnSubstract.click();
			getNumber(numberY);
			btnEquals.click();
//			System.out.println("numberX "+numberX+" - numberY "+numberY+" = "+((double)numberX - (double)numberY));
			doubExpected = (double)numberX - (double)numberY;
		}
		return doubExpected;
	}
	
	public void doEqualz() {
		btnEquals.click();
	}
	
	public double getTxtResult() {
		Character charAwal = resultCalc.getText().charAt(0);
		Character ganti = '-';
		String strResult;
		if (charAwal==8722) {
			strResult =resultCalc.getText().replace(charAwal.toString(),ganti.toString()); 
			
		}else {
			strResult = resultCalc.getText();
		}
		System.out.println("hasil dari android "+resultCalc.getText());
		System.out.println("hasil dari java "+ strResult);
		return Double.parseDouble(strResult);
	}

	public void clear() {
		btnClear.click();
	}
}