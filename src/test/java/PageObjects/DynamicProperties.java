package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicProperties {
    WebDriver driver;
    String url = "https://demoqa.com/dynamic-properties";
    public DynamicProperties(WebDriver driver) {
        this.driver = driver;
    }
    public void getPage() {
        driver.get(url);
    }
    By enableAfter = By.id("enableAfter");
    By colorChange = By.id("colorChange");
    By visibleAfter = By.id("visibleAfter");

    public WebElement getEnabledButton() {
        return driver.findElement(enableAfter);
    }
    public WebElement getChangedColorBtn() {
        return driver.findElement(colorChange);
    }
    public WebElement getVisibleAfterBtn() {
        return driver.findElement(visibleAfter);
    }
}
