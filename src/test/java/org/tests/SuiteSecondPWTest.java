package org.tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SuiteSecondPWTest {

    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(true)
        );
    }

    @AfterAll
     static void closeBrowser() {
        browser.close();
        playwright.close();
    }

    @BeforeEach
    void createContext() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void closeContext() {
        context.close();
    }

    @Test
    void shouldOpenPlaywrightSite() {
        page.navigate("https://playwright.dev/");
        assertTrue(page.title().contains("Playwright"));
    }

    @Test
    void shouldAddProductToBasket() {
        page.navigate("https://auchan.ua/");

        page.click(".modal__body [value=\"ua\"]");
        page.click("[href=\"/klimaticheskaja-tehnika/\"]");
        page.waitForURL("https://auchan.ua/ua/klimaticheskaja-tehnika/");

        page.hover("[class*=\"ProductCard_wrapper\"]");
        page.click("[class*=\"ProductCard_wrapper\"] [class*=\"PrimaryButton_primaryButton\"]");


        assertEquals("1", page.locator("[aria-label*=\"Cart\"]:has-text('1')").textContent());
    }
}
