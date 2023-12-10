package com.Ecommerce.Project.Test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.Ecommerce.Project.test.Mobile.EcommerceBaseClass;

import io.appium.java_client.AppiumBy;

public class E_Commerce_TC_2 extends EcommerceBaseClass {

	@Test
	public void fillForm() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.EditText[@text='Enter name here']")).sendKeys("Anshu Singh");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"));")).click();
		driver.findElement(By.className("android.widget.Button")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"PG 3\"));"));
		int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		for(int i=0;i<productCount;i++) {
			String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			
			if(productName.equalsIgnoreCase("PG 3")) {
				driver.findElement(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).click();
			}
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "cart"));
		driver.findElement(By.className("android.widget.CheckBox")).click();
		String proceedButtonText  = driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).getText();
		System.out.println(proceedButtonText);
		assertEquals(proceedButtonText, "Visit to the website to complete purchase");
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(3000);
			
	}
}
