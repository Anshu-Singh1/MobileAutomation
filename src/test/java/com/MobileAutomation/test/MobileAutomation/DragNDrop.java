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

public class DragNDrop extends BaseClass{
	
	@Test
	public void DragAndDropTest() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]")).click();
		WebElement source = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) source).getId(),
			    "endX", 626,
			    "endY", 553
			));
		
		Thread.sleep(2000);
		String result = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		System.out.println(result);
		assertEquals(result, "Dropped!");
		
		
	}

}
