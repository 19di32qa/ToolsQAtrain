package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NestedFramesPage {
    WebDriver driver;
    String url = "https://demoqa.com/nestedframes";
    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
    }
    public void getPage() {
        driver.get(url);
    }
    public WebElement getFrame(String selector) {
        return driver.findElement(By.id(selector));
    }
}
