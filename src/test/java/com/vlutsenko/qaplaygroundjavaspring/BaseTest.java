package com.vlutsenko.qaplaygroundjavaspring;

import com.vlutsenko.framework.config.driver.WebDriverFactory;
import com.vlutsenko.framework.service.property.PropertiesLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {

    protected WebDriverWait wait;
    protected WebDriver driver;

    @BeforeSuite
    protected void setUpProperties(){
        PropertiesLoader.configureProperties();
    }

    @BeforeTest
    protected void setUpDriver() {
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(PropertiesLoader.getProperty("timeout"))));
        driver.manage().window().maximize();
    }

    @AfterTest
    protected void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
