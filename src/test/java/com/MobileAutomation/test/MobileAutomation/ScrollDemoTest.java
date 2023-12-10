package com.MobileAutomation.test.MobileAutomation;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class ScrollDemoTest extends BaseClass{
	
	@Test
	public void ScrollCursor() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		//when you know where to scroll is known prior
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));	
		
		//No prior idea
		scrollToEndAction();
		
		
		Thread.sleep(2000);
		
	}

}
