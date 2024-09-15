package com.xbook.xbookstore.hooks;

import com.xbook.xbookstore.utils.WebDriverManagerUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class TestHooks {
    private static WebDriver driver;

    @Before("@api_test")
    public void setupApiTests() {
        // Code to run only for API contract tests
        System.out.println("Setting up API contract tests...");
        // Initialize resources, configure clients, etc.
    }

    @Before("@web_ui_test")
    public void setUp() {
        driver = WebDriverManagerUtil.getDriver("chrome");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            WebDriverManagerUtil.quitDriver();
            driver = null;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
