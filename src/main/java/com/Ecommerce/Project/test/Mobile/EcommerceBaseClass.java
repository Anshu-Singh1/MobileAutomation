package com.Ecommerce.Project.test.Mobile;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class EcommerceBaseClass {
	public AppiumDriverLocalService service;
	public UiAutomator2Options options;
	public AndroidDriver driver;
	public WebDriver drivers;
	
	@BeforeClass
	public void configure() throws MalformedURLException {
		service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\LENOVO\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
				service.start();
				options = new UiAutomator2Options();
				options.setDeviceName("AnshuMobile");
			    options.setChromedriverExecutable("C:\\Users\\LENOVO\\Downloads\\chromedriver_win32 (6)");
				options.setApp("C:\\Users\\LENOVO\\eclipse-workspace\\MobileAutomation\\src\\test\\java\\resource\\General-Store.apk");
				
				 driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    }
	public void longPressAction(WebElement ele) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),
						"duration",2000));
	}
	public void scrollToEndAction() {
	
	boolean canScrollMore;
	do
	{
	canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
		    "left", 100, "top", 100, "width", 200, "height", 200,
		    "direction", "down",
		    "percent", 3.0
		));
	}while(canScrollMore);
	
}
	
	public void swipeGesture(WebElement ele,String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement)ele).getId(),
			    "direction", direction,
			    "percent", 0.75
			));
	}
	public double getFormattedAmount(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}

