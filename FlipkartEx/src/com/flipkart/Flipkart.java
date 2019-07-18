package com.flipkart;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.xpath.axes.SubContextList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flipkart {

	static double sum = 0;

	public static void main(String[] args) throws Exception {

		String str = null;

		double avg = 0;

		WebDriver driver = new FirefoxDriver();

		List<WebElement> page1List = null;

		List<WebElement> subList = new ArrayList<WebElement>();

		ArrayList<WebElement> grandList = new ArrayList<WebElement>();

		ArrayList<Integer> al = new ArrayList<Integer>();

		WebElement next = null;

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, 20);

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.get("https://www.flipkart.com");

		WebElement popUp = driver.findElement(By.xpath("//button[@class=\"_2AkmmA _29YdH8\"]"));

		popUp.click();

		WebElement searchBox = driver.findElement(By.xpath("//input[@title=\"Search for products, brands and more\"]"));

		searchBox.clear();

		searchBox.sendKeys("iphone");

		WebElement search = driver.findElement(By.xpath("//button[@class='vh79eN' and @type='submit']"));

		search.click();

		next = driver.findElement(By.xpath("//a[@class='_3fVaIS']"));

		page1List = driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));

		grandList.addAll(page1List);

		WebElement pages[] = new WebElement[7];

		WebElement page1 = driver.findElement(By.xpath("//div[@class='_2zg3yZ']//a[contains(text(),'1')]"));
		WebElement page2 = driver.findElement(By.xpath("//div[@class='_2zg3yZ']//a[contains(text(),'2')]"));
		WebElement page3 = driver.findElement(By.xpath("//div[@class='_2zg3yZ']//a[contains(text(),'3')]"));
		WebElement page4 = driver.findElement(By.xpath("//div[@class='_2zg3yZ']//a[contains(text(),'4')]"));
		WebElement page5 = driver.findElement(By.xpath("//div[@class='_2zg3yZ']//a[contains(text(),'5')]"));
		WebElement page6 = driver.findElement(By.xpath("//div[@class='_2zg3yZ']//a[contains(text(),'6')]"));
		WebElement page7 = driver.findElement(By.xpath("//div[@class='_2zg3yZ']//a[contains(text(),'7')]"));
		WebElement page8 = driver.findElement(By.xpath("//div[@class='_2zg3yZ']//a[contains(text(),'8')]"));

		pages[0] = page1;
		pages[1] = page2;
		pages[2] = page3;
		pages[3] = page4;
		pages[4] = page5;
		pages[4] = page6;
		pages[5] = page7;
		pages[6] = page8;

		for (int i = 0; i < pages.length; i++) {

			subList = driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));

			System.out.println(i + " >> " + "Phone List Size >> " + subList.size());

			grandList.addAll(subList);

			if (i == 6) {
				
				break;

			} else {
				
				js.executeScript("arguments[0].click();", pages[i]);

			}
		}

		System.out.println("Grand List Size >> " + grandList.size());

		for (WebElement ele : grandList) {

			System.out.println(ele.getText());

		}

		System.out.println("=======================================");

		String arr[] = new String[grandList.size()];

		for (int i = 0; i < grandList.size(); i++) {

			arr[i] = grandList.get(i).getText();

			str = arr[i];

			str = str.replaceAll("[^a-zA-Z0-9]", "");

			int aa = Integer.parseInt(str);

			al.add(aa);

			System.out.println("Integer ArrayList >> " + aa);
		}

		for (int i = 0; i < al.size(); i++) {

			sum = sum + al.get(i);

			avg = sum / al.size();

		}

		System.out.println("=======================================");

		System.out.println("Sum >> " + sum);

		System.out.println("Average >> " + avg);

		System.out.println("=======================================");

		driver.close();

	}
}
