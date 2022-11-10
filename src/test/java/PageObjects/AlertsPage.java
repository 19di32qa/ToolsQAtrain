package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlertsPage {
    WebDriver driver;
    String url = "https://demoqa.com/alerts";
    public  AlertsPage(WebDriver driver) {
        this.driver = driver;
    }
    public By alertButton = By.id("alertButton");
    public By timerAlertButton = By.id("timerAlertButton");
    public By confirmButton = By.id("confirmButton");
    public By promtButton = By.id("promtButton");

    public void getPage() {
        driver.navigate().to(url);
    }
    public WebElement getElement(By selector) {
        return driver.findElement(selector);
    }
}
