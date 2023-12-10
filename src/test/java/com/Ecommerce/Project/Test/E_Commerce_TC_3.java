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

import io.appium.java_client.AppiumBy;

public class E_Commerce_TC_3 extends EcommerceBaseClass {

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
		double totalSum = 0;
		for(int i=0;i<count;i++) {
			String amountString = productPrices.get(i).getText();
			Double price = Double.parseDouble(amountString.substring(1));
			totalSum = totalSum+price; //160.97+120 = 280.97
		}
		System.out.println("Total sum :" + totalSum);
		assertEquals(totalSum, 280.97);
		
			
	}
}
