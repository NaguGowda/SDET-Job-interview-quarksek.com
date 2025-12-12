package com.check;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class ViewCourse {
	WebDriver driver = new ChromeDriver();
	@Test(priority = 1)
	public void Check() throws InterruptedException {				
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement Select = driver.findElement(By.xpath("//a[contains(.,\"Udemy Courses\")]"));
		Select.click();
		
		driver.manage().window().maximize();
		Thread.sleep(5000);

	}
	
	@Test(priority = 2)
	public void Waiting() {
		Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("(//div[@class=\"course\"]/a[text()='View Course'])[1]")); // Replace with your element locator
            }
        });
            
        element.click();
	}
	
	@Test(priority = 3)
	public void locatnext() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(10))
                .ignoring(NoSuchElemen	tException.class);

        WebElement ReportBtn = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//button[span[text()='Report abuse']]")); // Replace with your element locator
            }
        });   
        ReportBtn.click();
		
	}
}
