package org.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class SuiteFirstTest {


    WebDriver driver;
@BeforeClass
public void setUpClass() {

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
    public void test1() {
        driver.get("https://www.google.com/");

        assertTrue(driver.findElement(By.cssSelector("svg[aria-label='Google']")).isDisplayed());
    }

    @Test(enabled = false)
    public void test2() {
        driver.get("https://www.google.com/");

        assertFalse(driver.findElement(By.cssSelector("svg[aria-label='Google']")).isDisplayed());
    }

    @AfterClass
    public void tearDownClass() {
        driver.quit();
    }
}
