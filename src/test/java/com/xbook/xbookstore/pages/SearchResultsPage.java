package com.xbook.xbookstore.pages;

import org.openqa.selenium.By;

public class SearchResultsPage extends BasePage {

    public SearchResultsPage() {
        super();
    }

    public boolean isBookInSearchResults(String bookTitle) {
        try {
            driver.findElement(By.linkText(bookTitle));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnBookLink(String bookTitle) {
        driver.findElement(By.linkText(bookTitle)).click();
    }
}
