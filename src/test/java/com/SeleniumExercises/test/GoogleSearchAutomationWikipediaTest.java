package com.SeleniumExercises.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchAutomationWikipediaTest {

	private WebDriver driver;
	private WebDriverWait wait;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	@Test
	public void testGooglePage() throws InterruptedException {

		// Maximize the browser window
		driver.manage().window().maximize();
		// Navigate to Google homepage
		driver.get("https://www.google.com/");

		// Find and click the "Reject all" button on the cookies popup
		WebElement element = driver.findElement(By.xpath("//div[text()='Rechazar todo' or text()='Reject all']"));
        element.click();
        
        // Wait until the search box is clickable and enter the search term "automation"
		WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
		searchBox.sendKeys("automation");
		searchBox.submit();
		
		// Wait until the search results are visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
		
		// Find and click the Wikipedia link in the search results
        WebElement wikiLink = driver.findElement(By.xpath("//a[contains(@href, 'wikipedia.org')]"));
        wikiLink.click();
        
        // Wait until the Wikipedia logo is visible to confirm successful navigation
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("mw-logo")));
        
        // Verify that the Wikipedia page contains the year in which the first automatic process was done (1745)
        WebElement content = driver.findElement(By.xpath("//div[@id='mw-content-text']"));
        assertTrue(content.getText().contains("1745"));

        // Take a screenshot of the current page and save it as "wikipedia_screenshot.png"
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("wikipedia_screenshot.png");

        try {
            FileUtils.copyFile(screenshot, destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

	}
	
	@After
	public void tearDown() {
		
		if (driver != null) {
			driver.quit();
		}
		
	}
}
