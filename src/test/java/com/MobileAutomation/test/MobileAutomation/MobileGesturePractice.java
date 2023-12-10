package com.MobileAutomation.test.MobileAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class MobileGesturePractice extends BaseClass{
	@Test
	public void MobileGesture() throws InterruptedException {
//		driver.findElement(AppiumBy.accessibilityId("Views")).click();
//		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]")).click();
//		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]")).click();
//		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Dog Names\"]"));
//		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
//				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));
		
		//Scroll to element when i know the prior
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Visibility\"));"));
	}

}
