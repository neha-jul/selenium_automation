package com.neha.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NehaTest {
	@Test
	public void tarteCosmeticTests() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://tartecosmetics.com/en_IN/home");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		Thread.sleep(5000);

		// a[@id='bx-close-inside-1146662']//*[name()='svg' and @class='bx-close-xsvg']

		WebElement closePopup = driver.findElement(
				By.xpath("//a[@id='bx-close-inside-1146662']//*[name()='svg' and @class='bx-close-xsvg']"));

		Thread.sleep(10000);
		closePopup.click();

		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.xpath("//a[@class='js-menu-nav--link has-sub-menu']"))).build()
				.perform();

		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"//nav[@id='navigation']/ul[1]/li[4]/div[@class='level-2']/ul[2]//ul[@class='level-3']//a[@href='https://tartecosmetics.com/en_IN/makeup/face/foundation/']"))
				.click();

		// Verify URL
		String expectedUrl = "https://tartecosmetics.com/en_IN/makeup/face/foundation/";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Url don't match");

		Thread.sleep(5000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");

		Thread.sleep(5000);

		(driver.findElement(By.xpath(
				"//ul[@id='search-result-items']/li[2]/div[@class='product-tile']/div[@class='product-image']/a[1]/img[2]")))
						.click();

		String firstProductExpectedUrl = "https://tartecosmetics.com/en_IN/makeup/face/foundation/maracuja-tinted-hydrator/2014.html?cgid=makeup-face-foundation&dwvar_2014_color=10N%20fair%20neutral#start=2";
		String firstProductActualUrl = driver.getCurrentUrl();
		Assert.assertEquals(firstProductActualUrl, firstProductExpectedUrl, "Url don't match");

		Thread.sleep(5000);

		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,350)", "");

		driver.findElement(By.xpath("//button[@id='add-to-cart']")).click();

		Thread.sleep(5000);

		driver.navigate().back();

		String secondProductExpectedUrl = "https://tartecosmetics.com/en_IN/makeup/face/foundation/";
		String secondProductActualUrl = driver.getCurrentUrl();
		Assert.assertEquals(secondProductActualUrl, secondProductExpectedUrl, "Url don't match");

		Thread.sleep(5000);

		JavascriptExecutor scroll2 = (JavascriptExecutor) driver;
		scroll2.executeScript("window.scrollBy(0,550)", "");

		Thread.sleep(5000);

		driver.findElement(By.xpath(
				"//ul[@id='search-result-items']/li[3]/div[@class='product-tile']//a[@title='Go to Product: face tape™ foundation']/span[@class='product-name-desktop']"))
				.click();

		JavascriptExecutor scroll3 = (JavascriptExecutor) driver;
		scroll3.executeScript("window.scrollBy(0,570)", "");

		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@id='add-to-cart']")).click();

		Thread.sleep(5000);

		driver.navigate().back();

		String thirdExpectedUrl = "https://tartecosmetics.com/en_IN/makeup/face/foundation/";
		String thirdActualUrl = driver.getCurrentUrl();
		Assert.assertEquals(thirdActualUrl, thirdExpectedUrl, "Url don't match");

		Thread.sleep(5000);

		JavascriptExecutor scroll4 = (JavascriptExecutor) driver;
		scroll4.executeScript("window.scrollBy(0,550)", "");
		
		Thread.sleep(5000);

		driver.findElement(By.xpath(
				"//ul[@id='search-result-items']/li[5]/div[@class='product-tile']//a[@title='Go to Product: shape tape™ tone tool']/span[@class='product-name-desktop']"))
				.click();
		
		JavascriptExecutor scroll5 = (JavascriptExecutor) driver;
		scroll5.executeScript("window.scrollBy(0,570)", "");

		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@id='add-to-cart']")).click();
		
		Thread.sleep(3000);

		JavascriptExecutor scroll6 = (JavascriptExecutor) driver;
		scroll6.executeScript("window.scrollBy(250,0)", "");
		
		Actions cartMouseHover = new Actions(driver);

		cartMouseHover.moveToElement(driver.findElement(By.xpath("span[@class='minicart-quantity']"))).build()
				.perform();

		
		//span[@class='minicart-quantity']

		//driver.findElement(By.xpath("//button[@id='add-to-cart']")).click();

		// button[@id='add-to-cart']

		// select from cart

		// add to cart

		// close driver
		// driver.quit();

	}

}
