package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    WebDriver driver;
    String url = "https://demoqa.com/register";
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    public void getPage() {
        driver.get(url);
    }
    public WebElement getElement(String selector) {
        return driver.findElement(By.id(selector));
    }
}
