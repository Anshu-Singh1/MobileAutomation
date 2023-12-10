package com.MobileAutomation.test.MobileAutomation;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumBy;

public class SwipeGesture extends BaseClass{
	
	@Test
	public void swipeGesture() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Photos\"]")).click();
		WebElement firstImage = driver.findElement(By.xpath("//android.widget.ImageView [1]"));
		assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView) [1]")).getAttribute("focusable"),"true");
		
		swipeGesture(firstImage,"left");
		assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView) [1]")).getAttribute("focusable"),"false");
		
		
		
		Thread.sleep(2000);
		
	}

}
