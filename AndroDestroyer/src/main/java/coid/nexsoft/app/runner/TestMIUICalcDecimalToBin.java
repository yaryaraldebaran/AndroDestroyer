package coid.nexsoft.app.runner;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import coid.nexsoft.app.pageobject.CalcDestroyer;
import coid.nexsoft.app.pageobject.MIUICalcDecimalToBin;
import coid.nexsoft.app.utils.ExcelReader;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TestMIUICalcDecimalToBin {
	private static AndroidDriver<MobileElement> driver;
	private MIUICalcDecimalToBin decToBin;
	private Random rand;
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
			capabilities.setCapability("appPackage", "com.miui.calculator");
			capabilities.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
			capabilities.setCapability("noReset", "true");
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			decToBin = new MIUICalcDecimalToBin(driver);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testOne() {
		decToBin.pindahKeNumSys();
		String binJ = decToBin.tryNine(9);
		assertTrue(binJ.equals(decToBin.getBin()));
	}
}

