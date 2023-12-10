package com.MobileAutomation.test.MobileAutomation;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class GesturePractice extends BaseClass{
	
	@Test
	public void PracticeGestureTest() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Alert Dialogs\"]")).click();
		
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Text Entry dialog\"]")).click();
		
		String text = driver.findElement(By.id("android:id/alertTitle")).getText();
		System.out.println(text);
		assertEquals(text, "Text Entry dialog");
		
		//Key event
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Alert Dialogs\"]")).click();
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Text Entry dialog\"]")).click();
		
		WebElement usernameTextField = driver.findElement(By.id("io.appium.android.apis:id/username_edit"));
		usernameTextField.sendKeys("Anshu@gmail.com");
		
		WebElement passwordTextField = driver.findElement(By.id("io.appium.android.apis:id/password_edit"));
		passwordTextField.sendKeys("passwordTextField");
		
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		driver.findElement(By.id("io.appium.android.apis:id/two_buttons")).click();
		driver.findElement(By.id("android:id/button1")).click();
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		driver.findElement(AppiumBy.accessibilityId("List dialog")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Command three\"]")).click();
		String message = driver.findElement(By.id("android:id/message")).getText();
		System.out.println(message);
		assertEquals(message, "You selected: 2 , Command three");
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		
		driver.findElement(AppiumBy.accessibilityId("Repeat alarm")).click();
		WebElement monday = driver.findElement(By.xpath("//android.widget.CheckedTextView[@text=\"Every Monday\"]"));
		monday.click();
		monday.isSelected();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text=\"Every Wednesday\"]")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text=\"Every Friday\"]")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text=\"Every Saturday\"]")).click();
		DeviceRotation landscape = new DeviceRotation(0,0,90);
		driver.rotate(landscape);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text=\"Every Sunday\"]")).click();
		WebElement tuesday = driver.findElement(By.xpath("//android.widget.CheckedTextView[@text=\"Every Tuesday\"]"));
		tuesday.click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text=\"Every Thursday\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/button1")).click();
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
			
	}

}
