package com.xbook.xbookstore.pages;

import com.xbook.xbookstore.hooks.TestHooks;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage() {
        this.driver = TestHooks.getDriver();
    }
}
