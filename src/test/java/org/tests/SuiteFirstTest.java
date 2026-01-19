package org.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class SuiteFirstTest {


   static WebDriver driver;
@BeforeAll
public static void setUpClass() {

    WebDriverManager.chromedriver().setup();

    ChromeOptions options = new ChromeOptions();
    if (System.getenv("CI") != null) {
        options.addArguments("--headless=new");
    }  // або "--headless"
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--disable-gpu");
    options.addArguments("--window-size=1920,1080");

    // Initialize the ChromeDriver
    driver = new ChromeDriver(options);
}

    @Test
    public void shouldOpenGoogleSite() {
        driver.get("https://www.google.com/");

        assertTrue(driver.findElement(By.cssSelector("svg[aria-label='Google']")).isDisplayed());
    }

    @Disabled
    @Test
    public void shouldNotOpenGoogleSite() {
        driver.get("https://www.google.com/");

        assertFalse(driver.findElement(By.cssSelector("svg[aria-label='Google']")).isDisplayed());
    }

    @AfterAll
    public static void tearDownClass() {
        driver.quit();
    }
}
