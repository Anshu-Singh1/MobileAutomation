package com.Ecommerce.Project.Test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.Ecommerce.Project.test.Mobile.EcommerceBaseClass;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumBy;

public class E_Commerce_TC_4 extends EcommerceBaseClass {

	@Test
	public void fillForm() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.EditText[@text='Enter name here']")).sendKeys("Anshu Singh");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"));")).click();
		driver.findElement(By.className("android.widget.Button")).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		Thread.sleep(2000);
		List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count = productPrices.size();
		double totalSum  = 0;
		for(int i=0;i<count;i++) {
			String StringAmount = productPrices.get(i).getText();
			Double price = getFormattedAmount(StringAmount);
			totalSum +=price;//
		}
		String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();		
		Double displayFormattedSum = getFormattedAmount(displaySum);	
		assertEquals(totalSum, displayFormattedSum);
		WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(ele);
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.className("android.widget.CheckBox")).click();
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.androidsample.generalstore:id/btnProceed']")).click();
		Thread.sleep(2000);
		
		
		
	}
}
