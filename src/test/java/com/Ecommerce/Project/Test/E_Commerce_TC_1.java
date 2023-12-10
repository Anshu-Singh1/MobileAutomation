package com.Ecommerce.Project.Test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Ecommerce.Project.test.Mobile.EcommerceBaseClass;

import io.appium.java_client.AppiumBy;

public class E_Commerce_TC_1 extends EcommerceBaseClass {

	@Test
	public void fillForm() throws InterruptedException {
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Anshu Singh");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Male']")).click();
		driver.findElement(By.className("android.widget.Spinner")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));")).click();
		driver.findElement(By.className("android.widget.Button")).click();
		String toastMessgae = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		assertEquals(toastMessgae, "Please enter your name");
		
		
	}
}
