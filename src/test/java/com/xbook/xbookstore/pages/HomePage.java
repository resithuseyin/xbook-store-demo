package com.xbook.xbookstore.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private By searchBox = By.id("search-box");
    private By searchButton = By.id("search-button");

    public HomePage() {
        super();
    }

    public void searchForBook(String bookTitle) {
        driver.findElement(searchBox).sendKeys(bookTitle);
        driver.findElement(searchButton).click();
    }

    public void navigateToHomePage() {
        driver.get("https://www.dr.com.tr/"); // Replace with actual URL
    }
}
