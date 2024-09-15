package com.xbook.xbookstore.pages;

import org.openqa.selenium.By;

public class BookDetailsPage extends BasePage {

    private By bookTitle = By.id("book-title");
    private By bookAuthor = By.id("book-author"); // Assuming there's an ID for the author
    private By bookDescription = By.id("book-description"); // Assuming there's an ID for the description

    public BookDetailsPage() {
        super();
    }

    public String getBookTitle() {
        return driver.findElement(bookTitle).getText();
    }

    public String getBookAuthor() {
        return driver.findElement(bookAuthor).getText();
    }

    public String getBookDescription() {
        return driver.findElement(bookDescription).getText();
    }
}
