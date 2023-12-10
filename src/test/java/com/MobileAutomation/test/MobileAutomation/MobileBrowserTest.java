package com.MobileAutomation.test.MobileAutomation;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest {

	
	@Test

public void browserTest() {
		driver.get("https://www.google.co.in/");
		WebElement testFieled  = driver.findElement(By.name("q"));
		testFieled.sendKeys("anshu singh");
		testFieled.sendKeys(Keys.ENTER);
		
	
}
}
