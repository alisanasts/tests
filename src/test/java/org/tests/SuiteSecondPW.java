package org.tests;

import com.microsoft.playwright.*;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

public class SuiteSecondPW {

    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;

    @BeforeSuite
     void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
    }

    @AfterSuite
     void closeBrowser() {
        browser.close();
        playwright.close();
    }

    @BeforeMethod
    void createContext() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterMethod
    void closeContext() {
        context.close();
    }

    @Test
    void shouldOpenPlaywrightSite() {
        page.navigate("https://playwright.dev/");
        assertTrue(page.title().contains("Playwright"));
    }
}
