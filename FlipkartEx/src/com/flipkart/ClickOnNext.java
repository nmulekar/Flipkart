package com.flipkart;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClickOnNext {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new FirefoxDriver();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.get("https://www.flipkart.com");

		WebElement popUp = driver.findElement(By.xpath("//button[@class=\"_2AkmmA _29YdH8\"]"));

		popUp.click();

		Thread.sleep(2000);

		WebElement searchBox = driver.findElement(By.xpath("//input[@title=\"Search for products, brands and more\"]"));

		searchBox.clear();

		searchBox.sendKeys("iphone");

		WebElement search = driver.findElement(By.xpath("//button[@class='vh79eN' and @type='submit']"));

		search.click();

		Thread.sleep(2000);

		WebElement next = driver.findElement(By.xpath("//a[@class='_3fVaIS']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement page8 = driver.findElement(By.xpath("//div[@class='_2zg3yZ']//a[contains(text(),'8')]"));

		js.executeScript("arguments[0].click();", page8);

		List<WebElement> phoneList = driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));

		System.out.println("Size >> " + phoneList.size());

		for (WebElement ele : phoneList) {

			System.out.println(ele.getText());

		}

	}

}
