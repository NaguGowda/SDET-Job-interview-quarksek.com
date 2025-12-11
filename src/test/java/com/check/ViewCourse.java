package com.check;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class ViewCourse {
	WebDriver driver;
	@Test(priority = 1)
	public void Check() throws InterruptedException {
				
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement Select = driver.findElement(By.xpath("//a[contains(.,\"Udemy Courses\")]"));
		Select.click();
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
                return driver.findElement(By.xpath("//h2//a[contains(text(),'View Course')]")); // Replace with your element locator
            }
        });
            
        element.click();
	}
	
	@Test(priority = 3)
	public void locatnext() {
		driver.findElement(By.xpath("//*[@id=\"u493-tabs--138-content-0\"]/div[2]/div[1]/div[1]/div/div[5]/div/button"));		
		driver.close();
		
	}
}
