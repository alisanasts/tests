package org.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class SuiteFirst {


    WebDriver driver;
@BeforeClass
public void setUpClass() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized");

    // Initialize the ChromeDriver
    driver = new ChromeDriver(options);
}

    @Test
    public void test1() {
        driver.get("https://www.google.com/");

        assertTrue(driver.findElement(By.cssSelector("svg[aria-label='Google']")).isDisplayed());
    }

    @Test
    public void test2() {
        driver.get("https://www.google.com/");

        assertFalse(driver.findElement(By.cssSelector("svg[aria-label='Google']")).isDisplayed());
    }

    @AfterClass
    public void tearDownClass() {
        driver.quit();
    }
}
