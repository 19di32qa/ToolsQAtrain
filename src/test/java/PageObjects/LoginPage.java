package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.nio.file.LinkOption;

public class LoginPage {
    WebDriver driver;
    String url = "https://demoqa.com/login";
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void getPage() {
        driver.get(url);
    }
    public WebElement getUserName() {
        return driver.findElement(By.id("userName"));
    }
    public WebElement getPassword() {
        return driver.findElement(By.id("password"));
    }
    public WebElement getLoginBtn() {
        return driver.findElement(By.id("login"));
    }
}
