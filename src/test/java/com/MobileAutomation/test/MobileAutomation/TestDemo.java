package com.MobileAutomation.test.MobileAutomation;


import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


public class TestDemo extends BaseClass{

	@SuppressWarnings("deprecation")
	@Test
	public void test() throws MalformedURLException, InterruptedException {
		
		
	Activity activity = new Activity(" io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
	driver.startActivity(activity);
//	driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//	driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
	driver.findElement(By.id("android:id/checkbox")).click();
	
	//Ratate landscape
	
	DeviceRotation landscape = new DeviceRotation(0,0,90);
	driver.rotate(landscape);
	driver.findElement(By.xpath("(//android.widget.RelativeLayout) [2]")).click();
	String wiFiText = driver.findElement(By.id("android:id/alertTitle")).getText();
	System.out.println(wiFiText);
	assertEquals(wiFiText, "WiFi settings");
	
	//copy paste
	//copy to clipboard  - paste it to clipboard
	
	driver.setClipboardText("anshuWIFI");
	driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
	
	//Key event
	
	driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	driver.findElement(By.id("android:id/button1")).click();
	driver.pressKey(new KeyEvent(AndroidKey.BACK));
	driver.pressKey(new KeyEvent(AndroidKey.HOME));
	
    }
}
