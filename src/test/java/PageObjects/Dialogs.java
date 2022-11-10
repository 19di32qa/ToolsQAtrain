package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dialogs {
    WebDriver driver;
    String url = "https://demoqa.com/modal-dialogs";
    public Dialogs(WebDriver driver) {
        this.driver = driver;
    }
    public void getPage() {
        driver.navigate().to(url);
    }
    public WebElement getSmallModal() {
        return driver.findElement(By.id("showSmallModal"));
    }
    public WebElement getLargeModal() {
        return driver.findElement(By.id("showLargeModal"));
    }
    public WebElement getModalBody() {
        return driver.findElement(By.className("modal-body"));
    }
    public WebElement getSmallModalBtn() {
        return driver.findElement(By.id("closeSmallModal"));
    }
}
