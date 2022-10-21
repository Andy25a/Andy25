package pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    protected static WebDriver driver;

    public AbstractPage(WebDriver driver) {
        AbstractPage.driver = driver;
    }
}