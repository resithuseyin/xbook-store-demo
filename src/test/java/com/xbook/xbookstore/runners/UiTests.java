package com.xbook.xbookstore.runners;

import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/ui-features",
        glue = {"com.xbook.xbookstore.stepdefinitions", "com.xbook.xbookstore.hooks"}
)
public class UiTests {
}
