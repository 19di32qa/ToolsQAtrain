package PageObjects;

import org.apache.groovy.json.internal.Exceptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookStorePage {
    WebDriver driver;
    String url ="https://demoqa.com/books";

    public BookStorePage(WebDriver driver) {
        this.driver =driver;
    }
    public void getPage() {
        driver.get(url);
    }
    public WebElement getBook(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(name)));
    }
    public WebElement getLogoutBtn() {
        return driver.findElement(By.id("submit"));
    }
}
