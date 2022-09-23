package coid.nexsoft.app.runner;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import coid.nexsoft.app.pageobject.Calculator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestAndroidCalc {
	private static AndroidDriver<MobileElement> driver;
	private Calculator calculator;
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "ASUS Z01QD");
		capabilities.setCapability("uuid", "127.0.0.1:21513");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.1.2");
		capabilities.setCapability("appPackage", "com.google.android.calculator");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");//automationName
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	
	@BeforeMethod
	public void pageObject() {
		calculator = new Calculator(driver);
	}
	
	@Test
	public void testAddOneFiveNine() {
		//test penjumlahan 1+5+9
		calculator.jumlahSatuLimaSembilan();
		assertEquals(calculator.getTxtResult(), Integer.toString(1+5+9));
		calculator.clear();
	}
	
	
	@AfterClass
	public void closeApp() {
		driver.quit();
	}	
}
