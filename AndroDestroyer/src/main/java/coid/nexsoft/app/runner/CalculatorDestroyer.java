package coid.nexsoft.app.runner;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.json.simple.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import coid.nexsoft.app.pageobject.CalcDestroyer;
import coid.nexsoft.app.utils.ExcelReader;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculatorDestroyer {

	private static AndroidDriver<MobileElement> driver;
	private CalcDestroyer calcDestroyer;
	private ExcelReader excelReader;
	private Object [][] dDriven ;
	private int intColumnNums;
	private int intRowNums;
	private int intNumX=0;
	private int intNumNext = 0;
	private int intLoopCalc =0;
	private int intOperator = 0;
	private double doubResultExpected = 0.0;
	private double doubResultActual = 0.0;
	private Random rand ;
	
	@BeforeTest
	public void befTest()
	{
		
		try {
			
			rand = new Random();
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("deviceName", "ASUS_Z01QD");
			capabilities.setCapability("uuid", "127.0.0.1:21503");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("platformVersion", "7.1.2");
			capabilities.setCapability("appPackage", "com.google.android.calculator");
			capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
			
				driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			
			String excelPath = "./data/DataDriven.xlsx";
			String sheetName = "Sheet1";
			excelReader = new ExcelReader(excelPath, sheetName);
			intRowNums = excelReader.getRowCount();
			intColumnNums = excelReader.getColCount();
			calcDestroyer = new CalcDestroyer(driver);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	@DataProvider(name = "DataProviderFirst")
	public Object[][] dataDrivenPost()
	{
		dDriven = new Object[intRowNums][intColumnNums];
		
		Iterator<Row> rX = excelReader.getIter();
		int a=0;
		while(rX.hasNext())
		{
			Row rows = rX.next();
			for(int j=0;j<intColumnNums;j++)
			{
				dDriven[a][j] = excelReader.getCellData(a, j);
				System.out.println(dDriven[a][j]);
			}
			a++;
		}
		return dDriven;		
	}
	
	@Test(priority = 0,dataProvider="DataProviderFirst")
	public void testPost(String x)
	{	
		System.out.println("\nTesting ke ---> "+ x);
		intLoopCalc = 1;//rand.nextInt(4);
		intNumX = rand.nextInt(10);
		System.out.println("nilai awal intLoopCalc "+intLoopCalc);
		if (intLoopCalc==0) {
			intLoopCalc+=1;
		}
		System.out.println("pada testing ini terdapat "+(intLoopCalc)+" operasi");
		for(int i=0;i<intLoopCalc;i++)
		{
			intNumNext = rand.nextInt(10); //variable untuk angka
			intOperator = rand.nextInt(4); //variable untuk operator
						
			if(i==0)
			{
				System.out.println("nilai awal "+intNumX+" dan nilai kedua adalah "+intNumNext);
				System.out.println("operasi awal adalah "+cariOperator(intOperator));
				doubResultExpected = calcDestroyer.initCalc(intNumX,intNumNext, intOperator);
				System.out.println("Hasil awal adalah "+doubResultExpected);
				if (Double.toString(doubResultExpected).equals("Infinity")) {
					calcDestroyer.clear();
					continue;
				}
				
			}
			else
			{
				System.out.println("numnext adalah "+intNumNext);
				System.out.println("operasi ke "+i+" adalah "+ cariOperator(intOperator));
				doubResultExpected = calcDestroyer.getResult(doubResultExpected,intNumNext,intOperator);
				System.out.println("Hasilnya adalah "+doubResultExpected);
				if (Double.toString(doubResultExpected).equals("Infinity")) {
					calcDestroyer.clear();
					continue;
				}
			}
			System.out.println("---------operasi "+(i+1)+" selesai--------");
		}
		calcDestroyer.doEqualz();
		doubResultActual = calcDestroyer.getTxtResult();
		System.out.println("ACTUAL : "+doubResultActual+" --- EXPECTED : "+doubResultExpected);
		System.out.println("=======CALCULATOR CLEARED========");
		//pengondisian assert
		if (doubResultExpected<0) {
			String doubExp = Double.toString(doubResultExpected);
			doubExp = doubExp.substring(1,doubExp.length());
			assertTrue(Double.toString(doubResultActual).contains(doubExp));
		}
		else if(Double.toString(doubResultActual).equals("Infinity")) {
			assertTrue(Double.toString(doubResultActual).contains("Can't divide"));
		}
		else {
			assertEquals(doubResultActual, doubResultExpected);
		}
		//pengondisian assert
		calcDestroyer.clear();
	}
	public String cariOperator(int opr) {
		String strOpr="";
		if (opr==0) {
			strOpr = "*";
		}else if(opr==1) {
			strOpr = "/";
		}else if(opr==2) {
			strOpr = "+";
		}else {
			strOpr = "-";
		}
		return strOpr;
	}
//	public boolean cekInfinity(String strInf) {
//		if(strInf.equals("Infinity")) {
//			
//			continue;
//		}
//	}
}