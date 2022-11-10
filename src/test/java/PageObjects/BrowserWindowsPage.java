package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserWindowsPage {
    WebDriver driver;
    String url = "https://demoqa.com/browser-windows";
    public BrowserWindowsPage(WebDriver driver) {
        this.driver = driver;
    }
    public void getPage() {
        driver.navigate().to(url);
    }
    public By tabButton = By.id("tabButton");
    public By windowButton =  By.id("windowButton");
    public By messageWindowButton = By.id("messageWindowButton");

}
