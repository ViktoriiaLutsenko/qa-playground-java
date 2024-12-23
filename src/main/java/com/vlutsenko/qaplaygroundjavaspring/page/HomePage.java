package com.vlutsenko.qaplaygroundjavaspring.page;

import com.vlutsenko.framework.page.AbstractComponent;
import com.vlutsenko.framework.service.property.PropertiesLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class HomePage extends AbstractComponent {

    @FindBy(css = ".hero-content h1")
    private WebElement titleElement;

    @FindBy(css = ".card-course h3")
    private List<WebElement> courseCardTitles;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getTitleText() {
        return titleElement.getText();
    }

    public void clickOnCard(String cardName) {
        courseCardTitles
            .stream()
            .filter(t -> Objects.equals(t.getText(), cardName))
            .findFirst()
            .orElseThrow(NoSuchElementException::new)
            .click();

    }

    public void goTo() {
        driver.get(PropertiesLoader.getProperty("app.url"));
    }

    @Override
    public boolean isAt() {
        return wait.until(d -> titleElement.isDisplayed());
    }
}
